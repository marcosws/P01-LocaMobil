/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.controller;

import locamobil.global.util.Criptografia;
import locamobil.global.util.LoginStatus;
import locamobil.model.dao.UsuarioDao;
import locamobil.model.entity.Usuario;
import locamobil.view.mdi.LoginView;
import locamobil.view.util.UsuarioLogado;

/**
 *
 * @author Marcos
 */
public class LoginController {
    
    public LoginStatus logar(Object view){
        
        LoginView loginView = (LoginView) view;
        Criptografia criptografia = new Criptografia();
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        usuario = usuarioDao.consultar(loginView.getJtfLogin().getText());
        char[] senhaArr = loginView.getJpfSenha().getPassword();
        String senha = "";
        for(char s: senhaArr){
            senha += String.valueOf(s);
        }
        if(usuario != null) {
            if(!usuario.isAtivo()){
                return LoginStatus.USUARIO_INATIVO;
            }
            else if(usuario.getSenha().equals(criptografia.hashSHA512(senha))){
                UsuarioLogado.setNomeUsuario(usuario.getNomeUsuario());
                UsuarioLogado.setLoginUsuario(usuario.getLogin());
                UsuarioLogado.setAdminstrador(usuario.isAdministrador());
                return LoginStatus.OK;
            }
            else{
                return LoginStatus.LOGIN_SENHA_INVALIDO;
            }
        } 
        else{
            return LoginStatus.LOGIN_SENHA_INVALIDO;
        }
    }
    
}
