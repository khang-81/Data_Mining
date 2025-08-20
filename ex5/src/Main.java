public class Main {

    // MẢNG TOÀN CỤC LƯU KẾT QUẢ
    // results: chứa các câu hợp lệ đã tách được
    // Giả định tối đa 100 câu. Nếu nhiều hơn phải tăng kích thước.
    static String[] results = new String[100];

    // count: số câu thực tế đã lưu vào results
    static int count = 0;

    /**
     * Hàm wordBreak: khởi động quá trình tách chuỗi s thành các câu
     * sao cho mỗi từ đều thuộc từ điển dict.
     *
     * @param s    Chuỗi đầu vào (ví dụ: "catsanddog")
     * @param dict Mảng các từ hợp lệ (ví dụ: {"cat", "cats", "and", "sand", "dog"})
     */
    public static void wordBreak(String s, String[] dict) {
        // Gọi hàm đệ quy từ index = 0 (chưa xét ký tự nào)
        // current = "" (chưa có từ nào trong câu)
        backtrack(s, dict, "", 0);
    }

    // HÀM ĐỆ QUY BACKTRACK
    /**
     * Hàm backtrack: thử ghép các từ từ vị trí index trong s.
     *
     * @param s       Chuỗi gốc cần tách
     * @param dict    Từ điển
     * @param current Câu đang được xây dựng (nối bằng khoảng trắng)
     * @param index   Vị trí hiện tại trong s (ký tự tiếp theo cần xét)
     */
    private static void backtrack(String s, String[] dict, String current, int index) {
        // ---- BASE CASE ----
        // Nếu đã duyệt hết chuỗi (index == s.length())
        // => câu hiện tại là 1 kết quả hợp lệ
        if (index == s.length()) {
            // Lưu kết quả (loại bỏ khoảng trắng thừa đầu/cuối bằng trim())
            results[count++] = current.trim();
            return;
        }

        // Duyệt toàn bộ từ điển dict
        for (int i = 0; i < dict.length; i++) {
            String word = dict[i]; // từ đang xét

            // Kiểm tra độ dài: phải đủ để cắt ra substring
            if (index + word.length() <= s.length()) {
                // Lấy đoạn con của s, từ index, độ dài = word.length()
                String sub = s.substring(index, index + word.length());

                // Nếu trùng với word trong từ điển
                if (sub.equals(word)) {
                    // Nối word vào current (thêm 1 khoảng trắng trước để cách từ)
                    // Sau đó gọi đệ quy tiếp từ vị trí index + word.length()
                    backtrack(s, dict, current + " " + word, index + word.length());
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] dict = {"cat", "cats", "and", "sand", "dog"};

        wordBreak(s, dict);

        for (int i = 0; i < count; i++) {
            System.out.println(results[i]);
        }
        // Kết quả:
        // cats and dog
        // cat sand dog
    }
}
