package Model;

import Controller.BinaryCalculator;

/**
 * Stores and Manipulates Binary Value
 */
public class Binary extends Number{

    /**
     * Creates a new Binary of size 0
     */
    public Binary(){
        value = "0";
    }

    /**
     * Creates a new Binary of size binaryString
     * @param binaryString A Binary String to be used
     */
    public Binary(String binaryString){
        this.value = binaryString;
    }

    /**
     * Creates a new Binary of the decimal size of binaryString
     * @param num Decimal number to be converted to binary
     */
    public Binary(long num){
        BinaryCalculator calc = new BinaryCalculator(this);
        this.value = calc.fromDecimal(num);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Sets the binary String to a new binary String
     * @param value New String to be used
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Sets the binary String to a new binary String
     * @param value New String to be used
     */
    public void setValue(long value) {
        BinaryCalculator calc = new BinaryCalculator(this);
        this.value = calc.fromDecimal(value);
    }

    /**
     * Creates a String of the value of Binary
     * @return Returns a String of Binary
     */
    public String toString(){
        return value;
    }

    /**
     * Does Addition, Subtraction, Multiplication, and Division with a Model.Binary Number
     * @param other Other Model.Binary number with which calculations are performed on
     * @param symbol Symbol for type of calculation Ex. (+,-,*,/)
     */
    /*
    public void binaryMath(Binary other, char symbol){
        long num;
        if(symbol == '+'){
            num = binaryToDecimal(toString()) + binaryToDecimal(other.toString());
        }
        else if(symbol == '-'){
            num = binaryToDecimal(toString()) - binaryToDecimal(other.toString());
        }
        else if(symbol == '*'){
            num = binaryToDecimal(toString()) * binaryToDecimal(other.toString());
        }
        else if(symbol == '/'){
            num = binaryToDecimal(toString()) / binaryToDecimal(other.toString());
        }
        else {
            System.out.println("Either does not have a modifier or contains unknown characters");
            return;
        }
        binaryString = Binary.decimalToBinary(num);
    }
     */

    /**
     * Converts a Long to a Model.Binary Sequence up to approaching the Long Max Value
     * @param number Long number for translation
     * @return Returns the decimal as binary
     */
    /*
    public String fromDecimal(BigInteger number) {
        // 256 128 64 32 16 4 2 u
        StringBuilder bin = new StringBuilder();
        if(number.compareTo(new BigInteger("0"))<0){
            bin.append("-");
            number = number.abs();
        }
        int nearPw = 0;
        for(int y = 1; number.compareTo(new BigInteger("2").pow(y))>=0; y++){
            nearPw = y;
        }
        for(int i=nearPw;i>=0;i--){
            if(number.compareTo(new BigInteger("2").pow(i))>=0){
                bin.append("1");
                number = number.subtract(new BigInteger("2").pow(i));
            }
            else {
                bin.append("0");
            }
        }
        return bin.toString();
    }
    */

    /*
    public String fromDecimal(long number) {
        // 256 128 64 32 16 4 2 u
        StringBuilder bin = new StringBuilder();
        if(number<0){
            bin.append("-");
            number = Math.abs(number);
        }
        int nearPw = 0;
        for(int y=1;Math.pow(2,y)<=number;y++){
            nearPw = y;
        }
        for(int i=nearPw;i>=0;i--){
            if(number>=Math.pow(2,i)){
                bin.append("1");
                number -= (long)Math.pow(2,i);
            }
            else {
                bin.append("0");
            }
        }
        return bin.toString();
    }
    */

    /**
     * Converts a Model.Binary String to a Decimal Long
     * @return Returns the binary as a decimal
     */
    /*
    public Long toDecimal(){
        StringBuilder bin = new StringBuilder();
        long number = 0;
        String[] sepList = binaryString.split("");
        for(int i=binaryString.length()-1;i>=0;i--){
            bin.append(sepList[i]);
        }
        sepList = bin.toString().split("");
        if(sepList[0].equals("1")){
            number++;
        }
        for(int x=1;x<sepList.length;x++){
            if(sepList[x].equals("1")){
                number+=Math.pow(2,x);
            }
        }
        return number;
    }
     */

    /*
    public Long toDecimal(Binary binary){
        StringBuilder bin = new StringBuilder();
        long number = 0;
        String binaryString = binary.toString();
        String[] sepList = binaryString.split("");
        for(int i=binaryString.length()-1;i>=0;i--){
            bin.append(sepList[i]);
        }
        sepList = bin.toString().split("");
        if(sepList[0].equals("1")){
            number++;
        }
        for(int x=1;x<sepList.length;x++){
            if(sepList[x].equals("1")){
                number+=Math.pow(2,x);
            }
        }
        return number;
    }
     */
}
