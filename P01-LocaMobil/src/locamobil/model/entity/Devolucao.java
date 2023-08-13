/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.model.entity;

import java.util.Calendar;

/**
 *
 * @author Marcos
 */
public class Devolucao {
    
    private int idDevolucao;
    private Calendar dataDevolucao;
    private double valorMultaTotal;
    private String anotacoes;
    private int idLocacao;
    private int idUsuario;

    public int getIdDevolucao() {
        return idDevolucao;
    }

    public void setIdDevolucao(int idDevolucao) {
        this.idDevolucao = idDevolucao;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorMultaTotal() {
        return valorMultaTotal;
    }

    public void setValorMultaTotal(double valorMultaTotal) {
        this.valorMultaTotal = valorMultaTotal;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
}
