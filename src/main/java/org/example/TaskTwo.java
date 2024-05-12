package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskTwo {
    static class Ad {
        int id;
        double bid;

        Ad(int id, double bid) {
            this.id = id;
            this.bid = bid;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a CSV file as input.");
            return;
        }

        String csvFile = args[0];
        String line;
        String cvsSplitBy = ",";

        PriorityQueue<Ad> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a.bid));
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] ad = line.split(cvsSplitBy);
                int id = Integer.parseInt(ad[0]);
                double bid = Double.parseDouble(ad[1]);
                pq.add(new Ad(id, bid));
            }

            pq.poll(); // Best bid
            Ad secondBest = pq.poll();
            System.out.println(secondBest.id + ", " + secondBest.bid);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


