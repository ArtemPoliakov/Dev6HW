package com.homework.actual_homework;
import com.homework.actual_homework.services.DatabaseQueryService;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService.getProjectWithMaxDuration().stream().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        DatabaseQueryService.getMaxProjectsClient().stream().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        DatabaseQueryService.getMaxSalaryWorker().stream().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        DatabaseQueryService.getYoungestEldestWorkers().stream().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        DatabaseQueryService.getAllProjectPrices().stream().forEach(System.out::println);
    }
}