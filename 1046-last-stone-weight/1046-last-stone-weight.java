class Solution {
    public int lastStoneWeight(int[] stones) {

        // 1. Create Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // 2. Insert all stones
        for (int stone : stones) {
            pq.offer(stone);
        }

        // 3. Process stones
        while (pq.size() > 1) {

            int y = pq.poll(); // Largest
            int x = pq.poll(); // Second largest

            // 4. If weights are different
            if (x != y) {
                pq.offer(y - x);
            }
        }

        // 5. Return remaining stone
        return pq.isEmpty() ? 0 : pq.poll();
    }
}