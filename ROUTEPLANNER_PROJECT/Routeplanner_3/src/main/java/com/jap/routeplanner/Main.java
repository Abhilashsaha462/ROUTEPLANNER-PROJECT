package com.jap.routeplanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException {


        Scanner scan = new Scanner(System.in);
        Operations operations=new Operations();
        System.out.println("=================================================Displaying All Flights Details============================================================");
        List<RouteDetails> route= operations.displayAllFlights();

        System.out.println("Enter the Source Station");
        String fromCity= scan.nextLine();

        System.out.println("===========================================Displaying All Flights Details From Source Station===============================================");
        System.out.println(String.format("%15s %15s %25s %20s %20s", "From", "To", "Distance in Km", "Travel Time", "Typical Airfare"));
        List<RouteDetails> directFlights=operations.showDirectFlights(route,fromCity);

        System.out.println("=======================================Displaying All Sorted Flights Details From Source Station============================================");
        System.out.println(String.format("%15s %15s %25s %20s %20s", "From", "To", "Distance in Km", "Travel Time", "Typical Airfare"));
        List<RouteDetails> sortedDirectFlights=operations.sortDirectFlights(directFlights);

        System.out.println("Enter the Source Station");
        fromCity = scan.nextLine();
        System.out.println("Enter the Destination Station");
        String toCity= scan.nextLine();
        System.out.println("================= Displaying All Flights Details From Source Station To Destination Station Including Intermediate Flights==================");
        System.out.println(String.format("%15s %15s %25s %20s %20s", "From", "To", "Distance in Km", "Travel Time", "Typical Airfare"));
        operations.showAllConnections(route, fromCity, toCity);
    }
}