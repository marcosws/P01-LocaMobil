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
import locamobil.model.entity.Montadora;

/**
 *
 * @author Marcos
 */
public class MontadoraDao {
    
    private Connection connection;
    
    /**
     * public void incluir(Montadora montadora)
     * @param montadora 
     */
    public void incluir(Montadora montadora){
        
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "INSERT INTO MONTADORA(NOME_MONTADORA) VALUES(?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, montadora.getNomeMontadora());
            preparedStatement.execute();
            this.connection.close();
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
    
    }
    /**
     * public void alterar(Montadora montadora)
     * @param montadora 
     */
    public void alterar(Montadora montadora){
        
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "UPDATE MONTADORA SET NOME_MONTADORA=? WHERE ID_MONTADORA=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, montadora.getNomeMontadora());
            preparedStatement.setInt(2, montadora.getIdMontadora());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
        } 
        catch (SQLException e) {
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
    }
    /**
     * 
     * @param montadora 
     */
    public void excluir(Montadora montadora){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MONTADORA WHERE ID_MONTADORA=?");
            preparedStatement.setInt(1, montadora.getIdMontadora());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }
	catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
	}
        
    }
    /**
     * public Montadora consultar(int idMontadora)
     * @param idMontadora
     * @return Montadora
     */
    public Montadora consultar(int idMontadora){
        
        this.connection = new ConexaoSQLite().getConnection();
        Montadora montadora = new Montadora();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM MONTADORA WHERE ID_MONTADORA=?"); 
            preparedStatement.setInt(1,idMontadora);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(!resultSet.isClosed()){
                montadora.setIdMontadora(resultSet.getInt("ID_MONTADORA"));
                montadora.setNomeMontadora(resultSet.getString("NOME_MONTADORA"));
                resultSet.close();
            }
            this.connection.close();
            return montadora;
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
    }
    /**
     * public List Montadora consultar()
     * @return 
     */
    public List<Montadora> consultar(){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            List<Montadora> montadoras = new ArrayList<Montadora>();
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM MONTADORA;");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.isClosed()){
                while(resultSet.next()){

                    Montadora montadora = new Montadora();
                    montadora.setIdMontadora(resultSet.getInt("ID_MONTADORA"));
                    montadora.setNomeMontadora(resultSet.getString("NOME_MONTADORA"));

                    montadoras.add(montadora);
                }
            }
            this.connection.close();
            return montadoras;
        }
        catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), this.getClass().getSimpleName());
        }
        return null;
    }
}
