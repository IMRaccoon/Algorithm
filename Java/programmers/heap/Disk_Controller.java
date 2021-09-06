package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Disk_Controller {
    public static void main(String[] args) {
        Disk_Controller dc = new Disk_Controller();
        System.out.println(dc.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Work> timeSorted = new PriorityQueue<>(Comparator.comparingInt(w -> w.start));
        PriorityQueue<Work> durationSorted = new PriorityQueue<>(Comparator.comparingInt(w -> w.duration));

        for(int [] job : jobs) {
            timeSorted.offer(new Work(job[0], job[1]));
        }

        int start = timeSorted.peek().start;
        int acc = 0;
        Work tmp;
        while(!timeSorted.isEmpty() || !durationSorted.isEmpty()) {
            while(!timeSorted.isEmpty() && (timeSorted.peek().start <= start)) {
                durationSorted.offer(timeSorted.poll());
            }
            if(durationSorted.isEmpty()) {
                tmp = timeSorted.poll();
                tmp.start = start;
                durationSorted.offer(tmp);
            }
            tmp = durationSorted.poll();
            acc += (start - tmp.start + tmp.duration);
            start += tmp.duration;
        }

        return Math.floorDiv(acc, jobs.length);
    }

    private class Work {
        int start;
        int duration;

        Work(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
}
