package controller;

import model.Hexadecimal;

import java.math.BigInteger;

/**
 * Modifies Hexadecimal with various mathematical functions and conversions
 */
public class HexCalculator implements Calculator{
    private final Hexadecimal hexadecimal;

    /**
     * Creates a new HexCalculation with the default value of hexadecimal
     */
    public HexCalculator(){
        hexadecimal = new Hexadecimal();
    }

    /**
     * Creates a new HexCalculation with a value of hexadecimal
     * @param hexadecimal New Hexadecimal value to be used
     */
    public HexCalculator(Hexadecimal hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    /**
     * Adds a new Hexadecimal to the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public long add(Object other) {
        return toDecimal() + new HexCalculator((Hexadecimal)other).toDecimal();
    }

    /**
     * Subtracts a new Hexadecimal from the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public long sub(Object other) {
        return toDecimal() - new HexCalculator((Hexadecimal)other).toDecimal();
    }

    /**
     * Multiplies a new Hexadecimal by the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public long multi(Object other) {
        return toDecimal() * new HexCalculator((Hexadecimal)other).toDecimal();
    }

    /**
     * Divides a new Hexadecimal by the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public double div(Object other) {
        return ((double)toDecimal())/new HexCalculator((Hexadecimal)other).toDecimal();
    }

    // Simplification of operations for fromDecimal
    private BigInteger comp(int pow, String val){
        return new BigInteger("16").pow(pow).multiply(new BigInteger(val));
    }

    /**
     * Converts a Long to a Model.Hexadecimal Sequence up to approaching the Long Max Value
     * @param number Long number for translation
     * @return Returns the decimal as a hexadecimal
     */
    public String fromDecimal(long number){
        BigInteger num = new BigInteger(String.valueOf(number));
        StringBuilder hex = new StringBuilder();
        if(num.compareTo(new BigInteger("0"))<0){
            hex.append("-");
            num = num.abs();
        }
        int nearPw = 0;
        for(int y = 1; num.compareTo(new BigInteger("16").pow(y))>=0; y++){
            nearPw = y;
        }
        for(int i=nearPw;i>=0;i--){
            if(num.compareTo(comp(i,"15"))>=0){
                hex.append("F");
                num = num.subtract(comp(i,"15"));
            }
            else if(num.compareTo(comp(i,"14"))>=0){
                hex.append("E");
                num = num.subtract(comp(i,"14"));
            }
            else if(num.compareTo(comp(i,"13"))>=0){
                hex.append("D");
                num = num.subtract(comp(i,"13"));
            }
            else if(num.compareTo(comp(i,"12"))>=0){
                hex.append("C");
                num = num.subtract(comp(i,"12"));
            }
            else if(num.compareTo(comp(i,"11"))>=0){
                hex.append("B");
                num = num.subtract(comp(i,"11"));
            }
            else if(num.compareTo(comp(i,"10"))>=0){
                hex.append("A");
                num = num.subtract(comp(i,"10"));
            }
            else if(num.compareTo(comp(i,"9"))>=0){
                hex.append("9");
                num = num.subtract(comp(i,"9"));
            }
            else if(num.compareTo(comp(i,"8"))>=0){
                hex.append("8");
                num = num.subtract(comp(i,"8"));
            }
            else if(num.compareTo(comp(i,"7"))>=0){
                hex.append("7");
                num = num.subtract(comp(i,"7"));
            }
            else if(num.compareTo(comp(i,"6"))>=0){
                hex.append("6");
                num = num.subtract(comp(i,"6"));
            }
            else if(num.compareTo(comp(i,"5"))>=0){
                hex.append("5");
                num = num.subtract(comp(i,"5"));
            }
            else if(num.compareTo(comp(i,"4"))>=0){
                hex.append("4");
                num = num.subtract(comp(i,"4"));
            }
            else if(num.compareTo(comp(i,"3"))>=0){
                hex.append("3");
                num = num.subtract(comp(i,"3"));
            }
            else if(num.compareTo(comp(i,"2"))>=0){
                hex.append("2");
                num = num.subtract(comp(i,"2"));
            }
            else if(num.compareTo(comp(i,"1"))>=0){
                hex.append("1");
                num = num.subtract(comp(i,"1"));
            }
            else {
                hex.append("0");
            }
        }
        return hex.toString();
    }

    /**
     * Converts a Model.Hexadecimal String to a Decimal Long
     * @return Returns the hexadecimal as a decimal
     */
    public Long toDecimal(){
        BigInteger num = new BigInteger("0");
        String hexString = hexadecimal.toString();
        String[] hexList = hexString.split("");
        int x = 0;
        if(!hexString.matches(".*[0123456789abcdef].*")){
            return 0L;
        }
        for(int i=hexList.length-1;i>=0;i--){
            if(hexList[i].equalsIgnoreCase("a")){
                hexList[i] = "10";
            }
            else if(hexList[i].equalsIgnoreCase("b")){
                hexList[i] = "11";
            }
            else if(hexList[i].equalsIgnoreCase("c")){
                hexList[i] = "12";
            }
            else if(hexList[i].equalsIgnoreCase("d")){
                hexList[i] = "13";
            }
            else if(hexList[i].equalsIgnoreCase("e")){
                hexList[i] = "14";
            }
            else if(hexList[i].equalsIgnoreCase("f")){
                hexList[i] = "15";
            }
            //num += Long.parseLong(hexList[i])*Math.pow(16,x);
            num = num.add(new BigInteger(hexList[i]).multiply(new BigInteger("16").pow(x)));
            x++;
        }
        return Long.parseLong(num.toString());
    }
}
