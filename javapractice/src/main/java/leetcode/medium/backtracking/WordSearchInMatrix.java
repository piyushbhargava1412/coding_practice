package main.java.leetcode.medium.backtracking;

// https://leetcode.com/problems/word-search/description/?envType=daily-question&envId=2024-04-03
public class WordSearchInMatrix {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[0].length; x++) {
                if(board[y][x] == word.charAt(0) && backtrack(board, word, 0, x, y)) return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int index, int x, int y) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length || board[y][x] != word.charAt(index))
            return false;

        if (index == word.length() - 1) return true;

        char temp = board[y][x];
        board[y][x] = '-';
        boolean found = backtrack(board, word, index + 1, x + 1, y) ||
                backtrack(board, word, index + 1, x - 1, y) ||
                backtrack(board, word, index + 1, x, y + 1) ||
                backtrack(board, word, index + 1, x, y - 1);
        board[y][x] = temp;
        return found;
    }
}
