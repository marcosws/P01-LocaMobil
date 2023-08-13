/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import javax.swing.JLabel;
import javax.swing.JTextField;
import locamobil.view.util.GridView;
import locamobil.view.util.Operacao;
import locamobil.view.util.PrincipalDimensao;

/**
 *
 * @author Marcos
 */
public class CombustivelView  extends ControleChild {

    private JTextField jtfIdCombustivel;
    private JTextField jtfCombustivel;
    private GridView gridView;
    
    
    public CombustivelView() {
        
        super("Combustivel", "Cadastro de Tipo de Combustivel");
        
        jtfIdCombustivel = new JTextField();
        jtfCombustivel = new JTextField();
        
        JLabel lbIdCombustivel = new  JLabel("Id:");
        lbIdCombustivel.setBounds(20, 120, 500, 20);
        jtfIdCombustivel.setBounds(20, 140, 100, 20);
        jtfIdCombustivel.setEditable(false);
        
        JLabel lbCombustivel = new  JLabel("Combustivel:");
        lbCombustivel.setBounds(20, 160, 500, 20);
        jtfCombustivel.setBounds(20, 180, 200, 20);
        jtfCombustivel.setEditable(false);
        
        JLabel lbCombustivelCadastradas = new JLabel("Combustiveis Cadastradas:");
        lbCombustivelCadastradas.setBounds(20, 200, 500, 20);
        gridView = new GridView();
        gridView.getModel().addColumn("Id");
        gridView.getModel().addColumn("Combustivel"); 
        gridView.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = gridView.getTable().getSelectedRow();
                jtfIdCombustivel.setText(gridView.getTable().getModel().getValueAt(row, 0).toString()); 
                jtfCombustivel.setText(gridView.getTable().getModel().getValueAt(row, 1).toString());
            }
        });
        gridView.getjScrollPane().setBounds(20, 220, 700, 200);

        panel.add(lbIdCombustivel);
        panel.add(jtfIdCombustivel);
        panel.add(lbCombustivel);
        panel.add(jtfCombustivel);
        panel.add(lbCombustivelCadastradas);
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
    
    private void habilitaDesabilitaCampos(boolean valor) {
        jtfCombustivel.setEditable(valor);
    }

    private void limpaCampos() {
        jtfIdCombustivel.setText("");
        jtfCombustivel.setText("");
    }
    
    @Override
    public void incluir() {
       
    }

    @Override
    public void alterar() {
        
    }

    @Override
    public void excluir() {
        
    }

    @Override
    public void consultar() {
        
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
