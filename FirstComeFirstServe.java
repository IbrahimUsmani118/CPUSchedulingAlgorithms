import java.util.Random;
import java.util.Scanner;

public class FirstComeFirstServe {
    public static void main(String[] args) {
        int n; // n is the variable representing the number of processes in the algorithm
        /* the burst time, wait time, and turnaround time have an index of 10 indicating 
          the max number of processes that can be calculated is 10*/
        int[] burst_time = new int[10];
        int[] wait_time = new int[10];
        int[] turnaround_time = new int[10];
        // average wait and turnaround time are initialized to 0 
        int average_wait_time = 0;
        int average_turnaround_time = 0;
        // variable i stands for index, i.e process number's index P[0], P[1], P[2], etc
        int i;
        int j;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of processes: ");
        n = sc.nextInt();

        System.out.print("\nEnter Process Burst Time: \n");
        for (i = 0; i < n; i++) {
            System.out.print("P[");
            System.out.print(i + 1);
            System.out.print("]:");
            burst_time[i] = sc.nextInt();
        }

        wait_time[0] = 0; // Wait time for the first process is 0

        // Calculating waiting time
        for (i = 1; i < n; i++) {
            wait_time[i] = 0;
            for (j = 0; j < i; j++) {
                wait_time[i] += burst_time[j];
            }
        }

        System.out.print("\nProcess\t\tBurst Time\tWaiting Time\tTurnaround Time");

        // Calculating turnaround time
        for (i = 0; i < n; i++) {
            turnaround_time[i] = burst_time[i] + wait_time[i];
            average_wait_time += wait_time[i];
            average_turnaround_time += turnaround_time[i];
            System.out.print("\nP[");
            System.out.print(i + 1);
            System.out.print("]");
            System.out.print("      \t\t  ");
            System.out.print(burst_time[i]);
            System.out.print("    \t\t  ");
            System.out.print(wait_time[i]);
            System.out.print("        \t\t  ");
            System.out.print(turnaround_time[i]);
        }

        // Printing average waiting and turnaround times
        average_wait_time /= i;
        average_turnaround_time /= i;
        System.out.print("\n\nAverage Waiting Time:");
        System.out.print(average_wait_time);
        System.out.print("\nAverage Turnaround Time:");
        System.out.print(average_turnaround_time);

    }
}