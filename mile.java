
// link of the problem
//https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java

public class mile {
    public static void main(String[] args) {

    }
    public static int isInteresting(int number, int[] awesomePhrases) {

        int lengthP = awesomePhrases.length;
        int numDigits = String.valueOf(number).length();


        //check if the number is equal to the awesomePhrases members
        for (int i = 0; i < lengthP; i++) {
            if (number == awesomePhrases[i]){return 2;} else if ((number +=2) >= awesomePhrases[i]) {return 1;}else {return 0;}
        }


        //check if the number has 3 digits or
        if (numDigits<3){return 0;}

        // check if the first digit is followed by zeros
        String numStr = String.valueOf(number);
        boolean allButFirstZero = numStr.substring(1).matches("0*");
        boolean isTwoAway = number - Integer.parseInt(numStr.charAt(0) + "00") <= 2;
        if (allButFirstZero) {
            return 2;
        }
        // check if 2 or less mile is away from n000
        else if (isTwoAway) {
            return 1;
        }

        return 0;
    }
}
