package com.conexionDB;

import java.sql.*;

public class ConexionMysql {
    private Connection connection;//Creando la variable que va a almacenar los datos de la coneccion
    private Statement statement; //Creando la variable Statement
    private  ResultSet resultSet;// Creando la variable resultset
    private PreparedStatement stmnt;
    public void createConexionMysql() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/depositopf",
                    "root",
                    "1234"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createStatement() {
        try {
            this.statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(String nombreTabla) {
        try {
            this.resultSet = statement.executeQuery("SELECT * FROM EMI");
            while(resultSet.next()){
                System.out.println(resultSet.getString("usuario"));
                System.out.println(resultSet.getString("contraseña"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

/*
Codigo de ejemplo para el resulset
try{


        resultSet= statement.executeLECQuery("SELECT * FROM USERS");
        while(resultSet.next()){
        System.out.println(resultSet.getString("user"));
        System.out.println(resultSet.getString("password"));
        }

        }catch(SQLException ex){
        ex.printStackTrace();
        }
    */