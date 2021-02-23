package Controller;

import Model.Binary;

/**
 * Modifies Binary with various mathematical functions and conversions
 */
public class BinaryCalculator implements Calculator{
    private Binary binary;

    /**
     * Creates a new BinaryCalculator with a value of binary
     * @param binary New value to be used
     */
    public BinaryCalculator(Binary binary) {
        this.binary = binary;
    }

    /**
     * Adds a new Binary to the current value
     * @param other Other value that the function uses
     * @return Returns a long of the modified number
     */
    public long add(Object other) {
        return toDecimal() + new BinaryCalculator((Binary)other).toDecimal();
    }

    /**
     * Subtracts a new Binary from the current value
     * @param other Other value that the function uses
     * @return Returns a long of the modified number
     */
    public long sub(Object other) {
        return toDecimal() - new BinaryCalculator((Binary)other).toDecimal();
    }

    /**
     * Multiplies a new Binary by the current value
     * @param other Other value that the function uses
     * @return Returns a long of the modified number
     */
    public long multi(Object other) {
        return toDecimal() * new BinaryCalculator((Binary)other).toDecimal();
    }

    /**
     * Divides a new Binary by the current value
     * @param other Other value that the function uses
     * @return Returns a double of the modified number
     */
    public double div(Object other) {
        return ((double)toDecimal())/new BinaryCalculator((Binary)other).toDecimal();
    }

    /**
     * Converts a long into a Binary String
     * @param number number to be converted
     * @return Returns a String of binary
     */
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

    /**
    * Converts a Model.Binary String to a Decimal Long
    * @return Returns the binary as a decimal
    */
    public Long toDecimal(){
        String binaryString = binary.toString();
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
}
