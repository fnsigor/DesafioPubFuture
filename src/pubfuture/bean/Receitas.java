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
public class Receitas {

    private Integer idreceitas;
    private Double valor;
    private Date dtrecebimento;
    private Date dtrecesperado;
    private String descricao;
    private String tipo;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDtrecebimento() {
        return dtrecebimento;
    }

    public void setDtrecebimento(Date dtrecebimento) {
        this.dtrecebimento = dtrecebimento;
    }

    public Date getDtrecesperado() {
        return dtrecesperado;
    }

    public void setDtrecesperado(Date dtrecesperado) {
        this.dtrecesperado = dtrecesperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    private Conta conta;

    public Integer getIdreceitas() {
        return idreceitas;
    }

    public void setIdreceitas(Integer idreceitas) {
        this.idreceitas = idreceitas;
    }

}
