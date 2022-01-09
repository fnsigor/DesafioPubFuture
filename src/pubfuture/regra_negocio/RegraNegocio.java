/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.regra_negocio;

import pubfuture.bean.Conta;

/**
 *
 * @author Igor Fernandes
 */
public class RegraNegocio {
     public void registarReceita(Conta conta, double valorReceita) {
        conta.setSaldo(valorReceita + conta.getSaldo());

    }

    public String registarDespesa(Conta conta, double valorDespesa) {
        String mensagem;
        if (valorDespesa <= conta.getSaldo()) {
            conta.setSaldo(conta.getSaldo() - valorDespesa);
            mensagem = "Retire seu dinheiro";
        } else {
            mensagem = "O saldo de "+conta.getSaldo()+" reais é insuficiente para realizar esta operação";
        }
        return mensagem;
    }
    
}
