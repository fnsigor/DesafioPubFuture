/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.bean;

/**
 *
 * @author Igor Fernandes
 */
public class Conta {

    private Integer idconta;
    private String tipo;
    private String instituicao;
    private double saldo;

    public Integer getId() {
        return idconta;
    }

    public void setId(Integer id) {
        this.idconta = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(String tipo, String instituicao, double saldo) {
        this.tipo = tipo;
        this.instituicao = instituicao;
        this.saldo = saldo;
    }

    public Conta() {

    }

}
