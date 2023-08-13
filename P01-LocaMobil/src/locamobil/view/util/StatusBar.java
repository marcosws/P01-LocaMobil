/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.util;

import java.awt.Dimension;
import javax.swing.JLabel;
import locamobil.model.util.DadosArqProperties;

/**
 *
 * @author Marcos
 */
public class StatusBar extends JLabel{
    
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public StatusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 18));
        DadosArqProperties dadosArqProperties = new DadosArqProperties();
        this.textoMensagem("LocaMobil - Sistema para locação de veículos | Usuário: " + UsuarioLogado.getNomeUsuario() + " | Banco de Dados: " + dadosArqProperties.getNameDataBase());
    }
    
    private void textoMensagem(String msg){
        this.setText(" " + msg);
    }
    
}
