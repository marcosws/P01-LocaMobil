/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.controller;

import java.util.List;
import locamobil.model.dao.ModeloDao;
import locamobil.model.dao.MontadoraDao;
import locamobil.model.entity.Modelo;
import locamobil.model.entity.Montadora;
import locamobil.view.chid.ModeloView;

/**
 *
 * @author Marcos
 */
public class ModeloController implements IController {

    private ModeloView modeloView;
    
    @Override
    public void incluir(Object view) {
        
        modeloView = (ModeloView)view;
        ModeloDao modeloDao = new ModeloDao();
        Modelo modelo = new Modelo();
        modelo.setNomeModelo(modeloView.getJtfNomeModelo().getText());
        modelo.setIdMontadora(this.recuperaIdMontadora(modeloView));
        modeloDao.incluir(modelo);
        
    }

    @Override
    public void alterar(Object view) {
        
        modeloView = (ModeloView)view;
        ModeloDao modeloDao = new ModeloDao();
        Modelo modelo = new Modelo();
        modelo.setIdModelo(Integer.parseInt(modeloView.getJtfIdModelo().getText()));
        modelo.setNomeModelo(modeloView.getJtfNomeModelo().getText());
        modelo.setIdMontadora(this.recuperaIdMontadora(modeloView));
        modeloDao.alterar(modelo);
        
    }

    @Override
    public void excluir(Object view) {
        
        modeloView = (ModeloView)view;
        ModeloDao modeloDao = new ModeloDao();
        Modelo modelo = new Modelo();
        modelo.setIdModelo(Integer.parseInt(modeloView.getJtfIdModelo().getText()));
        modeloDao.excluir(modelo);
        
    }

    @Override
    public void consultar(Object view) {
        
        modeloView = (ModeloView)view;
        ModeloDao modeloDao = new ModeloDao();
        MontadoraDao montadoraDao = new MontadoraDao();
        List<Modelo> modelos = modeloDao.consultar();
        modeloView.getGridView().clearGrid();
        modelos.forEach((m) ->{
            modeloView.getGridView().getModel().addRow(new Object[]{
                m.getIdModelo(),
                m.getNomeModelo(),
                montadoraDao.consultar(m.getIdMontadora()).getNomeMontadora()
            });
        });
        
    }
    
    public void carregaComboMontadora(Object view){
        
        modeloView = (ModeloView)view;
        MontadoraDao montadoraDao = new MontadoraDao();
        List<Montadora> montadoras = montadoraDao.consultar();
        montadoras.forEach((m) -> {
            modeloView.getJcbMontadora().addItem(m.getNomeMontadora());
        });
    }
    
    private int recuperaIdMontadora(ModeloView modeloView){
        
        MontadoraDao montadoraDao = new MontadoraDao();
        String strMontadora = modeloView.getJcbMontadora().getModel().getSelectedItem().toString();
        List<Montadora> montadoras = montadoraDao.consultar();
        for(Montadora m: montadoras){
            if(m.getNomeMontadora().equals(strMontadora)){
                return m.getIdMontadora();
            }
        }
        return 0; 
    }
    
}
