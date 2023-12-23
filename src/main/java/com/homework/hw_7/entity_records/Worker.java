package com.homework.hw_7.entity_records;

import java.sql.Date;

public record Worker(String name, Date birthday, String level, Integer salary) {}