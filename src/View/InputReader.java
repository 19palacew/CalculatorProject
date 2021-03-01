package View;

import Controller.BinaryCalculator;
import Controller.HexCalculator;
import Model.Binary;
import Model.Hexadecimal;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * An object that helps to get input from the user that matches method criteria
 */
public class InputReader {
    private final ArrayList<Character> operators;
    private final ArrayList<String> values;

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
        JFrame frame = new JFrame();
        while(!functionSelected) {
            frame.setVisible(true);
            //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMER TO DISPLAY");
            functionSelection = JOptionPane.showInputDialog(frame, instr).toLowerCase();
            String[] list = functionSelection.split("");
            for (String x: list){
                if(!x.matches(param)){
                    JOptionPane.showMessageDialog(frame,"Bad Input\n" + instr,"Alert",JOptionPane.WARNING_MESSAGE);
                    functionSelected = false;
                    break;
                }
                else {
                    functionSelected = true;
                }
            }
            frame.setVisible(false);
        }
        frame.setVisible(false);
        return functionSelection;
    }

    public static String protectString(JFrame frame, String instr, String param){
        boolean functionSelected = false;
        String functionSelection = "";
        while(!functionSelected) {
            //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMER TO DISPLAY");
            try {
                functionSelection = JOptionPane.showInputDialog(frame, instr).toLowerCase();
            }
            catch (NullPointerException e){

            }
            String[] list = functionSelection.split("");
            for (String x: list){
                if(!x.matches(param)){
                    JOptionPane.showMessageDialog(frame,"Bad Input\n" + instr,"Alert",JOptionPane.WARNING_MESSAGE);
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

    public static String protectBandUnit(JFrame frame, String instr){
        boolean functionSelected = false;
        String input = "";
        while(!functionSelected) {
            //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMER TO DISPLAY");
            try {
                input = JOptionPane.showInputDialog(frame, instr);
            }
            catch (NullPointerException e){

            }
            try {
                if(input.equals("b")||input.equals("kb")||input.equals("mb")||input.equals("gb")||input.equals("tb")||input.equals("B")||input.equals("KB")
                        ||input.equals("MB")||input.equals("GB")||input.equals("TB")){
                    functionSelected = true;
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Bad Input\n" + instr,"Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
            catch (NullPointerException e){
                functionSelected = true;
                input = "b";
            }
        }
        return input;
    }

    public static int protectDayUnit(JFrame frame, String instr){
        boolean functionSelected = false;
        String input = "";
        while(!functionSelected) {
            //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMER TO DISPLAY");
            try {
                input = JOptionPane.showInputDialog(frame, instr).toLowerCase();
            }
            catch (NullPointerException e){

            }
            try {
                if(input.equals("second")||input.equals("minute")||input.equals("hour")||input.equals("day")||input.equals("week")||input.equals("month")||input.equals("year")){
                    functionSelected = true;
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Bad Input\n" + instr,"Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
            catch (NullPointerException e){
                functionSelected = true;
                input = "b";
            }
        }
        return switch (input) {
            case "minute" -> 2;
            case "hour" -> 3;
            case "day" -> 4;
            case "week" -> 5;
            case "month" -> 6;
            case "year" -> 7;
            default -> 1;
        };
    }

    public static Long protectLong(JFrame frame, String instr, String param, String size){
        boolean functionSelected = false;
        String functionSelection = "0";
        long maxNum = Long.MAX_VALUE;
        if(size.equals("int")){
            maxNum = Integer.MAX_VALUE;
        }
        while(!functionSelected) {
            //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMBER TO DISPLAY");
            try {
                functionSelection = JOptionPane.showInputDialog(frame, instr).toLowerCase();
            }
            catch (NullPointerException e){

            }
            String[] list = functionSelection.split("");
            for (String x: list){
                if(!x.matches(param)||new BigInteger(functionSelection).compareTo(new BigInteger(String.valueOf(maxNum)))>0){
                    JOptionPane.showMessageDialog(frame,"Bad Input or Too Large\n" + instr,"Alert",JOptionPane.WARNING_MESSAGE);
                    functionSelected = false;
                    break;
                }
                else {
                    functionSelected = true;
                }
            }
        }
        return Long.parseLong(functionSelection);
    }

    public static String protectUnit(JFrame frame, String instr, String type, Long size){
        boolean correctSymbols = false;
        boolean withinRange = false;
        String input = "1";
        String param;
        if(type.equals("binary")){
            param = ".*[01].*";
        }
        else if(type.equals("hex")){
            param = "[0123456789abcdef]";
        }
        else{
            param = "[0123456789]";
        }
            while (!correctSymbols||!withinRange) {
                //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMBER TO DISPLAY");
                try {
                    input = JOptionPane.showInputDialog(frame, instr).toLowerCase();
                } catch (NullPointerException e) {

                }
                String[] list = input.split("");
                for (String x : list) {
                    if (!x.matches(param)) {
                        if(!input.equals("")) {
                            JOptionPane.showMessageDialog(frame, "Bad Input\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        correctSymbols = false;
                        break;
                    } else {
                        correctSymbols = true;
                    }
                }
                if(type.equals("binary")&&correctSymbols){
                    //System.out.println(new BinaryCalculator(new Binary(size+"")).fromDecimal(size));
                    if(input.compareTo(new BinaryCalculator(new Binary(size+"")).fromDecimal(size))<=0){
                        withinRange = true;
                    }
                    else {
                        if(correctSymbols){
                            JOptionPane.showMessageDialog(frame, "Too Large\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        correctSymbols = false;
                    }
                }
                else if(type.equals("hex")&&correctSymbols){
                    try {
                        if (new HexCalculator(new Hexadecimal(input)).toDecimal() <= size) {
                            withinRange = true;
                        } else {
                            if (correctSymbols) {
                                JOptionPane.showMessageDialog(frame, "Too Large\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                            }
                            correctSymbols = false;
                        }
                        System.out.println(new HexCalculator(new Hexadecimal(input)).toDecimal());
                    }
                    catch (NumberFormatException e){
                        if (correctSymbols) {
                            JOptionPane.showMessageDialog(frame, "Too Large\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        correctSymbols = false;
                    }
                }
                else if(type.equals("decimal")&&correctSymbols){
                    if(new BigInteger(input).compareTo(new BigInteger(String.valueOf(size)))<=0){
                        withinRange = true;
                    }
                    else {
                        if(correctSymbols){
                            JOptionPane.showMessageDialog(frame, "Too Large\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        correctSymbols = false;
                    }
                }
            }
        return input;
    }

    public static double protectDouble(JFrame frame, String instr) {
        boolean correctSymbols = false;
        boolean withinRange = false;
        String input = "1";
        String param = "[.0123456789]";
        while (!correctSymbols || !withinRange) {
            //String yo = JOptionPane.showInputDialog(null, "INPUT A NUMBER TO DISPLAY");
            try {
                input = JOptionPane.showInputDialog(frame, instr).toLowerCase();
            } catch (NullPointerException e) {

            }
            String[] list = input.split("");
            for (String x : list) {
                if (!x.matches(param)) {
                    if (!input.equals("")) {
                        JOptionPane.showMessageDialog(frame, "Bad Input\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                    correctSymbols = false;
                    break;
                } else {
                    correctSymbols = true;
                }
            }
            if (new BigDecimal(input).compareTo(new BigDecimal(String.valueOf(Double.MAX_VALUE))) <= 0) {
                withinRange = true;
            } else {
                if (correctSymbols) {
                    JOptionPane.showMessageDialog(frame, "Too Large\n" + instr, "Alert", JOptionPane.WARNING_MESSAGE);
                }
                correctSymbols = false;
            }
        }
        return Double.parseDouble(input);
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
