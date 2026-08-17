class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {

            if (color[i] != 0) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int neighbor : graph[node]) {

                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[node];
                        q.add(neighbor);
                    }
                    else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}