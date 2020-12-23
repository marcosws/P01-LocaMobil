/*
 * 
 */
package locamobil.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import locamobil.global.util.Mensagens;
import locamobil.model.util.DadosArqProperties;
import org.sqlite.SQLiteConfig;

/**
 * git status
 * @author Marcos
 */
public class ConexaoSQLite {
    
     private Properties connectionProperties = new Properties();
    
    public Connection getConnection(){
        
        DadosArqProperties dadosArqProperties = new DadosArqProperties();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        connectionProperties = config.toProperties();
        String path = System.getProperty("user.dir");
        String partialPath = "/db/";
        //path = path.replace("\\", "/");
        String strConexao = "jdbc:sqlite:" + path + partialPath + dadosArqProperties.getNameDataBase();
        
        try{	
            return DriverManager.getConnection(strConexao,connectionProperties);	
	}
	catch(SQLException e){
            Mensagens.mensagemErro("Erro: " + e.getMessage() + "\nCódigo do Erro: " + e.getErrorCode(), "Conexao:");
        }
        return null;
    }
    
}
