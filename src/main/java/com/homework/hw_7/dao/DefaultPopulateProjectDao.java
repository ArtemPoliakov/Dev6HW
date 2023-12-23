package com.homework.hw_7.dao;

import com.homework.hw_7.config.ConfiguredHikariPool;
import com.homework.hw_7.entity_records.Project;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DefaultPopulateProjectDao {
    private static final HikariPool connectionPool = ConfiguredHikariPool.getInstance().getHikariPool();
    private DefaultPopulateProjectDao(){}
    public static int[] createProjects(){
        String sql = "INSERT INTO project(client_id, start_date, finish_date) VALUES(?, ?, ?)";
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            for(Project project: supplyDefaultProjects()){
                preparedStatement.setInt(1, project.client_id());
                preparedStatement.setDate(2, project.startDate());
                preparedStatement.setDate(3, project.finishDate());
                preparedStatement.addBatch();
            }
            return preparedStatement.executeBatch();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new int[]{-1};
    }
    private static List<Project> supplyDefaultProjects(){
        return List.of(
        new Project(1, Date.valueOf("2025-09-09"), Date.valueOf("2030-07-16")),
        new Project(1, Date.valueOf("2023-11-27"), Date.valueOf("2024-03-03")),
        new Project(3, Date.valueOf("2024-12-21"), Date.valueOf("2031-02-25")),
        new Project(2, Date.valueOf("2025-07-16"), Date.valueOf("2025-08-21")),
        new Project(3, Date.valueOf("2025-09-12"), Date.valueOf("2026-06-27")),
        new Project(5, Date.valueOf("2025-05-27"), Date.valueOf("2026-12-09")),
        new Project(2, Date.valueOf("2026-01-22"), Date.valueOf("2027-07-06")),
        new Project(5, Date.valueOf("2025-01-12"), Date.valueOf("2026-08-09")),
        new Project(4, Date.valueOf("2024-02-24"), Date.valueOf("2026-07-23")),
        new Project(4, Date.valueOf("2025-08-25"), Date.valueOf("2031-08-26"))
        );
    }
}
