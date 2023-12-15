package com.homework.my_test;

import lombok.SneakyThrows;

import java.sql.*;

public class Demo {
    @SneakyThrows
    public static void main(String... args) {
        String link = "jdbc:postgresql://localhost:5432/ArtemDatabase";
        String login = "postgres";
        String password = "Ukraine1991";
        try (
                Connection conn = DriverManager.getConnection(link, login, password);

        ) {
           test(conn);
        } catch(SQLException se){
            System.out.println("trouble");
        }
    }
    private static void test(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT name, birthday FROM users WHERE id < ?");
        preparedStatement.setInt(1, 6);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.print(resultSet.getString("name") + " ");
            System.out.println(resultSet.getString("birthday"));
        }
    }
}
