package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final HashMap<Integer, Pair> start = new HashMap<>();
    private static final HashMap<Integer, Pair> end = new HashMap<>();
    private static int activeRequests = 0;

    public static class Pair{
        int key;
        ArrayList<Request> requests = new ArrayList<>();

        public Pair(int key){
            this.key = key;
        }

        void addRequest(Request r){
            requests.add(r);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", requests=" + requests +
                    '}';
        }
    }

    public static class Point{
        int key;
        float longitude;
        float latitude;

        public Point(int key, float longitude, float latitude){
            this.key = key;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public float getLength(Point point){
            return (float) Math.sqrt(Math.pow(longitude - point.longitude, 2) + Math.pow(latitude - point.latitude, 2));
        }
    }

    /**
     * get graph from file
     * @param graph graph to be initialized
     * @throws FileNotFoundException mao not found
     */
    public static void getGraph(Graph graph) throws FileNotFoundException {
        int n, m;
        File in = new File("Maps\\1\\m1.txt");
        Scanner sc = new Scanner(in);

        n = sc.nextInt(); m = sc.nextInt();
        HashMap<Integer, Point> map = new HashMap<>();

        for (int i = 0 ; i < n ; i++){
            int key = sc.nextInt();
            float longitude = sc.nextFloat(), latitude = sc.nextFloat();
            map.put(key, new Point(key, longitude, latitude));
        }

        for (int j = 0 ; j < m ; j++){
            int key1 = sc.nextInt(), key2 = sc.nextInt();
            float length = map.get(key1).getLength(map.get(key2));
            graph.addEdge(key1, key2, length);
        }

        System.out.println(graph.toString());
    }

    /**
     * get requests from file
     * @throws FileNotFoundException testcase not found
     */
    public static void getRequest() throws FileNotFoundException {
        File in = new File("Maps\\1\\test.txt");
        Scanner sc = new Scanner(in);
        int maxTime = 0;
        while (sc.hasNext()) {
            int time = sc.nextInt();
            int key1 = sc.nextInt(), key2 = sc.nextInt();
            if (maxTime < time) maxTime = time;
            Request request = new Request(time, key1, key2);

            if (!start.containsKey(time)){
                Pair pair = new Pair(time);
                pair.addRequest(request);
                start.put(time, pair);
            } else {
                start.get(time).addRequest(request);
            }
            activeRequests++;
        }

        System.out.println(start.toString());
    }

    /**
     * get response for active requests
     */
    public static void getResponse(Graph graph){
        int i = 0;
        while (activeRequests > 0){
            if (start.containsKey(i)){
                for (Request r : start.get(i).requests){
                    r.catchResponse(graph);

                    int arrivingTime = (int) (r.getEnd() + 1);
                    if (!end.containsKey(arrivingTime)){
                        Pair pair = new Pair(arrivingTime);
                        pair.addRequest(r);
                        end.put(arrivingTime, pair);
                    } else {
                        end.get(arrivingTime).addRequest(r);
                    }
                }
            }

            if (end.containsKey(i)){
                if (!end.get(i).requests.isEmpty())
                    for (Request r : end.get(i).requests){
                        if (r.isDone(i)) {
                            r.decreaseTraffic();
                            activeRequests--;
                        }
                    }
            }

            i++;
        }
        start.clear();
        end.clear();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph();
        getGraph(graph);
        getRequest();
        getResponse(graph);
    }
}
