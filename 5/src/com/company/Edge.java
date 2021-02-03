package com.company;

public class Edge {
    private final Vertex head;
    private final Vertex tail;
    private final float length;
    private int traffic;

    Edge(Vertex head, Vertex tail, float length) {
        this.head = head;
        this.tail = tail;
        this.length = length;
        this.traffic = 0;
    }

    public Vertex getV(Vertex v){
        return v.getKey().equals(head.getKey()) ? tail : head;
    }

    public float getLength() {
        return length;
    }

    public float getWeight(){

        return (float) (length * (1 + 0.3 * traffic));
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
