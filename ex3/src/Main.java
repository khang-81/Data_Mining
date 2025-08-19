import java.util.Arrays;

public class Main {

    /**
     * Hàm chính để tìm khoảng vị trí của target.
     * Nó gọi hai hàm con để tìm vị trí đầu và cuối.
     */
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirstPosition(nums, target);
        int last = findLastPosition(nums, target);
        return new int[]{first, last};
    }


     // Hàm tìm kiếm nhị phân để tìm vị trí ĐẦU TIÊN của target.

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1; // Lưu vị trí đầu tiên tìm được

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPos = mid; // Tìm thấy một vý trí, lưu lại
                right = mid - 1; // và tiếp tục tìm ở bên trái xem có vị trí nào sớm hơn không
            } else if (nums[mid] < target) {
                left = mid + 1; // Target nằm ở bên phải
            } else {
                right = mid - 1; // Target nằm ở bên trái
            }
        }
        return firstPos;
    }


     // Hàm tìm kiếm nhị phân để tìm vị trí CUỐI CÙNG của target.

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPos = -1; // Lưu vị trí cuối cùng tìm được

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPos = mid; // Tìm thấy một vị trí, lưu lại
                left = mid + 1; // và tiếp tục tìm ở bên phải xem có vị trí nào muộn hơn không
            } else if (nums[mid] < target) {
                left = mid + 1; // Target nằm ở bên phải
            } else {
                right = mid - 1; // Target nằm ở bên trái
            }
        }
        return lastPos;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 8, 15};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(result)); // Output: [3, 4]

        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Output: [-1, -1]
    }
}