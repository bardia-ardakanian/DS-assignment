package com.company;

import java.util.ArrayList;

public class Heap {
    private int size;
    private final int[] position;
    private ArrayList<HeapNode> heapNodes;

    public Heap(int capacity){
        this.size = 0;
        this.position = new int[capacity];
    }

    public void swapNodes(HeapNode src, HeapNode dest){
        int srcIndex = heapNodes.indexOf(src), destIndex = heapNodes.indexOf(dest);
        HeapNode temp = src;
        heapNodes.set(srcIndex, dest);
        heapNodes.set(destIndex, temp);
    }

    public void minHeapify(int idx){
        int smallest, left, right;
        smallest = idx;
        left = 2 * idx + 1;
        right = 2 * idx + 2;

        if (left < size && heapNodes.get(left).getDist() < heapNodes.get(smallest).getDist()) smallest = left;
        if (right < size && heapNodes.get(right).getDist() < heapNodes.get(smallest).getDist()) smallest = right;

        if (smallest != idx){
            HeapNode smallestNode = heapNodes.get(smallest);
            HeapNode idxNode = heapNodes.get(idx);

            swapNodes(smallestNode, idxNode);
            minHeapify(smallest);
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public HeapNode extractMin(){
        if (!isEmpty()) return null;

        HeapNode root = heapNodes.get(0);
        HeapNode last = heapNodes.get(size - 1);
        heapNodes.set(0, last);
        position[root.getV()] = this.size-1;
        position[last.getV()] = 0;
        size--;

        minHeapify(0);

        return root;
    }

    public void decreaseKey(int v, int dist){
        int i = position[v];

        heapNodes.get(i).setDist(dist);

        while (i > 0 && heapNodes.get(i).getDist() < heapNodes.get((i - 1) / 2).getDist())
        {
            position[heapNodes.get(i).getV()] = (i - 1) / 2;
            position[heapNodes.get((i - 1) / 2).getV()] = i;
            swapNodes(heapNodes.get(i), heapNodes.get((i - 1) / 2));
            //goto parent
            i = (i - 1) / 2;
        }
    }

    public boolean containsV(int v){
        return position[v] < size;
    }
}
