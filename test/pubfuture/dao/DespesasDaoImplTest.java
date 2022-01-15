/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pubfuture.bean.Conta;
import pubfuture.bean.Despesas;
import pubfuture.bean.Receitas;

/**
 *
 * @author Igor Fernandes
 */

//testes unitários de cada método da classe DespesasDaoImpl
public class DespesasDaoImplTest {

    Despesas despesa = new Despesas();
    DespesasDaoImpl despesaDao = new DespesasDaoImpl();
    Conta conta = new Conta();
    ContaDaoImpl contasDao = new ContaDaoImpl();
    
    public DespesasDaoImplTest() {
    }
    
    //@Test
    public void testRegistarReceita() {
        despesa.setValor(0.87000000000006);
        despesa.setDtpagamento(new Date());
        despesa.setDtpagesperado(new Date());
        despesa.setTipo("Alimentação");
        conta = contasDao.pesquisaPorId(1);
        despesa.setConta(conta);
        despesaDao.registarDespesa(despesa);
    }

    
    //@Test
    public void testPesquisaPorId() {
        despesa = despesaDao.pesquisaPorId(2);
        verDespesa(despesa);
    }

    
    // @Test
    public void testAlterar() {
        despesa = despesaDao.pesquisaPorId(1);
        despesa.setTipo("Lazer");
        despesaDao.alterar(despesa);
    }

    
    //@Test
    public void testDeletar() {
        despesaDao.deletar(2);
    }

    
    //@Test
    public void testListar() {
        List<Despesas> despesasdb = new ArrayList<>();
        despesasdb = despesaDao.listar();
         despesasdb.forEach((despesa) -> {
            verDespesa(despesa);
        });
    }
    
    //método pára ver todos os valores do registro no banco
    public void verDespesa(Despesas despesa) {
        System.out.println("id despesa: " + despesa.getIddespesas());
        System.out.println("valor despesa: " + despesa.getValor());
        System.out.println("dt pagamento despesa: " + despesa.getDtpagamento());
        System.out.println("dtrecesperado despesa: " + despesa.getDtpagesperado());
        System.out.println("tipo despesa: " + despesa.getTipo());
        System.out.println("conta despesa: " + despesa.getConta().getId());
        System.out.println("instituicao conta despesa: " + despesa.getConta().getInstituicao());
        System.out.println("saldo conta despesa: " + despesa.getConta().getSaldo());
    }
}
