package com.company;

import java.util.*;

public class Graph{

    private List<Edge> edges;
    private Map<Integer, Vertex> vertices;

    public Graph(){
        edges = new ArrayList<>();
        vertices = new HashMap<>();
    }

    public void addEdge(int key1, int key2, int weight){
        Vertex head = null;
        if(vertices.containsKey(key1)){
            head = vertices.get(key1);
        }else{
            head = new Vertex(key1);
            vertices.put(key1, head);
        }
        Vertex tail = null;
        if(vertices.containsKey(key2)){
            tail = vertices.get(key2);
        }else{
            tail = new Vertex(key2);
            vertices.put(key2, tail);
        }

        Edge edge = new Edge(head,tail,weight);
        edges.add(edge);
        head.addEdge(edge, tail);
        tail.addEdge(edge, head);
    }

    public Vertex getVertex(int key){
        return vertices.get(key);
    }

    public Collection<Vertex> getVertices() {
        return vertices.values();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "\nedges=" + edges.toString() +
                "\nvertices=" + vertices.toString() +
                "\n}";
    }
}


