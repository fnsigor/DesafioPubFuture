/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import pubfuture.bean.Conta;
import org.junit.Test;

 

public class ContaDaoImplTest {
    
    Conta conta;
    ContaDaoImpl dao;
    
    public ContaDaoImplTest() {
       dao  = new ContaDaoImpl();
    }

   // @Test
    public void testSalvar() {
       Conta objeto = new Conta();
       objeto.setInstituicao("Inter");
       objeto.setTipo("Poupança");
       objeto.setSaldo(9.99);
       dao.salvar(objeto);
    }
    
   // @Test
    public void testPesquisaPorId() {
       conta = dao.pesquisaPorId(3);
        System.out.println(conta.getId());
        System.out.println(conta.getInstituicao());
        System.out.println(conta.getTipo());
    }
    
    //@Test
    public void testAlterar() {
         conta = dao.pesquisaPorId(3);
         conta.setTipo("Carteira");
         conta.setSaldo(6.75);
         dao.alterar(conta);
      
    }

   // @Test
    public void testDeletar() {
        dao.deletar(4);
    }

    //@Test
    public void testListar() {
       List<Conta> contas = new ArrayList();
       contas = dao.listar();
       contas.forEach((conta)->{
           System.out.println(conta.getId());
           System.out.println(conta.getInstituicao());
           System.out.println(conta.getTipo());
           System.out.println(conta.getSaldo());
       });
     
    }

    //@Test
    public void testPesquisaPorInstitucao() {
        List<Conta> contas = new ArrayList();
       contas = dao.pesquisaPorInstitucao("nu");
       contas.forEach((conta)->{
           System.out.println(conta.getId());
           System.out.println(conta.getInstituicao());
           System.out.println(conta.getTipo());
           System.out.println(conta.getSaldo());
       });
       
       
    }
    
  
    
    
    
}
