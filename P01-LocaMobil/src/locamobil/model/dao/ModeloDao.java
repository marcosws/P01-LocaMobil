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
import locamobil.model.entity.Modelo;

/**
 *
 * @author Marcos
 */
public class ModeloDao {
    
    private Connection connection;
    
    public void incluir(Modelo modelo){
    
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "INSERT INTO MODELO (NOME_MODELO, ID_MONTADORA) VALUES (?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, modelo.getNomeModelo());
            preparedStatement.setInt(2, modelo.getIdMontadora());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
    }
    public void alterar(Modelo modelo){
        
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "UPDATE MODELO SET NOME_MODELO=?, ID_MONTADORA=? WHERE ID_MODELO=?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, modelo.getNomeModelo());
            preparedStatement.setInt(2, modelo.getIdMontadora());
            preparedStatement.setInt(3, modelo.getIdModelo());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        
    }
    public void excluir(Modelo modelo){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MODELO WHERE ID_MODELO=?");
            preparedStatement.setInt(1, modelo.getIdModelo());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
    }
    public Modelo consultar(int idModelo){

        this.connection = new ConexaoSQLite().getConnection();
        Modelo modelo = new Modelo();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM MODELO WHERE ID_MODELO=?");
            preparedStatement.setInt(1, idModelo);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(!resultSet.isClosed()){
                modelo.setIdModelo(resultSet.getInt("ID_MODELO"));
                modelo.setNomeModelo(resultSet.getString("NOME_MODELO"));
                modelo.setIdMontadora(resultSet.getInt("ID_MONTADORA"));
                resultSet.close();
            }
            this.connection.close();
            return modelo;
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
        
    }
    public List<Modelo> consultar(){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            List<Modelo> modelos = new ArrayList<Modelo>();
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM MODELO;");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.isClosed()){
                while(resultSet.next()){
                    Modelo modelo = new Modelo();
                    modelo.setIdModelo(resultSet.getInt("ID_MODELO"));
                    modelo.setNomeModelo(resultSet.getString("NOME_MODELO"));
                    modelo.setIdMontadora(resultSet.getInt("ID_MONTADORA"));
                    modelos.add(modelo);
                }
            }
            this.connection.close();
            return modelos;
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
    }
    
}
