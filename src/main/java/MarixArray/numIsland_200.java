package MarixArray;

/**
 * Created by yuehu on 6/17/19.
 */


public class numIsland_200 {
    private int m;
    private int n;
    public int numIsland(char[][] grid) {
        int res = 0;
        n = grid.length;
        m = grid[0].length;
        if(n == 0) {
            return 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);

    }

}
