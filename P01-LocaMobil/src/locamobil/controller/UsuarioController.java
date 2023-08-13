/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.controller;

import java.util.List;
import locamobil.global.util.Criptografia;
import locamobil.model.dao.UsuarioDao;
import locamobil.model.entity.Usuario;
import locamobil.model.service.UsuarioService;
import locamobil.view.chid.UsuarioView;

/**
 *
 * @author Marcos
 */
public class UsuarioController extends UsuarioService implements IController{
    
    private UsuarioView usuarioView;
 
    @Override
    public void incluir(Object view) {
        usuarioView = (UsuarioView)view;
        if(!verificaNome(usuarioView.getJtfNomeUsuario().getText())){return;}
        if(!verificaLogin(usuarioView.getJtfLogin().getText())){return;}
        if(!verificaSenha(this.converteSenha(usuarioView.getJpfSenha().getPassword()))){return;}
        if(this.comparaSenha(usuarioView.getJpfSenha().getPassword(), usuarioView.getJpfCofirmarSenha().getPassword())){
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = new Usuario();
            Criptografia criptografia = new Criptografia();
            usuario.setNomeUsuario(usuarioView.getJtfNomeUsuario().getText());
            usuario.setLogin(usuarioView.getJtfLogin().getText());
            usuario.setSenha(criptografia.hashSHA512(this.converteSenha(usuarioView.getJpfSenha().getPassword())));
            usuario.setAdministrador(this.converteSimOuNao(usuarioView.getJcbAdministrador().getModel().getSelectedItem().toString()));
            usuario.setAtivo(this.converteSimOuNao(usuarioView.getJcbAtivo().getModel().getSelectedItem().toString()));
            usuarioDao.incluir(usuario);
        }
        usuarioView.limpaCampos();
    }

    @Override
    public void alterar(Object view) {
        usuarioView = (UsuarioView)view;
        if(!verificaId(usuarioView.getJtfIdUsuario().getText())){return;}
        if(!verificaNome(usuarioView.getJtfNomeUsuario().getText())){return;}
        if(!verificaLogin(usuarioView.getJtfLogin().getText())){return;}
        Criptografia criptografia = new Criptografia();
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(usuarioView.getJtfIdUsuario().getText()));
        usuario.setNomeUsuario(usuarioView.getJtfNomeUsuario().getText());
        usuario.setLogin(usuarioView.getJtfLogin().getText());
        if(usuarioView.getJcbAlterarSenha().getModel().isSelected()){
            if(!verificaSenha(this.converteSenha(usuarioView.getJpfSenha().getPassword()))){return;}
            if(this.comparaSenha(usuarioView.getJpfSenha().getPassword(), usuarioView.getJpfCofirmarSenha().getPassword()))
                usuario.setSenha(criptografia.hashSHA512(this.converteSenha(usuarioView.getJpfSenha().getPassword())));
            else
                return;
        }
        else{
            usuario.setSenha("");
        }
        usuario.setAdministrador(this.converteSimOuNao(usuarioView.getJcbAdministrador().getModel().getSelectedItem().toString()));
        usuario.setAtivo(this.converteSimOuNao(usuarioView.getJcbAtivo().getModel().getSelectedItem().toString()));
        usuarioDao.alterar(usuario);
        usuarioView.limpaCampos();
           
    }

    @Override
    public void excluir(Object view) {

        usuarioView = (UsuarioView)view;
        if(!verificaId(usuarioView.getJtfIdUsuario().getText())){return;}
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(usuarioView.getJtfIdUsuario().getText()));
        usuarioDao.excluir(usuario);
        usuarioView.limpaCampos();
        
    }

    @Override
    public void consultar(Object view) {
        
        usuarioView = (UsuarioView)view;
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = usuarioDao.consultar();
        usuarioView.getGridView().clearGrid();
        usuarios.forEach((u) -> {
            usuarioView.getGridView().getModel().addRow(new Object[]{
                u.getIdUsuario(),
                u.getNomeUsuario(),
                u.getLogin(),
                this.converteSimOuNao(u.isAdministrador()),
                this.converteSimOuNao(u.isAtivo())
            });
        });
        usuarioView.limpaCampos();
        
    }
}
