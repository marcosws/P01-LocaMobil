/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.util;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class GridView {
    
    protected JTable table;
    protected DefaultTableModel model;
    protected JScrollPane jScrollPane;

    public JTable getTable() {
        return table;
    }
    
    public DefaultTableModel getModel() {
        return model;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }
    public GridView(){
        
        model = new DefaultTableModel();
        table = new JTable(model){
            @Override // Deixa o JTable como somente leitura (Read Only)
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jScrollPane = new JScrollPane(table);
    }
    public void clearGrid(){
        int linhas = model.getRowCount();
        for(int i = linhas - 1; i >= 0; i--){
           model.removeRow(i); 
        }
    }
}
