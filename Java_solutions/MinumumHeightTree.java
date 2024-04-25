//this one really really sucked, higly because constructing the graph was shockingly difficult. Both because it was a little hard to conceptualize and hard to actually get to work, using that arrow is the 
//ONLY way I could find to get an arraylist to go in correctly, I don't understand why it complained so much about that. Once the graph was constructed you could apply a topological search to it, which was
//hard to visualize but more than worth doing. 

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0); // Only one node, return the root
        }

        int[] neigh = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            int inf = edges[i][0];
            int ins = edges[i][1];
            graph.computeIfAbsent(ins, k -> new ArrayList<>()).add(inf);
            graph.computeIfAbsent(inf, k -> new ArrayList<>()).add(ins);
            neigh[inf]++;
            neigh[ins]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (neigh[i] == 1) {
                queue.offer(i);
            }
        }
        
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                if (graph.containsKey(leaf)) {
                    for (int neighbor : graph.get(leaf)) {
                        neigh[neighbor]--;
                        if (neigh[neighbor] == 1) {
                            queue.offer(neighbor);
                        }
                    }
                    graph.remove(leaf); // Optional: Remove leaf node from the graph
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}
