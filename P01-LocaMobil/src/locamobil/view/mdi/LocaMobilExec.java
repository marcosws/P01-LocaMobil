/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.mdi;


/**
 *
 * @author Marcos
 */
public class LocaMobilExec {
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.inicializa();
        });

    }
    
}
