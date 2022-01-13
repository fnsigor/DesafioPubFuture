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
public class Transferencia {

    double valor;
    Date dtTransferencia;
    Conta pagador;
    Conta recebedor;
    int idtransferencia;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDtTransferencia() {
        return dtTransferencia;
    }

    public void setDtTransferencia(Date dtTransferencia) {
        this.dtTransferencia = dtTransferencia;
    }

    public Conta getPagador() {
        return pagador;
    }

    public void setPagador(Conta pagador) {
        this.pagador = pagador;
    }

    public Conta getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(Conta recebedor) {
        this.recebedor = recebedor;
    }

    public int getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(int idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

}
