import java.util.Scanner;

public class RoundRobin {

    public static void main(String[] args) {
        // Initializing variables for the program to perform its tasks
        Scanner sc = new Scanner(System.in);
        int i;
        int n;
        int time = 0;
        int remain;
        int temps = 0;
        int quantum;

        // Initialize wait and turnaround time to 0 as the initial starting point
        int wait_time = 0;
        int turnaround_time = 0;

        // Ask user for the total number of processes to calculate its times
        System.out.println("=============================================");
        System.out.println("              ROUND ROBIN SCHEDULING          ");
        System.out.println("=============================================");
        System.out.print("Enter the total number of processes: ");
        n = sc.nextInt();
        remain = n;

        // Arrival, burst and return time
        int[] arrival_time = new int[n];
        int[] burst_time = new int[n];
        int[] remaining_burst_time = new int[n];
        int[] completion_time = new int[n];
        int[] turnaround_time_list = new int[n];
        int[] waiting_time_list = new int[n];

        // User is prompted to enter the arrival and burst time for the # processes desired
        System.out.println("\nEnter the arrival time and burst time for each process: ");
        for (i = 0; i < n; i++) {
            System.out.print("\nProcess " + (i + 1) + ":\n");
            System.out.print("Arrival time: ");
            arrival_time[i] = sc.nextInt();
            System.out.print("Burst time: ");
            burst_time[i] = sc.nextInt();
            remaining_burst_time[i] = burst_time[i];
        }

        // Enter the quantum value for the scheduling task
        System.out.println("\n=============================================");
        System.out.print("Enter the quantum value: ");
        quantum = sc.nextInt();

        System.out.println("\n\n=========================================");
        System.out.println("                   GANTT CHART               ");
        System.out.println("=============================================");

        System.out.print("0");
        for (time = 0, i = 0; remain != 0;) {
            if (remaining_burst_time[i] <= quantum && remaining_burst_time[i] > 0) {
                time += remaining_burst_time[i];
                System.out.print("  |  P" + (i+1) + "  |  " + time);
                remaining_burst_time[i] = 0;
                temps = 1;
            } else if (remaining_burst_time[i] > 0) {
                remaining_burst_time[i] -= quantum;
                time += quantum;
                System.out.print("  |  P" + (i+1) + "  |  " + time);
            }

            if (remaining_burst_time[i] == 0 && temps == 1) {
                remain--;
                completion_time[i] = time;
                turnaround_time_list[i] = completion_time[i] - arrival_time[i];
                waiting_time_list[i] = turnaround_time_list[i] - burst_time[i];
                // Displaying the result of waiting, turn around time:
                System.out.printf("\n\nP[%d]\t:\tTurnaround Time = %d\tWaiting Time = %d",
                    i + 1, turnaround_time_list[i], waiting_time_list[i]);
                wait_time += waiting_time_list[i];
                turnaround_time += turnaround_time_list[i];
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
    }
}
