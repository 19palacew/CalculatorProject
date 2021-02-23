package View;

import Controller.BinaryCalculator;
import Controller.DecimalCalculator;
import Controller.HexCalculator;
import Model.Bandwidth;
import Model.Binary;
import Model.Decimal;
import Model.Hexadecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Stores Menus for the Calculator
 */
public class Menus {
    /**
     * Binary Functions Menu
     */
    public void binaryMenu(){
        Binary binary;
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m \nBinary to Decimal       |1\nDecimal to Binary       |2\nBinary Calculator       |3" +
                "\nBack:                   |4";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<5){
                functionSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.print((char)27 + "[34m");
            binary = new Binary(InputReader.protectString("Type a Binary String to be converted:", ".*[01].*"));
            BinaryCalculator calc = new BinaryCalculator(binary);
            System.out.println("Converted: " + calc.toDecimal());
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            System.out.println("Type a Number to be converted:");
            while (!input.hasNextLong()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println("Type a Number to be converted:");
            }
            binary = new Binary(input.nextLong());
            System.out.println("Converted: " + binary);
        }
        else if(functionSelection==3){
            binaryCalcMenu();
            /*
            System.out.print((char)27 + "[34m");
            System.out.println("Operations of (+,-,*,/) Are acceptable:");
            Binary num = new Binary(InputReader.protectString("Type a Model.Binary String to be converted:", ".*[01].*"));
            char symbol = InputReader.protectChar("Type an Operation Symbol:", ".*[-+/*].*");
            Binary other = new Binary(InputReader.protectString("Type a Model.Binary String to be converted:", ".*[01].*"));
            num.binaryMath(other, symbol);
            System.out.println("= " + Binary.binaryToDecimal(num));

             */
        }
        else {
            return;
        }
        binaryMenu();
    }

    /**
     * Sub-Menu for Binary addition, subtraction, multiplication, and division
     */
    public void binaryCalcMenu(){
        Binary binary;
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m \nAdd            |1\nSubtract       |2\nMultiply       |3" +
                "\nDivide         |4";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<5){
                functionSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.print((char)27 + "[34m");
            binary = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator calc = new BinaryCalculator(binary);
            Binary other = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator otherCalc = new BinaryCalculator(other);
            System.out.println("Binary: " + binary + " + " + other + " = " + calc.fromDecimal(calc.add(other)));
            System.out.println("Decimal: " + calc.toDecimal() + " + " + otherCalc.toDecimal() + " = " + calc.add(other));
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            binary = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator calc = new BinaryCalculator(binary);
            Binary other = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator otherCalc = new BinaryCalculator(other);
            System.out.println("Binary: " + binary + " - " + other + " = " + calc.fromDecimal(calc.sub(other)));
            System.out.println("Decimal: " + calc.toDecimal() + " - " + otherCalc.toDecimal() + " = " + calc.sub(other));
        }
        else if(functionSelection==3){
            System.out.print((char)27 + "[34m");
            binary = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator calc = new BinaryCalculator(binary);
            Binary other = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator otherCalc = new BinaryCalculator(other);
            System.out.println("Binary: " + binary + " * " + other + " = " + calc.fromDecimal(calc.multi(other)));
            System.out.println("Decimal: " +calc.toDecimal() + " * " + otherCalc.toDecimal() + " = " + calc.multi(other));
        }
        else{
            System.out.print((char)27 + "[34m");
            binary = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator calc = new BinaryCalculator(binary);
            Binary other = new Binary(InputReader.protectString("Type a Binary String:", ".*[01].*"));
            BinaryCalculator otherCalc = new BinaryCalculator(other);
            String[] divSplit = (calc.div(other) + "").split("\\.");
            BinaryCalculator divTransfer = new BinaryCalculator(new Binary());
            System.out.println("Binary: " + binary + " / " + other + " = " + divTransfer.fromDecimal(Long.parseLong(divSplit[0])) + " Remainder: " + divTransfer.fromDecimal(Long.parseLong(divSplit[1])));
            System.out.println("Decimal: " +calc.toDecimal() + " / " + otherCalc.toDecimal() + " = " + calc.div(other));
        }
        binaryMenu();
    }

    /**
     * Hexadecimal Functions Menu
     */
    public void hexadecimalMenu(){
        Hexadecimal hexadecimal;
        Scanner input = new Scanner(System.in);
        final String hexParam = "[0123456789abcdef]";
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m\nHexadecimal to Decimal  |1\nDecimal to Hexadecimal  |2\nHexadecimal Calculator  |3" +
                "\nBack:                   |4";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<5){
                functionSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            hexadecimal = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String to be converted:", hexParam));
            HexCalculator calc = new HexCalculator(hexadecimal);
            System.out.print((char)27 + "[34m");
            System.out.println("Converted: " + calc.toDecimal());
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            System.out.println("Type a Number to be converted:");
            while (!input.hasNextLong()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println("Type a Number to be converted:");
            }
            hexadecimal = new Hexadecimal(input.nextLong());
            System.out.println("Converted: " + hexadecimal);
        }
        else if(functionSelection==3){
            hexCalcMenu();
            /*
            System.out.print((char)27 + "[34m");
            System.out.println("Operations of (+,-,*,/) Are acceptable:");
            Hexadecimal num = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String to be converted:", hexParam));
            char symbol = InputReader.protectChar("Type an Operation Symbol:", ".*[-+/*].*");
            Hexadecimal other = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String to be converted:", hexParam));
            num.hexadecimalMath(other, symbol);
            System.out.println("= " + Hexadecimal.toDecimal(num));

             */
        }
        else {
            return;
        }
        hexadecimalMenu();
    }

    /**
     * Sub-Menu for Hexadecimal addition, subtraction, multiplication, and division
     */
    public void hexCalcMenu(){
        Hexadecimal hexadecimal;
        String hexParam = "[0123456789abcdef]";
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m \nAdd            |1\nSubtract       |2\nMultiply       |3" +
                "\nDivide         |4";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<5){
                functionSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.print((char)27 + "[34m");
            hexadecimal = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator calc = new HexCalculator(hexadecimal);
            Hexadecimal other = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator otherCalc = new HexCalculator(other);
            System.out.println("Hexadecimal: " + hexadecimal + " + " + other + " = " + calc.fromDecimal(calc.add(other)));
            System.out.println("Decimal: " + calc.toDecimal() + " + " + otherCalc.toDecimal() + " = " + calc.add(other));
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            hexadecimal = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator calc = new HexCalculator(hexadecimal);
            Hexadecimal other = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator otherCalc = new HexCalculator(other);
            System.out.println("Hexadecimal: " + hexadecimal + " - " + other + " = " + calc.fromDecimal(calc.sub(other)));
            System.out.println("Decimal: " + calc.toDecimal() + " - " + otherCalc.toDecimal() + " = " + calc.sub(other));
        }
        else if(functionSelection==3){
            System.out.print((char)27 + "[34m");
            hexadecimal = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator calc = new HexCalculator(hexadecimal);
            Hexadecimal other = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator otherCalc = new HexCalculator(other);
            System.out.println("Hexadecimal: " + hexadecimal + " * " + other + " = " + calc.fromDecimal(calc.multi(other)));
            System.out.println("Decimal: " +calc.toDecimal() + " * " + otherCalc.toDecimal() + " = " + calc.multi(other));
        }
        else{
            System.out.print((char)27 + "[34m");
            hexadecimal = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator calc = new HexCalculator(hexadecimal);
            Hexadecimal other = new Hexadecimal(InputReader.protectString("Type a Hexadecimal String:", hexParam));
            HexCalculator otherCalc = new HexCalculator(other);
            String[] divSplit = (calc.div(other) + "").split("\\.");
            HexCalculator divTransfer = new HexCalculator(new Hexadecimal());
            System.out.println("Hexadecimal: " + hexadecimal + " / " + other + " = " + divTransfer.fromDecimal(Long.parseLong(divSplit[0])) + " Remainder: " + divTransfer.fromDecimal(Long.parseLong(divSplit[1])));
            System.out.println("Decimal: " + calc.toDecimal() + " / " + otherCalc.toDecimal() + " = " + calc.div(other));
        }
        hexadecimalMenu();
    }

    /**
     * Bandwidth Functions Menu
     */
    public void bandwidthMenu(){
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m\nData Unit Converter            |1\nDownload Time Calculator       |2\nWebsite Bandwidth Calculator   |3" +
                "\nHosting Bandwidth Converter    |4"+"\nBack:                          |5";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<6){
                functionSelected = true;
            }
            else {
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.print((char)27 + "[34m");
            System.out.println("Enter Value: ");
            while (!input.hasNextBigDecimal()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Numbers Only");
                System.out.print((char)27 + "[34m");
            }
            BigDecimal num = input.nextBigDecimal();
            String unit = InputReader.fileUnitSelect();
            System.out.println(Bandwidth.dataUnitConvert(num,unit,"") + " Terrabytes (TB)");
            System.out.println();
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            System.out.println("Enter File Size Value: ");
            while (!input.hasNextBigInteger()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Numbers Only");
                System.out.print((char)27 + "[34m");
            }
            BigInteger fileSize = input.nextBigInteger();
            String fileUnit = InputReader.fileUnitSelect();
            System.out.println("Enter Bandwidth Value: ");
            while (!input.hasNextBigDecimal()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Numbers Only");
                System.out.print((char)27 + "[34m");
            }
            BigInteger bandSize = input.nextBigInteger();
            String bandUnit = InputReader.fileUnitSelect();
            //System.out.println(fileSize+fileUnit+" "+bandSize+bandUnit);
            System.out.println(Bandwidth.downloadTimeCalc(fileSize,fileUnit,bandSize,bandUnit));
        }
        else if(functionSelection==3){
            System.out.print((char)27 + "[34m");
            String rateInst = "Enter Page Views Rate: \nPer Second        1|\nPer Minute        2|\nPer Hour          3|\nPer Day           4|\nPer Month         5|";
            System.out.println(rateInst);
            boolean rateSelected = false;
            int rateSelection = 0;
            while(!rateSelected) {
                while (!input.hasNextInt()) {
                    input.next();
                    System.out.print((char)27 + "[31m");
                    System.out.println("Bad Input");
                    System.out.print((char)27 + "[34m");
                    System.out.println(rateInst);
                }
                rateSelection = input.nextInt();
                if(rateSelection>0&&rateSelection<6){
                    rateSelected = true;
                }
                else {
                    System.out.print((char)27 + "[31m");
                    System.out.println("Bad Input");
                    System.out.print((char)27 + "[34m");
                    System.out.println(rateInst);
                }
            }
            System.out.println("Enter Page Views: ");
            while (!input.hasNextDouble()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Numbers Only");
                System.out.print((char)27 + "[34m");
            }
            Double pageViews = input.nextDouble();
            System.out.println("Enter Average Page Size: ");
            while (!input.hasNextLong()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Numbers Only");
                System.out.print((char)27 + "[34m");
            }
            long avgPgSize = input.nextLong();
            String pgSizeUnit = InputReader.fileUnitSelect();
            String redunInst = "Enter Redundancy Factor (Must be at least 1): ";
            System.out.println(redunInst);
            boolean redunSelected = false;
            Double redunF = 0.0;
            while(!redunSelected) {
                while (!input.hasNextDouble()) {
                    input.next();
                    System.out.print((char)27 + "[31m");
                    System.out.println("Bad Input");
                    System.out.print((char)27 + "[34m");
                    System.out.println(redunInst);
                }
                redunF = input.nextDouble();
                if(redunF>=1){
                    redunSelected = true;
                }
                else {
                    System.out.print((char)27 + "[31m");
                    System.out.println("Bad Input");
                    System.out.print((char)27 + "[34m");
                    System.out.println(redunInst);
                }
            }
            Bandwidth.websiteBandwidthCalc(pageViews,rateSelection,avgPgSize,pgSizeUnit,redunF);

        }
        else if(functionSelection==4){
            bandwidthHostingSubMenu();
        }
        else {
            return;
        }
        bandwidthMenu();
    }

    /**
     * Submenu for Hosting Bandwidth Calculations
     */
    public void bandwidthHostingSubMenu(){
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m\nGet Rate            |1\nGet Total           |2\nBack:               |3";
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
            if(functionSelection>0&&functionSelection<4){
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
            System.out.print((char)27 + "[34m");
            System.out.println("Enter the monthly usage size");
            while (!input.hasNextInt()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println("Enter the monthly usage size");
            }
            long num = input.nextLong();
            System.out.println("Enter the monthly usage type");
            String monthUseType = InputReader.fileUnitSelect();
            System.out.println("Enter the converted type");
            String bandwidthType = InputReader.fileUnitSelect();
            Bandwidth.hostingBandwidthCalcRate(num,monthUseType,bandwidthType);
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            System.out.println("Enter the bandwidth usage size");
            while (!input.hasNextInt()) {
                input.next();
                System.out.print((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.print((char)27 + "[34m");
                System.out.println("Enter the bandwidth usage size");
            }
            long num = input.nextLong();
            System.out.println("Enter the bandwidth type");
            String bandwidthType = InputReader.fileUnitSelect();
            System.out.println("Enter the converted type");
            String monthUseType = InputReader.fileUnitSelect();
            Bandwidth.hostingBandwidthCalcTotal(num, bandwidthType, monthUseType);
        }
        else {
            return;
        }
        bandwidthHostingSubMenu();
    }

    /**
     * Calculator Menu for Decimal Numbers
     */
    public void decimalMenu(){
        String decimalParam = ".*[-0123456789.].*";
        Decimal decimal;
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m \nAdd            |1\nSubtract       |2\nMultiply       |3" +
                "\nDivide         |4\nBack           |5";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<6){
                functionSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.print((char)27 + "[34m");
            decimal = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator calc = new DecimalCalculator(decimal);
            Decimal other = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator otherCalc = new DecimalCalculator(other);
            //System.out.println("Decimal: " + decimal + " + " + other + " = " + calc.fromDecimal(calc.add(other)));
            System.out.println("Decimal: " + calc.toDouble() + " + " + otherCalc.toDouble() + " = " + calc.addDouble(other));
        }
        else if(functionSelection==2){
            System.out.print((char)27 + "[34m");
            decimal = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator calc = new DecimalCalculator(decimal);
            Decimal other = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator otherCalc = new DecimalCalculator(other);
            //System.out.println("Decimal: " + decimal + " - " + other + " = " + calc.fromDecimal(calc.sub(other)));
            System.out.println("Decimal: " + calc.toDouble() + " - " + otherCalc.toDouble() + " = " + calc.subDouble(other));
        }
        else if(functionSelection==3){
            System.out.print((char)27 + "[34m");
            decimal = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator calc = new DecimalCalculator(decimal);
            Decimal other = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator otherCalc = new DecimalCalculator(other);
            //System.out.println("Decimal: " + decimal + " * " + other + " = " + calc.fromDecimal(calc.multi(other)));
            System.out.println("Decimal: " + calc.toDouble() + " * " + otherCalc.toDouble() + " = " + calc.multiDouble(other));
        }
        else if(functionSelection==4){
            System.out.print((char)27 + "[34m");
            decimal = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator calc = new DecimalCalculator(decimal);
            Decimal other = new Decimal(InputReader.protectString("Type a Decimal String:", decimalParam));
            DecimalCalculator otherCalc = new DecimalCalculator(other);
            String[] divSplit = (calc.divDouble(other) + "").split("\\.");
            DecimalCalculator divTransfer = new DecimalCalculator(new Decimal());
            //System.out.println("Decimal: " + decimal + " / " + other + " = " + divTransfer.fromDecimal(Long.parseLong(divSplit[0])) + " Remainder: " + divTransfer.fromDecimal(Long.parseLong(divSplit[1])));
            System.out.println("Decimal: " + calc.toDouble() + " / " + otherCalc.toDouble() + " = " + calc.divDouble(other));
        }
        else {
            return;
        }
        decimalMenu();
    }

    /**
     * Calculator Menu for Big Integers
     */
    public void bigIntCalc(){
        BigInteger num;
        String bigIntParam = ".*[-0123456789.].*";
        Scanner input = new Scanner(System.in);
        String instructions = ((char)27 + "[33mSelect Your Desired Function:")  + (char)27 + "[39m \nAdd            |1\nSubtract       |2\nMultiply       |3" +
                "\nDivide         |4\nBack           |5";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<6){
                functionSelected = true;
            }
            else {
                System.out.println((char)27 + "[31m");
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            BigInteger other;
            System.out.print((char)27 + "[34m");
            num = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            other = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            System.out.println("BigInteger: " + num + " + " + other + " = " + num.add(other));
        }
        else if(functionSelection==2){
            BigInteger other;
            System.out.print((char)27 + "[34m");
            num = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            other = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            System.out.println("BigInteger: " + num + " - " + other + " = " + num.subtract(other));
        }
        else if(functionSelection==3){
            BigInteger other;
            System.out.print((char)27 + "[34m");
            num = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            other = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            System.out.println("BigInteger: " + num + " * " + other + " = " + num.multiply(other));
        }
        else if(functionSelection==4){
            BigInteger other;
            System.out.print((char)27 + "[34m");
            num = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            other = new BigInteger(InputReader.protectString("Type a BigInteger String:", bigIntParam));
            System.out.println("BigInteger: " + num + " / " + other + " = " + num.divide(other));
        }
        else {
            return;
        }
        bigIntCalc();
    }

    /**
     * Makes a String Yellow
     * @param str String to be yellow
     * @return Returns a yellow String
     */
    public String toYel(String str){
        return ((char)27 + "[33m" + str) + ((char)27 + "[39m");
    }
}
