import java.util.Scanner;

public class RoundRobin {
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int n;
        int time = 0;
        int quantum;

        System.out.println(ANSI_BOLD + "=============================================");
        System.out.println("              ROUND ROBIN SCHEDULING          ");
        System.out.println("=============================================" + ANSI_RESET);
        System.out.print(ANSI_BOLD + "Enter the total number of processes: " + ANSI_RESET);
        n = sc.nextInt();

        int[] arrival_time = new int[n];
        int[] burst_time = new int[n];
        int[] remaining_burst_time = new int[n];

        System.out.println("\n" + ANSI_BOLD + "Enter the arrival time and burst time for each process: " + ANSI_RESET);
        for (i = 0; i < n; i++) {
            System.out.print("\n" + ANSI_BOLD + "Process " + (i + 1) + ":" + ANSI_RESET);
            System.out.print("\n" + ANSI_BOLD + "Arrival time: " + ANSI_RESET);
            arrival_time[i] = sc.nextInt();
            System.out.print(ANSI_BOLD + "Burst time: " + ANSI_RESET);
            burst_time[i] = sc.nextInt();
            remaining_burst_time[i] = burst_time[i];
        }

        System.out.println("\n" + ANSI_BOLD + "=============================================");
        System.out.print("Enter the quantum value: " + ANSI_RESET);
        quantum = sc.nextInt();

        // Store the Gantt Chart information in a StringBuilder
        StringBuilder ganttChart = new StringBuilder();

        // Generating the Gantt Chart
        for (i = 0; i < n; i++) {
            ganttChart.append("P").append(i + 1).append("  |  ").append(arrival_time[i]);
            if (i != n - 1) {
                ganttChart.append("  |  ");
            }
        }

        // Print the Gantt Chart after all processes have been executed
        System.out.println("\n\n" + ANSI_BOLD + "=========================================");
        System.out.println("                   GANTT CHART               ");
        System.out.println("=============================================" + ANSI_RESET);

        System.out.println("");

        System.out.print(ganttChart.toString());

        System.out.println("");
        System.out.println("");

        // Close the Scanner object after using it
        sc.close();
    }
}
