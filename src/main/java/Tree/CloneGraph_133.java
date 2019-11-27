package Tree;

import java.util.*;

/**
 * Created by yuehu on 8/11/19.
 * 这道题目录制的并不正确，更正为以下代码
 */
public class CloneGraph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return clone(node);
        // return cloneIterative(node);
    }


    // DFS
    private Node clone(Node node) {
        if(node == null) return null;
        if(map.get(node.val) != null) {
            return map.get(node.val);
        }
        Node cloned = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, cloned);
        for(Node n : node.neighbors) {
            Node dup = clone(n);
            cloned.neighbors.add(dup);
        }
        return cloned;
    }

    //BFS
    private Node cloneIterative(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        q.add(node);
        map.put(node.val, new Node(node.val, new ArrayList<Node>()));
        while(!q.isEmpty()) {
            Node cur = q.remove();
            for(Node n : cur.neighbors) {
                if(map.get(n.val) == null) {
                    map.put(n.val, new Node(n.val, new ArrayList<Node>()));
                    q.add(n);
                }
                map.get(cur.val).neighbors.add(map.get(n.val));
            }
        }

        return map.get(node.val);
    }
}
