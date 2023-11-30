import java.util.Scanner;

public class ShortestJobFirst {
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        int n, temp, tt = 0, i, j;

        Scanner sc = new Scanner(System.in);
        System.out.print(ANSI_BOLD + "Enter number of processes: " + ANSI_RESET);
        n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] e = new int[n];
        int[] turnaround_time = new int[n];
        int[] wait_time = new int[n];

        System.out.println("\n" + ANSI_BOLD + "Enter arrival time and burst time for each process:" + ANSI_RESET);
        for (i = 0; i < n; i++) {
            System.out.print("Arrival time for process " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            System.out.print("Burst time for process " + (i + 1) + ": ");
            b[i] = sc.nextInt();
        }

        for (i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }
            }
            temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;
            temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }

        for (i = 0; i < n; i++) {
            if (a[i] > tt) {
                tt = a[i];
            }
            e[i] = tt + b[i];
            tt = e[i];
            turnaround_time[i] = e[i] - a[i];
            wait_time[i] = turnaround_time[i] - b[i];
        }

        float average_turnaround_time = calculateAverage(turnaround_time);
        float average_wait_time = calculateAverage(wait_time);

        StringBuilder ganttChart = new StringBuilder();
        // ganttChart.append("0");
        for (i = 0; i < n; i++) {
            // .append("  |  P").
            ganttChart.append("  |  P").append(i + 1).append("  |  ").append(e[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Process    Arrival-time      Burst-time        Wait-time     Turnaround-time\n");
        for (i = 0; i < n; i++) {
            sb.append(String.format("P%-10d%-18d%-18d%-15d%-15d\n", i + 1, a[i], b[i], wait_time[i], turnaround_time[i]));
        }
        String processTable = sb.toString();

        System.out.println("\n" + processTable);
        System.out.printf("Average Wait Time=%.2f Average Turnaround Time=%.2f\n", average_wait_time, average_turnaround_time);

        System.out.println("\n" + ANSI_BOLD + "=========================================");
        System.out.println("                GANTT CHART               ");
        System.out.println("=========================================" + ANSI_RESET);
        System.out.println(ANSI_GREEN + ganttChart.toString() + ANSI_RESET);

        sc.close(); // Close the scanner
    }

    // Calculate average of an array of integers
    private static float calculateAverage(int[] array) {
        float sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum / array.length;
    }
}
