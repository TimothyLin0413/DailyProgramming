
class ProgrammingLibrary {
    // 12/20/23 This function removes the duplicate numbers in a non-decreasing array while keeping the positions. 
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // 12/21/23
    // Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // word is bigger than grid size 
        if (m*n < word.length())
            return false;
            
        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];
        // get the count of character 
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                ++boardf[board[i][j]];
            }
        }
        // if count of the letter is used more than the count in the grid return false
        for (char ch : wrd)
        {
            if (--boardf[ch] < 0)
            {
                return false;
            }
        }
        // go through the grid and see the letters are adjacent to each other and able to form the word
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (wrd[0] == board[i][j]
                    && found(board, i, j, wrd, new boolean[m][n], 0))
                    return true;
            }
        }
        return false;
    }

    private static final int[] dirs = {0, -1, 0, 1, 0};
    private boolean found(char[][] board, int row, int col, char[] word,
                        boolean[][] visited, int index)
    {
        // set the position of the found letter to true and recursive call the function until all letters are found or return false otherwise
        if (index == word.length)
            return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
            || board[row][col] != word[index] || visited[row][col])
            return false;
        visited[row][col] = true;
        for (int i = 0; i < 4; ++i)
        {
            if (found(board, row + dirs[i], col + dirs[i + 1],
                word, visited, index + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }

    // 12/22/23
    // remove all occurrences of val in nums and return length of modified array
    public int removeElement(int[] nums, int val) {
        // using two indexes, one is for modified index and one is looping
        int i = 0;
        for (int j = 0; j < nums.length; ++j){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 12/26/23
    // find first occurence of subtring
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }

    // find length of last word 
    public int lengthOfLastWord(String s) {
        String trimString = s.trim();
        int last_i = trimString.lastIndexOf(' ');
        String last_word = trimString.substring(last_i + 1);
        return last_word.length();
    }
}
