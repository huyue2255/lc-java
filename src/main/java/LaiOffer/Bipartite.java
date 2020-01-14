package LaiOffer;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.*;


/**
 * Created by yuehu on 1/26/20.
 */
public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        //use 0 and 1 to denote two different groups.
        //the map maintains for each node which group it belongs to.
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        //the graph can be represented by a list of nodes
        // (if it is not guaranteed to be connected)
        //you have to do BFS from each of the nodes
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
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        //start breadth-first-search from node, since the node has not been
        //visited, we can assign it to any of the groups, for example, group0.
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            //the group assigned for cur node
            int curGroup = visited.get(cur);
            //the group assigned for any neighbor of cur node.
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode nei : cur.neighbors) {
                //if the neighbor has not been visited, just put it in the queue
                //and chose the correct group
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    return false;
                }
                //if the neighbor has been traversed and the group matches the
                //desired one, we do not need to do anything
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphNode root1 = new GraphNode(1);
        GraphNode root2 = new GraphNode(2);
        GraphNode root3 = new GraphNode(3);

        List<GraphNode> list1 = new ArrayList<>();
        list1.add(root2);
        list1.add(root3);
        List<GraphNode> list2 = new ArrayList<>();
        list2.add(root1);
        list2.add(root2);
        List<GraphNode> list3 = new ArrayList<>();
        list3.add(root1);
        list3.add(root2);
        root1.neighbors = list1;
        root2.neighbors = list2;
        root3.neighbors = list3;

        Bipartite b = new Bipartite();
        List<GraphNode> graph = new ArrayList<>();
        graph.add(root1);
        graph.add(root2);
        graph.add(root3);
        b.isBipartite(graph);
        System.out.println(b.isBipartite(graph));

    }
}
