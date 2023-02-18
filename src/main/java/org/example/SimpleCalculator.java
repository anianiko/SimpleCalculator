package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        //Implement main(String[] args) to create the calculator.
        // The function continuously asks for number 'a' and 'b' and an operator and
        // calculates the result of 'a' 'operator' 'b'.


        //System.out.println(askForANumber(true));
        // System.out.println(askForAnOperator(true));

        Float num1 = askForANumber(false);
        if (num1 != null){
            String op = askForAnOperator(true);
            Float num2 = askForANumber(true);
            System.out.println("The result is: " + calc(op, num1, num2));
        }
    }

    public static boolean isNumber(String str) {
        // Implement isNumber(String str) function, which checks whether given string can be converted into a Float.

        //megpróbáljuk Floattá átalakítani a Stringet. Sikerül/nem sikerül kimenet és akciók:
        try {
            Float.parseFloat(str); //float number = Float.parseFloat(str); ez az egész nem kell, mert nem akarjuk eltárolni, csak az igaz/hamis kell. Nem fogjuk később használni.
        } catch (NullPointerException | NumberFormatException exception) {
            return false;
            // finally olyan ág, ami mindig lefut, pl loggolni akarunk. Finally ágat ritkán hasnzáljuk, nem feltétlen szükséges.
        } finally {
            System.out.println("Original String: " + str);
        }

        return true;
    }

    public static Float convertNumber(String str) {
        // Implement convertNumber(String str) function, which converts given string into a Float.

        return Float.parseFloat(str);

    }

    public static boolean isValidOperator(String operator) {
        // Implement an isValidOperator(String operator) to return true if the operator input parameter represents a valid operator, and otherwise return false.

        //egyik megoldás:
        //int[] numbers = new int[10];
        //List<Integer> numbers2 = new ArrayList<>();
        // stb.

        //hogyan tudjuk lemérni, hogy milyen gyors a metódusunk?
        //long start = System.currentTimeMillis();
        // System.out.println("Time elapsed is ms: " + System.currentTimeMillis() - start) + "ms");

        //másik megoldás:
        // léterehoz egy listát, anélkül hogy lementené. Ggyorsan létrehoz egy listát,
        // megnézi hogy benne van e az operátor, aztán a listát azonnal el is felejti.

        return Arrays.asList("+","-","*","/").contains(operator);


        //harmadik megoldás:
        /*
        if (operator.equals("+")){
            return true;
        }
        if (operator.equals("-")){
            return true;
        }
        if (operator.equals("*")){
            return true;
        }
        if (operator.equals("/")){
            return true;
        }
        return false;

         */

        //negyedik megoldás (tömbös megoldás):

        /*
        String[] arr = new String[4];
        arr[0] = "+";
        arr[1] = "-";
        arr[2] = "*";
        arr[3] = "/";
        for (byte i = 0; i<arr.length; i++; {
            if (arr[i].equals(operator)){     //== nem lesz itt jó, mert az operator egy string
                return true;
            }
        }
        return false;

         */

        //örödik megoldás (listás megoldás - referenciaosztály miatt beírható a contains() ):
        /*
        List<String> operators = new ArrayList<>();   //Alt+Enterrel importálom a List listát és ArrayList-et is!!
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        return operators.contains(operator);   //megnézi,hogy benne van-e az operátor, logikai eredményt ad vissza.

         */



    }

    // askforanumber és askforanoperatorból kiemelem a scannert, és külön teszem, ide valahova kívülre:
    static Scanner scanner = new Scanner(System.in);


    public static Float askForANumber(boolean forceValidInput) {
        // Implement askForANumber(boolean forceValidInput) to return the numeric value of the user input.
        // The function continuously asks for input from the user until the input is numeric when forceValidInput is true.
        // When the forceValidInput is false and the user input is not numeric, the function returns with null.


        //Egyik megoldás:
        /*
        Scanner scanner = new Scanner (System.in);   //input kérése a konzolról


        while(true) {
            System.out.print("Please, provide a number! > ");

            String input = scanner.nextLine();  //String lehetne var is

            if (isNumber(input)) {
                return convertNumber(input);
            } else if (!forceValidInput){

                return null;
            }
            System.out.println("This didn't look like a number, try again. \n> ");
        }
        */

        //Másik megoldás:
        // askforanumber és askforanoperatorból kiemelem a scannert, és külön teszem

        while(true) {
            System.out.print("Please provide a number: ");
            String input = scanner.nextLine();
            if (isNumber(input)){    //ha szám, akkor convertNumber:
                return convertNumber(input);
            }
            else {     //minden egyéb esetben pedig:
                if (!forceValidInput) {
                    return null;
                }
                else {
                    System.out.println("This didn't look like a number, try again.");
                }
            }
        }
    }





    public static String askForAnOperator(boolean forceValidInput) {
        // Implement an askForAnOperator(boolean forceValidInput) to return a valid operator. The function continuously asks the user for an operator until the input is valid when forceValidInput is true. When forceValidInput is false and the user input is not a valid operator, the function returns null.


        //askForANumber kódja is ugyanez, egy pici módosítással:

        while(true) {
            System.out.print("Please provide an operator (one of +, -, *, /)! ");
            String operator = scanner.nextLine();
            if (isValidOperator(operator)) {
                return operator;
            } else {
                if (forceValidInput == true) {
                    System.out.println("Unknown operator.");
                } else {
                    return null;
                }
            }
        }

        /*System.out.println(operator);
        return "";*/
    }








    public static Float calc(String op, Float a, Float b) {
        // Implement a calc(String operator, Float a, Float b) to calculate the result of the 'a' 'operator' 'b' operator.
        // The function returns null if any operand or the operator is not valid. The function handles division by zero,
        // in this case the returned value is null

        if(!(isNumber(a.toString()) && isValidOperator(op) && isNumber(b.toString()))){
            return null;
        }
        if(op.equals("/") && b == 0.0f) {
            return null;
        }

        if(op.equals("+")){
            return a+b;
        }
        if(op.equals("-")){
            return a-b;
        }
        if(op.equals("*")){
            return a*b;
        }
        if(op.equals("/")){
            return a/b;
        }
        return null;  //ha lehagyjuk az else ágat, akkor mindenképp legyen return!!! VAGY else ág legyen, és return nem kell
    }


}
