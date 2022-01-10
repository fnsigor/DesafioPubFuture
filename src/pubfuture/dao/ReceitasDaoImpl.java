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

    
    
    public void registarReceita(Receitas receita) {
        sqlReceita = "INSERT INTO RECEITAS(VALOR, DTRECEBIMENTO, DTRECESPERADO, DESCRICAO, TIPO, IDCONTA) VALUES (?, ?, ?, ?, ?, ?)";
        sqlConta = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, receita.getValor());
            ps.setDate(2, new Date(receita.getDtrecebimento().getTime()));
            ps.setDate(3, new Date(receita.getDtrecesperado().getTime()));
            ps.setString(4, receita.getDescricao());
            ps.setString(5, receita.getTipo());
            ps.setObject(6, receita.getConta().getId());
            double novoSaldo = receita.getValor() + receita.getConta().getSaldo();
            psSaldo = connection.prepareStatement(sqlConta);
            psSaldo.setDouble(1, novoSaldo);
            psSaldo.setObject(2, receita.getConta().getId());

            ps.executeUpdate();
            psSaldo.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            receita.setIdreceitas(result.getInt(1));

        } catch (Exception e) {
            System.out.println("erro ao salvar receita");
            System.out.println(e.getMessage());
        }

    }

    public Receitas pesquisaPorId(Integer idReceita) {
        sqlReceita = "SELECT * FROM RECEITAS WHERE IDRECEITA=?";
        try {

            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            ps.setInt(1, idReceita);
            result = ps.executeQuery();

            if (result.next()) {
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

    public void alterar(Receitas x) {

        sqlReceita = "UPDATE RECEITAS SET VALOR=?, DTRECEBIMENTO=?, DTRECESPERADO=?, DESCRICAO=?, TIPO=? WHERE IDRECEITA= ?";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sqlReceita);
            ps.setDouble(1, receita.getValor());
            ps.setDate(2, new Date(receita.getDtrecebimento().getTime()));
            ps.setDate(3, new Date(receita.getDtrecesperado().getTime()));
            ps.setString(4, receita.getDescricao());
            ps.setString(5, receita.getTipo());
            ps.setInt(6, receita.getIdreceitas());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar");
            System.out.println(e.getMessage());

        }
    }

}
