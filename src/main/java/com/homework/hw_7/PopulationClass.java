package com.homework.hw_7;

import com.homework.actual_homework.services.DatabaseQueryService;
import com.homework.hw_7.dao.DefaultPopulateClientDao;
import com.homework.hw_7.dao.DefaultPopulateProjectDao;
import com.homework.hw_7.dao.DefaultPopulateProjectWorkerDao;
import com.homework.hw_7.dao.DefaultPopulateWorkerDao;

public class PopulationClass {
    public static void populateDb(){
        DefaultPopulateWorkerDao.createWorkers();
        DefaultPopulateClientDao.createClients();
        DefaultPopulateProjectDao.createProjects();
        DefaultPopulateProjectWorkerDao.assignWorkersToProjects();
    }
}
