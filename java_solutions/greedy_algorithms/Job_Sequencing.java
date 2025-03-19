package java_solutions.greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Input: jobs[] = [(1,4,20), (2,1,1), (3,1,40), (4,1,30)]
    Output: [2, 60]
                            job_id   deadLine   profit
                               1        4         20
                               2        1          1
                               3        1         40
                               4        1         30

    step-1 -> sort based on profit -> descending order
    step-2 -> perform maximum profit

    step-1 ->               job_id   deadLine   profit
                               3        1         40
                               4        1         30
                               1        4         20
                               2        1          1

    step-2 -> cnt = 0, totalProfit = 0
           -> find maximum deadLine and create visited array size of (maxDeadLine)

           -> find the number of jobs perform to gain maximum profit
           -> vis[0] -> 3 -> 40
           -> vis[3] -> 1 -> 20

           -> cnt = 2, maxProfit = 60
 */
public class Job_Sequencing {

    public static int[] fn(Job[] jobs) {

        Arrays.sort(jobs, (a, b) -> (b.profit - a.profit));

        int maxDeadLine = 0;

        for (Job job : jobs) {
            maxDeadLine = Math.max(maxDeadLine, job.deadLine);
        }

        int cnt = 0, maxProfit = 0;
        int[] vis = new int[jobs.length];
        Arrays.fill(vis, -1);

        for (Job job : jobs) {
            for (int i = job.deadLine-1; i>=0; i--) {
                if (vis[i] == -1) {
                    vis[i] = job.id;
                    cnt++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }

        return new int[] {cnt, maxProfit};
    }

    public static void main(String[] args) {

        Job[] jobs = new Job[4];

        jobs[0] = new Job(1, 4, 40);
        jobs[1] = new Job(2, 1, 10);
        jobs[2] = new Job(3, 1, 40);
        jobs[3] = new Job(4, 1, 30);

        int[] ans = fn(jobs);
        System.out.println(Arrays.toString(ans));
    }
}

class Job {
    int id;
    int deadLine;
    int profit;
    public Job(int id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }
}

