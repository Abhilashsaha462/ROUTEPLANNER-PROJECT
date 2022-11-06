package com.jap.routeplanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Operations {
    ArrayList<RouteDetails> list = new ArrayList<>();
    public List<RouteDetails> displayAllFlights() throws IOException {
        File f = new File("C:\\NIIT\\New folder\\Routeplanner_3\\src\\main\\resources\\routes.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            int i = 0;
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] tempArray = temp.split(",");
                int distance = Integer.parseInt(tempArray[2].trim());
                list.add(new RouteDetails(tempArray[0], tempArray[1], distance, tempArray[3], tempArray[4]));
                i++;
            }
        }
        list.forEach(x -> System.out.println(x));
        return list;
    }

    public List<RouteDetails> showDirectFlights(List<RouteDetails> list,String fromCity){
        List<RouteDetails> routeDetails=list.stream().filter(i->i.getFromCity().equalsIgnoreCase(fromCity)).map(i->i).collect(Collectors.toList());
        routeDetails.forEach(x->System.out.println(x));
        return routeDetails;
    }

    public List<RouteDetails> sortDirectFlights(List<RouteDetails> list)
    {
        List<RouteDetails> routeDetails=list.stream().sorted((RouteDetails a,RouteDetails b)->a.getToCity().compareToIgnoreCase(b.getToCity())).collect(Collectors.toList());
        routeDetails.forEach(x->System.out.println(x));
        return routeDetails;
    }
    public void showAllConnections(List<RouteDetails> list,String fromCity,String toCity) throws NoSuchFieldException
    {
        AtomicInteger count = new AtomicInteger();
        int count1 = 0;
        list.stream().filter(x->x.getFromCity().trim().equals(fromCity.trim())).filter(j->j.getToCity().trim().equals(toCity.trim())).forEach(i-> System.out.println(i+"\n"));
        list.stream().filter(x->x.getFromCity().trim().equals(fromCity.trim())).filter(j->j.getToCity().trim().equals(toCity.trim())).forEach(x->count.set(count.get()+1));
        if(count.get()==0 && count.get()!=0)
        {
            throw new NoSuchFieldException("We are sorry. At this point of time, we do not have any information on flights between "+fromCity+" and "+toCity);
        }


        for (RouteDetails x : list) {
            String intermediate = x.getToCity().trim();
            if (x.getFromCity().trim().equals(fromCity) && x.getToCity().trim().equals(intermediate.trim())) {

                for (RouteDetails y : list) {
                    if (intermediate.trim().equals(y.getFromCity().trim()) && y.getToCity().trim().equals(toCity.trim())) {

                        if (y.getFromCity().trim().equals(intermediate.trim())) {

                            count1++;
                            System.out.println("Intermediate Flights");
                            System.out.println(x);
                            System.out.println(y+"\n");
                        }
                    }
                }
            }

        }
    }
}