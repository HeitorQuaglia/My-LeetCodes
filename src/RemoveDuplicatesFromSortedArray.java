public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2}; // Input array
        int[] expectedNums = {1, 2, 0};

        int k = removeDuplicates(nums); // Calls your implementation

        //System.out.println(k == expectedNums.length);
        for (int i = 0; i < k; i++) {
            System.out.println( nums[i] == expectedNums[i] );
        }
    }

    public static int removeDuplicates(int[] nums) {
        var latest = nums[nums.length - 1];
        var index = 1;
        for (int i = 1; nums[index - 1] != latest; i++) {
            if (nums[i-1] >= nums[i]) continue;
            nums[index++] = nums[i];
        }

        return index;
    }
}
