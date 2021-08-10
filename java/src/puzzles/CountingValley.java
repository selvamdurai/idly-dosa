import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class CountingValleyResult {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int numberOfValleys=0;
        int marker=0;
        boolean startCount=false;
        for(int i =0; i< path.length(); i++){
            char c= path.charAt(i);
            switch (c){
                case 'U':
                    ++marker;
                    break;
                case 'D':
                    --marker;
                    break;
            }
            if(marker<0){
                startCount=true;
            }
            if(marker==0 && startCount){
                ++numberOfValleys;
                startCount=false;
            }
        }
        return numberOfValleys;
    }

}

public class CountingValley {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        String path = bufferedReader.readLine();
        int result = CountingValleyResult.countingValleys(steps, path);
        System.out.println("Result = " + result);
        bufferedReader.close();
    }
}
