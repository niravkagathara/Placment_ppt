// Write a program to implement job sequencing algorithm using greedy approach
import java.util.Arrays;
import java.util.Comparator;

// Job class to represent each job with deadline and profit
class Job {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class p60 {
    
    // Function to find the maximum profit job sequence
    public static void jobSequence(Job[] jobs, int n) {
        // Sort jobs according to decreasing order of profit
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit; // descending order of profit
            }
        });

        // To keep track of free time slots
        boolean[] slot = new boolean[n];
        int[] result = new int[n]; // To store result (job id sequence)
        Arrays.fill(slot, false);

        // To count total jobs that can be scheduled
        int countJobs = 0;
        int totalProfit = 0;

        // Iterate over all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for the current job
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = jobs[i].id;
                    countJobs++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        // Print the result (Job sequence and maximum profit)
        System.out.println("Job Sequence:");
        for (int i = 0; i < n; i++) {
            if (result[i] != 0) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        // Example input: (Job id, Deadline, Profit)
        Job[] jobs = new Job[]{
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30),
            new Job(5, 2, 50)
        };

        int n = jobs.length;
        jobSequence(jobs, n); // Function call to perform job sequencing
    }
}
