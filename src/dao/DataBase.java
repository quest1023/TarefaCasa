package dao;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class DataBase {

    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DATABASE = URL + "db_login";
    private final String USER = "root";
    private final String PASSWORD = "senac";

    public boolean open() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
            System.out.println("CONECTOU");
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("DRIVER NÃO ENCONTRADO");
            System.out.println("ERRO: " + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("PROBLEMAS COM A CONEXÃO");
            System.out.println("ERRO: " + erro);
            return false;
        }
    }
    
    public boolean close() {
        try {
            connection.close();
            System.out.println("DESCONECTOU");
            return true;
        } catch (SQLException erro) {
            System.out.println("PROBLEMAS COM A DESCONEXÃO");
            System.out.println("ERRO: " + erro);
            return false;
        }
    }
    
}
