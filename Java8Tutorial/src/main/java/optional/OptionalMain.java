package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {

        // Optional class làm cho việc xử lý null ít khi bị lỗi

        List<String> names = Arrays.asList("Tita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh");

        System.out.println(getNameStartByT(names));
        System.out.println(getNameStartByTUsingOptional(names));

    }

    // cách thông thường khi check tên bắt đầu bằng chữ T
    private static String getNameStartByT(List<String> names){
        String result = null;
        for (String name : names){
            if (name.startsWith("T")){
                result = name;
                break;
            }
        }
        return result == null ? "no name" : result;
    }

    private static String getNameStartByTUsingOptional(List<String> names){
        Optional<String> result = names.stream().filter(name -> name.startsWith("T")).findFirst();
        // phương thức orElse("") -> có nghĩa nếu result = null thì sẽ trả về giá trị được truyền vào.
        return result.orElse("no name");
    }
}
