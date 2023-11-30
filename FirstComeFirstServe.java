import java.util.Scanner;

public class FirstComeFirstServe {
    // ANSI color codes for matrix-like output and bold text
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";

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
        System.out.print(ANSI_BOLD + "Enter total number of processes: " + ANSI_RESET);
        n = sc.nextInt();

        System.out.print("\n" + ANSI_BOLD + "Enter Process Burst Time: \n" + ANSI_RESET);
        for (i = 0; i < n; i++) {
            System.out.print(ANSI_BOLD + "P[" + (i + 1) + "]: " + ANSI_RESET);
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

        System.out.println("\n" + ANSI_BOLD + ANSI_GREEN + "Process\t\tBurst Time\tWaiting Time\tTurnaround Time" + ANSI_RESET);

        // Calculating turnaround time
        for (i = 0; i < n; i++) {
            turnaround_time[i] = burst_time[i] + wait_time[i];
            average_wait_time += wait_time[i];
            average_turnaround_time += turnaround_time[i];
            System.out.println(ANSI_GREEN + "P[" + (i + 1) + "]\t\t" + burst_time[i] + "\t\t" + wait_time[i] + "\t\t" + turnaround_time[i] + ANSI_RESET);
        }

        // Printing average waiting and turnaround times
        average_wait_time /= i;
        average_turnaround_time /= i;
        System.out.println("\n" + ANSI_BOLD + ANSI_GREEN + "Average Waiting Time:\t" + average_wait_time + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_GREEN + "Average Turnaround Time:\t" + average_turnaround_time + ANSI_RESET);
    }
}
