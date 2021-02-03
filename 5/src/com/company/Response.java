package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Response {
    private final Map<Vertex,Float> distance;
    private final Map<Vertex, Vertex> parent;
    private final Stack<Vertex> vertices;
    private final ArrayList<Edge> edges;
    private float weight;
    private float time;



    public Response(Map<Vertex,Float> distance, Map<Vertex, Vertex> parent){
        this.distance = distance;
        this.parent = parent;
        this.vertices = new Stack<>();
        this.edges = new ArrayList<>();
    }

    public void calculate(Vertex destination){
        addVertex(destination);
        Vertex parent = getParent().get(destination), self = destination;
        while (parent != null){
            edges.add(self.getEdge(parent));
            addVertex(parent);
            self = parent;
            parent = getParent().get(parent);
        }

        weight = getWeight();
        time = getTime();
    }

    public float getTime(){
        return 120 * weight;
    }

    public float getWeight(){
        float sum = 0;
        for (Edge e : edges){
            sum += e.getWeight();
            e.setTraffic(e.getTraffic() + 1);
        }

        return sum;
    }

    public Map<Vertex, Vertex> getParent() {
        return parent;
    }

    public void addVertex(Vertex v){
        vertices.push(v);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("path: ");
        for (int i = vertices.size() - 1 ; i >= 0 ; i--) {
            builder.append(vertices.get(i).getKey());
            if (i != 0) builder.append(" -> ");
        }
        builder.append("\n");
        builder.append("Weight: ").append(weight);
        builder.append("\ntime: ").append(time);

        return String.valueOf(builder);
    }
}
