import java.util.Scanner;
// jobScheduler java class
public class JobScheduler {
	// method to find completion time of processes
    static int[] completionTime(int[][] arr, int totalProcess, int[] completionTime) {
        for (int i = 0; i < totalProcess; i++) {
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
    static int[] turnArroundTime(int[][] arrOfProcess, int totalProcess, int[] completionTime,
            int[] turnArroundTime) {
        for (int i = 0; i < totalProcess; i++) {
            turnArroundTime[i] = completionTime[i] - arrOfProcess[i][0];
        }
        return turnArroundTime;
    }
    // method to find waiting time of processes
    static int[] waitingTime(int[][] arrOfProcess, int totalProcess, int[] waitingTime, int[] turnArroundTime) {
        for (int i = 0; i < totalProcess; i++) {
            waitingTime[i] = turnArroundTime[i] - arrOfProcess[i][1];
        }
        return waitingTime;
    }
    // method to find average waiting time of all processes
    static float averageWaitingTime(int[] waitingTime, int totalProcess, float averageWaitingTime) {
        for (int i = 0; i < totalProcess; i++) {
            averageWaitingTime += waitingTime[i];
        }
        averageWaitingTime /= totalProcess;
        return averageWaitingTime;
    }
    // method to find maximum waiting time any process take in queue
    static int maximumWaitingTimePeriod(int[] waitingTime, int totalProcess, int maximumWaitingTimePeriod) {
        for (int i = 0; i < totalProcess; i++) {
            maximumWaitingTimePeriod += waitingTime[i];
        }
        return maximumWaitingTimePeriod;
    }
    // main method
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total no of processes - ");
        int totalProcess = scan.nextInt();
        int[][] arrOfProcess = new int[totalProcess][2];
        int completionTime[] = new int[totalProcess];
        int turnArroundTime[] = new int[totalProcess];
        int waitingTime[] = new int[totalProcess];
        float averageWaitingTime = 0;
        int maximumWaitingTimePeriod = 0;
        for (int i = 0; i < totalProcess; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1));
            for (int j = 0; j < 2; j++) {
                arrOfProcess[i][j] = scan.nextInt();
            }
        }
        completionTime(arrOfProcess, totalProcess, completionTime);
        System.out.println("Completion time for processes = ");
        for (int i : completionTime) {
            System.out.printf(i + " ");
        }
        System.out.println();
        turnArroundTime(arrOfProcess, totalProcess, completionTime, turnArroundTime);
        System.out.println("Turn Arround time for processes = ");
        for (int i : turnArroundTime) {
            System.out.printf(i + " ");
        }
        System.out.println();
        waitingTime(arrOfProcess, totalProcess, waitingTime, turnArroundTime);
        System.out.println("Waiting time for processes = ");
        for (int i : waitingTime) {
            System.out.printf(i + " ");
        }
        System.out.println();
        averageWaitingTime = averageWaitingTime(waitingTime, totalProcess, averageWaitingTime);
        System.out.println("Average Waiting time is = " + averageWaitingTime);
        maximumWaitingTimePeriod = maximumWaitingTimePeriod(waitingTime, totalProcess, maximumWaitingTimePeriod);
        System.out.println("Maximum Waiting time period for process in queue is = " + maximumWaitingTimePeriod);
        scan.close();
    }
}
