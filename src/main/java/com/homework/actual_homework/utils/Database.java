package com.homework.actual_homework.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Database {
    private static Database database;
    private Connection connection;
    private static final String DB_URI = "jdbc:h2:./data/office";
    private Database(){
        try {
            connection = DriverManager.getConnection(DB_URI);
        } catch (Exception e) {
            System.out.println("!!!!!trouble!!!!!");
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        if(database==null){
            database = new Database();
        }
        return database;
    }
    public Connection getConnection(){
        return connection;
    }
}
