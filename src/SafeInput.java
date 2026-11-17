import java.util.Scanner;

public class SafeInput {
   //Part A
    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String retString = "";
        do {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);
        return retString;
    }

    //Part B
    public static int getInt(Scanner pipe, String prompt){
        int retValue = 0;
        String trash = "";
        boolean done = false;
        do{
            System.out.println("\n" + prompt + ":");
            if (pipe.hasNextInt()){
                retValue = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("Invalid input. You must enter an integer not "+ trash);
            }

        }while(!done);
        return retValue;

    }

    //Part C
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("Invalid input. You must enter a number not "+ trash);
            }

        } while (!done);

        return retValue;
    }

    //Part D
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retValue = 0;
        boolean done = false;
        String trash = " ";

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine();

                if (retValue >= low && retValue <= high) {
                    done = true;
                }
                else {
                    System.out.println("Number must be between " + low + " and " + high);
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("Invalid input. Enter a whole number and from the given range not " + trash);
            }

        } while (!done);

        return retValue;
    }

    //Part E
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0;
        String trash = " ";
        boolean done = false;
        do {
            System.out.println("\n" + prompt + "[" + low + " - " + high + "]:");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine();
                if (retValue >= low && retValue <= high) {
                    done = true;
                }
                else{
                    System.out.println("Number must be between " + low + " and " + high);
                }

            }
            else {
                trash = pipe.nextLine();
                System.out.println("You must enter a number not "+ trash);
            }
        } while (!done);
        return retValue;
    }

    //Part F
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean retValue = true;
        boolean done = false;
        String response = "";
        do{
            System.out.println("\n" + prompt + " (Y/N): ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y")){
                retValue = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N")){
                retValue = false;
                done = true;
            }
            else{
                System.out.println("You must enter Y or N");
            }
        }while(!done);
        return retValue;
    }

    //Part G
    public static String getRegExString(Scanner pipe, String prompt, String regexPattern){
        String response = "";
        boolean done = false;
        do{
            System.out.println("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regexPattern)){
                done = true;
            }
            else{
                System.out.println("your input must match "+ regexPattern);
            }
        }while(!done);
        return response;
    }

    //Part 06
    public static void prettyHeader(String msg) {
        int width = 60;
        int insideWidth = width - 6;

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();

        int totalSpaces = insideWidth - msg.length();
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;


        System.out.print("***");
        for (int i = 0; i < leftSpaces; i++) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int i = 0; i < rightSpaces; i++) {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
