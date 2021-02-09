package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinHeap {

    private final ArrayList<Node> nodes = new ArrayList<>();
    private final Map<Vertex,Integer> position = new HashMap<>();

    public static class Node {
        float weight;
        Vertex key;

        public Node(float weight, Vertex key){
            this.weight = weight;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", key=" + key.getKey() +
                    '}';
        }
    }
    
    public void insert(int weight,Vertex key) {
        Node node = new Node(weight, key);
        nodes.add(node);
        
        int size = nodes.size();
        int curr = size - 1;
        int parent = (curr - 1) / 2;
        position.put(node.key, curr);

        while (parent >= 0) {
            Node parentNode = nodes.get(parent);
            Node currentNode = nodes.get(curr);
            if (parentNode.weight > currentNode.weight) {
                swap(parentNode,currentNode);
                updatePositionMap(parentNode.key, parent, currentNode.key, curr);
                curr = parent;
                parent = (parent - 1) / 2;
            } else break;
        }
    }
    
    public void decreaseKey(Vertex data, float newWeight){
        int curr = position.get(data);
        nodes.get(curr).weight = newWeight;
        int parent = (curr - 1) / 2;
        while(parent >= 0){
            if(nodes.get(parent).weight > nodes.get(curr).weight){
                swap(nodes.get(parent), nodes.get(curr));
                updatePositionMap(nodes.get(parent).key, parent,nodes.get(curr).key,curr);
                curr = parent;
                parent = (parent-1)/2;
            }else break;
        }
    }

    public float getWeight(Vertex key) {
        if(!position.containsKey(key)) return -1;
        return nodes.get(position.get(key)).weight;
    }
    
    public Node extractMin() {
        int size = nodes.size() -1;
        Node root = new Node(nodes.get(0).weight, nodes.get(0).key);

        nodes.get(0).weight = nodes.get(size).weight;
        nodes.get(0).key = nodes.get(size).key;
        position.remove(root.key);
        position.remove(nodes.get(0).key);
        position.put(nodes.get(0).key, 0);
        nodes.remove(size);

        heapify(0);
        return root;
    }

    public boolean contains(Vertex v){
        return position.containsKey(v);
    }

    public boolean isEmpty(){
        return nodes.size() == 0;
    }

    private void heapify(int i){
        int left = 2*i + 1, right = 2*i + 2, smaller;
        if(left >= nodes.size()) return;

        if(right >= nodes.size()) right = left;

        smaller = nodes.get(left).weight <= nodes.get(right).weight ? left : right;

        if(nodes.get(i).weight > nodes.get(smaller).weight){
            swap(nodes.get(i), nodes.get(smaller));
            updatePositionMap(nodes.get(i).key,i, nodes.get(smaller).key, smaller);
            heapify(smaller);
        }
    }

    private void swap(Node a,Node b){
        float wTemp = a.weight;
        Vertex vTemp = a.key;

        a.weight = b.weight;
        a.key = b.key;

        b.weight = wTemp;
        b.key = vTemp;
    }

    private void updatePositionMap(Vertex v1, int pos1, Vertex v2, int pos2){
        position.remove(v1);
        position.remove(v2);
        position.put(v1, pos1);
        position.put(v2, pos2);
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "\nnodes=" + nodes.toString() +
                "\nposition=" + position +
                "\n}";
    }
}
