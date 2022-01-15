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
    
    //metodo para gerar numero de conta (5 numeros aleatorios de 0 a 10) ao cadastrar conta no banco de dados
    public String gerarNumeroConta() {
        
        String numeroAleatorio = "";
        for (int i = 0; i < 5; i++) {
            numeroAleatorio += (int) (Math.random() * 10);
        }
        
        return numeroAleatorio;
    }
    
}
