package Day14_searchBackTrace;

public class Solution {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (DFS(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, String word, boolean[][] visited, int row, int column, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }
        if (visited[row][column] || board[row][column] != word.charAt(index)) {
            return false;
        }
        visited[row][column] = true;
        index++;
        boolean res = DFS(board, word, visited, row + 1, column, index) ||
                DFS(board, word, visited, row - 1, column, index) ||
                DFS(board, word, visited, row, column + 1, index) ||
                DFS(board, word, visited, row, column - 1, index);
        visited[row][column] = false;
        return res;
    }


    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return helper(m, n, visited, 0, 0, k);
    }

    private int helper(int m, int n, boolean[][] visited, int row, int column, int k) {
        if (row < 0 || row >= m || column < 0 || column >= n || visited[row][column]) {
            return 0;
        }
        if (compare(row, column, k)) {
            return 0;
        }
        visited[row][column] = true;
        return 1 + helper(m, n, visited, row + 1, column, k) +
                helper(m, n, visited, row - 1, column, k) +
                helper(m, n, visited, row, column + 1, k) +
                helper(m, n, visited, row, column - 1, k);
    }

    private boolean compare(int row, int column, int k) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (column > 0) {
            sum += column % 10;
            column = column / 10;
        }
        return sum > k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(solution.movingCount(2, 3, 1));
    }
}
