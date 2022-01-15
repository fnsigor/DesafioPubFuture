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
import javax.swing.JOptionPane;
import pubfuture.bean.Conta;
import pubfuture.bean.Despesas;
import pubfuture.bean.Transferencia;

/**
 *
 * @author Igor Fernandes
 */
public class OperacoesDaoImpl {

    private Connection connection;
    private PreparedStatement psDevedor;
    private PreparedStatement psRecebedor;
    private PreparedStatement psTransferencia;
    private String sqlRecebedor;
    private String sqlDevedor;
    private String SqlTransferencia;
    private Despesas despesa;
    private ContaDaoImpl contaDao;
    private Transferencia transferencia;
    private ResultSet result;

    
    //metodo que registra transferencia e atualiza valores dos saldos das contas envolvidas
    public void transferenciaHistorico(Transferencia transferencia) {

        //comandos sql que serão utilizados no método
        SqlTransferencia = "INSERT INTO TRANSFERENCIAS(VALOR, DTTRANSFERENCIA, IDPAGADOR, IDRECEBEDOR) VALUES(?, ?, ?, ?)";
        sqlDevedor = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        sqlRecebedor = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";

        try {

            //preparanndo conexao 
            connection = ConnectionFactory.abreConexao();
            psTransferencia = connection.prepareStatement(SqlTransferencia);

            //setando os valores na instancia do objeto 
            psTransferencia.setDouble(1, transferencia.getValor());
            psTransferencia.setDate(2, new Date(transferencia.getDtTransferencia().getTime()));
            psTransferencia.setObject(3, transferencia.getPagador().getId());
            psTransferencia.setObject(4, transferencia.getRecebedor().getId());

            //colocando a instancia de objeto no banco e colocando a id gerada na instancia de objeto
            psTransferencia.executeUpdate();

            //preparando para atualizar saldos apos transferencia
            psDevedor = connection.prepareStatement(sqlDevedor);
            psRecebedor = connection.prepareStatement(sqlRecebedor);

            //definindo pagador/recebedor e valor dos saldos atualizados
            Conta pagador = transferencia.getPagador();
            Conta recebedor = transferencia.getRecebedor();
            double novoSaldoPagador = pagador.getSaldo() - transferencia.getValor();
            double novoSaldoRecebedor = recebedor.getSaldo() + transferencia.getValor();

            //setando valores nos comandos sql para atualizar saldos
            psDevedor.setDouble(1, novoSaldoPagador);
            psDevedor.setInt(2, transferencia.getPagador().getId());
            psRecebedor.setDouble(1, novoSaldoRecebedor);
            psRecebedor.setInt(2, transferencia.getRecebedor().getId());

            //atualizando saldos
            psDevedor.executeUpdate();
            psRecebedor.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar transferência");
            System.out.println("Erro ao executar transferência");
            System.out.println(e.getMessage());
        }
    }
    
    
    //metodo que lista todas as transferencias no banco de dados
    public List<Transferencia> listar() {
        
        //definindo comandos sql e criando lista que vai receber o resultado retorno desse metodo
        SqlTransferencia = "SELECT IDTRANSFERENCIA, DTTRANSFERENCIA, VALOR, IDPAGADOR, IDRECEBEDOR FROM TRANSFERENCIAS";
        List<Transferencia> transferenciasdb = new ArrayList<>();
        
        try {
            //abrinco conexao com o banco, defindo comando sql a ser utilizado e executando comando
            connection = ConnectionFactory.abreConexao();
            psTransferencia = connection.prepareStatement(SqlTransferencia);
            result = psTransferencia.executeQuery();
            
            //enquanto vierem registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                transferencia = new Transferencia();
                transferencia.setIdtransferencia(result.getInt("idtransferencia"));
                transferencia.setDtTransferencia(result.getDate("dttransferencia"));
                transferencia.setValor(result.getDouble("valor"));
                contaDao = new ContaDaoImpl();
                transferencia.setPagador(contaDao.pesquisaPorId(result.getInt("idpagador")));
                transferencia.setRecebedor(contaDao.pesquisaPorId(result.getInt("idrecebedor")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                transferenciasdb.add(transferencia);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }
        return transferenciasdb;
    }

    
    //metodo que pesquisa transferenica no banco pela id do pagador
    public List<Transferencia> pesquisaIdPagador(int idPagador) {
        
        //definindo comandos sql e criando lista que vai receber o resultado retorno desse metodo
        SqlTransferencia = "SELECT * FROM TRANSFERENCIAS WHERE IDPAGADOR=?";
        List<Transferencia> transferenciasdb = new ArrayList<>();
        
        try {
            
            //abrindo conexao com o banco, definindo comando a ser utilizado, setando valor do parametro no comando
            connection = ConnectionFactory.abreConexao();
            psTransferencia = connection.prepareStatement(SqlTransferencia);
            psTransferencia.setInt(1, idPagador);
            
            //executando comando
            result = psTransferencia.executeQuery();

            while (result.next()) {
                //enquanto vierem registros do banco
                transferencia = new Transferencia();
                transferencia.setIdtransferencia(result.getInt("idtransferencia"));
                transferencia.setDtTransferencia(result.getDate("dttransferencia"));
                transferencia.setValor(result.getDouble("valor"));
                contaDao = new ContaDaoImpl();
                transferencia.setPagador(contaDao.pesquisaPorId(result.getInt("idpagador")));
                transferencia.setRecebedor(contaDao.pesquisaPorId(result.getInt("idrecebedor")));
                
                //adicionando instancia de objeto na lista que o metodo vai retornar
                transferenciasdb.add(transferencia);
            }

        } catch (Exception e) {
            System.out.println("erro ao pesquisar ID de conta");
            System.out.println(e.getMessage());
        }
        return transferenciasdb;
    }
    
}
