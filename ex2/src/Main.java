import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Regex mẫu kiểm tra URL
    private static final String URL_REGEX =
            "^(https?://)?(www\\.)?[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập URL để kiểm tra: ");
        String input = scanner.nextLine().trim();

        if (isValidURL(input)) {
            System.out.println("URL hợp lệ");
        } else {
            System.out.println("URL không hợp lệ");
        }

        scanner.close();
    }

    private static boolean isValidURL(String url) {
        return URL_PATTERN.matcher(url).matches();
    }
}
