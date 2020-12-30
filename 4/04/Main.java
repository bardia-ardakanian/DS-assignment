import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static StringBuilder path = new StringBuilder("");
    
    static class Node
    {
        private int data; //node number
        private boolean visited; 
        private List<Node> neighbors;
        private Node parent;

        public Node(int data)
        {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node neighborNode)
        {
            this.neighbors.add(neighborNode);
        }

        @Override
        public String toString() {
            String str = data + "-> ";
            for (Node node : neighbors) {
                str = str.concat(str + node.data + ", ");
            }
            return str;
        }

        public int getData() {
            return data;
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public Node getParent() {
            return parent;
        }

        public void setNeighbors(List<Node> neighbors) {
            this.neighbors = neighbors;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
    
    public static boolean findPath(Node start, Node end)
    {
        if (start == end)
        {
            Node curr = end;
            while(curr != null)
            {
                path.insert(0, curr.data + " ");
                curr = curr.parent;
            }
            return true;
        }

        start.setVisited(true);
        //get unvisited nodes
        List<Node> unvisitedNodes = new ArrayList<>();
        for (Node node : start.neighbors) {
            if(!node.visited) unvisitedNodes.add(node);
        }

        for (Node node : unvisitedNodes) {
            //set parent
            node.parent = start;

            if(findPath(node, end)) return true;
        }

        return false;
    }

    public static void addAdj(Node head, Node tail)
    {
        head.neighbors.add(tail);
        tail.neighbors.add(head);
    }

    public static void main(String[] args) {

        int V; // No. of vertices
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();

        List<Node> graphNodes = new ArrayList<>();
        //initialize all nodes
        for (int i = 1; i <= V; i++) {
            graphNodes.add(new Node(i));
        }

        for (int i = 1; i < V; i++) {
            addAdj(graphNodes.get(i), graphNodes.get(sc.nextInt()-1));
        }

        findPath(graphNodes.get(0), graphNodes.get(V-1));
        System.out.println(path);
    }
}