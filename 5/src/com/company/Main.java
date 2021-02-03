package com.company;

public class Main {



    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.addEdge(1, 2, 5);
//        graph.addEdge(2, 3, 2);
//        graph.addEdge(1, 4, 9);
//        graph.addEdge(1, 5, 3);
//        graph.addEdge(5, 6, 2);
//        graph.addEdge(6, 4, 2);
//        graph.addEdge(3, 4, 3);
//        System.out.println(graph.getVertex(1).getAdjList().toString());

//        MinHeap heap = new MinHeap();
//        for (int i = 0; i < 7 ; i++){
//            heap.insert(i, new Vertex(i));
//        }
//        System.out.println(heap.toString());
//        for (int i = 0; i < 7 ; i++){
//            System.out.println(heap.extractMin().getKey());
//            System.out.println(heap.toString());
//        }

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        Dijkstra dijkstra = new Dijkstra();
        Vertex source = graph.getVertex(1);
        Vertex destination = graph.getVertex(4);
//        Map<Vertex,Integer> distance = dsp.shortestPath(graph, sourceVertex);
//        System.out.println(distance);
//        for (Vertex key : distance.keySet()){
//            if (key.getKey() == 4) System.out.println(distance.get(key));
//        }

        PathDetail detail = dijkstra.sssp(graph, source);
        detail.optimalPath(destination);
        System.out.println(detail.toString());
    }
}
