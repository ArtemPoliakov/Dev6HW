package com.homework.hw_7.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;

public final class ConfiguredHikariPool {
    private static final String URL = "jdbc:h2:./data/office";
    private static ConfiguredHikariPool configuredHikariPool;
    public static final int MAX_POOL_SIZE = 10;
    private final HikariPool hikariPool;

    private ConfiguredHikariPool(){
        this.hikariPool = new HikariPool(getConfig());
    }
    public static ConfiguredHikariPool getInstance(){
        if(configuredHikariPool==null){
            configuredHikariPool = new ConfiguredHikariPool();
        }
        return configuredHikariPool;
    }
    public HikariPool getHikariPool(){
        return hikariPool;
    }
    private HikariConfig getConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setMaximumPoolSize(MAX_POOL_SIZE);
        return hikariConfig;
    }
}
