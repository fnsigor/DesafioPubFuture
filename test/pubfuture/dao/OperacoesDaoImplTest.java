/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.util.Date;
import org.junit.Test;
import pubfuture.bean.Conta;
import pubfuture.bean.Transferencia;

/**
 *
 * @author Igor Fernandes
 */

//testes unitários de cada método da classe OperacoesDaoImpl
public class OperacoesDaoImplTest {
    
    OperacoesDaoImpl dao = new OperacoesDaoImpl();
    Transferencia objeto = new Transferencia();
    Conta conta = new Conta();
    ContaDaoImpl contasDao = new ContaDaoImpl();
    
    public OperacoesDaoImplTest() {
    }
    
    //@Test
    public void testSomeMethod() {
        //operacao.transferencia(1, 2, 20.0);
    }

    
    //@Test
    public void testTransferenciaHistorico() {
        objeto.setDtTransferencia(new Date());
        objeto.setValor(5);
        conta = contasDao.pesquisaPorId(7);
        objeto.setPagador(conta);
        conta = contasDao.pesquisaPorId(8);
        objeto.setRecebedor(conta);
        dao.transferenciaHistorico(objeto);
    }
    
}
