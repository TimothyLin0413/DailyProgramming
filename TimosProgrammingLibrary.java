
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
}
