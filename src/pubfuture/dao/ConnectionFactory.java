/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Igor Fernandes
 */
public class ConnectionFactory {
  
    //ATENÇÃO: CASO A PORTA QUE SEU SERVIDOR MYSQL USE NÃO SEJA A 3306, ALTERE PARA A PORTA CORRETA NO MÉTODO ABAIXO
    
    //Usuário: root / Senha: admin
    
    //CASO O USUÁRIO TENHA NOME DIFERENTE DE root E/OU A SENHA USADA NO SERVIDOR SEJA DIFENRENTE DE admin, ALTERE PARA OS DADOS CORRETOS NO METODO ABAIXO
    public static Connection abreConexao() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpubfuture?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull", "root", "admin");
    }
}
