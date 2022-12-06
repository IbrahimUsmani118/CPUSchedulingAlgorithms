import java.util.Random;
import java.util.Scanner;

public class ShortestJobFirst {
    public static void main(String[] args) {
        // Declaring the integer variables
        int n;
        int temp;
        int tt = 0;
        int min;
        int d = 0;
        int i;
        int j;

        // Declaring the float variables
        float average_turnaround_time = 0F;
        float average_wait_time = 0F;
        float shortest_turnaround_time = 0F;
        float shortest_wait_time = 0F;

        // Ask user for the number of processes
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of process: ");
        System.out.print("\n");
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] e = new int[n];
        int[] turnaround_time = new int[n];
        int[] wait_time = new int[n];

        // For loop to prompt user to enter arrival time
        for (i = 0; i < n; i++) {
            System.out.print("Enter arrival time: ");
            a[i] = sc.nextInt();
        }
        // For loop to prompt user to enter burst time
        for (i = 0; i < n; i++) {
            System.out.print("Enter burst time: ");
            b[i] = sc.nextInt();
        }
        // Calculation of algorithm involving temps or temporary variable
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (b[i] > b[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;

                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        min = a[0];

        // Calculate minimum time
        for (i = 0; i < n; i++) {
            if (min > a[i]) {
                min = a[i];
                d = i;
            }
        }

        tt = min;
        e[d] = tt + b[d];
        tt = e[d];

        for (i = 0; i < n; i++) {
            if (a[i] != min) {
                e[i] = b[i] + tt;
                tt = e[i];
            }
        }
        // Calculate turnaround time and wait time along with the shortest of them both
        for (i = 0; i < n; i++) {

            turnaround_time[i] = e[i] - a[i];
            shortest_turnaround_time = shortest_turnaround_time + turnaround_time[i];
            wait_time[i] = turnaround_time[i] - b[i];
            shortest_wait_time = shortest_wait_time + wait_time[i];
        }
        // Calculate the average wait and turn around time
        average_turnaround_time = shortest_turnaround_time / n;
        average_wait_time = shortest_wait_time / n;
        // Print the chart of the processes along with arrival, burst, wait and turnaround time lines 97-117
        System.out.print("Process    Arrival-time      Burst-time        Wait-time     Turnaround-time\n");

        for (i = 0; i < n; i++) {
            System.out.print("P");
            System.out.print(i + 1);
            System.out.print("              ");
            System.out.print(a[i]);
            System.out.print("                ");
            System.out.print(b[i]);
            System.out.print("                  ");
            System.out.print(wait_time[i]);
            System.out.print("               ");
            System.out.print(turnaround_time[i]);
            System.out.print("\n");
        }
        // System prints the average wait and turnaround time
        System.out.print("Average Wait Time=");
        System.out.print(average_wait_time);
        System.out.print(" Average Turnaround Time=");
        System.out.print(average_turnaround_time);

    }
}