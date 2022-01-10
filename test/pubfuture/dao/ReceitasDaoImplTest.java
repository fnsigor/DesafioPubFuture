/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import pubfuture.bean.Conta;
import pubfuture.bean.Receitas;

/**
 *
 * @author Igor Fernandes
 */
public class ReceitasDaoImplTest {
    Receitas receita = new Receitas();
    ReceitasDaoImpl receitasDao = new ReceitasDaoImpl();
    Conta conta = new Conta();
    ContaDaoImpl  contasDao = new ContaDaoImpl();
    
    public ReceitasDaoImplTest() {
    }

    //@Test
    public void testRegistarReceita() {
       receita.setValor(20.0);
        receita.setDtrecebimento(new Date());
        receita.setDtrecesperado(new Date());
        receita.setDescricao("teste 22222");
        receita.setTipo("Presente");
        conta = contasDao.pesquisaPorId(1);
        receita.setConta(conta);
        receitasDao.registarReceita(receita);
    }

    //@Test
    public void testPesquisaPorId() {
       receita = receitasDao.pesquisaPorId(3);
        verReceita(receita);
       
    }

   //@Test
    public void testAlterar() {
       receita = receitasDao.pesquisaPorId(3);
       receita.setDescricao("xxxxxxxxxx");
       receitasDao.alterar(receita);
    }
    
    
    
    public void verReceita(Receitas receita){
        System.out.println("id receita: "+receita.getIdreceitas());
        System.out.println("valor receita: "+receita.getValor());
        System.out.println("dtrecebiemtno receita: "+receita.getDtrecebimento());
        System.out.println("dtrecesperado receita: "+receita.getDtrecesperado());
        System.out.println("descricao receita: "+receita.getDescricao());
        System.out.println("tipo receita: "+receita.getTipo());
        System.out.println("conta receita: "+receita.getConta().getId());
        System.out.println("instituicao conta receita: "+receita.getConta().getInstituicao());
        System.out.println("saldo conta receita: "+receita.getConta().getSaldo());
        
    }
    
    
}
