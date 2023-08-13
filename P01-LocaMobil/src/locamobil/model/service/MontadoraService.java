/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.model.service;

import locamobil.global.util.Common;
import locamobil.global.util.Mensagens;

/**
 *
 * @author Marcos
 */
public class MontadoraService {
    
    public boolean verificaId(String id){
        if(Common.isNullOrEmpty(id)){
            Mensagens.mensagemErro("Selecione uma montadora!", "Usuario");
            return false;
        }
        return true;
    }
    public boolean verificaMontadora(String montadora){
        if(Common.isNullOrEmpty(montadora)){
            Mensagens.mensagemErro("O Campo Montadora é obrigatório!", "Usuario");
            return false;
        }
        return true;
    }
    
}
