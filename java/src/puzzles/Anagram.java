package puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();
        int deleteCount=0;
        for(int i=0; i< a.length(); i++){
            if(b.indexOf(a.charAt(i)) == -1){ // delete
                sb1.append(a.charAt(i)).append(',');
                deleteCount++;
            }else{
                sbA.append(a.charAt(i));
            }
        }
        for(int i=0; i< b.length(); i++){
            if(a.indexOf(b.charAt(i)) == -1){ // delete
                sb2.append(b.charAt(i)).append(',');
                deleteCount++;
            }else{
                sbB.append(b.charAt(i));
            }
        }
        System.out.println("Delete following chars from Str A " + sb1.toString());
        System.out.println("Delete following chars from Str b " + sb2.toString());
        Map<String, Integer> mapA = findRepetitions(sbA.toString());
        Map<String, Integer> mapB = findRepetitions(sbB.toString());
        for (String key : mapA.keySet()){
            if(mapA.get(key) != mapB.get(key)){
                int diff = mapA.get(key)-mapB.get(key);
                if(diff <0){
                    diff *=-1;
                }
                deleteCount += diff;
            }
        }
        System.out.println("Delete Count =" + deleteCount);

        return deleteCount;
    }

    public void test(String s){
        System.out.println(s);
    }

    public void test(Integer i){
        System.out.println(i);
    }

    public static Map<String, Integer> findRepetitions(String str){
        Map<String, Integer> hmap = new HashMap<>();
        for(int i=0; i< str.length(); i++){
            String chr = Character.toString(str.charAt(i));
            Integer countObj = hmap.get(chr);
            if( countObj != null){
                int count = countObj.intValue();
                count++;
                hmap.put(chr, count);
            }else{
                Integer c = new Integer(1);
                hmap.put(chr, c);
            }
        }
        return hmap;
    }

}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        System.out.println(String.valueOf(res));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

