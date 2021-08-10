package puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class SherlockResult {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        Map<String, Integer> mapS = findRepetitions(s);
        if(checkifValid(mapS , 0)){
            return "YES";
        }else{
            return "NO";
        }
    }
    public static boolean checkifValid(Map<String, Integer> mapS , int deletionsCount){
        System.out.println("map=" + mapS);
        System.out.println("deletionsCount=" + deletionsCount);
        int i=0, j=0;
        int average=0;
        int sum=0;
        int prevCount=0;
        String prevKey="";
        if(deletionsCount>1){
            return false;
        }
        for(String key : mapS.keySet()){
            int current=Integer.valueOf(mapS.get(key));
            if(prevCount==0){ // First iteration, move on to next
                prevKey=key;
                prevCount= current;
                i++;
                sum = current;
                average = current;
                continue;
            }
            if(prevCount == current){//prev and crnt matches hence move on to next
                prevKey=key;
                i++;
                sum += current;
                average = sum/i;
                continue;
            }
            int diff = prevCount - current;
            if(diff>1 || diff < -1 ){ // to delete more than 1 char
                System.out.println("Diff greater than 1");
                return false;
            }
            //special case for first item removal
            //if(i)
            if(current < average && prevCount==average && current == 1){
                //mapS.remove(key); // Delete just one odd character in the map
                deletionsCount++;
            }
            else if(current > average && prevCount==average && current-1 == average){
                mapS.put(key, current-1);
                deletionsCount++;
            } else {
                System.out.println("Unknown criteria");
            }
            prevKey=key;
            prevCount=current;
            if(deletionsCount >1)
                return false;
        }
        return deletionsCount <=1 ;
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

public class SherlockString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = SherlockResult.isValid(s);
        System.out.println(result);
        bufferedReader.close();

    }
}
