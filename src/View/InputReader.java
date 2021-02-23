package View;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * An object that helps to get input from the user that matches method criteria
 */
public class InputReader {
    private ArrayList<Character> operators;
    private ArrayList<String> values;

    /**
     * Creates a new Input Reader
     * @param input Formula String, in the format "101+10"
     */
    public InputReader(String input){
        operators = new ArrayList<>();
        values = new ArrayList<>();
        input = input.replaceAll("\\s", "");
        String[] sepList = input.split("[-+*/=]");
        for(String x: input.split("")){
            if(x.contains("+")||x.contains("-")||x.contains("*")||x.contains("/")){
                operators.add(x.charAt(0));
            }
        }
        for(String x: sepList){
            values.add(x);
        }
    }

    /**
     * Returns the operators used in the operation
     * @return Returns an array of Characters
     */
    public ArrayList<Character> getOperators(){
        return operators;
    }

    /**
     * Returns the number of an operation.
     * @return Returns an array of Strings
     */
    public ArrayList<String> getValues(){
        return values;
    }

    /**
     * Selects the Data Unit from User Input
     * @return Returns the desired Data Unit5
     */
    public static String fileUnitSelect(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select Unit Type:");
        String instructions = "bits      |1\nkilobits  |2\nmegabits  |3\ngigabits  |4\nterabits  |5\nBytes     |6\nKilobytes |7\nMegabytes |8\n" +
                "Gigabytes |9\nTerabytes |10";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<11){
                functionSelected = true;
            }
            else {
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            return "b";
        }
        else if(functionSelection==2){
            return "kb";
        }
        else if(functionSelection==3){
            return "mb";
        }
        else if(functionSelection==4){
            return "gb";
        }
        else if(functionSelection==5){
            return "tb";
        }
        else if(functionSelection==6){
            return "B";
        }
        else if(functionSelection==7){
            return "KB";
        }
        else if(functionSelection==8){
            return "MB";
        }
        else if(functionSelection==9){
            return "GB";
        }
        else {
            return "TB";
        }
    }

    /**
     * Get a specific String from the user (Not case sensitive)
     * @param instr Instructions for the user
     * @param param Specific Characters that the String must be comprised of.
     * @return Returns the desired String
     */
    public static String protectString(String instr, String param){
        Scanner input = new Scanner(System.in);
        boolean functionSelected = false;
        String functionSelection = "";
        System.out.println(instr);
        while(!functionSelected) {
            functionSelection = input.next().toLowerCase();
            String[] list = functionSelection.split("");
            for (String x: list){
                if(!x.matches(param)){
                    System.out.print((char)27 + "[31m");
                    System.out.println("Bad Input");
                    System.out.print((char)27 + "[34m");
                    System.out.println(instr);
                    functionSelected = false;
                    break;
                }
                else {
                    functionSelected = true;
                }
            }
        }
        return functionSelection;
    }

    /**
     * Gets a specific char from a user
     * @param instr Instructions for the user
     * @param param Specific character to be found
     * @return Returns desired character
     */
    public static char protectChar(String instr, String param){
        Scanner input = new Scanner(System.in);
        boolean functionSelected = false;
        char functionSelection = ' ';
        System.out.println(instr);
        while(!functionSelected) {
            functionSelection = input.next().charAt(0);
            if((functionSelection+"").matches(param)){
                functionSelected = true;
            }
            else {
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println(instr);
            }
        }
        return functionSelection;
    }

    /**
     * Creates a String for Input Reader
     * @return Returns a String for Input Reader
     */
    public String toString(){
        String temp = "";
        for(String x: values){
            temp += x + "";
        }
        for(char y: operators){
            temp += y + "";
        }
        return temp;
    }
}
