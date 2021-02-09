package com.company;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    public static Response sssp(Graph graph, Vertex sourceVertex){

        MinHeap heap = new MinHeap();
        Map<Vertex,Float> distance = new HashMap<>();
        Map<Vertex, Vertex> parent = new HashMap<>();

        for(Vertex vertex : graph.getVertices()){
            heap.insert(Integer.MAX_VALUE, vertex);
        }

        heap.decreaseKey(sourceVertex, 0);
        distance.put(sourceVertex, (float) 0);
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

                float length = edge.getWeight();
                float newDist = distance.get(head) + length;

                if(heap.getWeight(tail) > newDist) {
                    heap.decreaseKey(tail, newDist);
                    parent.put(tail, head);
                }
            }
        }
        return new Response(distance, parent);
    }
}
