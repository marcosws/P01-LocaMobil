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
import locamobil.model.service.UsuarioService;
import locamobil.view.mdi.AlterarSenhaView;
import locamobil.view.util.UsuarioLogado;

/**
 *
 * @author Marcos
 */
public class AlterarSenhaController {
    
    public LoginStatus alterarSenha(Object view){
        
        AlterarSenhaView alterarSenhaView = (AlterarSenhaView)view;
        Criptografia criptografia = new Criptografia();
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        UsuarioService usuarioService = new UsuarioService();
        usuario = usuarioDao.consultar(alterarSenhaView.getJtfLogin().getText());
        String senha = usuarioService.converteSenha(alterarSenhaView.getJpfSenha().getPassword());
        if(usuario != null) {
            if(!usuario.isAtivo()){
                return LoginStatus.USUARIO_INATIVO;
            }
            else if(usuario.getSenha().equals(criptografia.hashSHA512(senha))){
 
                if(!usuarioService.verificaSenha(usuarioService.converteSenha(alterarSenhaView.getJpfNovaSenha().getPassword()))){
                    return LoginStatus.SENHA_VAZIA;
                }
                if(usuarioService.comparaSenha(alterarSenhaView.getJpfNovaSenha().getPassword(), alterarSenhaView.getJpfConfirmaSenha().getPassword())){
                    senha = usuarioService.converteSenha(alterarSenhaView.getJpfNovaSenha().getPassword());
                    usuario.setSenha(criptografia.hashSHA512(senha));
                    usuarioDao.alterar(usuario);
                    return LoginStatus.OK;
                }
                else{
                    return LoginStatus.SENHA_DIFERENTE;
                }
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
