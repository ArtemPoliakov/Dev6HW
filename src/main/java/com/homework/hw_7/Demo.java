package com.homework.hw_7;

import com.homework.actual_homework.services.DatabaseQueryService;

public class Demo {
    public static void main(String... args){
        PopulationClass.populateDb();

        DatabaseQueryService.getAllProjectPrices();
        DatabaseQueryService.getYoungestEldestWorkers();
        DatabaseQueryService.getMaxProjectsClient();
        DatabaseQueryService.getProjectWithMaxDuration();
        DatabaseQueryService.getMaxSalaryWorker();
    }
}
