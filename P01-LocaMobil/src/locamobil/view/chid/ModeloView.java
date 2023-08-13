/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import locamobil.controller.ModeloController;
import locamobil.view.util.GridView;
import locamobil.view.util.Operacao;
import locamobil.view.util.PrincipalDimensao;

/**
 *
 * @author Marcos
 */
public class ModeloView  extends ControleChild {
    
    private JTextField jtfIdModelo;
    private JTextField jtfNomeModelo;
    private JComboBox jcbMontadora;
    private GridView gridView;

    public GridView getGridView() {
        return gridView;
    }

    public JTextField getJtfIdModelo() {
        return jtfIdModelo;
    }

    public JTextField getJtfNomeModelo() {
        return jtfNomeModelo;
    }

    public JComboBox getJcbMontadora() {
        return jcbMontadora;
    }
    
    

    public ModeloView() {
        
        super("Modelo", "Cadastro de Modelo");
        
        jtfIdModelo = new JTextField();
        jtfNomeModelo = new JTextField();
        jcbMontadora = new JComboBox();
        
        JLabel lbIdModelo = new  JLabel("Id:");
        lbIdModelo.setBounds(20, 120, 500, 20);
        jtfIdModelo.setBounds(20, 140, 100, 20);
        jtfIdModelo.setEditable(false);
        
        JLabel lbNomeModelo = new  JLabel("Nome Modelo:");
        lbNomeModelo.setBounds(20, 160, 500, 20);
        jtfNomeModelo.setBounds(20, 180, 200, 20);
        jtfNomeModelo.setEditable(false);
        
        JLabel lbMontadora = new  JLabel("Montadora:");
        lbMontadora.setBounds(20, 200, 500, 20);
        jcbMontadora.setBounds(20, 220, 200, 20);
        jcbMontadora.setEnabled(false);
        
        JLabel lbModeloCadastrados = new JLabel("Modelos Cadastrados:");
        lbModeloCadastrados.setBounds(20, 240, 500, 20);
        gridView = new GridView();
        gridView.getModel().addColumn("Id");
        gridView.getModel().addColumn("Modelo");
        gridView.getModel().addColumn("Montadora");
        gridView.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = gridView.getTable().getSelectedRow();
                jtfIdModelo.setText(gridView.getTable().getModel().getValueAt(row, 0).toString()); 
                jtfNomeModelo.setText(gridView.getTable().getModel().getValueAt(row, 1).toString());
                jcbMontadora.getModel().setSelectedItem(gridView.getTable().getModel().getValueAt(row, 2).toString());
            }
        });
        gridView.getjScrollPane().setBounds(20, 260, 700, 200);
        
        
        panel.add(lbIdModelo);
        panel.add(jtfIdModelo);
        panel.add(lbNomeModelo);
        panel.add(jtfNomeModelo);
        panel.add(lbMontadora);
        panel.add(jcbMontadora);
        panel.add(lbModeloCadastrados);
        panel.add(gridView.getjScrollPane());
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(0, 0, (int)PrincipalDimensao.getWidth(), (int)PrincipalDimensao.getHeight());
        frame.setVisible(true);
    }
    
    public void inicializa(){
        
        ModeloController modeloController = new ModeloController();
        modeloController.carregaComboMontadora(this);
                
        botaoIncluir.addActionListener(this);
        botaoAlterar.addActionListener(this);
        botaoExcluir.addActionListener(this);
        botaoConsultar.addActionListener(this);
        botaoCancelar.addActionListener(this);
        botaoConfirmar.addActionListener(this);
        botaoFechar.addActionListener(this);
        
    }
    
    public void limpaCampos(){
        jtfIdModelo.setText("");
        jtfNomeModelo.setText("");
    }
    
    public void habilitaDesabilitaCampos(boolean valor){
        jtfNomeModelo.setEditable(valor);
        jcbMontadora.setEnabled(valor);
    }
    
    @Override
    public void incluir() {
        ModeloController modeloController = new ModeloController();
        modeloController.incluir(this);
    }

    @Override
    public void alterar() {
        ModeloController modeloController = new ModeloController();
        modeloController.alterar(this);
    }

    @Override
    public void excluir() {
        ModeloController modeloController = new ModeloController();
        modeloController.excluir(this);
    }

    @Override
    public void consultar() {
        ModeloController modeloController = new ModeloController();
        modeloController.consultar(this);
    }

    @Override
    public void habilitaDesabilitaCampos() {
        if(operacao.equals(Operacao.INCLUIR.getNomeOperacao())){
            this.habilitaDesabilitaCampos(true);
            this.limpaCampos();
        }
        else if(operacao.equals(Operacao.ALTERAR.getNomeOperacao())){
            this.habilitaDesabilitaCampos(true);
        }
        else if(operacao.equals(Operacao.EXCLUIR.getNomeOperacao())){
            this.habilitaDesabilitaCampos(false);
        }
        else if(operacao.equals(Operacao.CONSULTAR.getNomeOperacao())){
            this.habilitaDesabilitaCampos(false);
            this.limpaCampos();
        }
        else if(operacao.equals(Operacao.CANCELAR.getNomeOperacao())){
            this.habilitaDesabilitaCampos(false);
            this.limpaCampos();
        }
        else{
            this.habilitaDesabilitaCampos(false);
        }
    }
    
}
