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
    private String tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
