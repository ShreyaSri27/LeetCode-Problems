class Solution {
        public boolean isBipartite(int[][] graph) {
                int len = graph.length;
                int visited[] = new int[len];
                Arrays.fill(visited, -1);
                boolean flag = false;
                for (int i = 0; i < len; ++i) {
                        if (visited[i] == -1) {
                                flag = logic(graph, i, visited);
                                if (!flag)
                                        return false;
                        }
                }

                return true;
        }

        class Pair {
                int src;
                int level;

                Pair() {}
                Pair(int src, int level) {
                        this.src = src;
                        this.level = level;
                }
        }

        public boolean logic(int graph[][], int src, int visited[]) {

                Queue < Pair > queue = new ArrayDeque < > ();

                queue.add(new Pair(src, 0));

                while (!queue.isEmpty()) {
                        Pair rem = queue.poll();

                        if (visited[rem.src] != -1) {
                                if (visited[rem.src] != rem.level)
                                        return false;
                        }

                        visited[rem.src] = rem.level;

                        for (int edge: graph[rem.src])
                                if (visited[edge] == -1)
                                        queue.add(new Pair(edge, rem.level + 1));
                }

                return true;
        }
}
