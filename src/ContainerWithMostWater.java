public class ContainerWithMostWater {
    public static void main(String[] args) {
        var height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        var result = maxArea(height);
        System.out.println(result == 49);

        height = new int[]{1, 1};
        result = maxArea(height);
        System.out.println(result == 1);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int longest = 0;

        while(left != right) {
            var result = minValue(height, left, right);
            longest = Math.max(longest, result[0] * (right - left));
            if (result[1] == -1) {
                left++;
            } else {
                right--;
            }
        }

        return longest;
    }

    public static int[] minValue(int[] array, int left, int right) {
        if (array[left] < array[right])
            return new int[]{array[left], -1};
        else
            return new int[]{array[right], 1};
    }
}
