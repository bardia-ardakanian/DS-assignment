import java.util.Scanner;

public class Main {
    
    //recursively find the next elements in order
    //use ascii code to represent order
    public static int findPath(int row, int column, int[][] matrix, int x, int y) {
        //itself
        int result = 1;
        if (x+1 < row && matrix[x][y] + 1 == matrix[x+1][y])
        {
            int temp = 1 + findPath(row, column, matrix, x+1, y);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (y+1 < column && matrix[x][y] + 1 == matrix[x][y+1])
        {
            int temp = 1 + findPath(row, column, matrix, x, y+1);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (x-1 >= 0 && matrix[x][y] + 1 == matrix[x-1][y])
        {
            int temp = 1 + findPath(row, column, matrix, x-1, y);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (y-1 >= 0 && matrix[x][y] + 1 == matrix[x][y-1])
        {
            int temp = 1 + findPath(row, column, matrix, x, y-1);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (x+1 < row && y+1 < column && matrix[x][y] + 1 == matrix[x+1][y+1])
        {
            int temp = 1 + findPath(row, column, matrix, x+1, y+1);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (x-1 >= 0 && y+1 < column && matrix[x][y] + 1 == matrix[x-1][y+1])
        {
            int temp = 1 + findPath(row, column, matrix, x-1, y+1);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (x+1 < row && y-1 >= 0 && matrix[x][y] + 1 == matrix[x+1][y-1])
        {
            int temp = 1 + findPath(row, column, matrix, x+1, y-1);
            if (temp > result)
            {
                result = temp;
            }
        }
        if (x-1 >= 0 && y-1 >= 0 && matrix[x][y] + 1 == matrix[x-1][y-1])
        {
            int temp = 1 + findPath(row, column, matrix, x-1, y-1);
            if (temp > result)
            {
                result = temp;
            }
        }
    
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), column = sc.nextInt();
        int[][] grid = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        
        int x=0, y=0, longestPath=0, target = sc.next().charAt(0);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                int temp;
                if (grid[i][j] == target)
                {
                    temp = findPath(row, column, grid, i, j);
                    if (temp > longestPath)
                    {
                        x=i; y=j;
                        longestPath = temp;
                    }
                }
            }
        }

        System.out.println(longestPath + "\n" + x + " " + y);
        sc.close();
    }
}
