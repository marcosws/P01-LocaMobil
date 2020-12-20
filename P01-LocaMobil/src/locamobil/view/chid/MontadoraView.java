/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import java.awt.event.ActionEvent;
import locamobil.view.util.PrincipalDimensao;

/**
 *
 * @author Marcos
 */
public class MontadoraView extends ControleChild {
    
    
    public MontadoraView(){
        
        super("Montadora","Cadastro de Montadora");
        

        
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
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource().equals(botaoIncluir)){
            
        }
        else if(evento.getSource().equals(botaoAlterar)){
                
        }
        else if(evento.getSource().equals(botaoExcluir)){
                
        }
        else if(evento.getSource().equals(botaoConsultar)){
                
        }
        else if(evento.getSource().equals(botaoCancelar)){
                
        }
        else if(evento.getSource().equals(botaoConfirmar)){
                
        }
        else if(evento.getSource().equals(botaoFechar)){
                
        }
    }
    
}
