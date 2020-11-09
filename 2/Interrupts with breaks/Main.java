import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static class Interrupt
    {
        private String serial;
        private Integer delay;

        public Interrupt(String serial, Integer delay)
        {
            setSerial(serial);
            setDelay(delay);
        }

        @Override
        public String toString() {
            return "{" + serial + " ," + delay + "}";
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public void setDelay(Integer delay) {
            this.delay = delay;
        }

        public Integer getDelay() {
            return delay;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Interrupt> interrupts = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        int actions=Integer.parseInt(sc.nextLine());
        for(int i = 0; i<actions; i++)
        {
            strings.add(sc.nextLine());
        }

        for(String s : strings)
        {
            String[] string =  s.split(" ");

            if(string[0].contains("i"))
            {
                interrupts.add(new Interrupt(string[0], Integer.parseInt(string[1])));
            }
            else if(string[0].contains("t"))
            {
                //see if there are any interruptions left
                if(interrupts.size() != 0)
                {
                    int time = Integer.parseInt(string[1]);
                    while(time > 0 && interrupts.size() != 0)
                    {
                        if(interrupts.get(interrupts.size()-1).getDelay() <= time)
                        {
                            time -= interrupts.get(interrupts.size()-1).getDelay();
                            interrupts.remove(interrupts.size()-1);
                        }
                        else
                        {
                            int remaining = interrupts.get(interrupts.size()-1).getDelay() - time;
                            time = 0;
                            interrupts.get(interrupts.size()-1).setDelay(remaining);
                        }
                    }

                    if(interrupts.size() != 0)
                    {
                        System.out.println(interrupts.get(interrupts.size()-1).serial);
                    }
                    else
                    {
                        System.out.println("main");
                    }
                }
                else
                {
                    System.out.println("main");
                }
            }
        }

        sc.close();
    }
}