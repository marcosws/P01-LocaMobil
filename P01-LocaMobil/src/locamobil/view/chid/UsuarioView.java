/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import locamobil.controller.UsuarioController;
import locamobil.view.util.Constantes;
import locamobil.view.util.GridView;
import locamobil.view.util.Operacao;
import locamobil.view.util.PrincipalDimensao;

/**
 *
 * @author Marcos
 */
public class UsuarioView extends ControleChild {
    
    private JTextField jtfIdUsuario;
    private JTextField jtfNomeUsuario;
    private JTextField jtfLogin;
    private final JCheckBox jcbAlterarSenha;
    private final JPasswordField jpfSenha;
    private final JPasswordField jpfCofirmarSenha;
    private JComboBox jcbAdministrador;
    private JComboBox jcbAtivo;
    private GridView gridView;


    public JTextField getJtfIdUsuario() {
        return jtfIdUsuario;
    }

    public JTextField getJtfNomeUsuario() {
        return jtfNomeUsuario;
    }

    public JTextField getJtfLogin() {
        return jtfLogin;
    }

    public JCheckBox getJcbAlterarSenha() {
        return jcbAlterarSenha;
    }

    public JPasswordField getJpfSenha() {
        return jpfSenha;
    }

    public JPasswordField getJpfCofirmarSenha() {
        return jpfCofirmarSenha;
    }

    public JComboBox getJcbAdministrador() {
        return jcbAdministrador;
    }

    public JComboBox getJcbAtivo() {
        return jcbAtivo;
    }

    public GridView getGridView() {
        return gridView;
    }
    
    public UsuarioView() {
        
        super("Usuário", "Cadastro de Usuario");
        
        jtfIdUsuario = new JTextField();
        jtfNomeUsuario = new JTextField();
        jtfLogin = new JTextField();
        jpfSenha = new JPasswordField();
        jpfCofirmarSenha = new JPasswordField();
        jcbAdministrador = new JComboBox();
        jcbAtivo = new JComboBox();
        
        JLabel lbIdUsuario = new  JLabel("Id:");
        lbIdUsuario.setBounds(20, 120, 500, 20);
        jtfIdUsuario.setBounds(20, 140, 100, 20);
        jtfIdUsuario.setEditable(false);
                
        JLabel lbNomeUsuario = new  JLabel("Nome do Usuario:");
        lbNomeUsuario.setBounds(20, 160, 500, 20);
        jtfNomeUsuario.setBounds(20, 180, 500, 20);
        jtfNomeUsuario.setEditable(false);

        JLabel lbLogin = new  JLabel("Login:");
        lbLogin.setBounds(20, 200, 500, 20);
        jtfLogin.setBounds(20, 220, 150, 20);
        jtfLogin.setEditable(false);

        jcbAlterarSenha = new JCheckBox("Alterar Senha", false);
        jcbAlterarSenha.setBounds(180, 260, 150, 20);
        jcbAlterarSenha.setEnabled(false);
        jcbAlterarSenha.addActionListener((ActionEvent e) -> {
            if(jcbAlterarSenha.getModel().isSelected()){
                jpfSenha.setEditable(true);
                jpfCofirmarSenha.setEditable(true);
            }
            else{
                jpfSenha.setEditable(false);
                jpfCofirmarSenha.setEditable(false);
            }
        });

        JLabel lbSenha = new  JLabel("Senha:");
        lbSenha.setBounds(20, 240, 500, 20);
        jpfSenha.setBounds(20, 260, 150, 20);
        jpfSenha.setEditable(false);
        
        JLabel lbConfirmarSenha = new  JLabel("Confirme a Senha:");
        lbConfirmarSenha.setBounds(20, 280, 500, 20);
        jpfCofirmarSenha.setBounds(20, 300 , 150, 20);
        jpfCofirmarSenha.setEditable(false);

        JLabel lbAdministrador = new  JLabel("Administrador do Sistema:");
        lbAdministrador.setBounds(20, 320, 500, 20);
        jcbAdministrador.setBounds(20, 340, 150, 20);
        jcbAdministrador.addItem(Constantes.SIM);
        jcbAdministrador.addItem(Constantes.NAO);
        jcbAdministrador.setEnabled(false);
           
        JLabel lbAtivo = new  JLabel("Ativo no Sistema:");
        lbAtivo.setBounds(20, 360, 500, 20);
        jcbAtivo.setBounds(20, 380, 150, 20);
        jcbAtivo.addItem(Constantes.SIM);
        jcbAtivo.addItem(Constantes.NAO);
        jcbAtivo.setEnabled(false);
        
        JLabel lbUsuariosCadastrados = new JLabel("Usuarios Cadastrados:");
        lbUsuariosCadastrados.setBounds(20, 400, 500, 20);
        gridView = new GridView();
        gridView.getModel().addColumn("Id");
        gridView.getModel().addColumn("Nome"); 
        gridView.getModel().addColumn("Login"); 
        gridView.getModel().addColumn("Adminstrador"); 
        gridView.getModel().addColumn("Ativo"); 
        gridView.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = gridView.getTable().getSelectedRow();
                jtfIdUsuario.setText(gridView.getTable().getModel().getValueAt(row, 0).toString()); 
                jtfNomeUsuario.setText(gridView.getTable().getModel().getValueAt(row, 1).toString());
                jtfLogin.setText(gridView.getTable().getModel().getValueAt(row, 2).toString());
                jcbAdministrador.getModel().setSelectedItem(gridView.getTable().getModel().getValueAt(row, 3).toString());
                jcbAtivo.getModel().setSelectedItem(gridView.getTable().getModel().getValueAt(row, 4).toString());
            }
        });
        gridView.getjScrollPane().setBounds(20, 420, 700, 200);
        
        panel.add(lbIdUsuario);
        panel.add(lbNomeUsuario);
        panel.add(lbLogin);
        panel.add(lbSenha);
        panel.add(lbConfirmarSenha);
        panel.add(lbAdministrador);
        panel.add(lbAtivo);
        panel.add(jtfIdUsuario);
        panel.add(jtfNomeUsuario);
        panel.add(jtfLogin);
        panel.add(jpfSenha);
        panel.add(jcbAlterarSenha);
        panel.add(jpfCofirmarSenha);
        panel.add(jcbAdministrador);
        panel.add(jcbAtivo);
        panel.add(lbUsuariosCadastrados);
        panel.add(gridView.getjScrollPane());
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(0, 0, (int)PrincipalDimensao.getWidth(), (int)PrincipalDimensao.getHeight());
        frame.setVisible(true);
        
    }

    public void inicializa(){
        
        botaoIncluir.addActionListener(this);
        botaoAlterar.addActionListener(this);
        botaoExcluir.addActionListener(this);
        botaoConsultar.addActionListener(this);
        botaoCancelar.addActionListener(this);
        botaoConfirmar.addActionListener(this);
        botaoFechar.addActionListener(this);
        jcbAlterarSenha.addActionListener(this);
        
    }
    public void limpaCampos(){
        
        jtfIdUsuario.setText("");
        jtfNomeUsuario.setText("");
        jtfLogin.setText("");
        jpfSenha.setText("");
        jpfCofirmarSenha.setText("");
        jcbAdministrador.getModel().setSelectedItem("Sim");
        jcbAtivo.getModel().setSelectedItem("Sim");
        
    }
    private void desabilitaCampos(){
        jtfNomeUsuario.setEditable(false);
        jtfLogin.setEditable(false);
        jcbAlterarSenha.setEnabled(false);
        jpfSenha.setEditable(false);
        jpfCofirmarSenha.setEditable(false);
        jcbAdministrador.setEnabled(false);
        jcbAtivo.setEnabled(false);
    }
    @Override
    public void habilitaDesabilitaCampos(){
        if(operacao.equals(Operacao.INCLUIR.getNomeOperacao())){
            jtfNomeUsuario.setEditable(true);
            jtfLogin.setEditable(true);
            jcbAlterarSenha.setEnabled(false);
            jpfSenha.setEditable(true);
            jpfCofirmarSenha.setEditable(true);
            jcbAdministrador.setEnabled(true);
            jcbAtivo.setEnabled(true);
        }
        else if(operacao.equals(Operacao.ALTERAR.getNomeOperacao())){
            jtfNomeUsuario.setEditable(true);
            jtfLogin.setEditable(true);
            jcbAlterarSenha.setEnabled(true);
            jpfSenha.setEditable(false);
            jpfCofirmarSenha.setEditable(false);
            jcbAdministrador.setEnabled(true);
            jcbAtivo.setEnabled(true);
        }
        else if(operacao.equals(Operacao.EXCLUIR.getNomeOperacao())){
            this.desabilitaCampos();
        }
        else if(operacao.equals(Operacao.CONSULTAR.getNomeOperacao())){
            this.desabilitaCampos();
        }
        else if(operacao.equals(Operacao.CANCELAR.getNomeOperacao())){
            this.desabilitaCampos();
            this.limpaCampos();
        }
        else{
            this.desabilitaCampos();
        }
    }
    @Override
    public void incluir() {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.incluir(this);
    }

    @Override
    public void alterar() {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.alterar(this);
    }

    @Override
    public void excluir() {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.excluir(this);
    }

    @Override
    public void consultar() {
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.consultar(this);
    }
    
}
