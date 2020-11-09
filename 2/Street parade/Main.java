import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
    final static int SIZE = 2600;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> truckQueue = new ArrayList<>();
        ArrayList<Integer> subordinateStack = new ArrayList<>();

        String string[] = sc.nextLine().split(" ");

        for(String s : string)
        {
            truckQueue.add(Integer.parseInt(s));
        }

        for (int i = 0; i < truckQueue.size(); i++)
        {
            if(i != truckQueue.size()-1 &&
                (truckQueue.get(i) > i+1 || truckQueue.get(i) > truckQueue.get(i+1)))
            {
                subordinateStack.add(truckQueue.get(i));
                truckQueue.remove(i);
                i--;
            }
            else if(!subordinateStack.isEmpty())
            {
                if(truckQueue.get(i)+1 == subordinateStack.get(subordinateStack.size()-1))
                {
                    truckQueue.add(i+1, subordinateStack.get(subordinateStack.size()-1));
                    subordinateStack.remove(subordinateStack.size()-1);
                }
            }

            // System.out.println("Queue " + truckQueue.toString());
            // System.out.println("Stack " + subordinateStack.toString());
        }

        if(subordinateStack.size() != 0)
        {
            System.out.println("no");
        }
        else
        {
            System.out.println("yes");
        }

        sc.close();
    }
}