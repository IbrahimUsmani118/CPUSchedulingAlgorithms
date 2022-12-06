import java.util.Random;
import java.util.Scanner;

public class RoundRobin {

    public static void main(String[] args) {
        // Initializing variables for the program to perform its tasks
        Scanner sc = new Scanner(System.in);
        int i;
        int n;
        int time;
        int remain;
        int temps = 0;
        int quantum;
         
        // Initialize wait and turnaround time to 0 as the initial starting point
        int wait_time = 0;
        int turnaround_time = 0;

        // Ask user for the total number of processes to calculate its times
        System.out.print("Enter the total number of processes: ");
        System.out.print("\n");
        n = sc.nextInt();
        remain = n;

        // Arrival, burst and return time
        int[] arrival_time = new int[n];
        int[] burst_time = new int[n];
        int[] remaining_burst_time = new int[n];

        // User is prompted to enter the arrival and burst time for the # processes desired
        System.out.print("Enter the processes' arrival and burst time");
        System.out.print("\n");
        for (i = 0; i < n; i++) {
            System.out.print("Arrival time for process ");
            System.out.print(i + 1);
            System.out.print("\n");
            arrival_time[i] = sc.nextInt();
            System.out.print("Burst time for process ");
            System.out.print(i + 1);
            System.out.print("\n");
            burst_time[i] = sc.nextInt();
            remaining_burst_time[i] = burst_time[i];
        }

        // Enter the quantum value for the scheduling task
        System.out.print("Enter the quantum value:");
        System.out.print("\n");
        quantum = sc.nextInt();

        System.out.print("\n\nProcess\t:Turnaround Time:Waiting Time\n\n");
        for (time = 0, i = 0; remain != 0;) {
            if (remaining_burst_time[i] <= quantum && remaining_burst_time[i] > 0) {
                time += remaining_burst_time[i];

                remaining_burst_time[i] = 0;
                temps = 1;
            } else if (remaining_burst_time[i] > 0) {
                remaining_burst_time[i] -= quantum;

                time += quantum;

            }

            if (remaining_burst_time[i] == 0 && temps == 1) {
                remain--;
                // Displaying the result of wating, turn around time:
                System.out.printf("P[%d]\t   :     \t%d\t     :  \t%d\n", i + 1, time - arrival_time[i], time - arrival_time[i] - burst_time[i]);
                System.out.print("\n");

                wait_time += time - arrival_time[i] - burst_time[i];
                turnaround_time += time - arrival_time[i];
                temps = 0;
            }

            if (i == n - 1) {
                i = 0;
            } else if (arrival_time[i + 1] <= time) {
                i++;
            } else {
                i = 0;
            }
        }

        // Print the average waiting time and average turnaround time
        System.out.print("Average waiting time ");
        System.out.print(wait_time * 1.0 / n);
        System.out.print("\n");
        System.out.print("Average turn around time ");
        System.out.print(turnaround_time * 1.0 / n);
        System.out.print("\n");

    }
}