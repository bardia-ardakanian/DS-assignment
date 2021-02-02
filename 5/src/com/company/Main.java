package com.company;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addEdge(35, 30, 50);
        graph.addEdge(20, 30, 50);
        graph.addEdge(25, 30, 30);
        graph.addEdge(25, 15, 10);
        graph.addEdge(20, 15, 15);
        graph.addEdge(10, 15, 25);

        System.out.println(graph.toString());
    }
}
