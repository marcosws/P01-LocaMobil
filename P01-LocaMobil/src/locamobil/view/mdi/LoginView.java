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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import locamobil.controller.LoginController;

/**
 *
 * @author Marcos
 */
public class LoginView extends JFrame implements ActionListener{
     
    private final JTextField jtfLogin;
    private final JPasswordField jpfSenha;
    private final JButton jbAcessar;
    private final JButton jbAlterarSenha;
    private final JButton jbSair;
    private final JPanel panel;
    
    public JTextField getJtfLogin() {
        return jtfLogin;
    }

    public JPasswordField getJpfSenha() {
        return jpfSenha;
    }
    
    public LoginView(){
        
        panel = new JPanel();
        panel.setLayout(null);
        
        jtfLogin = new JTextField();
        jpfSenha = new JPasswordField();
        JLabel jlTitulo = new JLabel("LocaMobil - Login");
        JLabel jlLogin = new JLabel("Login");
        JLabel jlSenha = new JLabel("Senha");
        jbAcessar = new JButton("Acessar");
        jbAlterarSenha = new JButton("Alterar Senha");
        jbSair = new JButton("Sair");
        
        jlTitulo.setBounds(10, 10, 300, 30);
        jlTitulo.setFont(new Font("Arial",Font.BOLD,14));
        
        jlLogin.setBounds(10, 40, 100, 20);
        jtfLogin.setBounds(10, 60, 200, 20);
        jlSenha.setBounds(10, 80, 100, 20);        
        jpfSenha.setBounds(10, 100, 200, 20);
        
        jbAcessar.setBounds(220, 60, 120, 20);
        jbAlterarSenha.setBounds(220, 100, 120, 20);
        jbSair.setBounds(220, 20, 120, 20);
        
        panel.add(jlTitulo);
        panel.add(jlLogin);
        panel.add(jtfLogin);
        panel.add(jlSenha);
        panel.add(jpfSenha);
        panel.add(jbAcessar);
        panel.add(jbAlterarSenha);
        panel.add(jbSair);
        
    }
    
    public void inicializa(){
        
        jbAcessar.addActionListener(this);
        jbSair.addActionListener(this);
        jbAlterarSenha.addActionListener(this);
        
        this.setTitle("LocaMobil");
        this.setBounds(0, 0, 360, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource().equals(jbAcessar)){
            
            LoginController loginController = new LoginController();
            switch (loginController.logar(this)) {
                case OK:
                    LocaMobilPrincipal locaMobilPrincipal = new LocaMobilPrincipal();
                    locaMobilPrincipal.inicializa();
                    this.dispose();
                    break;
                case USUARIO_INATIVO:
                {
                    int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
                    JOptionPane.showMessageDialog(null, "Usuário inativo!", "Acesso Negado", option);
                    break;
                }
                default:
                {
                    int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
                    JOptionPane.showMessageDialog(null, "Login ou Senha Inválido!", "Acesso Negado", option);
                    break;
                }
            }

        }
        else if(evento.getSource().equals(jbAlterarSenha)){
            AlterarSenhaView alterarSenhaView = new AlterarSenhaView();
            alterarSenhaView.inicializa();
            this.dispose();
        }
        else if(evento.getSource().equals(jbSair)){
            if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Login", JOptionPane.OK_CANCEL_OPTION) == 0){
                System.exit(0);
            }
        }
        
    }
    
}
