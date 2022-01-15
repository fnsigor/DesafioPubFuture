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
import pubfuture.bean.Conta;
import pubfuture.bean.Receitas;

/**
 *
 * @author Igor Fernandes
 */
public class ReceitasDaoImpl {

    private Connection connection;

    private PreparedStatement ps;
    private PreparedStatement psSaldo;
    private ResultSet result;
    private String sqlReceita;
    private String sqlConta;
    private Conta conta;
    private ContaDaoImpl contaDao;
    private Receitas receita;

    //metodo que registra receita no banco e atualiza saldo da conta
    public void registarReceita(Receitas receita) {
        
        //definindo comandos que serão utilizados no banco
        sqlReceita = "INSERT INTO RECEITAS(VALOR, DTRECEBIMENTO, DTRECESPERADO, DESCRICAO, TIPO, IDCONTA) VALUES (?, ?, ?, ?, ?, ?)";
        sqlConta = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        
        try {
             //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita, PreparedStatement.RETURN_GENERATED_KEYS);
            
            //setando valores no comando de acordo com a posição das colunas do comando 
            ps.setDouble(1, receita.getValor());
            ps.setDate(2, new Date(receita.getDtrecebimento().getTime()));
            ps.setDate(3, new Date(receita.getDtrecesperado().getTime()));
            ps.setString(4, receita.getDescricao());
            ps.setString(5, receita.getTipo());
            ps.setObject(6, receita.getConta().getId());
            
            //criando saldo atualizado da conta somando o valor da receita, com outro comando sql
            double novoSaldo = receita.getValor() + receita.getConta().getSaldo();
            psSaldo = connection.prepareStatement(sqlConta);
            psSaldo.setDouble(1, novoSaldo);
            psSaldo.setObject(2, receita.getConta().getId());

            //registrando receita no banco e atualizando saldo da conta
            ps.executeUpdate();
            psSaldo.executeUpdate();

        } catch (Exception e) {
            System.out.println("erro ao salvar receita");
            System.out.println(e.getMessage());
        }
    }

    
    //metodo que pesquisa receita no banco pela id da receita
    public Receitas pesquisaPorId(Integer idReceita) {
        
        //definindo comando sql
        sqlReceita = "SELECT * FROM RECEITAS WHERE IDRECEITA=?";
        
        try {
             //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            
            //setando valor da id informada no comando e executando comando
            ps.setInt(1, idReceita);
            result = ps.executeQuery();

            //caso o comando retornar algum registro do banco
            if (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                receita = new Receitas();
                receita.setIdreceitas(result.getInt("idreceita"));
                receita.setValor(result.getDouble("valor"));
                receita.setDtrecebimento(result.getDate("dtrecebimento"));
                receita.setDtrecesperado(result.getDate("dtrecesperado"));
                receita.setDescricao(result.getString("descricao"));
                receita.setTipo(result.getString("tipo"));
                contaDao = new ContaDaoImpl();
                receita.setConta(contaDao.pesquisaPorId(result.getInt("idconta")));
            }
            
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por id");
            System.out.println(e.getMessage());
        }
        return receita;
    }
    
    //metodo que também pesquisa receita no banco pela id da receita mas retorna lista
    public List<Receitas> pesquisaIdLista(int idReceita) {
        
        //definindo comando sql e criando lista que vai receber o retorno desse metodo
        sqlReceita = "SELECT * FROM RECEITAS WHERE IDRECEITA= ? ";
        List<Receitas> receitas = new ArrayList<>();

        try {
             //abrindo conexao com o banco, definindo comando a ser utilizado e colocando valor do parametro nesse comando 
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            ps.setInt(1,idReceita);
            
            //executando comando
            result = ps.executeQuery();
            
            //enquanto o método trouxer registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                receita = new Receitas();
                receita.setIdreceitas(result.getInt("idreceita"));
                receita.setDtrecebimento(result.getDate("dtrecebimento"));
                receita.setDtrecesperado(result.getDate("dtrecesperado"));
                receita.setTipo(result.getString("tipo"));
                receita.setDescricao(result.getString("descricao"));
                receita.setValor(result.getDouble("valor"));
                ContaDaoImpl dao = new ContaDaoImpl();
                receita.setConta(dao.pesquisaPorId(result.getInt("idconta")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                receitas.add(receita);
            }

        } catch (Exception e) {
            System.out.println("erro ao pesquisar por nome");
            System.out.println(e.getMessage());
        }
        return receitas;
    }
    
    //metodo que altera registros no banco
    public void alterar(Receitas x) {
        
        //definindo comando sql
        sqlReceita = "UPDATE RECEITAS SET VALOR=?, DTRECEBIMENTO=?, DTRECESPERADO=?, DESCRICAO=?, TIPO=? WHERE IDRECEITA= ?";

        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            
            //setando novos valores no registro
            ps.setDouble(1, receita.getValor());
            ps.setDate(2, new Date(receita.getDtrecebimento().getTime()));
            ps.setDate(3, new Date(receita.getDtrecesperado().getTime()));
            ps.setString(4, receita.getDescricao());
            ps.setString(5, receita.getTipo());
            ps.setInt(6, receita.getIdreceitas());
            
            //executando atualização
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("erro ao alterar");
            System.out.println(e.getMessage());
        }
    }
 
    
    //metodo que deleta regitro no banco pela id 
    public void deletar(int id) {
        
        //definindo comando sql
        sqlReceita = "DELETE FROM RECEITAS WHERE IDRECEITA= ?";

        try {
            //abrindo conexao com, definindo comando a ser utilizado e setando valor do parametro no comando sql
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            ps.setInt(1, id);
            
            //excluindo registro do banco
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("erro ao deletar por id");
            System.out.println(e.getMessage());
        }
    }

    
    //metodo que lista todos os registros no banco
    public List<Receitas> listar() {
        
        //definindo comando sql e criando lista que vai receber o retorno do metodo
        sqlReceita = "SELECT * FROM RECEITAS";
        List<Receitas> receitasdb = new ArrayList<>();

        try {
            //abrindo conexao com o banco, definindo comando  aser utilizado e executando comando
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            result = ps.executeQuery();

            //enquanto o método trouxer registros do banco
            while (result.next()) {
                
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                receita = new Receitas();
                receita.setIdreceitas(result.getInt("idreceita"));
                receita.setValor(result.getDouble("valor"));
                receita.setDtrecebimento(result.getDate("dtrecebimento"));
                receita.setDtrecesperado(result.getDate("dtrecesperado"));
                receita.setDescricao(result.getString("descricao"));
                receita.setTipo(result.getString("tipo"));
                contaDao = new ContaDaoImpl();
                receita.setConta(contaDao.pesquisaPorId(result.getInt("idconta")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                receitasdb.add(receita);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }
        return receitasdb;
    }


       //metodo que pesquisa registros de receitas no banco pelo id da conta
       public List<Receitas> pesquisaIdContaLista(int idConta) {
           
        //definindo comando sql e criando lista que vai receber o retorno desse metodo
        sqlReceita = "SELECT * FROM RECEITAS WHERE IDCONTA= ? ";
        List<Receitas> receitas = new ArrayList<>();

        try {
            //abrindo conexao com o banco, definindo comando a ser utilizado e setando o valor do parametro no comando 
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            ps.setInt(1,idConta);
            
            //executando comando
            result = ps.executeQuery();

            //enquanto vierem registros do banco
            while (result.next()) {
                
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                receita = new Receitas();
                receita.setIdreceitas(result.getInt("idreceita"));
                receita.setDtrecebimento(result.getDate("dtrecebimento"));
                receita.setDtrecesperado(result.getDate("dtrecesperado"));
                receita.setTipo(result.getString("tipo"));
                receita.setValor(result.getDouble("valor"));
                receita.setDescricao(result.getString("descricao"));
                ContaDaoImpl dao = new ContaDaoImpl();
                receita.setConta(dao.pesquisaPorId(result.getInt("idconta")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                receitas.add(receita);
            }

        } catch (Exception e) {
            System.out.println("erro ao pesquisar por ID conta");
            System.out.println(e.getMessage());
        }
        return receitas;
    }
    
}




