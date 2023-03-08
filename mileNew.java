//https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java
public class mileNew {

    public static void main(String[] args) {
        System.out.println(isInteresting(3442,new int[]{1337, 256}));
    }
    //return 2 if it matches
    //return 1 if its 2 miles away from matching it
    //else return zeros
    public static int isInteresting(int number, int[] awesomePhrases) {

        //return followedByAllZeros(number);
        //return everyDigitSameNumber(number);
        //return incrementing(number);
        //return decrementing(number);
        return  palindrome(number);
    }
    //followedByAllZeros is Done.
    public static int followedByAllZeros(int number){
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
        boolean two = false;
        boolean one = false;
        //set the two to true if the all digits are the same.
        String numStr = Integer.toString(number);
        char firstDigit = numStr.charAt(0);
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) != firstDigit) {
                two = false;
            }
            else {
                two = true;
            }
        }
        //now check if ir should return one
        if (!two){
            boolean initial = false;
            for (int i = 1; i < numStr.length()-1; i++) {
                if (numStr.charAt(i) != firstDigit){
                    initial = false;
                    break;
                }else {
                    initial = true;
                }
            }
            int lastDigit = Character.getNumericValue(firstDigit);
            int last1 = lastDigit-1;
            int last2 = lastDigit-2;
            String strLast1 = Integer.toString(last1);
            String strLast2 = Integer.toString((last2));
            boolean checkingIfOne = initial && (numStr.endsWith(strLast1)|| numStr.endsWith(strLast2));
            boolean checkingIfOne1 = initial && (numStr.endsWith("9")|| numStr.endsWith("0"));
            boolean checkingIfOne0 = initial && (numStr.endsWith("8")|| numStr.endsWith("9"));
            if (lastDigit != 1 && lastDigit != 0){
                if (checkingIfOne){
                    one = true;
                }
            } else if (lastDigit == 1) {
                if (checkingIfOne1){
                    one = true;
                }
            }else {
                if (checkingIfOne0){
                    one = true;
                }
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
    public static int incrementing(int number){
        boolean two = false;
        boolean one = false;
        //set the two to true if the all digits are the same.
        String numStr = Integer.toString(number);

        for (int i = 1; i < numStr.length() ; i++) {
            if (numStr.charAt(i) != numStr.charAt(i-1)+1){
                two = false;
                break;
            }
            else {
                two = true;
            }
        }

        if (!two){
            boolean initial = false;
            for (int i = 1; i < numStr.length()-1; i++) {
                if (numStr.charAt(i) != numStr.charAt(i-1)+1){
                    initial = false;
                    break;
                }
                else {
                    initial = true;
                }
            }
            if(initial){
                char lastChar = numStr.charAt(numStr.length() - 1);
                char OneToLastChar = numStr.charAt(numStr.length() - 2);
                int lastDigit = Character.getNumericValue(lastChar);
                int oneTOLastDigit = Character.getNumericValue(OneToLastChar);
                if(oneTOLastDigit+2 >= lastDigit){
                    one = true;
                }
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
    public static int decrementing(int number){
        boolean two = false;
        boolean one = false;
        //set the two to true if the all digits are the same.
        String numStr = Integer.toString(number);
        for (int i = 1; i < numStr.length() ; i++) {
            if (numStr.charAt(i) != numStr.charAt(i-1)-1){
                two = false;
                break;
            }
            else {
                two = true;
            }
        }

        if (!two){
            boolean initial = false;
            for (int i = 1; i < numStr.length()-1; i++) {
                if (numStr.charAt(i) != numStr.charAt(i-1)-1){
                    initial = false;
                    break;
                }
                else {
                    initial = true;
                }
            }
            if(initial){
                char lastChar = numStr.charAt(numStr.length() - 1);
                char OneToLastChar = numStr.charAt(numStr.length() - 2);
                int lastDigit = Character.getNumericValue(lastChar);
                int oneTOLastDigit = Character.getNumericValue(OneToLastChar);
                if(oneTOLastDigit+3 >= lastDigit){
                    one = true;
                }
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
    public static int palindrome(int number) {
        boolean two = false;
        boolean one = false;
        String numStr = Integer.toString(number);

        if (numStr.length() % 2 == 0) {
            char[] evenNumArrFirst = new char[numStr.length() ];
            char[] evenNumArrSecond = new char[numStr.length() ];

            for (int i = 0; i < numStr.length() / 2; i++) {
                evenNumArrFirst[i] = numStr.charAt(i);
            }
            for (int i = numStr.length() - 1; i >= numStr.length() / 2; i--) {
                evenNumArrSecond[numStr.length() - 1 - i] = numStr.charAt(i);
            }
            for (int i = 0; i < numStr.length() / 2; i++) {
                if (evenNumArrFirst[i] != evenNumArrSecond[i]) {
                    two = false;
                    break;
                } else {
                    two = true;
                }
            }

            if (!two) {
                boolean initial = false;

                for (int i = 1; i < numStr.length() / 2 - 1; i++) {
                    if (evenNumArrFirst[i] != evenNumArrSecond[i]) {
                        initial = false;
                        break;
                    } else {
                        initial = true;
                    }
                }
                if (initial && (evenNumArrFirst[0] <= evenNumArrFirst[numStr.length() / 2 -1] + 2)) {
                    one = true;
                }

            }

        } else {

            char[] oddNumArrFirst = new char[numStr.length() ];
            char[] oddNumArrSecond = new char[numStr.length() ];

            for (int i = 0; i < numStr.length() / 2; i++) {
                oddNumArrFirst[i] = numStr.charAt(i);
            }
            for (int i = numStr.length() - 1; i >= numStr.length() / 2; i--) {
                oddNumArrSecond[numStr.length() - 1 - i] = numStr.charAt(i);
            }
            for (int i = 0; i < numStr.length() / 2; i++) {
                if (oddNumArrFirst[i] != oddNumArrSecond[i]) {
                    two = false;
                    break;
                } else {
                    two = true;
                }
            }

            if (!two) {
                boolean initial = false;

                for (int i = 1; i < numStr.length() / 2 ; i++) {
                    if (oddNumArrFirst[i] != oddNumArrSecond[i]) {
                        initial = false;
                        break;
                    } else {
                        initial = true;
                    }
                }
                if (initial && (oddNumArrFirst[0] <= oddNumArrSecond[oddNumArrSecond.length-1] + 2)) {
                    one = true;
                }




            }

        }
        if (two) {
            return 2;
        } else if (one) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int matchAw (int number, int[] awesomePhrases){
        return 0;
    }
}
