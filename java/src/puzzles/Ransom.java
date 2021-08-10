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

 class RansomResult {

     /*
      * Complete the 'checkMagazine' function below.
      *
      * The function accepts following parameters:
      *  1. STRING_ARRAY magazine
      *  2. STRING_ARRAY note
      */

     public static void checkMagazine(List<String> magazine, List<String> note) {
         // Write your code here
         boolean exists=true;
         for(String str : note ){
             if(isExists(str,magazine)){
                 //magazine.remove(i);
             }else{
                 exists=false;
                 break;
             }
         }
         if(exists){
             System.out.println("Yes");
         }else{
             System.out.println("No");
         }
     }
     private static boolean isExists(String str, List<String> magazine){
         boolean exists=false;
         int i=0;
         System.out.println("str =" + str);
         System.out.println("List=" + magazine);
         for(String st : magazine){
             if(st.equalsIgnoreCase(str)){
                 exists=true;
                 magazine.remove(i);
                 break;
             }
             i++;
         }
         System.out.println("result=" + exists);
         return exists;
     }

 }

public class Ransom {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        RansomResult.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}