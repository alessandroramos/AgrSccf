package br.com.agr.model.entities;
// Generated 18/05/2015 08:05:26 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Andamento generated by hbm2java
 */
@Entity
@Table(name="andamento"
    ,schema="public"
)
public class Andamento  implements java.io.Serializable {


     private int andamentoId;
     private Integer andamentoCodigoAtendimento;
     private Integer andamentoCodigoUsuario;
     private String andamentoData;
     private String andamentoHora;
     private String andamentoTipo;

    public Andamento() {
    }

	
    public Andamento(int andamentoId) {
        this.andamentoId = andamentoId;
    }
    public Andamento(int andamentoId, Integer andamentoCodigoAtendimento, Integer andamentoCodigoUsuario, String andamentoData, String andamentoHora, String andamentoTipo) {
       this.andamentoId = andamentoId;
       this.andamentoCodigoAtendimento = andamentoCodigoAtendimento;
       this.andamentoCodigoUsuario = andamentoCodigoUsuario;
       this.andamentoData = andamentoData;
       this.andamentoHora = andamentoHora;
       this.andamentoTipo = andamentoTipo;
    }
   
     @Id 

    
    @Column(name="andamento_id", unique=true, nullable=false)
    public int getAndamentoId() {
        return this.andamentoId;
    }
    
    public void setAndamentoId(int andamentoId) {
        this.andamentoId = andamentoId;
    }

    
    @Column(name="andamento_codigo_atendimento")
    public Integer getAndamentoCodigoAtendimento() {
        return this.andamentoCodigoAtendimento;
    }
    
    public void setAndamentoCodigoAtendimento(Integer andamentoCodigoAtendimento) {
        this.andamentoCodigoAtendimento = andamentoCodigoAtendimento;
    }

    
    @Column(name="andamento_codigo_usuario")
    public Integer getAndamentoCodigoUsuario() {
        return this.andamentoCodigoUsuario;
    }
    
    public void setAndamentoCodigoUsuario(Integer andamentoCodigoUsuario) {
        this.andamentoCodigoUsuario = andamentoCodigoUsuario;
    }

    
    @Column(name="andamento_data", length=10)
    public String getAndamentoData() {
        return this.andamentoData;
    }
    
    public void setAndamentoData(String andamentoData) {
        this.andamentoData = andamentoData;
    }

    
    @Column(name="andamento_hora", length=10)
    public String getAndamentoHora() {
        return this.andamentoHora;
    }
    
    public void setAndamentoHora(String andamentoHora) {
        this.andamentoHora = andamentoHora;
    }

    
    @Column(name="andamento_tipo", length=20)
    public String getAndamentoTipo() {
        return this.andamentoTipo;
    }
    
    public void setAndamentoTipo(String andamentoTipo) {
        this.andamentoTipo = andamentoTipo;
    }




}


