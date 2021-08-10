package puzzles;

public class StringtoInt {

    public static void main(String[] args) {
        String str = " abc  -42";

        System.out.println("Input = " + str);
        System.out.println("Output = " + atoiL2R(str));

    }

    public static int atoiL2R(String s){
        long numberToReturn=0;
        int i;
        boolean firstDigit=true;
        int firstDigitMarker=0;
        s = s.trim();
        if(s.length()==0)
            return 0;
        if(!(s.charAt(0) == '-' || s.charAt(0) == '+') && ( s.charAt(0) < 48 || s.charAt(0) > 57 ))
            return 0;
        for( i = 0; i < s.length(); i++ ){
            int ch= s.charAt(i);
            if(ch >=48 && ch <=57 ){
                numberToReturn = (numberToReturn * 10 ) + (ch-48);
                if(firstDigit){
                    firstDigit=false;
                    firstDigitMarker = i;
                }
            } else if(!firstDigit){
                break;
            }
            if(numberToReturn >= Integer.MAX_VALUE){
                numberToReturn = Integer.MAX_VALUE;
                break;
            }
            if(numberToReturn <= Integer.MIN_VALUE){
                numberToReturn = Integer.MIN_VALUE;
                break;
            }
        }
        if(firstDigitMarker > 0 && s.charAt(firstDigitMarker-1) == '-'){
            if(numberToReturn == Integer.MAX_VALUE){
                numberToReturn=Integer.MIN_VALUE;
            }
            numberToReturn *= -1;
        }else if(firstDigitMarker > 1 ){
            return 0;
        }

        return (int) numberToReturn;
    }


    public static int atoiR2L(String s){
        long numberToReturn=0;
        int i;
        int multiplier=1;
        boolean identified=false;
        for( i = s.length()-1; i>=0; i-- ){
            int ch= s.charAt(i);
            if(ch >=48 && ch <=57 ){
                numberToReturn = numberToReturn  + (ch-48) * multiplier;
                multiplier *= 10;
                identified=true;
            } else if(identified && (s.charAt(i) == '-')){
                numberToReturn *= -1;
            }
            if(numberToReturn >= Integer.MAX_VALUE){
                numberToReturn = Integer.MAX_VALUE;
                break;
            }
            if(numberToReturn <= Integer.MIN_VALUE){
                numberToReturn = Integer.MIN_VALUE;
                break;
            }
        }
        return (int) numberToReturn;
    }



}
