public class CoreJavaTest {
    static int i=100;

    static{
        i = i-- - --i;
        System.out.println( "value of i = " + i);
    }

    public static void main(String[] args) {
        CoreJavaTest t = new CoreJavaTest();

    }


}
