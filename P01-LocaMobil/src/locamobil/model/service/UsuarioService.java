/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.model.service;

import java.util.Arrays;
import locamobil.global.util.Mensagens;

/**
 *
 * @author Marcos
 */
public class UsuarioService {
    
    public String converteSenha(char[] senhaArr){
          
        String senha = "";
        for(char s: senhaArr){
            senha += String.valueOf(s);
        }
        return senha;
    }
    public boolean converteSimOuNao(String valor){
        return valor.equalsIgnoreCase("sim");
    }
    public String converteSimOuNao(boolean valor){
        return (valor? "Sim" : "Não");
    }
    public boolean comparaSenha(char[] NovaSenha, char[] ConfirmaSenha){
        
        if(Arrays.equals(NovaSenha, ConfirmaSenha)){
            return true;
        }
        else{
            Mensagens.mensagemErro("A Senha está diferente.", "Senha Diferente");
            return false;
        }
        
    }
    public boolean verificaId(String id){
        if(isNullOrEmpty(id)){
            Mensagens.mensagemErro("Selecione um usuario!", "Usuario");
            return false;
        }
        return true;
    }
    public boolean verificaNome(String nome){
        if(isNullOrEmpty(nome)){
            Mensagens.mensagemErro("O Campo Nome é obrigatório!", "Usuario");
            return false;
        }
        return true;
    }
    public boolean verificaLogin(String login){
        if(isNullOrEmpty(login)){
            Mensagens.mensagemErro("O Campo Login é obrigatório!", "Usuario");
            return false;
        }
        return true;
    }
    public boolean verificaSenha(String senha){
        if(isNullOrEmpty(senha)){
            Mensagens.mensagemErro("O Campo Senha é obrigatório!", "Usuario");
            return false;
        }
        return true;
    }
    private boolean isNullOrEmpty(String valor){
        return (valor == null || valor.isEmpty());
    }
    
    
}
