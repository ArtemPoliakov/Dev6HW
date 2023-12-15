package com.homework.actual_homework.services;

import com.homework.actual_homework.db_records.*;
import com.homework.actual_homework.utils.Database;
import com.homework.actual_homework.utils.FileUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DatabaseQueryService {
    private static final String PATH_TO_LONGEST_PROJECT_SCRIPT =
            "src/main/java/com/homework/actual_homework/sql/DML/find_longest_project.sql";
    private static final String PATH_TO_MAX_PROJECTS_CLIENT_SCRIPT =
            "src/main/java/com/homework/actual_homework/sql/DML/find_max_projects_client.sql";
    private static final String PATH_TO_MAX_SALARY_WORKER_SCRIPT =
            "src/main/java/com/homework/actual_homework/sql/DML/find_max_salary_worker.sql";
    private static final String PATH_TO_YOUNGEST_ELDEST_WORKER_SCRIPT =
            "src/main/java/com/homework/actual_homework/sql/DML/find_youngest_eldest_workers.sql";
    private static final String PATH_TO_PROJECT_PRICES_SCRIPT =
            "src/main/java/com/homework/actual_homework/sql/DML/print_project_prices.sql";

    public static List<ProjectDurationRecord> getProjectWithMaxDuration(){
        List<ProjectDurationRecord> data = new LinkedList<>();
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FileUtils.readWholeFile(PATH_TO_LONGEST_PROJECT_SCRIPT));
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                Integer duration = resultSet.getInt("duration");
                data.add(new ProjectDurationRecord(id, duration));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    public static List<MaxProjectsClientRecord> getMaxProjectsClient(){
        List<MaxProjectsClientRecord> data = new LinkedList<>();
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FileUtils.readWholeFile(PATH_TO_MAX_PROJECTS_CLIENT_SCRIPT));
            while(resultSet.next()){
                String name = resultSet.getString("name");
                Integer count = resultSet.getInt("count_of_projects");
                data.add(new MaxProjectsClientRecord(name, count));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    public static List<MaxSalaryWorkerRecord> getMaxSalaryWorker(){
        List<MaxSalaryWorkerRecord> data = new LinkedList<>();
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FileUtils.readWholeFile(PATH_TO_MAX_SALARY_WORKER_SCRIPT));
            while(resultSet.next()){
                String name = resultSet.getString("name");
                Integer salary = resultSet.getInt("salary");
                data.add(new MaxSalaryWorkerRecord(name, salary));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    public static List<YoungestEldestRecord> getYoungestEldestWorkers(){
        List<YoungestEldestRecord> data = new LinkedList<>();
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FileUtils.readWholeFile(PATH_TO_YOUNGEST_ELDEST_WORKER_SCRIPT));
            while(resultSet.next()){
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                data.add(new YoungestEldestRecord(type, name, birthday));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
    public static List<ProjectPriceRecord> getAllProjectPrices(){
        List<ProjectPriceRecord> data = new LinkedList<>();
        Connection connection = Database.getInstance().getConnection();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FileUtils.readWholeFile(PATH_TO_PROJECT_PRICES_SCRIPT));
            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                Integer price = resultSet.getInt("price");
                data.add(new ProjectPriceRecord(id, price));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }
}
