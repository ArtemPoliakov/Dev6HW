package com.homework.hw_7.dao;

import com.homework.hw_7.config.ConfiguredHikariPool;
import com.homework.hw_7.entity_records.Client;
import com.zaxxer.hikari.pool.HikariPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DefaultPopulateClientDao {
    private static final HikariPool connectionPool = ConfiguredHikariPool.getInstance().getHikariPool();
    private DefaultPopulateClientDao(){}
    public static int[] createClients(){
        String sql = "INSERT INTO client(name) VALUES(?)";
        try(    Connection connection = connectionPool.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            for(Client client: supplyDefaultClients()){
                preparedStatement.setString(1, client.name());
                preparedStatement.addBatch();
            }
            return preparedStatement.executeBatch();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new int[]{-1};
    }
    private static List<Client> supplyDefaultClients(){
        return List.of(
              new Client  ("Garvey Crosgrove"),
              new Client  ("Chrissy Stannah"),
              new Client  ("Araldo Wilcinskis"),
              new Client  ("Elly Wrettum"),
              new Client  ("Brendin Patinkin")
        );
    }
}
