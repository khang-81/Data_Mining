public class Main {
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;   // lưu lại vị trí
                right = mid - 1; // tiếp tục tìm bên trái
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;   // lưu lại vị trí
                left = mid + 1; // tiếp tục tìm bên phải
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Test
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 8, 15};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
