/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.mdi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class LoginView extends JFrame implements ActionListener{
     
    private final JTextField jtfLogin;
    private final JTextField jtfSenha;
    private final JButton jbAcessar;
    private final JButton jbSair;
    private final JPanel panel;
    
    public LoginView(){
        
        panel = new JPanel();
        panel.setLayout(null);
        
        jtfLogin = new JTextField();
        jtfSenha = new JTextField();
        JLabel jlTitulo = new JLabel("LocaMobil - Login");
        JLabel jlLogin = new JLabel("Login");
        JLabel jlSenha = new JLabel("Senha");
        jbAcessar = new JButton("Acessar");
        jbSair = new JButton("Sair");
        
        jlTitulo.setBounds(10, 10, 300, 30);
        jlTitulo.setFont(new Font("Arial",Font.BOLD,14));
        
        jlLogin.setBounds(10, 40, 100, 20);
        jtfLogin.setBounds(10, 60, 200, 20);
        jlSenha.setBounds(10, 80, 100, 20);        
        jtfSenha.setBounds(10, 100, 200, 20);
        
        jbAcessar.setBounds(220, 60, 100, 20);
        jbSair.setBounds(220, 100, 100, 20);
        
        panel.add(jlTitulo);
        panel.add(jlLogin);
        panel.add(jtfLogin);
        panel.add(jlSenha);
        panel.add(jtfSenha);
        panel.add(jbAcessar);
        panel.add(jbSair);
        
    }
    
    public void inicializa(){
        
        jbAcessar.addActionListener(this);
        jbSair.addActionListener(this);
        
        this.setTitle("LocaMobil");
        this.setBounds(0, 0, 350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource().equals(jbAcessar)){
            LocaMobilPrincipal locaMobilPrincipal = new LocaMobilPrincipal();
            locaMobilPrincipal.inicializa();
            this.dispose();
        }
        else if(evento.getSource().equals(jbSair)){
            if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Login", JOptionPane.OK_CANCEL_OPTION) == 0){
                System.exit(0);
            }
        }
        
    }
    
}
