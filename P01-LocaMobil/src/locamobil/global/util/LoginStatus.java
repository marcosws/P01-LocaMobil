/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.global.util;

/**
 *
 * @author Marcos
 */
public enum LoginStatus {
    
    SENHA_VAZIA("SENHA_VAZIA"),
    SENHA_DIFERENTE("SENHA_DIFERENTE"),
    LOGIN_SENHA_INVALIDO("LOGIN_SENHA_INVALIDO"),  
    USUARIO_INATIVO("USUARIO_INATIVO"),
    OK("OK");

    private final String status;
    LoginStatus(String loginStatus){
        status = loginStatus;
    }
	
    public String getStatus(){
        return status;
    }
    
}
