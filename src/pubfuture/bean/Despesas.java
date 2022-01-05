/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.bean;

import java.util.Date;

/**
 *
 * @author Igor Fernandes
 */
public class Despesas {

    private Integer iddespesas;
    private Double valor;
    private Date dtpagamento;
    private Date dtpagesperado;
    private String descricao;
    private Conta conta;

    public Integer getIddespesas() {
        return iddespesas;
    }

    public void setIddespesas(Integer iddespesas) {
        this.iddespesas = iddespesas;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDtpagamento() {
        return dtpagamento;
    }

    public void setDtpagamento(Date dtpagamento) {
        this.dtpagamento = dtpagamento;
    }

    public Date getDtpagesperado() {
        return dtpagesperado;
    }

    public void setDtpagesperado(Date dtpagesperado) {
        this.dtpagesperado = dtpagesperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Despesas(Double valor, Date dtpagamento, Date dtpagesperado, String descricao, Conta conta) {
        this.valor = valor;
        this.dtpagamento = dtpagamento;
        this.dtpagesperado = dtpagesperado;
        this.descricao = descricao;
        this.conta = conta;
    }

    public Despesas() {
    }

}
