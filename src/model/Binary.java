package model;

import controller.BinaryCalculator;

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
    @SuppressWarnings("unused")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Sets the binary String to a new binary String
     * @param value New String to be used
     */
    @SuppressWarnings("unused")
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
}
