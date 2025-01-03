import java.util.*;

public class p75 {
    public int scheduleCourse(int[][] courses) {
        // Sort courses by lastDay
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        // Min-heap to store the durations of the selected courses
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int currentTime = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            // If we can take the course within its last day
            if (currentTime + duration <= lastDay) {
                // Take this course and add its duration to currentTime
                minHeap.offer(duration);
                currentTime += duration;
            } else if (!minHeap.isEmpty() && minHeap.peek() > duration) {
                // If we already took a course and it has a longer duration than the current course
                // Remove the longest duration course and take the current one
                currentTime -= minHeap.poll(); // Remove the longest duration
                minHeap.offer(duration);       // Add the current course
                currentTime += duration;       // Update the current time
            }
        }

        // The size of the heap is the number of courses we can take
        return minHeap.size();
    }

    public static void main(String[] args) {
        p75 solution = new p75();
        int[][] courses = {
            {100, 200}, 
            {200, 1300}, 
            {1000, 1250}, 
            {2000, 3200}
        };

        int result = solution.scheduleCourse(courses);
        System.out.println("Maximum number of courses: " + result);  // Output: 3
    }
}
