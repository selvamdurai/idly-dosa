package puzzles;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt rtm = new RomanToInt();
        rtm.convert("MMMCDXXV"); // 3425
        rtm.convert("MMMCDXXIV"); // 3424
        rtm.convert("MMMCMXXIV"); // 3924
        rtm.convert("MMMCMXXIX"); // 3929
        rtm.convert("CCXLVIII"); // 248
    }

    private int convert(String roman) {
        int result =0;
        Map<String, Integer> singles = new HashMap<>();
        Map<String, Integer> combos = new HashMap<>();
        singles.put("I",1);
        singles.put("V",5);
        singles.put("X",10);
        singles.put("L",50);
        singles.put("C",100);
        singles.put("D",500);
        singles.put("M",1000);
        combos.put("IV",4);
        combos.put("IX",9);
        combos.put("XL",40);
        combos.put("XC",100);
        combos.put("CD",400);
        combos.put("CM",900);
        if(roman.length()<1){
            return 0;
        }
        String singleChar="";
        String twoCharStr="";
        int i=0;
        StringBuffer twoChars = new StringBuffer();
        for(i = 0; i < roman.length()-1; i++){
            singleChar = Character.toString(roman.charAt(i));
            twoChars = new StringBuffer();
            twoChars.append(roman.charAt(i)).append(roman.charAt(i+1));
            twoCharStr= twoChars.toString();
            if(combos.containsKey(twoCharStr)){
                result += combos.get(twoCharStr);
                ++i;
            }else{
                result += singles.get(singleChar);
            }
        }
        if(!combos.containsKey(twoCharStr)){
            singleChar = Character.toString(roman.charAt(i));
            result += singles.get(singleChar);
        }
        if(result > 9999){
            System.out.println("Invalid input string" + roman);
            result=0;
        }
        System.out.println("Input value = " + roman + " Result = " + result);
        return result;
    }
}
