
// link of the problem
//https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java

public class mile {
    public static void main(String[] args) {
        System.out.println(isInteresting(1336, new int[]{1337, 256}));
    }
    public static int isInteresting(int number, int[] awesomePhrases) {

        int countTwos = 0;
        int countOnes = 0;
        int countZeroes = 0;

        int lengthP = awesomePhrases.length;
        int numDigits = String.valueOf(number).length();
        String numStr = String.valueOf(number);
        int firstDigits = numStr.charAt(0);



        //check if the number has 3 digits or
        if (numDigits<3){return  0;}

        //check if the number is equal to the awesomePhrases members
        for (int awesomePhrase : awesomePhrases) {
            if (number == awesomePhrase) {
                countTwos += 1;
            } else if ((number += 2) >= awesomePhrase) {
                countOnes += 1;
            } else {
                countZeroes += 1;
            }
        }

        // check if the first digit is followed by zeros
        String wantedFollowedByZeros = String.valueOf(numStr.charAt(0));
        for (int i = 0; i < numStr.length()-1; i++) {
            wantedFollowedByZeros +="0";
        }

        int wantedNumFollowedZerosInt = Integer.parseInt(wantedFollowedByZeros);

        if (number == wantedNumFollowedZerosInt){
            countTwos +=1;
        } else if ((number+2)>=wantedNumFollowedZerosInt ) {
            countOnes += 1;
        }
        else {
            countZeroes +=1;
        }


        //check if the number has the same digits

        String wantedSameDigits = "" ;
        for (int i = 0; i < numStr.length(); i++) {
            wantedSameDigits += firstDigits;
        }

        int wantedSaDigitsInt = Integer.parseInt(wantedSameDigits);

        if (number == wantedSaDigitsInt){
            countTwos +=1;
        } else if ((number+2) >= wantedSaDigitsInt) {
            //check if it's 2 away from being a same digit number
            countOnes +=1;
        } else {countZeroes += 1;}

        //check if the digits are sequential, incrementing

        String wantedIncrementingStr = String.valueOf(firstDigits);

        for (int i = firstDigits+1; i <numStr.length() ; i++) {
            wantedIncrementingStr += "i";
        }
        int wantedIncrementingInt = Integer.parseInt(wantedIncrementingStr);

        if (wantedIncrementingInt == number) {
            countTwos +=1;

        } else if ((number + 2) >= number) {
            countOnes +=1;
        }else {countZeroes +=1;}

        //check if the digits are sequential, decrementing

        String wantedDecrementingStr = String.valueOf(firstDigits);
        int k = numStr.length();
        while (k>0){
            wantedDecrementingStr += "i";

            k--;
        }
        try {
            int wantedDecrementingInt = Integer.parseInt(wantedDecrementingStr);

            if (number == wantedDecrementingInt){
                countTwos +=1;
            } else if ((number+2)>=number) {
                countOnes+=1;
            }else {countZeroes+=1;}

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        try {
            //The digits are a palindrome
            String num2 = Integer.toString(number+2);
            //for even length numbers
            if (numStr.length() %2 ==0 ) {
                int halfPal =numStr.length()/2;
                for (int i = 0; i < halfPal; i++) {
                    if (numStr.charAt(i) != numStr.charAt(numStr.length()-i)){
                        countOnes +=1;
                    } else if (numStr.charAt(i) <= num2.charAt(numStr.length()-i)) {
                        countOnes +=1;
                    }
                    else{
                        countTwos+=1;
                    }
                }
            }//for odd digits length number
            else{
                int halfPalOdd =numStr.length()/2-1;
                for (int i = 0; i < halfPalOdd ; i++) {
                    if (numStr.charAt(i) != numStr.charAt(numStr.length()-i)) {
                        countZeroes+=1;
                    } else if (numStr.charAt(i) <= num2.charAt(numStr.length()-i)) {
                        countOnes+=1;
                    }else {
                        countTwos+=1;
                    }
                }
            }


        }catch (Exception e){System.out.println(e.getMessage());}


        if (countTwos > 0) {
            return 2;
        } else if (countOnes>0 ) {
            return 1;
        }
        else {return 0;}

    }



}
