package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuehu on 7/17/19.
 */
public class BFS {
    public static void bfs(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while(!queue.isEmpty()) {
            GraphNode node = queue.poll();
            System.out.println(node.label);
            for (GraphNode neighbor: node.neighbors) {
                if(!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void bfs2(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = queue.poll();
                System.out.println(node.label);
                for (GraphNode neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println(" ");
        }
    }


    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b);//1
        a.neighbors.add(d);//3
        a.neighbors.add(f);//5

        b.neighbors.add(a);//0
        b.neighbors.add(e);//4
        b.neighbors.add(c);//2

        c.neighbors.add(b);//1
        c.neighbors.add(e);//4

        d.neighbors.add(a);//0
        d.neighbors.add(e);//4

        e.neighbors.add(d);//3
        e.neighbors.add(b);//1
        e.neighbors.add(c);//2

        f.neighbors.add(a);//0

        BFS g = new BFS();
        g.bfs2(a);
    }
}
