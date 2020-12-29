/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.controller;

import java.util.List;
import locamobil.model.dao.MontadoraDao;
import locamobil.model.entity.Montadora;
import locamobil.model.service.MontadoraService;
import locamobil.view.chid.MontadoraView;

/**
 *
 * @author Marcos
 */
public class MontadoraController implements IController{

    private MontadoraView montadoraView;
    
    @Override
    public void incluir(Object view) {
        montadoraView = (MontadoraView)view;
        MontadoraDao montadoraDao = new MontadoraDao();
        Montadora montadora = new Montadora();
        MontadoraService montadoraService = new MontadoraService();
        if(!montadoraService.verificaMontadora(montadoraView.getJtfNomeMontadora().getText())){return;}
        montadora.setNomeMontadora(montadoraView.getJtfNomeMontadora().getText());
        montadoraDao.incluir(montadora);
    }

    @Override
    public void alterar(Object view) {
        montadoraView = (MontadoraView)view;
        MontadoraDao montadoraDao = new MontadoraDao();
        Montadora montadora = new Montadora();
        MontadoraService montadoraService = new MontadoraService();
        if(!montadoraService.verificaId(montadoraView.getJtfIdMontadora().getText())){return;}
        if(!montadoraService.verificaMontadora(montadoraView.getJtfNomeMontadora().getText())){return;}
        montadora.setIdMontadora(Integer.parseInt(montadoraView.getJtfIdMontadora().getText()));
        montadora.setNomeMontadora(montadoraView.getJtfNomeMontadora().getText());
        montadoraDao.alterar(montadora);
    }

    @Override
    public void excluir(Object view) {
        montadoraView = (MontadoraView)view;
        MontadoraDao montadoraDao = new MontadoraDao();
        Montadora montadora = new Montadora();
        MontadoraService montadoraService = new MontadoraService();
        if(!montadoraService.verificaId(montadoraView.getJtfIdMontadora().getText())){return;}
        montadora.setIdMontadora(Integer.parseInt(montadoraView.getJtfIdMontadora().getText()));
        montadoraDao.excluir(montadora);
    }

    @Override
    public void consultar(Object view) {
        montadoraView = (MontadoraView)view;
        MontadoraDao montadoraDao = new MontadoraDao();
        List<Montadora> montadoras = montadoraDao.consultar();
        montadoraView.getGridView().clearGrid();
        montadoras.forEach((m) -> {
            montadoraView.getGridView().getModel().addRow(new Object[]{
                m.getIdMontadora(),
                m.getNomeMontadora()
            });
        });
        
    }
    
}
