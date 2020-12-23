/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locamobil.global.util.Mensagens;
import locamobil.model.entity.Usuario;

/**
 *
 * @author Marcos
 */
public class UsuarioDao {
    
    private Connection connection;
    
    public void incluir(Usuario usuario){
    
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "INSERT INTO USUARIO (NOME_USUARIO, LOGIN, SENHA, ADMINISTRADOR, ATIVO) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setString(1, usuario.getNomeUsuario());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setBoolean(4, usuario.isAdministrador());
            preparedStatement.setBoolean(5, usuario.isAtivo());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
	}
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        
    }
    public void alterar(Usuario usuario){
    
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "";
        PreparedStatement preparedStatement = null;
        try{
            if(usuario.getSenha().isEmpty()){
                sql = "UPDATE USUARIO SET NOME_USUARIO=?, LOGIN=?, ADMINISTRADOR=?, ATIVO=?  WHERE ID_USUARIO=?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getNomeUsuario());
                preparedStatement.setString(2, usuario.getLogin());
                preparedStatement.setBoolean(3, usuario.isAdministrador());
                preparedStatement.setBoolean(4, usuario.isAtivo());
                preparedStatement.setInt(5, usuario.getIdUsuario());
            }
            else{
                sql = "UPDATE USUARIO SET NOME_USUARIO=?, LOGIN=?, SENHA=? , ADMINISTRADOR=?, ATIVO=?  WHERE ID_USUARIO=?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getNomeUsuario());
                preparedStatement.setString(2, usuario.getLogin());
                preparedStatement.setString(3, usuario.getSenha());
                preparedStatement.setBoolean(4, usuario.isAdministrador());
                preparedStatement.setBoolean(5, usuario.isAtivo());
                preparedStatement.setInt(6, usuario.getIdUsuario());
            }
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        }
        catch(SQLException e){
           Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName()); 
        }
        
        
    }
    public void excluir(Usuario usuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO=?");
            preparedStatement.setInt(1, usuario.getIdUsuario());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }
	catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
	}
        
    }
    public Usuario consultar(int idUsuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        Usuario usuario = new Usuario();
        
        PreparedStatement preparedStatement; 
        try {
            preparedStatement = this.connection.prepareStatement("SELECT * FROM USUARIO WHERE ID_USUARIO=?");
            preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(!resultSet.isClosed()){
                usuario.setIdUsuario(resultSet.getInt("ID_USUARIO"));
                usuario.setNomeUsuario(resultSet.getString("NOME_USUARIO"));
                usuario.setLogin(resultSet.getString("LOGIN"));
                usuario.setSenha(resultSet.getString("SENHA"));
                usuario.setAdministrador(resultSet.getBoolean("ADMINISTRADOR"));
                usuario.setAtivo(resultSet.getBoolean("ATIVO"));
                resultSet.close();
                this.connection.close();
                return usuario;
            }
            else{
                this.connection.close();
                return null;
            }
           
        } 
        catch(SQLException e) {
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
        
    }
    public Usuario consultar(String login){
        
        this.connection = new ConexaoSQLite().getConnection();
        Usuario usuario = new Usuario();

        PreparedStatement preparedStatement; 
        try {
            preparedStatement = this.connection.prepareStatement("SELECT * FROM USUARIO WHERE LOGIN=?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(!resultSet.isClosed()){
                usuario.setIdUsuario(resultSet.getInt("ID_USUARIO"));
                usuario.setNomeUsuario(resultSet.getString("NOME_USUARIO"));
                usuario.setLogin(resultSet.getString("LOGIN"));
                usuario.setSenha(resultSet.getString("SENHA"));
                usuario.setAdministrador(resultSet.getBoolean("ADMINISTRADOR"));
                usuario.setAtivo(resultSet.getBoolean("ATIVO"));
                resultSet.close();
                this.connection.close();
                return usuario;
            }
            else{
                this.connection.close();
                return null;
            }
           
        } 
        catch(SQLException e) {
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
 
    }
    public List<Usuario> consultar(){
        
        this.connection = new ConexaoSQLite().getConnection();
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM USUARIO");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.isClosed()){
                while(resultSet.next()){
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getInt("ID_USUARIO"));
                    usuario.setNomeUsuario(resultSet.getString("NOME_USUARIO"));
                    usuario.setLogin(resultSet.getString("LOGIN"));
                    usuario.setAdministrador(resultSet.getBoolean("ADMINISTRADOR"));
                    usuario.setAtivo(resultSet.getBoolean("ATIVO"));
                    usuarios.add(usuario);
                }
                resultSet.close();
            }
            this.connection.close();
            return usuarios;
            
        } 
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
        
    }
    
}
