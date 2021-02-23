package Controller;

import Model.Decimal;

/**
 * Modifies Decimals with various mathematical functions and conversions
 */
public class DecimalCalculator implements Calculator{
    private Decimal decimal;

    /**
     * Creates a new Decimal Calculator of the value decimal
     * @param decimal The value of the new Decimal
     */
    public DecimalCalculator(Decimal decimal) {
        this.decimal = decimal;
    }

    /**
     * Adds a new Decimal to the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public long add(Object other) {
        return toDecimal() + new DecimalCalculator((Decimal)other).toDecimal();
    }

    /**
     * Subtracts a new Decimal from the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public long sub(Object other) {
        return toDecimal() - new DecimalCalculator((Decimal)other).toDecimal();
    }

    /**
     * Multiplies a new Decimal by the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public long multi(Object other) {
        return toDecimal() * new DecimalCalculator((Decimal)other).toDecimal();
    }

    /**
     * Divides a new Decimal by the current value
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public double div(Object other) {
        return ((double)toDecimal())/new DecimalCalculator((Decimal)other).toDecimal();
    }

    /**
     * Adds a new Decimal to the current value (with decimal places)
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public double addDouble(Object other) {
        return toDouble() + new DecimalCalculator((Decimal)other).toDouble();
    }

    /**
     * Subtracts a new Decimal from the current value (with decimal places)
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public double subDouble(Object other) {
        return toDouble() - new DecimalCalculator((Decimal)other).toDouble();
    }

    /**
     * Multiplies a new Decimal by the current value (with decimal places)
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public double multiDouble(Object other) {
        return toDouble() * new DecimalCalculator((Decimal)other).toDouble();
    }

    /**
     * Divides a new Decimal by the current value (with decimal places)
     * @param other Other value that the function uses
     * @return Returns the modified number
     */
    public double divDouble(Object other) {
        return toDouble()/new DecimalCalculator((Decimal)other).toDouble();
    }


    /**
     * Converts a Long to a Decimal Sequence up to approaching the Long Max Value
     * @param number Long number for translation
     * @return Returns the decimal as a Decimal
     */
    public String fromDecimal(long number){
        return number + "";
    }

    /**
     * Converts a Decimal String to a Decimal Long
     * @return Returns the decimal as a decimal
     */
    public Long toDecimal(){
        return Long.parseLong(decimal.toString());
    }

    /**
     * Converts a Decimal String to a Decimal Double
     * @return Returns the decimal as a decimal
     */
    public double toDouble(){
        return Double.parseDouble(decimal.toString());
    }
}
