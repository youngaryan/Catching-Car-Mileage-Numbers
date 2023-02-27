public class mileNew {

    public static void main(String[] args) {
        System.out.println(isInteresting(234,new int[]{1337, 256}));
    }
    //return 2 if it matches
    //return 1 if its 2 miles away from matching it
    //else return zeros
    public static int isInteresting(int number, int[] awesomePhrases) {

        return followedByAllZeros(number, new int[]{1337, 256});
    }
    //followedByAllZeros is Done.
    public static int followedByAllZeros(int number, int[] awesomePhrases){
        boolean two = false;
        boolean one = false;
        String numStr = Integer.toString(number);
        
        for (int i = 1; i <numStr.length() ; i++) {
            if (numStr.charAt(i) == '0') {
                two = true;
            }
        }
        
        if (!two){
            boolean initial = false;
            int num2 = number+2;
            String numStr2 = Integer.toString(num2);
            for (int i = 1; i < numStr.length()-1; i++) {
                if (numStr.charAt(i) == '9') {
                    initial = true;
                }
            }
            if (initial && numStr2.endsWith("1") || numStr2.endsWith("0")) {
                one = true;
            }
        }

        if (two){
            return 2;
        } else if (one) {
            return 1;
        }else {
            return 0;
        }
    }
    public static int everyDigitSameNumber(int number){
        return 0;
    }
    public static int incrementing(int number){
        return 0;
    }
    public static int decrementing(int number){
        return 0;
    }
    public static int palindrome(int number){
        return 0;
    }
    public static int matchAw (int number, int[] awesomePhrases){
        return 0;
    }
}
