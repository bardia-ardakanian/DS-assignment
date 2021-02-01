package com.company;

public class HeapNode {
    private int v;
    private int dist;

    public HeapNode(int v, int dist){
        this.v = v;
        this.dist = dist;
    }

    public int getV() {
        return v;
    }

    public int getDist() {
        return dist;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }
}
