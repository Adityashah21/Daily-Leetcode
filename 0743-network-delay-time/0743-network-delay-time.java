class Solution {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] time : times) {

            int u = time[0];
            int v = time[1];
            int weight = time[2];

            adj.get(u).add(new Pair(v, weight));
        }

        // Distance array
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Min Heap
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(k, 0));

        // Dijkstra
        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int currentDistance = current.weight;

            for (Pair neighbor : adj.get(node)) {

                int nextNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (currentDistance + edgeWeight < dist[nextNode]) {

                    dist[nextNode] =
                        currentDistance + edgeWeight;

                    pq.add(new Pair(
                        nextNode,
                        dist[nextNode]
                    ));
                }
            }
        }

        // Find maximum distance
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}