import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    static class Ring
    {
        int head;
        List<Integer> array;

        public Ring(Integer ...numbers)
        {
            head = 0;
            array = Arrays.asList(numbers);
        }

        public void spin(int k)
        {
            int size = array.size();
            head += k;
            if(head >= 0) 
            {
                head %= size;
            }
            else
            {
                while(head < 0)
                {
                    head += size;
                }
            }
        }

        public void print()
        {
            for (int i = head; i < array.size() + head; i++) {
                System.out.print(array.get(i % array.size()) + " ");
            }
            System.out.println();
        }
    }

    public static void print(ArrayList<Ring> rings){
        for (Ring ring : rings) { 
            ring.print();
        }
    }

    public static void combination(ArrayList<Ring> rings, int head)
    {
        for (int i = head; i < rings.size() + head; i++) {
            int ringIndex = i%rings.size() ,headIndex = rings.get(ringIndex).head;
            System.out.print(rings.get(ringIndex).array.get(headIndex));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayList<Ring> rings = new ArrayList<>();

        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            Integer[] numbers = new Integer[Integer.parseInt(input[1])];
            for (int j = 0; j < Integer.parseInt(input[1]); j++) {
                numbers[j] = sc.nextInt();
            }
            rings.add(new Ring(numbers));
        }

        int h = sc.nextInt();
        int[] rb = new int[h];
        for (int i = 0; i < h; i++) {
            rb[i] = sc.nextInt();
        }

        int times = sc.nextInt();

        int head=0, i=0;
        while(times > 0)
        {
            rings.get(head).spin(rb[i]);
            i = (i+1) % rb.length;
            head = (head+1) % rings.size();
            times--;
        }

        combination(rings, head);
    }
}
