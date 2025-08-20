import java.util.Arrays;

public class Main {


    public static int[] countingSort(int[] a) {
        if (a == null || a.length <= 1) return a == null ? null : a.clone();

        // 1) Xác định min và max để tính miền giá trị (k = max - min + 1)
        int min = a[0], max = a[0];
        for (int v : a) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        int k = max - min + 1;

        // Cảnh báo thực tế: nếu k quá lớn so với n, Counting Sort có thể tốn bộ nhớ.
        int[] count = new int[k];

        // 2) Đếm tần suất
        for (int v : a) {
            count[v - min]++;
        }

        // 3) Prefix sum: count[i] = tổng tần suất <= i (tức là "vị trí kết thúc" 1-based)
        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }

        // 4) Xây out ổn định: duyệt từ phải sang trái
        int[] out = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int v = a[i];
            int idx = --count[v - min]; // chuyển về 0-based, đồng thời giảm để vị trí tiếp theo dịch trái
            out[idx] = v;
        }

        return out;
    }

    // Demo nhanh
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 8, 3, 3, 1};


        System.out.println("Input 1 : " + Arrays.toString(arr1));
        System.out.println("Sorted 1: " + Arrays.toString(countingSort(arr1)));

    }
}
