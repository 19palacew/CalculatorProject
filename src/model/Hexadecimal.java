package model;

import controller.HexCalculator;

/**
 * Stores and Manipulates Hexadecimal Value
 */
@SuppressWarnings("unused")
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
        this.value = hexadecimalString.toLowerCase();
    }

    /**
     * Creates a new Hexadecimal with a String of nums decimal size
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
}
