package com.homework.hw_7.dao;

import com.homework.hw_7.config.ConfiguredHikariPool;
import com.homework.hw_7.entity_records.ProjectWorker;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DefaultPopulateProjectWorkerDao {
    private static final HikariPool connectionPool = ConfiguredHikariPool.getInstance().getHikariPool();
    private DefaultPopulateProjectWorkerDao(){}
    public static int[] assignWorkersToProjects(){
        String sql = "INSERT INTO project_worker(worker_id, project_id) VALUES(?,?)";
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            for(ProjectWorker projectWorker: supplyDefaultProjectWorkers()){
                preparedStatement.setInt(1, projectWorker.workerId());
                preparedStatement.setInt(2, projectWorker.projectId());
                preparedStatement.addBatch();
            }
            return preparedStatement.executeBatch();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new int[]{-1};
    }
    private static List<ProjectWorker> supplyDefaultProjectWorkers(){
        List<ProjectWorker> pairs = new LinkedList<>();
        pairs.add(new ProjectWorker(1, 6));
        pairs.add(new ProjectWorker(1, 10));
        pairs.add(new ProjectWorker(13, 4));
        pairs.add(new ProjectWorker(2, 5));
        pairs.add(new ProjectWorker(2, 8));
        pairs.add(new ProjectWorker(2, 9));
        pairs.add(new ProjectWorker(14, 1));
        pairs.add(new ProjectWorker(3, 5));
        pairs.add(new ProjectWorker(3, 8));
        pairs.add(new ProjectWorker(4, 2));
        pairs.add(new ProjectWorker(4, 5));
        pairs.add(new ProjectWorker(3, 6));
        pairs.add(new ProjectWorker(5, 3));
        pairs.add(new ProjectWorker(5, 6));
        pairs.add(new ProjectWorker(5, 8));
        pairs.add(new ProjectWorker(6, 4));
        pairs.add(new ProjectWorker(7, 9));
        pairs.add(new ProjectWorker(8, 1));
        pairs.add(new ProjectWorker(8, 6));
        pairs.add(new ProjectWorker(8, 7));
        pairs.add(new ProjectWorker(8, 2));
        pairs.add(new ProjectWorker(9, 10));
        pairs.add(new ProjectWorker(10, 7));
        pairs.add(new ProjectWorker(10, 10));
        pairs.add(new ProjectWorker(14, 8));
        pairs.add(new ProjectWorker(15, 2));
        pairs.add(new ProjectWorker(10, 5));
        return pairs;
    }
}
