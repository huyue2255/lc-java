package GoldTile;

import java.util.*;

/**
 * Created by yuehu on 7/14/19.
 */
public class GoldTile {
    // dfs
    public List<Character> findPath(Tile start) {
        Set<Tile> visited = new HashSet<>();
        List<Character> dir = new ArrayList<>();
        dfs(start, visited, dir);
        return dir;
    }

    public boolean dfs(Tile cur, Set<Tile> visited, List<Character> directions) {
        if (cur == null) {
            return false;
        }

        if (cur.isGold) {
            return true;
        }

        if (visited.contains(cur)) {
            return false;
        }

        visited.add(cur);

        directions.add('n');
        if (this.dfs(cur.n, visited, directions)) {
            return true;
        } else {
            directions.remove(directions.size() - 1);
        }

        directions.add('e');
        if (this.dfs(cur.e, visited, directions)) {
            return true;
        } else {
            directions.remove(directions.size() - 1);
        }

        directions.add('w');
        if (this.dfs(cur.w, visited, directions)) {
            return true;
        } else {
            directions.remove(directions.size() - 1);
        }

        directions.add('s');
        if (this.dfs(cur.s, visited, directions)) {
            return true;
        } else {
            directions.remove(directions.size() - 1);
        }

        return false;
    }

    // bfs shorest
    public List<Character> findShortestPath(Tile start) {
        Queue<Tile> tileQ = new LinkedList<>();
        Queue<List<Character>> pathQ = new LinkedList<>();

        tileQ.offer(start);
        pathQ.offer(new LinkedList<>());
        Set<Tile> visited = new HashSet<>();

        while (!tileQ.isEmpty()) {
            Tile cur = tileQ.poll();
            List<Character> dir = pathQ.poll();
            if (cur.isGold) {
                return dir;
            }
            visit(tileQ, pathQ, cur, dir, 'e', visited);
            visit(tileQ, pathQ, cur, dir, 's', visited);
            visit(tileQ, pathQ, cur, dir, 'n', visited);
            visit(tileQ, pathQ, cur, dir, 'w', visited);
        }

        // gold not found
        return new LinkedList<>(Arrays.asList('x'));
    }

    private void visit(Queue<Tile> tileQ, Queue<List<Character>> pathQ, Tile cur, List<Character> dirs, Character dir, Set<Tile> visited) {
        Tile nextTile = null;
        switch (dir) {
            case 'e':
                nextTile = cur.e;
                break;
            case 's':
                nextTile = cur.s;
                break;
            case 'w':
                nextTile = cur.w;
                break;
            case 'n':
                nextTile = cur.w;
                break;
        }
        if (nextTile == null || visited.contains(nextTile)) {
            return;
        }
        visited.add(nextTile);
        tileQ.offer(nextTile);
        List<Character> newDir = new LinkedList<>(dirs);
        newDir.add(dir);
        pathQ.offer(newDir);
    }
}
