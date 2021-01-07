import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static class Queue<E> {

        private LinkedList<E> list = new LinkedList<E>();

        public void enqueue(E item) {
            list.addLast(item);
        }

        public E dequeue() {
            return list.poll();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public E peek() {
            return  list.peek();
        }

        public E poll() {
            return list.poll();
        }

        public void show() {
            System.out.print("Queue : ");
            for(E e : list) {
                Main.Point p = (Main.Point) e;
                System.out.print(p.x + "," + p.y + " ");
            }
            System.out.println();
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void BFS(Queue<Point> queue, int[][] map, boolean[][] visited, int row, int column) {

        while(!queue.isEmpty())
        {
            //get and remove top element
            Point top = queue.poll();
            int X = top.getX(), Y = top.getY();

            Point[] possibleDirs = {new Point(X+1, Y), new Point(X-1, Y), new Point(X, Y+1), new Point(X, Y-1)};
            for (Point possibleDir : possibleDirs) {
                int x = possibleDir.getX(), y = possibleDir.getY();

                boolean indexOutOfBound = (x >= 0 && x < row) && (y >= 0 && y < column);
                if (indexOutOfBound && !visited[x][y]) {
                    //increase length by one
                    map[x][y] = map[X][Y] + 1;
                    queue.enqueue(possibleDir);
                    visited[x][y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        sc.nextLine();
        Queue<Point> queue = new Queue<>();                          //queue of mountains

        int[][] map = new int[row][column];
        boolean[][] visited = new boolean[row][column];

        //get map
        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                //we suppose all nodes are blocked
                //and we haven't visited any node yet
                map[i][j] = -1;
                visited[i][j] = false;

                char c = line.charAt(j);

                if (c == 'M') {                                 //mountain
                    queue.enqueue(new Point(i, j));
                    //nearest mountain is itself
                    map[i][j] = 0;
                    visited[i][j] = true;
                } else if (c == 'X') {                          //obstacles
                    visited[i][j] = true;
                }
            }
        }

        BFS(queue, map, visited, row, column);

        //print
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}