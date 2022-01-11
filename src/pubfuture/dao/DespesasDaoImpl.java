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
import pubfuture.bean.Despesas;
import pubfuture.bean.Receitas;

/**
 *
 * @author Igor Fernandes
 */
public class DespesasDaoImpl {

    private Connection connection;
    private PreparedStatement ps;
    private PreparedStatement psSaldo;
    private ResultSet result;
    private String sqlDespesa;
    private String sqlConta;
    private Despesas despesa;
    private Conta conta;
    private ContaDaoImpl contaDao;

    public void registarDespesa(Despesas despesa) {
        sqlDespesa = "INSERT INTO DESPESAS(VALOR, DTPAGAMENTO, DTPAGESPERADO, TIPO, IDCONTA) VALUES (?, ?, ?, ?, ?)";
        sqlConta = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, despesa.getValor());
            ps.setDate(2, new Date(despesa.getDtpagamento().getTime()));
            ps.setDate(3, new Date(despesa.getDtpagesperado().getTime()));
            ps.setString(4, despesa.getTipo());
            ps.setObject(5, despesa.getConta().getId());
            
            double novoSaldo = despesa.getConta().getSaldo() - despesa.getValor();
            psSaldo = connection.prepareStatement(sqlConta);
            psSaldo.setDouble(1, novoSaldo);
            psSaldo.setObject(2, despesa.getConta().getId());

            ps.executeUpdate();
            psSaldo.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            despesa.setIddespesas(result.getInt(1));

        } catch (Exception e) {
            System.out.println("erro ao salvar receita");
            System.out.println(e.getMessage());
        }

    }

    public Despesas pesquisaPorId(Integer idReceita) {
        sqlDespesa = "SELECT * FROM DESPESAS WHERE IDDESPESA=?";
        try {

            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            ps.setInt(1, idReceita);
            result = ps.executeQuery();

            if (result.next()) {
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

    public void alterar(Despesas x) {

        sqlDespesa = "UPDATE DESPESAS SET VALOR=?, DTPAGAMENTO=?, DTPAGESPERADO=?, TIPO=? WHERE IDDESPESA= ?";

        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            ps.setDouble(1, despesa.getValor());
            ps.setDate(2, new Date(despesa.getDtpagamento().getTime()));
            ps.setDate(3, new Date(despesa.getDtpagesperado().getTime()));
            ps.setString(4, despesa.getTipo());
            ps.setInt(5, despesa.getIddespesas());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar");
            System.out.println(e.getMessage());

        }
    }

    public void deletar(int id) {

        sqlDespesa = "DELETE FROM DESPESAS WHERE IDDESPESA= ?";

        try {

            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("erro ao deletar por id");
            System.out.println(e.getMessage());
        }

    }
    
    
    
    
    public List<Despesas> listar() {
        sqlDespesa = "SELECT * FROM DESPESAS";
        List<Despesas> despesadb = new ArrayList<>();

        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlDespesa);
            result = ps.executeQuery();

            while (result.next()) {
                despesa = new Despesas();
                despesa.setIddespesas(result.getInt("iddespesa"));
                despesa.setValor(result.getDouble("valor"));
                despesa.setDtpagamento(result.getDate("dtpagamento"));
                despesa.setDtpagesperado(result.getDate("dtpagesperado"));
                despesa.setTipo(result.getString("tipo"));
                contaDao = new ContaDaoImpl();
                despesa.setConta(contaDao.pesquisaPorId(result.getInt("idconta")));
                despesadb.add(despesa);

            }

        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }

        return despesadb;

    }
    
    

}
