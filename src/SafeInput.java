
import java.util.Scanner;

/**
 *
 * @author wulft
 */
public class SafeInput 
{
    //* Get a String which contains at least one character
    //* @param - pipe a Scanner opened to read from System.in
    //* @param - prompt prompt for the user
    //* @return - a String response that is not zero length
    public static  String getNonZeroLenString(scanner pipe, String prompt)
    {
        String retString = "";
        do
            {
                System.out.println("\n" + prompt + ": ");
                retString = pipe.nextLine();
            } while (retString.length() == 0); //until we have some characters

        return retString;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    //* Get an int value within a specified numeric range
    //* @param pipe - Scanner instance to read the data System.in in most cases
    //* @param prompt - input prompt msg should not include range info
    //* @param low - low end of inclusive range
    //* @param high - high end of the inclusive range
    //* @return - int value within the inclusive range
    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi)
    {
        int result = 0;
        boolean done = false;
        String trash = "";
        do
        {            
            // Code and control logic to loop until validated
            System.out.print(prompt + "[" + lo + " - " + hi + "]: ");
            if(pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine(); // clear input buffer
                if(result >= lo && result <= hi)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + lo + " - " + hi + "]: " + result);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must entedr an int [" + lo + " - " + hi + "]: " + trash);
            }
       
        }while(!done);
        
        return result;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
//    * get a double value within an inclusive range
//    * @param pipe - Scanner instance to read the data System.in in most cases
//    * @param prompt - input prompt msg should not contain range info
//     * @param low - low value inclusive
//     * @Param high - high value inclusive
//     * @return - double value within the specified inclusive range
    public static int getInt(Scanner pipe, String Prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.println("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);
        return  retVal;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    //* @param pipe - Scanner instance to read the data System.in in most cases
    //* @param prompt - input prompt msg should not contain range info
    //* @return - an unconstrainted double value
    public static int getRangedDouble(Scanner pipe, String prompt, int low, int high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            // Code and control logic to loop until validated
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear input buffer
                if(retVal >= lo && retVal <= hi)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an double " + trash);
            }
        }while(!done);
        return retVal;
    }
    //////////////////////////////////////////////////////////////////////////
    //* @param pipe - Scanner instance to read the data System.in in most cases
    //* @param prompt - input prompt msg should not contain range info
    //* @return - an unconstrainted double value
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.println("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);
        return  retVal;
    }
    ////////////////////////////////////////////////////////////////////////
    //Get a [Y/N] confirmation from the user
    //* @param pipe - Scanner instance to read the data System.in in most cases
    //* @param prompt - input prompt msg for user does not need [Y/N]
    //* @return - true for yes false for no
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.println("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
                {
                    gotAVal = true;
                    retVal = true;
                }
            else if(response.equalsIgnoreCase("N"))
                {
                    gotAVal = true;
                    retVal = true;
                }
            else
                {
                    System.out.println("You must answer [Y/N]! " + response);
                }
        }while(!gotAVal);
        return retVal;
    }
    //////////////////////////////////////////////////////////////////////////////////////
    //* Get a string that matches a RegEx pattern! This is a very powerful method
    //* @param pipe - Scanner instance to read the data System.in in most cases
    //* @param prompt - prompt for user
    //* @param regExPattern - java style RegEx pattern to constrain the input
    //* @return a String that matches the RegEx pattern supplied
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.println("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matche(regExPattern))
                {
                    gotAVal = true;
                }
            else
                {
                    System.out.println("\n" + response + " must match the pattern " + regExPattern);
                    System.out.println("Try again!");
                }
        }while(!gotAVal);
        return response;
    }
}
