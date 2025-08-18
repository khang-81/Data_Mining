import java.util.*;

public class Main {

    // Hàm tìm kiếm nhị phân: trả về true nếu tìm thấy x trong arr
    static boolean contains(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                return true; // tìm thấy
            } else if (arr[mid] < x) {
                left = mid + 1; // dịch sang bên phải
            } else {
                right = mid - 1; // dịch sang bên trái
            }
        }
        return false; // không tìm thấy
    }

    // Hàm tìm giao 2 mảng đã sắp xếp
    static List<Integer> findIntersection(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();

        for (int value : A) {                  // duyệt từng phần tử trong A
            if (contains(B, value)) {          // nếu có trong B (dùng binary search)
                result.add(value);             // thêm vào kết quả
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 5, 9};
        int[] B = {2, 4, 6, 9, 10};

        List<Integer> intersection = findIntersection(A, B);

        System.out.println("Giao của hai mảng: " + intersection);
    }
}
