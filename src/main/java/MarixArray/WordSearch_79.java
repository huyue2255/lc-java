package MarixArray;

/**
 * Created by yuehu on 8/3/19.
 */
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist1(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist1(char[][] board, int i, int j,String word, int start) {
        if(start >= word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] == word.charAt(start++)){
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exist1(board, i+1,j, word,start) ||
                    exist1(board, i-1,j, word,start) ||
                    exist1(board, i,j+1, word,start) ||
                    exist1(board, i,j-1, word,start);
            board[i][j] = c;
            return res;
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "ABf";
         char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
         WordSearch_79 s = new WordSearch_79();
        System.out.println(s.exist(board,word));

    }
}
