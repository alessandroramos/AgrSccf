<%-- 
    Document   : aguarde
    Created on : 13/04/2015, 11:46:51
    Author     : Aolessandro G. Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    function start()
    {
        PF('startButton1').disable();    
        window['progress'] = setInterval(function() 
        {
            var pbClient = PF('pbClient'),
            oldValue = pbClient.getValue(),
            newValue = oldValue + 10;                
            pbClient.setValue(pbClient.getValue() + 10);    
            if(newValue === 100) 
            {
                clearInterval(window['progress']);
            }   
        }, 
        1000);        
    }    
</script>
