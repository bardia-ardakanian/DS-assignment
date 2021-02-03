package com.company;

public class Edge {
    private Vertex head;
    private Vertex tail;
    private int weight;

    Edge(Vertex head, Vertex tail, int weight) {
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    public Vertex getV(Vertex v){
        return v.getKey().equals(head.getKey()) ? tail : head;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "head=" + head +
                ", tail=" + tail +
                ", weight=" + weight +
                '}';
    }
}
