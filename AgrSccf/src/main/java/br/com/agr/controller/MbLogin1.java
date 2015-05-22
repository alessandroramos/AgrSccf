package br.com.agr.controller;

import br.com.agr.model.dao.HibernateDAO;
import br.com.agr.model.dao.InterfaceDAO;
import br.com.agr.model.entities.Usuario;
import br.com.agr.util.FacesContextUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.context.RequestContext;


@ManagedBean(name="mLogin")
@SessionScoped
public class MbLogin1 
{
    private static final long serialVersionUID = 1L;
    private Usuario usuario = new Usuario();
    private Usuario Listusuario = new Usuario();
    private List<Usuario> usuarios;
    private String confereSenha = "";

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }
    
    public MbLogin1()
    {
        
    }
    
    public String buscUsuario()
    {
        int confLogin = 0;
        if(usuario.getUsuarioLogin().equals(""))
        {
            confLogin = 0;
        }
        else
        {
            confLogin = confiUsuario();
        }
        String retorno = "/publica/login.html";
        if (confLogin == 1)
        {
            confereSenha = "";

            if(usuario.getUsuarioPermicao().equals("restrita"))
            {
                retorno = "/restrita/index.html";  
            }
            else
            {
                if(usuario.getUsuarioPermicao().equals("gestor"))
                {
                    retorno = "/gestor/index.html";  
                }
                else
                {
                    if(usuario.getUsuarioPermicao().equals("laudo"))
                    {
                        retorno = "/laudo/index.html";  
                    }
                    else
                    {
                        confereSenha = "Usuario não tem permição para acessar o sistema!";
                                FacesContext.getCurrentInstance().addMessage(null, 
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario não tem permição para acessar o sistema!",""));
                        retorno = "/publica/login.html";
                    }
                }
            }
        }
        else
        {
            confereSenha = "Login ou Senha Invalido!";
                    FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Login ou Senha Invalido!",""));
            retorno = "/publica/login.html";
        }
//        JOptionPane.showMessageDialog(null, retorno);
        return retorno.trim();
    }
    
    private InterfaceDAO<Usuario> usuarioDAO()
    {
        InterfaceDAO<Usuario> usuarioDAO = new HibernateDAO<Usuario>(Usuario.class, FacesContextUtil.getRequestSession()); 
        return usuarioDAO;
    }
    
    public String limpaUsuario() 
    {
        System.out.println("Inicia Limpeza!");
        usuario = new Usuario();
        usuario.setUsuarioId(0);
        usuario.setUsuarioSenha("");
        usuario.setUsuarioLogin("");
        JOptionPane.showMessageDialog(null, "/public/login.html");
        return "/publica/login.html";
    }
    
    public List<Usuario> getUsuarios() 
    {
        usuarios = usuarioDAO().getEntities();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) 
    {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario) 
    {
        this.usuario = usuario;
    }   

    private int confiUsuario() 
    {
        int retorno = 0;
        String login = usuario.getUsuarioLogin();
        String senha = usuario.getUsuarioSenha();
        SessionFactory fabrica = new Configuration().configure().buildSessionFactory(); 
        Session sessao = fabrica.openSession();
        try
        {
            List<Usuario> lista_usuario = new ArrayList();
            lista_usuario = sessao.createQuery("from Usuario where Usuario_login like '"+login+"'").list();
            int tamanho_lista = lista_usuario.size();
            if (tamanho_lista > 0)
            {
                
                usuario = lista_usuario.get(0);
                if (usuario.getUsuarioSenha().trim().equals(senha.trim()))
                    retorno = 1;

            }                        
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Erro ao ler o banco : "+erro);
        }
        
        return retorno;        
    }
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aguarde", "Aguarde.");
         
        RequestContext.getCurrentInstance().execute("Aguarde!");
    }

}
