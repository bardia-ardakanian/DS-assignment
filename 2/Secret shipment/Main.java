import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //store trucks in order
        List<String> input = new ArrayList<>();
        input.addAll(Arrays.asList(sc.nextLine().split(" ", -1)));
        sc.close();

        System.out.print(input.get(input.size()-1) + " ");

        int head=0,tail=input.size()-2;
        if(tail < 0)
        {
            return;
        }
        while(true)
        {
            if(head > tail)
            {
                break;
            }
            else if(head == tail)
            {
                System.out.print(input.get(head).trim());
                break;
            }
            System.out.print(input.get(head).trim() + " ");
            head++;

            System.out.print(input.get(tail).trim() + " ");
            tail--;
        }
    }
}