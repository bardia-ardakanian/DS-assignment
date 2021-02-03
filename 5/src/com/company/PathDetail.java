package com.company;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class PathDetail {
    private Map<Vertex,Integer> distance;
    private Map<Vertex, Vertex> parent;
    private Stack<Vertex> direction;
    private int weight;



    public PathDetail(Map<Vertex,Integer> distance, Map<Vertex, Vertex> parent){
        this.distance = distance;
        this.parent = parent;
        this.weight = 0;
        this.direction = new Stack<>();
    }

    public void optimalPath(Vertex destination){
        addVertex(destination);
        Vertex parent = getParent().get(destination);
        while (parent != null){
            addVertex(parent);
            parent = getParent().get(parent);
        }

        setWeight(getDistance().get(destination));
    }

    public Map<Vertex, Integer> getDistance() {
        return distance;
    }

    public Map<Vertex, Vertex> getParent() {
        return parent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addVertex(Vertex v){
        direction.push(v);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("path: ");
        for (int i = direction.size() - 1 ; i >= 0 ; i--) {
            builder.append(direction.get(i).getKey());
            if (i != 0) builder.append(" -> ");
        }
        builder.append("\n");
        builder.append("Weight: ").append(weight);

        return String.valueOf(builder);
    }
}
