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

    public static Connection abreConexao() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpubfuture?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull", "root", "admin");
    }
}
