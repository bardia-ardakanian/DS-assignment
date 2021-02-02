package com.company;

import java.util.*;

public class Graph {

    private ArrayList<Integer> keys;
    private ArrayList<Node> vertices;

    public Graph(){
        keys = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight){
        if (!keys.contains(source)) {
            keys.add(source);
            vertices.add(new Node(weight, source));
        }
        if (!keys.contains(destination)) {
            keys.add(destination);
            vertices.add(new Node(weight, destination));
        }

        //System.out.println("vertices: " + vertices.toString() + "\nkeys: " + keys.toString());
        int srcIndex = keys.indexOf(source), destIndex = keys.indexOf(destination);
        //System.out.println(srcIndex + " " + destIndex);
        vertices.get(srcIndex).addEdge(vertices.get(destIndex));
        vertices.get(destIndex).addEdge(vertices.get(srcIndex));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Node n : vertices){
            builder.append(n.toString() + "->");
            for (Node e : n.getAdjList()){
                builder.append(e.toString() + "->");
            }
            builder.append("NULL\n");
        }

        return (builder.toString());
    }
}
