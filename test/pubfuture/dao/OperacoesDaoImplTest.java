/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import org.junit.Test;

/**
 *
 * @author Igor Fernandes
 */
public class OperacoesDaoImplTest {
    
    OperacoesDaoImpl operacao = new OperacoesDaoImpl();
    
    public OperacoesDaoImplTest() {
    }

    @Test
    public void testSomeMethod() {
        operacao.transferencia(1, 2, 20.0);
    }
    
}
