package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinHeap {
    private final ArrayList<Node> nodes;
    private final Map<Integer,Integer> position;

    public MinHeap(){
        nodes = new ArrayList<>();
        position = new HashMap<>();
    }

    /**
     * insert new node and update HashTable positions
     */
    public void insert(int weight, int key){
        Node newNode = new Node(weight, key);
        nodes.add(newNode);
        int size = nodes.size(), curr = size - 1, parent = (curr - 1) / 2;
        position.put(newNode.getKey(), curr);

        positionFixup(curr, parent);
    }

    /**
     * decrease weight of a given key
     */
    public void decreaseKey(int key, int decreasedKey){
        int curr = position.get(key), parent = (curr - 1) / 2;
        nodes.get(curr).setWeight(decreasedKey);

        positionFixup(curr, parent);
    }

    /**
     * extract smallest key from heap
     */
    public int extractMin(){
        if (nodes.isEmpty()) return -1;

        if (nodes.size() == 1){
            Node root = nodes.get(0);
            nodes.clear();
            position.clear();
            return root.getKey();
        }

        int size = nodes.size() - 1;
        Node root = nodes.get(0), leaf = nodes.get(size);

        //remove root key from map
        position.remove(root.getKey());
        swap(root, leaf);
        nodes.remove(size);
        heapify(0);

        return root.getKey();
    }

    /**
     * display min-heap properties
     */
    public void display(){
        System.out.print("Heap :\n{ ");
        for (Node node : nodes){
            System.out.print(node.getKey() + ":" + node.getWeight() + " ");
        }
        System.out.println("}");

        System.out.println("Position :");
        System.out.println(position.toString());
    }

    public boolean isEmpty(){
        return nodes.size() > 0;
    }

    private void heapify(int i){
        int left = i * 2 + 1, right = i * 2 + 2, smaller = i;

        if (left < nodes.size() && nodes.get(left).getKey() < nodes.get(i).getKey()) smaller = left;
        if (right < nodes.size() && nodes.get(right).getKey() < nodes.get(smaller).getKey()) smaller = right;
        if (smaller != i){
            swap(nodes.get(i), nodes.get(smaller));
            update(nodes.get(i).getKey(), i, nodes.get(smaller).getKey(), smaller);
            heapify(smaller);
        }
    }

    private void update(int keyA, int positionA, int keyB, int positionB){
        position.remove(keyA); position.remove(keyB);
        position.put(keyA, positionA); position.put(keyB, positionB);
    }

    private void swap(Node a,Node b){
        int wTemp = a.getWeight();
        int kTemp = a.getKey();

        a.setWeight(b.getWeight());
        a.setKey(b.getKey());

        b.setWeight(wTemp);
        b.setKey(kTemp);
    }

    private void positionFixup(int curr, int parent) {
        while (parent >= 0){
            Node currNode = nodes.get(curr), parentNode = nodes.get(parent);
            if (currNode.getWeight() < parentNode.getWeight()){
                swap(currNode, parentNode);
                update(parentNode.getKey(), parent, currNode.getKey(), curr);
                curr = parent;
                parent = (parent - 1) / 2;
            } else break;
        }
    }
}
