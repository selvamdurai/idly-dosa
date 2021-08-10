package puzzles;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static boolean isEven(int num){
        System.out.println("isEven called for " + num);
        return num % 2 == 0;
    }

    public static boolean isGreaterThan3(int num){
        System.out.println("isGreaterThan3 called for " + num);
        return num > 3;
    }
    public static int doubleUp(int num){
        System.out.println("doubleUp called for " + num);
        return num * 2;
    }
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);
        /*System.out.println(
                values.stream()
                        .filter(StreamTest::isGreaterThan3)
                .filter(StreamTest::isEven )
                .map(StreamTest::doubleUp)
                .findFirst()
        );*/

        List<Person> people = Arrays.asList(
                new Person("Sudhakar", "Dharmarasan", 43,SEX.MALE),
                new Person("Rajesh", "Paul", 43,SEX.MALE),
                new Person("Jinu", "Augustine", 40,SEX.MALE),
                new Person("Lakshminarayana", "Jasti", 43,SEX.MALE),
                new Person("Selvam", "Durai", 43,SEX.MALE),
                new Person("Eldho", "Jacob", 40,SEX.MALE)
        );

//        people.stream()
//                .forEach(System.out::println);
//
        people.stream()
                .filter(p -> p.getLastName().startsWith("D"))
                .forEach(System.out::println);

        int numbers [] = {1,2,3,4,5,6,7,8,9};

        Arrays.stream(numbers).forEach(i -> System.out.println("Double of i = " + i*5) );

        String str ="sdgshkdjgdsbdscijvbdibb";

        long n = str.chars()
                .filter(c -> c =='g')
                .count();

        System.out.println("number of g="+n);




        
    }


}

enum SEX{MALE,FEMALE};


class Person{
    String firstName;
    String lastName;
    int age;
    SEX sex;

    public Person(String firstName, String lastName, int age, SEX sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SEX getSex() {
        return sex;
    }

    public void setSex(SEX sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}