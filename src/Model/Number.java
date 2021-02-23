package Model;

/**
 * Abstract Class for Types of Numbers (Binary, Decimal, Hexadecimal)
 */
abstract public class Number {
    protected String value;

    /**
     * Sets the value of the Number to a String
     * @param value The new value to be used
     */
    public abstract void setValue(String value);

    /**
     * Sets the value of the Number to a long
     * @param value The new value to be used
     */
    public abstract void setValue(long value);

    /**
     * Creates a String of the value
     * @return Returns a String of the value
     */
    public abstract String toString();
}
