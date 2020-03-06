package sort_list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortMain {

    private static class Student{
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        // sắp xếp mảng string theo chiều tăng dần
        List<String> cities = Arrays.asList(
                "aaaaa",
                "Aa",
                "aaa",
                "Aaa"
        );

        System.out.println("Mảng gốc: " + cities);

        // sắp xếp không quan trọng chữ hoa chữ thường
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Mảng sắp xếp không quan trọng chữ hoa: " + cities);

        // sắp xếp theo chữ hoa, chữ hoa sẽ ở đầu mảng
        cities.sort(Comparator.naturalOrder());
        System.out.println("Mảng sắp xếp tính cả chữ hoa: " + cities);

        // Sắp xếp mảng số nguyên
        List<Integer> numbers = Arrays.asList(2,4,5,1,3);
        System.out.println("Mảng gốc: " + numbers);
        numbers.sort(Comparator.naturalOrder());
        System.out.println("mảng sắp xếp tăng dần: " + numbers);

        // sắp xếp theo field của object
        List<Student> students = Arrays.asList(
                new Student(100, "Quang"),
                new Student(30, "Le"),
                new Student(25, "Quang"),
                new Student(34, "Trung")
        );

        System.out.println("Mảng gốc: ");
        students.forEach(System.out::println);

        System.out.println("Mảng sắp xếp theo tuổi tăng dần: ");
        students.sort(Comparator.comparing(Student::getAge));
        students.forEach(System.out::println);

        System.out.println("Mảng sắp xếp theo tuổi giảm dần: ");
        students.sort(Comparator.comparing(Student::getAge).reversed());
        students.forEach(System.out::println);

        // sắp xếp với custom Comparator
        System.out.println("Mảng sắp xếp với custom Comparator");
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student firstStudent, Student secondStudent) {
                return firstStudent.getAge() - secondStudent.getAge();
            }
        });
        students.forEach(System.out::println);


        // sắp xếp mảng mới nhiều điều kiện
        System.out.println("Mảng sắp xếp theo tên giảm dần, nếu tên trùng thì sx theo tuổi giảm dần");
        students.sort(Comparator.comparing(Student::getName)
                .reversed()
                .thenComparing(Student::getAge)
                .reversed());
        students.forEach(System.out::println);

    }

}

