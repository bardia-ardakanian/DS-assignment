package com.company;

import java.util.ArrayList;

public class Vertex {
    private final Integer key;
    private final ArrayList<Edge> edges;
    private final ArrayList<Vertex> adjList;

    Vertex(int key) {
        this.key = key;
        edges = new ArrayList<>();
        adjList = new ArrayList<>();
    }

    public void addEdge(Edge e, Vertex v) {
        edges.add(e);
        adjList.add(v);
    }

    public Edge getEdge(Vertex key) {
        if (!adjList.contains(key)) return null;
        return edges.get(adjList.indexOf(key));
    }

    public Integer getKey() {
        return key;
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
