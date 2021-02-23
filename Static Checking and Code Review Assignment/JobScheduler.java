import java.util.Scanner;
// jobScheduler java class
public class JobScheduler {
	// method to find completion time of processes
    static int[] completion_time(int[][] arr, int total_process, int[] completionTime) {
        for (int i = 0; i < total_process; i++) {
            if (i == 0) {
                completionTime[i] = arr[i][0] + arr[i][1];
            } else {
                if (arr[i][0] > completionTime[i - 1]) {
                    completionTime[i] = arr[i][0] + arr[i][1];
                } else
                    completionTime[i] = completionTime[i - 1] + arr[i][1];
            }
        }
        return completionTime;
    }
    // method to find turn around time of processes
    static int[] turn_arround_time(int[][] arr_of_process, int total_process, int[] completionTime,
            int[] turnArroundTime) {
        for (int i = 0; i < total_process; i++) {
            turnArroundTime[i] = completionTime[i] - arr_of_process[i][0];
        }
        return turnArroundTime;
    }
    // method to find waiting time of processes
    static int[] waiting_time(int[][] arr_of_process, int total_process, int[] waitingTime, int[] turnArroundTime) {
        for (int i = 0; i < total_process; i++) {
            waitingTime[i] = turnArroundTime[i] - arr_of_process[i][1];
        }
        return waitingTime;
    }
    // method to find average waiting time of all processes
    static float average_waiting_time(int[] waitingTime, int total_process, float averageWaitingTime) {
        for (int i = 0; i < total_process; i++) {
            averageWaitingTime += waitingTime[i];
        }
        averageWaitingTime /= total_process;
        return averageWaitingTime;
    }
    // method to find maximum waiting time any process take in queue
    static int maximum_waiting_time_period(int[] waitingTime, int total_process, int maximumWaitingTimePeriod) {
        for (int i = 0; i < total_process; i++) {
            maximumWaitingTimePeriod += waitingTime[i];
        }
        return maximumWaitingTimePeriod;
    }
    // main method
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total no of processes - ");
        int total_process = scan.nextInt();
        int[][] arr_of_process = new int[total_process][2];
        int completionTime[] = new int[total_process];
        int turnArroundTime[] = new int[total_process];
        int waitingTime[] = new int[total_process];
        float averageWaitingTime = 0;
        int maximumWaitingTimePeriod = 0;
        for (int i = 0; i < total_process; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1));
            for (int j = 0; j < 2; j++) {
                arr_of_process[i][j] = scan.nextInt();
            }
        }
        completion_time(arr_of_process, total_process, completionTime);
        System.out.println("Completion time for processes = ");
        for (int i : completionTime) {
            System.out.printf(i + " ");
        }
        System.out.println();
        turn_arround_time(arr_of_process, total_process, completionTime, turnArroundTime);
        System.out.println("Turn Arround time for processes = ");
        for (int i : turnArroundTime) {
            System.out.printf(i + " ");
        }
        System.out.println();
        waiting_time(arr_of_process, total_process, waitingTime, turnArroundTime);
        System.out.println("Waiting time for processes = ");
        for (int i : waitingTime) {
            System.out.printf(i + " ");
        }
        System.out.println();
        averageWaitingTime = average_waiting_time(waitingTime, total_process, averageWaitingTime);
        System.out.println("Average Waiting time is = " + averageWaitingTime);
        maximumWaitingTimePeriod = maximum_waiting_time_period(waitingTime, total_process, maximumWaitingTimePeriod);
        System.out.println("Maximum Waiting time period for process in queue is = " + maximumWaitingTimePeriod);
        scan.close();
    }
}
