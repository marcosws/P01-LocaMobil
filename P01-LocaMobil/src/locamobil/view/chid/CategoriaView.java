/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import locamobil.view.util.GridView;
import locamobil.view.util.Operacao;
import locamobil.view.util.PrincipalDimensao;

/**
 *
 * @author Marcos
 */
public class CategoriaView extends ControleChild {

    private JTextField jtfIdCategoria;
    private JTextField jtfCategoria;
    private GridView gridView;

    public JTextField getJtfIdCategoria() {
        return jtfIdCategoria;
    }

    public JTextField getJtfCategoria() {
        return jtfCategoria;
    }

    public GridView getGridView() {
        return gridView;
    }
    
    public CategoriaView() {
        
        super("Categoria", "Cadastro de Categoria");
        
        jtfIdCategoria = new JTextField();
        jtfCategoria = new JTextField();
        
        JLabel lbIdCategoria = new  JLabel("Id:");
        lbIdCategoria.setBounds(20, 120, 500, 20);
        jtfIdCategoria.setBounds(20, 140, 100, 20);
        jtfIdCategoria.setEditable(false);
        
        JLabel lbCategoria = new  JLabel("Categoria:");
        lbCategoria.setBounds(20, 160, 500, 20);
        jtfCategoria.setBounds(20, 180, 200, 20);
        jtfCategoria.setEditable(false);
        
        JLabel lbCategoriasCadastradas = new JLabel("Categorias Cadastradas:");
        lbCategoriasCadastradas.setBounds(20, 200, 500, 20);
        gridView = new GridView();
        gridView.getModel().addColumn("Id");
        gridView.getModel().addColumn("Categorias"); 
        gridView.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = gridView.getTable().getSelectedRow();
                jtfIdCategoria.setText(gridView.getTable().getModel().getValueAt(row, 0).toString()); 
                jtfCategoria.setText(gridView.getTable().getModel().getValueAt(row, 1).toString());
            }
        });
        gridView.getjScrollPane().setBounds(20, 220, 700, 200);

        panel.add(lbCategoria);
        panel.add(lbIdCategoria);
        panel.add(jtfIdCategoria);
        panel.add(jtfCategoria);
        panel.add(lbCategoriasCadastradas);
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
        jtfCategoria.setEditable(valor);
    }

    private void limpaCampos() {
        jtfIdCategoria.setText("");
        jtfCategoria.setText("");
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
