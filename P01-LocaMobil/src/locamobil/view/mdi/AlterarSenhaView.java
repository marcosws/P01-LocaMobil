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
import locamobil.controller.AlterarSenhaController;
import locamobil.global.util.Mensagens;

/**
 *
 * @author Marcos
 */
public class AlterarSenhaView  extends JFrame implements ActionListener{
    
    private final JTextField jtfLogin;
    private final JPasswordField jpfSenha;
    private final JPasswordField jpfNovaSenha;
    private final JPasswordField jpfConfirmaSenha;
    private final JButton jbCancelar;
    private final JButton jbAlterarSenha;
    private final JButton jbSair;
    private final JPanel panel;

    public JTextField getJtfLogin() {
        return jtfLogin;
    }

    public JPasswordField getJpfSenha() {
        return jpfSenha;
    }

    public JPasswordField getJpfNovaSenha() {
        return jpfNovaSenha;
    }

    public JPasswordField getJpfConfirmaSenha() {
        return jpfConfirmaSenha;
    }
    
    public AlterarSenhaView(){
        
        panel = new JPanel();
        panel.setLayout(null);
        
        jtfLogin = new JTextField();
        jpfSenha = new JPasswordField();
        jpfNovaSenha = new JPasswordField();
        jpfConfirmaSenha = new JPasswordField();
        
        JLabel jlTitulo = new JLabel("LocaMobil - Alterar");
        jlTitulo.setBounds(10, 10, 300, 30);
        jlTitulo.setFont(new Font("Arial",Font.BOLD,14));
        
        JLabel jlLogin = new JLabel("Login");
        jlLogin.setBounds(10, 40, 100, 20);
        jtfLogin.setBounds(10, 60, 200, 20);
        
        JLabel jlSenha = new JLabel("Sua Senha");
        jlSenha.setBounds(10, 80, 200, 20);
        jpfSenha.setBounds(10, 100, 200, 20);
        
        JLabel jlNovaSenha = new JLabel("Nova Senha");
        jlNovaSenha.setBounds(10, 120, 200, 20);
        jpfNovaSenha.setBounds(10, 140, 200, 20);
        
        JLabel jlConfirmaSenha = new JLabel("Confirmar Senha");
        jlConfirmaSenha.setBounds(10, 160, 200, 20);
        jpfConfirmaSenha.setBounds(10, 180, 200, 20);
       
        jbAlterarSenha = new JButton("Alterar Senha");
        jbAlterarSenha.setBounds(220, 60, 120, 20);
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(220, 100, 120, 20);
        
        jbSair = new JButton("Sair");
        jbSair.setBounds(220, 20, 120, 20);
        
        panel.add(jlTitulo);
        panel.add(jlLogin);
        panel.add(jtfLogin);
        panel.add(jlSenha);
        panel.add(jpfSenha);
        panel.add(jlNovaSenha);
        panel.add(jpfNovaSenha);
        panel.add(jlConfirmaSenha);
        panel.add(jpfConfirmaSenha);
        panel.add(jbCancelar);
        panel.add(jbAlterarSenha);
        panel.add(jbSair);
        
    }
    
    public void inicializa(){
        
        jbCancelar.addActionListener(this);
        jbAlterarSenha.addActionListener(this);
        jbSair.addActionListener(this);
                
        this.setTitle("LocaMobil");
        this.setBounds(0, 0, 360, 260);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource().equals(jbCancelar)){
            LoginView loginView = new LoginView();
            loginView.inicializa();
            this.dispose();
        }
        else if(evento.getSource().equals(jbAlterarSenha)){
            
            AlterarSenhaController alterarSenhaController = new AlterarSenhaController();
            switch(alterarSenhaController.alterarSenha(this))
            {
                case OK:
                    LoginView loginView = new LoginView();
                    loginView.inicializa();
                    this.dispose();
                    break;

                case SENHA_DIFERENTE:
                    /* Mensagem tratada na controller*/
                    break;
                    
                case SENHA_VAZIA:
                    /* Mensagem tratada na controller */
                    break;
                    
                case USUARIO_INATIVO:
                    Mensagens.mensagemErro("Usuario inativo!", "Alterar senha");
                    break;
                
                default:
                    Mensagens.mensagemErro("Login ou Senha Inválido!", "Alterar senha");
                    break;
                
            }

        }
        else if(evento.getSource().equals(jbSair)){
            if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Login", JOptionPane.OK_CANCEL_OPTION) == 0){
                System.exit(0);
            }
        }
    }
            
    
}
