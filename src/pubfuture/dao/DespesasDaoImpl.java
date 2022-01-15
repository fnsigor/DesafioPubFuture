/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pubfuture.bean.Despesas;

/**
 *
 * @author Igor Fernandes
 */
public class DespesasDaoImpl {
    
    //variaveis globais para não ter que ficar criando toda hora
    private Connection connection;
    private PreparedStatement ps;
    private PreparedStatement psSaldo;
    private ResultSet result;
    private String sqlDespesa;
    private String sqlConta;
    private Despesas despesa;
    private ContaDaoImpl contaDao;

    
    //metodo que registra a despesa no banco e atualiza o saldo da conta
    public void registarDespesa(Despesas despesa) {
        
        //definindo comandos que serão utilizados no banco
        sqlDespesa = "INSERT INTO DESPESAS(VALOR, DTPAGAMENTO, DTPAGESPERADO, TIPO, IDCONTA) VALUES (?, ?, ?, ?, ?)";
        sqlConta = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        
        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            
            //setando valores no comando de acordo com a posição das colunas do comando
            ps.setDouble(1, despesa.getValor());
            ps.setDate(2, new Date(despesa.getDtpagamento().getTime()));
            ps.setDate(3, new Date(despesa.getDtpagesperado().getTime()));
            ps.setString(4, despesa.getTipo());
            ps.setObject(5, despesa.getConta().getId());
            
            //criando saldo atualizado da conta subtraindo o valor da despesa, com outro comando sql
            double novoSaldo = despesa.getConta().getSaldo() - despesa.getValor();
            psSaldo = connection.prepareStatement(sqlConta);
            psSaldo.setDouble(1, novoSaldo);
            psSaldo.setObject(2, despesa.getConta().getId());
            
            //registrando despesa no banco e atualizando saldo da conta
            ps.executeUpdate();
            psSaldo.executeUpdate();

        } catch (Exception e) {
            System.out.println("erro ao salvar receita");
            System.out.println(e.getMessage());
        }
    }

    
    //metodo que pesquisa despesa pela id
    public Despesas pesquisaPorId(Integer IdDespesa) {
        
        //definindo comando sql
        sqlDespesa = "SELECT * FROM DESPESAS WHERE IDDESPESA=?";
        
        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            
            //setando valor da id informada no comando e executando comando
            ps.setInt(1, IdDespesa);
            result = ps.executeQuery();

            //caso o comando retornar algum registro do banco
            if (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                despesa = new Despesas();
                despesa.setIddespesas(result.getInt("iddespesa"));
                despesa.setValor(result.getDouble("valor"));
                despesa.setDtpagamento(result.getDate("dtpagamento"));
                despesa.setDtpagesperado(result.getDate("dtpagesperado"));
                despesa.setTipo(result.getString("tipo"));
                contaDao = new ContaDaoImpl();
                despesa.setConta(contaDao.pesquisaPorId(result.getInt("idconta")));
            }
            
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por id");
            System.out.println(e.getMessage());
        }
        return despesa;
    }

    
    //metodo que altera a despesa no banco
    public void alterar(Despesas x) {
        
        //definindo comando sql
        sqlDespesa = "UPDATE DESPESAS SET VALOR=?, DTPAGAMENTO=?, DTPAGESPERADO=?, TIPO=? WHERE IDDESPESA= ?";

        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            
            //setando novos valores no registro
            ps.setDouble(1, x.getValor());
            ps.setDate(2, new Date(x.getDtpagamento().getTime()));
            ps.setDate(3, new Date(x.getDtpagesperado().getTime()));
            ps.setString(4, x.getTipo());
            ps.setInt(5, x.getIddespesas());
            
            //executando atualização
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("erro ao alterar");
            System.out.println(e.getMessage());
        }
    }
    
    
    //metodo que deleta despesa no banco pela id
    public void deletar(int id) {
         
        //definindo comando sql
        sqlDespesa = "DELETE FROM DESPESAS WHERE IDDESPESA= ?";

        try {
            //abrindo conexao com, definindo comando a ser utilizado e setando valor do parametro no comando sql
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            ps.setInt(1, id);
            
            //excluindo registro do banco
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("erro ao deletar por id");
            System.out.println(e.getMessage());
        }
    }
    
    
    //metodo que lista todos os registros no banco    
    public List<Despesas> listar() {
        
        //definindo comando sql e criando lista que vai receber o retorno do metodo
        sqlDespesa = "SELECT * FROM DESPESAS";
        List<Despesas> despesadb = new ArrayList<>();

        try {
            //abrindo conexao com o banco, definindo comando  aser utilizado e executando comando
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            result = ps.executeQuery();
            
            //enquanto o método trouxer registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                despesa = new Despesas();
                despesa.setIddespesas(result.getInt("iddespesa"));
                despesa.setValor(result.getDouble("valor"));
                despesa.setDtpagamento(result.getDate("dtpagamento"));
                despesa.setDtpagesperado(result.getDate("dtpagesperado"));
                despesa.setTipo(result.getString("tipo"));
                contaDao = new ContaDaoImpl();
                despesa.setConta(contaDao.pesquisaPorId(result.getInt("idconta")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                despesadb.add(despesa);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }
        return despesadb;
    }
    
    
    //metodo que também pesquisa despesa pela id, mas retorna uma lista
    public List<Despesas> pesquisaIdLista(int idDespesa) {
        
        //definindo comando sql e criando lista que vai receber o retorno desse metodo
        sqlDespesa = "SELECT * FROM DESPESAS WHERE IDDESPESA= ? ";
        List<Despesas> despesas = new ArrayList<>();

        try {
            //abrindo conexao com o banco, definindo comando a ser utilizado e colocando valor do parametro nesse comando 
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            ps.setInt(1,idDespesa);
            
            //executando comando
            result = ps.executeQuery();
            
            //enquanto o método trouxer registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                despesa = new Despesas();
                despesa.setIddespesas(result.getInt("iddespesa"));
                despesa.setDtpagamento(result.getDate("dtpagamento"));
                despesa.setDtpagesperado(result.getDate("dtpagesperado"));
                despesa.setTipo(result.getString("tipo"));
                despesa.setValor(result.getDouble("valor"));
                ContaDaoImpl dao = new ContaDaoImpl();
                despesa.setConta(dao.pesquisaPorId(result.getInt("idconta")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                despesas.add(despesa);
            }

        } catch (Exception e) {
            System.out.println("erro ao pesquisar por nome");
            System.out.println(e.getMessage());
        }
        return despesas;
    }
    
    
    //metodo que pesquisa registro de despesa no banco pelo id da conta a qual o registro pertence
    public List<Despesas> pesquisaIdContaLista(int idConta) {
        
        //definindo comando sql e criando lista que vai receber o retorno desse metodo
        sqlDespesa = "SELECT * FROM DESPESAS WHERE IDCONTA= ? ";
        List<Despesas> despesas = new ArrayList<>();

        try {
            //abrindo conexao com o banco, definindo comando a ser utilizado e setando o valor do parametro no comando 
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            ps.setInt(1,idConta);
            
            //executando comando
            result = ps.executeQuery();

            //enquanto vierem registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                despesa = new Despesas();
                despesa.setIddespesas(result.getInt("iddespesa"));
                despesa.setDtpagamento(result.getDate("dtpagamento"));
                despesa.setDtpagesperado(result.getDate("dtpagesperado"));
                despesa.setTipo(result.getString("tipo"));
                despesa.setValor(result.getDouble("valor"));
                ContaDaoImpl dao = new ContaDaoImpl();
                despesa.setConta(dao.pesquisaPorId(result.getInt("idconta")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                despesas.add(despesa);
            }
            
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por ID conta");
            System.out.println(e.getMessage());
        }
        return despesas;
    }
    
}
