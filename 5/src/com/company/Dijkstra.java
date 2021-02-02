package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {

    public static void shortestPath(Graph graph, int source, int destination){

        MinHeap heap = new MinHeap();
        HashMap<Node, Integer> distance = new HashMap<>();
        HashMap<Node, Node> parent = new HashMap<>();

        for (Node node : graph.getVertices()){
            heap.insert(Integer.MAX_VALUE, node.getKey());
        }

        heap.decreaseKey(source, 0);
        distance.put(graph.getNode(source), 0);
        parent.put(graph.getNode(source), null);

        while (!heap.isEmpty()){
            int root = heap.extractMin();
        }
    }
}
