package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuehu on 7/2/19.
 */
public class DFS {

    public static void dfs(List<GraphNode> list) {
        HashSet<GraphNode> visited = new HashSet<>();
        for (GraphNode node: list) {
            if(!visited.contains(node)) {
                helper(node,visited);
            }
        }
    }

    public static void dfs2(GraphNode node) {
        helper(node, new HashSet<>());
    }

    public static void helper(GraphNode node, HashSet<GraphNode> visited) {
        visited.add(node);
        System.out.println(node.label);
        for(GraphNode neighbor: node.neighbors){
            if(!visited.contains(node)) {
                helper(neighbor,visited);
            }
        }
    }

    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            if(visited[i] == 0){
                helper2(matrix, visited, i);
            }
        }
    }

    public static void helper2(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        System.out.println(vertex);
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[vertex][i] == 1){
                if(visited[i] == 0) {
                    helper2(matrix, visited, i);
                }
            }

        }
    }

    public static void dfsIteration(GraphNode graphnode) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(graphnode);
        visited.add(graphnode);
        while(!stack.isEmpty()) {
            GraphNode node = stack.pop();
            System.out.println(node.label);
            for(GraphNode neighbor: node.neighbors) {
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
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

        int[][] matrix = new int[][] {
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0}
        };

//         dfsMatrix(matrix);
        dfsIteration(a);
    }
}
