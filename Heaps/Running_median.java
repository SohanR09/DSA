public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        ArrayList<Integer> result = new ArrayList<>();

        // add to max heap
        maxHeap.add(A.get(0));
        result.add(maxHeap.peek());

        for (int i = 1; i < A.size(); i++) {
            int cur = A.get(i);
            if (cur < maxHeap.peek()) {
                maxHeap.add(cur);
            } else {
                minHeap.add(cur);
            }

            int diff = maxHeap.size() - minHeap.size();

            if (diff == 0) {
                result.add(maxHeap.peek());
            } else if (diff == 1) {
                result.add(maxHeap.peek());
            } else if (diff == 2) {
                minHeap.add(maxHeap.poll());
                result.add(maxHeap.peek());
            } else if(diff == -1) {
                maxHeap.add(minHeap.poll());
                result.add(maxHeap.peek());
            }
        }

        return result;
    }
}
