/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import javax.swing.JLabel;
import javax.swing.JTextField;
import locamobil.controller.MontadoraController;
import locamobil.view.util.GridView;
import locamobil.view.util.Operacao;
import locamobil.view.util.PrincipalDimensao;

/**
 *
 * @author Marcos
 */
public class MontadoraView extends ControleChild {
    
    private JTextField jtfIdMontadora;
    private JTextField jtfNomeMontadora;
    private GridView gridView;

    public JTextField getJtfIdMontadora() {
        return jtfIdMontadora;
    }

    public JTextField getJtfNomeMontadora() {
        return jtfNomeMontadora;
    }

    public GridView getGridView() {
        return gridView;
    }
    
    public MontadoraView(){
        
        super("Montadora","Cadastro de Montadora");
        
        jtfIdMontadora = new JTextField();
        jtfNomeMontadora = new JTextField();
        
        JLabel lbIdMontadora = new  JLabel("Id:");
        lbIdMontadora.setBounds(20, 120, 500, 20);
        jtfIdMontadora.setBounds(20, 140, 100, 20);
        jtfIdMontadora.setEditable(false);
        
        JLabel lbNomeMontadora = new  JLabel("Montadora:");
        lbNomeMontadora.setBounds(20, 160, 500, 20);
        jtfNomeMontadora.setBounds(20, 180, 200, 20);
        jtfNomeMontadora.setEditable(false);
        
        JLabel lbMontadorasCadastradas = new JLabel("Montadoras Cadastradas:");
        lbMontadorasCadastradas.setBounds(20, 200, 500, 20);
        gridView = new GridView();
        gridView.getModel().addColumn("Id");
        gridView.getModel().addColumn("Montadora"); 
        gridView.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = gridView.getTable().getSelectedRow();
                jtfIdMontadora.setText(gridView.getTable().getModel().getValueAt(row, 0).toString()); 
                jtfNomeMontadora.setText(gridView.getTable().getModel().getValueAt(row, 1).toString());
            }
        });
        gridView.getjScrollPane().setBounds(20, 220, 700, 200);

        panel.add(lbIdMontadora);
        panel.add(jtfIdMontadora);
        panel.add(lbNomeMontadora);
        panel.add(jtfNomeMontadora);
        panel.add(lbMontadorasCadastradas);
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
        
    }
    public void limpaCampos(){
        jtfIdMontadora.setText("");
        jtfNomeMontadora.setText("");
    }
    @Override
    public void incluir() {
        MontadoraController montadoraController = new MontadoraController();
        montadoraController.incluir(this);
    }

    @Override
    public void alterar() {
        MontadoraController montadoraController = new MontadoraController();
        montadoraController.alterar(this);
    }

    @Override
    public void excluir() {
        MontadoraController montadoraController = new MontadoraController();
        montadoraController.excluir(this);
    }

    @Override
    public void consultar() {
        MontadoraController montadoraController = new MontadoraController();
        montadoraController.consultar(this);
    }

    @Override
    public void habilitaDesabilitaCampos() {
        if(operacao.equals(Operacao.INCLUIR.getNomeOperacao())){
            jtfNomeMontadora.setEditable(true);
            this.limpaCampos();
        }
        else if(operacao.equals(Operacao.ALTERAR.getNomeOperacao())){
            jtfNomeMontadora.setEditable(true);
        }
        else if(operacao.equals(Operacao.EXCLUIR.getNomeOperacao())){
            jtfNomeMontadora.setEditable(false);
        }
        else if(operacao.equals(Operacao.CONSULTAR.getNomeOperacao())){
            jtfNomeMontadora.setEditable(false);
            this.limpaCampos();
        }
        else if(operacao.equals(Operacao.CANCELAR.getNomeOperacao())){
            jtfNomeMontadora.setEditable(false);
            this.limpaCampos();
        }
        else{
            jtfNomeMontadora.setEditable(false);
        }
    }
    
}
