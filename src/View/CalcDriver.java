package View;

import Controller.BinaryCalculator;

import Model.Bandwidth;
import Model.Binary;
import Model.Hexadecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Calculator for Model.Binary, Model.Hexadecimal, and various other calculations
 * @author Winston Palace
 * @version 1/16/21
 */
public class CalcDriver {
    /*
        Calculator functions:
        Model.Binary - Add, Subtract, Multiply, and Divide. Convert Model.Binary to Decimal Value.
        Hex - Add, Subtract, Multiply, and Divide. Convert Model.Hexadecimal Value to Decimal Value.
            Convert Decimal Value to Model.Hexadecimal Value.
        Model.Bandwidth - Data Unit Converter, Download/Upload Time Calculator, Website Model.Bandwidth Calculator,
            and Hosting Model.Bandwidth Calculator.
    */

    //Currently Limited to Long sizes

    /**
     * Driver method for PRGA Calculator Project
     * @param args used for command line input
     */
    public static void main(String[] args) {
        //+~~~~~~+~~~~~~+~~~~~~~~~~~+
        //|  fg  |  bg  |  color    |
        //+~~~~~~+~~~~~~+~~~~~~~~~~~+
        //|  30  |  40  |  black    |
        //|  31  |  41  |  red      |
        //|  32  |  42  |  green    |
        //|  33  |  43  |  yellow   |
        //|  34  |  44  |  blue     |
        //|  35  |  45  |  magenta  |
        //|  36  |  46  |  cyan     |
        //|  37  |  47  |  white    |
        //|  39  |  49  |  default  |
        //+~~~~~~+~~~~~~+~~~~~~~~~~~+
        //System.out.println((char)27 + "[33mYELLOW");
        //System.out.println((char)27 + "[31m");
        menu();
    }

    /**
     * Main Menu
     */
    public static void menu(){
        Menus menu = new Menus();
        Scanner input = new Scanner(System.in);
        String instructions = (char)27 + "[33mSelect Your Desired Calculator:" + (char)27 + "[39m\nBinary Calculator       |1\nHexadecimal Calculator  |2\nBandwidth Calculator    |3" +
                "\nDecimal Calculator      |4\nBig Integer Calculator  |5\nTesting                 |6\nExit:                   |7";
        System.out.println(instructions);
        boolean calcSelected = false;
        int calcSelection = 0;
        while(!calcSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            calcSelection = input.nextInt();
            if(calcSelection>0&&calcSelection<8){
                calcSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(calcSelection==1){
            menu.binaryMenu();
        }
        else if(calcSelection==2){
            menu.hexadecimalMenu();
        }
        else if(calcSelection==3){
            menu.bandwidthMenu();
        }
        else if(calcSelection==4){
            menu.decimalMenu();
        }
        else if(calcSelection==5){
            menu.bigIntCalc();
        }
        else if(calcSelection==6){
            testCase();
        }
        else {
            return;
        }
        menu();
    }

    /**
     * Prints Test Cases for all conversion and mathematical methods
     */
    public static void testCase(){
        /*
        final long TEST_NUMBER = 100L;
        final String TEST_BINARY = "01100100";
        final String TEST_HEXADECIMAL = "64";
        System.out.println(toYel("Decimal to Model.Binary Converter:"));
        System.out.println("Number: " + TEST_NUMBER + " Converted: " + Binary.decimalToBinary(new BigInteger(String.valueOf(TEST_NUMBER))) + " Expected: 1100100");
        System.out.println();

        System.out.println(toYel("Model.Binary to Decimal Converter:"));
        System.out.println("Model.Binary: " + TEST_BINARY + " Converted: " + Binary.binaryToDecimal(TEST_BINARY) + " Expected: 100");
        System.out.println();

        System.out.println(toYel("Model.Binary Calculator:"));
        Binary binNum = new Binary(TEST_BINARY);
        binNum.binaryMath(new Binary(TEST_BINARY),'+');
        System.out.println("Input: 01100100 + 01100100 Output: " + Binary.binaryToDecimal(binNum) + " Expected: 200");
        System.out.println();

        System.out.println(toYel("Decimal to Model.Hexadecimal Converter:"));
        System.out.println("Number: " + TEST_NUMBER + " Converted: " + Hexadecimal.decimalToHexadecimal(TEST_NUMBER) + " Expected: 64");
        System.out.println();

        System.out.println(toYel("Model.Hexadecimal to Decimal Converter:"));
        System.out.println("Model.Hexadecimal: " + TEST_HEXADECIMAL + " Converted: " + Hexadecimal.hexadecimalToDecimal(TEST_HEXADECIMAL) + " Expected: 100");
        System.out.println();

        System.out.println(toYel("Model.Hexadecimal Calculator:"));
        Hexadecimal hexNum = new Hexadecimal(TEST_HEXADECIMAL);
        hexNum.hexadecimalMath(new Hexadecimal((TEST_HEXADECIMAL)),'+');
        System.out.println("Input: 64 + 64 Output: " + Hexadecimal.hexadecimalToDecimal(hexNum) + " Expected: 200");
        System.out.println();

        System.out.println(toYel("Data Unit Converter:"));
        System.out.println("Actual:");
        System.out.println("Amount of Data: 500 Data Unit: Megabytes (MB) ");
        System.out.println(Bandwidth.dataUnitConvert(BigDecimal.valueOf(500),"MB","") + " Terrabytes (TB)");
        System.out.println();
        System.out.println("Expected:\n4000000000 bits (b)\n" +
                "4000000 kilobits (kb)\n" +
                "4000 megabits (mb)\n" +
                "4 gigabits (gb)\n" +
                "0.004 terabits (tb)\n" +
                "500000000 Bytes (B)\n" +
                "500000 Kilobytes (KB)\n" +
                "0.5 Gigabytes (GB)\n" +
                "0.0005 Terabytes (TB)");
        System.out.println();

        System.out.println(toYel("Download/Upload Time Calculator:"));
        System.out.println("File Size: 123MB Model.Bandwidth: 12 Mbit/s\nActual:");
        System.out.println(Bandwidth.downloadTimeCalc(BigInteger.valueOf(123),"MB",BigInteger.valueOf(12),"mb"));
        System.out.println("Expected:\nDays: 0 Hours: 0 Minutes: 1 Seconds: 22");
        System.out.println();

        System.out.println(toYel("Website Bandweidth Calculator") + "\nPage Views: 12 view/Day Average Page Size: 15 Megabyte Redundancy Factor: 1.3\nExpected: ");
        Bandwidth.websiteBandwidthCalc(12.0,4,15,"MB",1.3);
        System.out.println("Actual: \nActual bandwidth needed is 0.016666666666667 Mbits/s or 5.47875 GB per month.\n" +
                "With redundancy factor of 1.3, the bandwidth needed is 0.021666666666667 Mbits/s or 7.122375 GB per month.");
        System.out.println();

        System.out.println(toYel("Hosting Model.Bandwidth Converter:"));
        System.out.println("Rate[123 GB Monthy Use to Mbit/s] \nActual:");
        Bandwidth.hostingBandwidthCalcRate(123,"GB","mb");
        System.out.println("Expected:");
        System.out.println("123 Gigabytes (GB) per month is equivalent to 0.37417294090805 Mbit/s.");
        System.out.println();
        System.out.println("Total[12 Mbit/s to GB (monthly)]:\nActual");
        Bandwidth.hostingBandwidthCalcTotal(12,"mb","GB");
        System.out.println("12 Mbit/s is equivalent to 3944.7 Gigabytes (GB) per month.");
        System.out.println();
         */
    }
}
