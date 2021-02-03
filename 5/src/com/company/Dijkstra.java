package com.company;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    public PathDetail sssp(Graph graph, Vertex sourceVertex){

        MinHeap heap = new MinHeap();
        Map<Vertex,Integer> distance = new HashMap<>();
        Map<Vertex, Vertex> parent = new HashMap<>();

        for(Vertex vertex : graph.getVertices()){
            heap.insert(Integer.MAX_VALUE, vertex);
        }

        heap.decreaseKey(sourceVertex, 0);
        distance.put(sourceVertex, 0);
        parent.put(sourceVertex, null);

        while(!heap.isEmpty()){
            MinHeap.Node root = heap.extractMin();
            Vertex head = root.key;

            distance.put(head, root.weight);

            for(Edge edge : head.getEdges()){

                Vertex tail = edge.getV(head);
                if(!heap.contains(tail)){
                    continue;
                }

                int weight = edge.getWeight();
                int newDist = distance.get(head) + weight;

                if(heap.getWeight(tail) > newDist) {
                    heap.decreaseKey(tail, newDist);
                    parent.put(tail, head);
                }
            }
        }
        return new PathDetail(distance, parent);
    }
}
