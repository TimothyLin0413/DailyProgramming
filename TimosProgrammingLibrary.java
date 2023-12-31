
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

    // given an integer array, add one and return the new array
    public int[] plusOne(int[] digits) {
    // if cuurent last digit is not 9 simply, increment by 1 and return the array, if it is 9, set it to 0 and go to next digit and treat it as last digit until it return or if every digit is 9. 
    for (int i = digits.length - 1; i >= 0; i--) {
	    if (digits[i] < 9) {
		    digits[i]++;
		    return digits;
	    }
	    digits[i] = 0;
    }       

    // if every digit is 9, create an array with +1 sizze and put 1 in the first digit or index 0
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
    }

    // 12/27/23
    // merge intervals
    public int[][] merge(int[][] intervals) {
	// sort based on starting of each interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();

	// loop thorugh all intervals, if the start of interval is greater than the end interval of answer arrray,
	// simply append that interval in the answer array else, take the maximum of end points from the interval and answer array and set it as the end point
        for (int[] interval : intervals) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }

    // 12/28/23
    // Given two binary, perform addition
    public String addBinary(String a, String b) {
         StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() -1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry 
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }
}
