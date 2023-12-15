package com.homework.actual_homework.services;
import com.homework.actual_homework.utils.Database;
import com.homework.actual_homework.utils.FileUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String PATH_TO_POPULATE_FILE = "src/main/java/com/homework/actual_homework/sql/DDL/populate_db.sql";
    public static void main(String... args){
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(FileUtils.readWholeFile(PATH_TO_POPULATE_FILE));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}