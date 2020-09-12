package LaiOffer;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.*;

/**
 * Created by yuehu on 9/9/20.
 * Deep copy with possible cycles
 * leetcode: 133
 */
public class DeepCopyGraph {
    Map<Integer, GraphNode> map = new HashMap<>();
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;
        return clone(node);
    }
    // DFS
    private GraphNode clone(GraphNode node) {
        if (node == null) return null;
        if (map.get(node.label) != null) {
            return map.get(node.label);
        }
        GraphNode cloned = new GraphNode(node.label, new ArrayList<GraphNode>());
        map.put(node.label, cloned);
        for (GraphNode n : node.neighbors) {
            GraphNode dup = clone(n);
            cloned.neighbors.add(dup);
        }
        return cloned;
    }

    // BFS
    private GraphNode cloneIterative(GraphNode node) {
        if (node == null) return null;
        Queue<GraphNode> q = new LinkedList<>();
        Map<Integer, GraphNode> map = new HashMap<>();
        q.add(node);
        map.put(node.label, new GraphNode(node.label, new ArrayList<GraphNode>()));
        while (!q.isEmpty()) {
            GraphNode cur = q.remove();
            for (GraphNode n : cur.neighbors) {
                if (map.get(n.label) == null) {
                    map.put(n.label, new GraphNode(n.label, new ArrayList<>()));
                    q.add(n);
                }
                map.get(cur.label).neighbors.add(map.get(n.label));
            }
        }
        return map.get(node.label);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer i : list) {
            System.out.println('i' + i);
        }
    }
}
