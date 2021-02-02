package com.company;

import java.util.LinkedList;

public class Node {

    private int weight;
    private int key;
    private LinkedList<Node> adjList;

    public Node(int weight, int key){
        this.key = key;
        this.weight = weight;
        adjList = new LinkedList<>();
    }

    public void addEdge(Node adj){
        adjList.add(adj);
    }

    public int getWeight() {
        return weight;
    }

    public int getKey() {
        return key;
    }

    public LinkedList<Node> getAdjList() {
        return adjList;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(key + ":" + weight);

        return (builder.toString());
    }
}
