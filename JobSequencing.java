
import java.util.Arrays;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void printJobSequence(Job[] jobs) {
        // Sort jobs based on their profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;
        int maxDeadline = getMaxDeadline(jobs);

        // Array to store the result sequence
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        // Initialize all slots to be free
        Arrays.fill(slot, false);

        // Traverse through all the jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for the current job starting from the last possible slot
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }

        // Print the result sequence
        for (char job : result) {
            System.out.print(job + " ");
        }
    }

    private static int getMaxDeadline(Job[] jobs) {
        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        return maxDeadline;
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };

        System.out.println("Job sequence:");
        printJobSequence(jobs);
    }
}
