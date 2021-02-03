package com.company;

import java.util.ArrayList;

public class Vertex {
    private Integer key;
    private ArrayList<Edge> edges;
    private ArrayList<Vertex> adjList;

    Vertex(int key) {
        this.key = key;
        edges = new ArrayList<>();
        adjList = new ArrayList<>();
    }

    public void addEdge(Edge e, Vertex v) {
        edges.add(e);
        adjList.add(v);
    }

    public Integer getKey() {
        return key;
    }

    public ArrayList<Vertex> getAdjList() {
        return adjList;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "key=" + key +
                "}";
    }
}
