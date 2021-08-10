package puzzles;

public class ReverseInt {
    public static void main(String[] args) {
        ReverseInt r = new ReverseInt();
//        r. reverseIntUsingString(987654321);
//        r.reverseIntUsingLong(-123456789);
//        r.reverseIntUsingLong(12345);
        System.out.println(r.reverse(1534236469));
    }

    private void reverseIntUsingString(long input) {
        String str = Long.toString(input);
        StringBuffer rev = new StringBuffer();
        for (int i = str.length()-1; i>=0; i-- ){
            rev.append(str.charAt(i));
        }
        System.out.println(" Input Value = " + input + " Result = " + rev.toString());
    }
    private void reverseIntUsingLong(long originalInput ){
        long input = originalInput;
        long reversed=0;
        long ones;
        if(originalInput<0){
            input *= -1;
        }
        while (input > 0){
            ones = input % 10;
            reversed += ones;
            if(input>10)
                reversed = reversed * 10;
            input /= 10;
        }
        if(originalInput<0){
            reversed *= -1;
        }
        System.out.println( " Input = " + originalInput + " Result = " + reversed);
    }
    public int reverse(int x) {
        long reverse=0;
        while( x != 0 ){
            reverse = (reverse*10) + (x % 10);
            x = x / 10;
            if(reverse > Integer.MAX_VALUE){
                reverse=0;
            }
        }
        return (int) reverse;
    }
}
