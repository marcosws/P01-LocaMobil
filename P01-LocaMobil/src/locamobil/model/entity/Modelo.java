/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.model.entity;

/**
 *
 * @author Marcos
 */
public class Modelo {
    
    private int idModelo;
    private String nomeModelo;
    private int idMontadora;
    
    public int getIdMontadora() {
        return idMontadora;
    }

    public void setIdMontadora(int idMontadora) {
        this.idMontadora = idMontadora;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

}
