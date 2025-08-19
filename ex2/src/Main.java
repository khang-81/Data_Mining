import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Regex kiểm tra URL hợp lệ theo yêu cầu đề bài
    private static final String URL_REGEX =
            "^(https?://)"            // bắt buộc http:// hoặc https://
                    + "(www\\.)?"               // có thể có www hoặc không
                    + "[a-z0-9]+"               // tên miền chỉ gồm chữ cái thường + số
                    + "(\\.[a-z]{2,6})"         // phần domain extension .vn, .com, .org...
                    + "(/[\\S]*)?$";            // phần path, không chứa khoảng trắng

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập URL để kiểm tra: ");
        String input = scanner.nextLine().trim();

        if (isValidURL(input)) {
            System.out.println("✅ URL hợp lệ");
        } else {
            System.out.println("❌ URL không hợp lệ");
        }

        scanner.close();
    }

    // Hàm kiểm tra URL
    private static boolean isValidURL(String url) {
        return URL_PATTERN.matcher(url).matches();
    }
}
