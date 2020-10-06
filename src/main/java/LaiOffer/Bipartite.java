package LaiOffer;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.*;


/**
 * Created by yuehu on 1/26/20.
 * Assumption: The given graph is not null
 */
public class Bipartite {

    // DFS

    //DFS
    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {

                // 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w : graph[v]) {
                        // 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
                        if (visited[w] == visited[v]) {
                            return false;
                        }
                        if (visited[w] == 0) {
                            visited[w] = -visited[v];
                            queue.offer(w);
                        }
                    }
                }
            }
        }
        return true;
    }
    // laioffer
    public boolean isBipartite(List<GraphNode> graph) {
        // use 0 and 1 to denote two different groups.
        // the map maintains for each node which group it belongs to.
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        // the graph can be represented by a lit of nodes (if it is not guaranteed
        // to be connected). we have to do BFS from each of the nodes
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);
        // start breadth-first-search from the node, since the node has not been
        // visited, we can assign it to any of the groups, for example, group 0.
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            // the group assigned for cur node.
            int curGroup = visited.get(cur);
            // the group assigned for any neighbor of cur node
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode nei : cur.neighbors) {
            // if the neighbor has not been visited, just put it in the queue
            // and choose the correct group
            if (!visited.containsKey(nei)) {
                visited.put(nei, neiGroup);
                queue.offer(nei);
            } else if (visited.get(nei) != neiGroup) {
             //only if the neighbor has been traversed and the group does not
             // match to desired one, return false.
                return false;
            }
            // if the neighbor has been traversed and the group matched the
            // desired one, we do not need to do anything
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphNode r1 = new GraphNode(1);
        GraphNode r2 = new GraphNode(2);
        GraphNode r3 = new GraphNode(3);
        GraphNode r4 = new GraphNode(4);
        List<GraphNode> l1 = new ArrayList<>();
        List<GraphNode> l2 = new ArrayList<>();
        List<GraphNode> l3 = new ArrayList<>();
        List<GraphNode> l4 = new ArrayList<>();

        l1.add(r2);
        l1.add(r4);

        l2.add(r1);
        l2.add(r3);

        l3.add(r2);
        l3.add(r4);

        l4.add(r1);
        l4.add(r3);

        r1.neighbors = l1;
        r2.neighbors = l2;
        r3.neighbors = l3;
        r4.neighbors = l4;

        List<GraphNode> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);

        Bipartite b = new Bipartite();
        System.out.println((b.isBipartite(list)));
    }

}
