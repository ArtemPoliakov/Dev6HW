package com.homework.actual_homework.services;

import com.homework.actual_homework.utils.Database;
import com.homework.actual_homework.utils.FileUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    private static final String PATH_TO_INIT_FILE = "src/main/java/com/homework/actual_homework/sql/DDL/init_db.sql";
    @SneakyThrows
    public static void main(String... args){
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(FileUtils.readWholeFile(PATH_TO_INIT_FILE));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
