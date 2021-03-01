package model;

/**
 * Stores and Manipulates Decimal Value
 */
@SuppressWarnings("unused")
public class Decimal extends Number{

    /**
     * Creates a new Decimal of value num
     * @param num long value to be used
     */
    public Decimal(long num){
        value = num + "";
    }

    /**
     * Creates a new Decimal of value num
     * @param num double value to be used
     */
    public Decimal(double num){
        value = num + "";
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Sets the current value of Decimal to decimalString
     * @param decimalString New string to be used
     */
    public void setValue(String decimalString){
        this.value = decimalString;
    }

    /**
     * Sets the current value of Decimal to a long num
     * @param num New long to be used
     */
    @SuppressWarnings("unused")
    public void setValue(long num){
        this.value = num + "";
    }

    /**
     * Creates a String of Decimal
     * @return Returns a String of value
     */
    public String toString(){
        return value;
    }
}
