package puzzles;

public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour p = new PowerOfFour();
        p.isPowerOfFour(654320);
    }

    private boolean isPowerOfFour(int i) {
        int l  = 0;
        while(i>1){
            System.out.println("Looping : " + l++);

            if(i % 4 != 0){
                System.out.println("Not a power of 4");
                return false;
            }
            i=i/4;
        }
        if(i==1){
            System.out.println("It is a power of 4");
            return true;
        }
        System.out.println("Not a power of 4");
        return false;
    }
}
