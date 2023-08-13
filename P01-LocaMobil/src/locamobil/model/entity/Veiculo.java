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
public class Veiculo {
    
    private int idVeiculo;
    private String descricao;
    private String placa;
    private String cor;
    private String ano;
    private Calendar dataCadastro;
    private double valorLocacao;
    private double valorMultaDiaria;
    private String anotacoes;
    private String status;
    private int idModelo;
    private int idCategoria;
    private int idCombustivel;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public double getValorMultaDiaria() {
        return valorMultaDiaria;
    }

    public void setValorMultaDiaria(double valorMultaDiaria) {
        this.valorMultaDiaria = valorMultaDiaria;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(int idCombustivel) {
        this.idCombustivel = idCombustivel;
    }
    
}
