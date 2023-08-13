/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.global.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class Mensagens {
    
    /**
     *
     * @param mensagem
     * @param titulo
     */
    public static void mensagemErro(String mensagem, String titulo){
         int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
         JOptionPane.showMessageDialog(null, mensagem, titulo, option);
    }
    public static void mensagemAviso(String mensagem, String titulo){
         int option = JOptionPane.WARNING_MESSAGE + JOptionPane.OK_OPTION;
         JOptionPane.showMessageDialog(null, mensagem, titulo, option);
    }
    public static void mensagemInfo(String mensagem, String titulo){
         int option = JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION;
         JOptionPane.showMessageDialog(null, mensagem, titulo, option);
    }
    public static boolean mensagemQuestao(String mensagem, String titulo){
        return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.OK_CANCEL_OPTION) == 0;
    }
    
}
