package com.homework.hw_7.dao;

import com.homework.hw_7.config.ConfiguredHikariPool;
import com.homework.hw_7.entity_records.Worker;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DefaultPopulateWorkerDao {
    private DefaultPopulateWorkerDao() {
    }

    private static final HikariPool connectionPool = ConfiguredHikariPool.getInstance().getHikariPool();

    public static int[] createWorkers() {
        String sql = "INSERT INTO worker(name, birthday, level, salary) VALUES(?,?,?,?)";
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            for (Worker worker : supplyDefaultWorkers()) {
                preparedStatement.setString(1, worker.name());
                preparedStatement.setDate(2, worker.birthday());
                preparedStatement.setString(3, worker.level());
                preparedStatement.setInt(4, worker.salary());
                preparedStatement.addBatch();
            }
            return preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new int[]{-1};
    }

    private static List<Worker> supplyDefaultWorkers() {
        List<Worker> workers = new LinkedList<>();
        workers.add(new Worker("Andres Antham", Date.valueOf("2000-12-12"), "Junior", 900));
        workers.add(new Worker("Kizzie Haynes", Date.valueOf("1990-08-09"), "Middle", 33575));
        workers.add(new Worker("Chaddy Cicci", Date.valueOf("1971-10-14"), "Senior", 34122));
        workers.add(new Worker("Darius Sallis", Date.valueOf("1993-11-08"), "Trainee", 50418));
        workers.add(new Worker("Ambrose Tame", Date.valueOf("1993-02-04"), "Middle", 42917));
        workers.add(new Worker("Eldon Beauchop", Date.valueOf("2003-03-23"), "Middle", 62970));
        workers.add(new Worker("Tab Woodland", Date.valueOf("1975-09-11"), "Senior", 62853));
        workers.add(new Worker("Dallis Simmon", Date.valueOf("1983-06-14"), "Middle", 73470));
        workers.add(new Worker("Alex Blain", Date.valueOf("1965-12-11"), "Trainee", 55473));
        workers.add(new Worker("Jessey Everard", Date.valueOf("1978-10-19"), "Trainee", 83175));
        workers.add(new Worker("Pascal Lorne", Date.valueOf("1968-09-01"), "Middle", 32370));
        workers.add(new Worker("Borg Wallis", Date.valueOf("1968-07-20"), "Middle", 43438));
        workers.add(new Worker("Bradley Dulanty", Date.valueOf("1977-09-21"), "Senior", 57117));
        workers.add(new Worker("Bernie Acton", Date.valueOf("1973-03-08"), "Junior", 39300));
        workers.add(new Worker("Krystyna Kohrt", Date.valueOf("1971-01-17"), "Junior", 6965));
        return workers;
    }
}
