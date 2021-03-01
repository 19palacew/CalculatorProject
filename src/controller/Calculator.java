package controller;

/**
 * Creates a template for Objects of the Calculator Type
 */
@SuppressWarnings("unused")
public interface Calculator {
    /**
     * Method for adding objects
     * @param other other value that the function uses
     * @return Returns a long of the modified number
     */
    long add(Object other);

    /**
     * Method for subtracting objects
     * @param other other value that the function uses
     * @return Returns a long of the modified number
     */
    long sub(Object other);

    /**
     * Method for multiplying objects
     * @param other other value that the function uses
     * @return Returns a long of the modified number
     */
    long multi(Object other);

    /**
     * Method for dividing objects
     * @param other other value that the function uses
     * @return Returns a double of the modified number
     */
    double div(Object other);

    /**
     * Method for converting from a decimal to a type of number
     * @param num number to be converted
     * @return Returns a String of the converted number
     */
    String fromDecimal(long num);

    /**
     * Method for converting a number to a different type of number
     * @return Returns a long of the converted value
     */
    Long toDecimal();
}
