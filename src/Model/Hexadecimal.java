package Model;

import Controller.HexCalculator;

/**
 * Stores and Manipulates Hexadecimal Value
 */
public class Hexadecimal extends Number{
    /**
     * Creates a new Hexadecimal of size 0
     */
    public Hexadecimal(){
        value = "0";
    }

    /**
     * Creates a new Hexadecimal with a String of hexadecimalString
     * @param hexadecimalString New String of hexadecimal value
     */
    public Hexadecimal(String hexadecimalString){
        this.value = hexadecimalString;
    }

    /**
     * Creates a new Hexadecimal with a String of num's decimal size
     * @param num Decimal number to be translated and stored as a Model.Hexadecimal String
     */
    public Hexadecimal(long num){
        HexCalculator calc = new HexCalculator(this);
        value = calc.fromDecimal(num);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------
    // Constructor/Method Separator

    /**
     * Sets the current Hexadecimal String to a new Hexadecimal String
     * @param hexadecimalString New Hexadecimal String to be used
     */
    public void setValue(String hexadecimalString){
        this.value = hexadecimalString;
    }

    /**
     * Sets the current Hexadecimal String to a new Hexadecimal String
     * @param num New long to be used
     */
    public void setValue(long num){
        HexCalculator calc = new HexCalculator(this);
        this.value = calc.fromDecimal(num);
    }

    /**
     * Returns a String of Hexadecimal
     * @return Makes a String of the Hexadecimal number
     */
    public String toString(){
        return value;
    }

    /**
     * Does Addition, Subtraction, Multiplication, and Division with a Hexadecimal Number
     * @param other Other Hexadecimal number with which calculations are performed on
     * @param symbol Symbol for type of calculation Ex. (+,-,*,/)
     */
    /*
    public void hexadecimalMath(Hexadecimal other, char symbol){
        long num;
        if(symbol == '+'){
            num = hexadecimalToDecimal(toString()) + hexadecimalToDecimal(other.toString());
        }
        else if(symbol == '-'){
            num = hexadecimalToDecimal(toString()) - hexadecimalToDecimal(other.toString());
        }
        else if(symbol == '*'){
            num = hexadecimalToDecimal(toString()) * hexadecimalToDecimal(other.toString());
        }
        else if(symbol == '/'){
            num = hexadecimalToDecimal(toString()) / hexadecimalToDecimal(other.toString());
        }
        else {
            System.out.println("Either does not have a modifier or contains unknown characters");
            return;
        }
        hexadecimalString = Hexadecimal.decimalToHexadecimal(num);
    }

     */

    /**
     * Converts a Long to a Model.Hexadecimal Sequence up to approaching the Long Max Value
     * @param number Long number for translation
     * @return Returns the deciaml as a hexadeciaml
     */
    /*
    public String fromDecimal(long number){
        StringBuilder hex = new StringBuilder();
        int nearPw = 0;
        if(number<0){
            hex.append("-");
            number = Math.abs(number);
        }
        for(int y=1;Math.pow(16,y)<=number;y++){
            nearPw = y;
        }
        for(int i=nearPw;i>=0;i--){
            if(number>=Math.pow(16,i)*15){
                hex.append("F");
                number -= Math.pow(16,i)*15;
            }
            else if(number>=Math.pow(16,i)*14){
                hex.append("E");
                number -= Math.pow(16,i)*14;
            }
            else if(number>=Math.pow(16,i)*13){
                hex.append("D");
                number -= Math.pow(16,i)*13;
            }
            else if(number>=Math.pow(16,i)*12){
                hex.append("C");
                number -= Math.pow(16,i)*12;
            }
            else if(number>=Math.pow(16,i)*11){
                hex.append("B");
                number -= Math.pow(16,i)*11;
            }
            else if(number>=Math.pow(16,i)*10){
                hex.append("A");
                number -= Math.pow(16,i)*10;
            }
            else if(number>=Math.pow(16,i)*9){
                hex.append("9");
                number -= Math.pow(16,i)*9;
            }
            else if(number>=Math.pow(16,i)*8){
                hex.append("8");
                number -= Math.pow(16,i)*8;
            }
            else if(number>=Math.pow(16,i)*7){
                hex.append("7");
                number -= Math.pow(16,i)*7;
            }
            else if(number>=Math.pow(16,i)*6){
                hex.append("6");
                number -= Math.pow(16,i)*6;
            }
            else if(number>=Math.pow(16,i)*5){
                hex.append("5");
                number -= Math.pow(16,i)*5;
            }
            else if(number>=Math.pow(16,i)*4){
                hex.append("4");
                number -= Math.pow(16,i)*4;
            }
            else if(number>=Math.pow(16,i)*3){
                hex.append("3");
                number -= Math.pow(16,i)*3;
            }
            else if(number>=Math.pow(16,i)*2){
                hex.append("2");
                number -= Math.pow(16,i)*2;
            }
            else if(number>=Math.pow(16,i)*1){
                hex.append("1");
                number -= Math.pow(16,i)*1;
            }
            else {
                hex.append("0");
            }
        }
        return hex.toString();
    }

     */

    /**
     * Converts a Model.Hexadecimal String to a Decimal Long
     * @return Returns the hexadecimal as a decimal
     */
    /*
    public Long toDecimal(){
        long num = 0;
        String[] hexList = value.split("");
        int x = 0;
        if(!value.toString().matches(".*[0123456789abcdef].*")){
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
            num += Long.parseLong(hexList[i])*Math.pow(16,x);
            x++;
        }
        return num;
    }
     */
}
