import java.util.Scanner;

public class ShortestJobFirst {
    public static void main(String[] args) {
        // Declaring the integer variables
        int n, temp, tt = 0, min = Integer.MAX_VALUE, d = 0, i, j;
        // Declaring the float variables
        float average_turnaround_time = 0f, average_wait_time = 0f, shortest_turnaround_time = 0f, shortest_wait_time = 0f;
    
        // Ask user for the number of processes
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();
    
        int[] a = new int[n];
        int[] b = new int[n];
        int[] e = new int[n];
        int[] turnaround_time = new int[n];
        int[] wait_time = new int[n];
    
        // For loop to prompt user to enter arrival time and burst time
        for (i = 0; i < n; i++) {
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            b[i] = sc.nextInt();
        }
    
        // Sort the processes in ascending order of burst time using selection sort
        for (i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the processes with minimum burst time
            temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;
            temp = a[minIndex];
            a[minIndex] = a[i];
        a[i] = temp;
    }

    // Calculate completion time for each process and turnaround time and wait time
    for (i = 0; i < n; i++) {
        if (a[i] > tt) {
            tt = a[i];
        }
        e[i] = tt + b[i];
        tt = e[i];
        turnaround_time[i] = e[i] - a[i];
        wait_time[i] = turnaround_time[i] - b[i];
        shortest_turnaround_time += turnaround_time[i];
        shortest_wait_time += wait_time[i];
    }

        // Calculate the average wait and turn around time
        average_turnaround_time = shortest_turnaround_time / n;
        average_wait_time = shortest_wait_time / n;
    
        // Build a string with the process table
        StringBuilder sb = new StringBuilder();
        sb.append("Process    Arrival-time      Burst-time        Wait-time     Turnaround-time\n");
        for (i = 0; i < n; i++) {
            sb.append(String.format("P%-10d%-18d%-18d%-15d%-15d\n", i+1, a[i], b[i], wait_time[i], turnaround_time[i]));
        }
        String processTable = sb.toString();
    
        // Print the process table and the average wait and turnaround time
        System.out.println(processTable);
        System.out.printf("Average Wait Time=%.2f Average Turnaround Time=%.2f\n", average_wait_time, average_turnaround_time);
    }
}
