package Model;

/**
 * Stores and Manipulates Decimal Value
 */
public class Decimal extends Number{

    /**
     * Creates a new Decimal of size 0
     */
    public Decimal(){
        value = "0";
    }

    /**
     * Creates a new Decimal with a String of decimal String
     * @param decimalString New String of decimalString value
     */
    public Decimal(String decimalString){
        this.value = decimalString;
    }

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
    public void setValue(long num){
        this.value = num + "";
    }

    /**
     * Sets the current value of Decimal to a double num
     * @param num New double to be used
     */
    public void setValue(double num){
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
