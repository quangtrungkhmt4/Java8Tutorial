package lambda;

public class LambdaMain {
    public static void main(String[] args) {

        // ta tạo 1 function nhận vào 1 giá trị và hiển thị giá trị đó ra màn hình
        // cách thông thường
        LambdaMain main = new LambdaMain();
        main.printSomething("hello world!");

        // cách sử dụng biểu thức lambda, ta tạo ra một Printer interface rồi sẽ quy định hành vi của nó bằng biểu thức
        // lambda, rồi chuyền cả printer vào phương thức printSomething
        Printer printer = (String value) -> {
            System.out.println(value);
        };

        main.printSomething("Hello", printer);
        // viết gọn
        main.printSomething("viết gọn", print -> System.out.println(print));

    }


    public void printSomething(String value){
        System.out.println(value);
    }

    interface Printer{
        void print(String val);
    }

    public void printSomething(String value, Printer printer){
        printer.print(value);
    }


}
