package test;

import controller.BinaryCalculator;
import model.Binary;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1010", "11111111111111111111"})
    void add(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        long actual = Long.parseLong(binary, 2) + Long.parseLong(binary, 2);
        assertEquals(binCalc.add(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1010", "11111111111111111111"})
    void sub(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        long actual = Long.parseLong(binary, 2) - Long.parseLong(binary, 2);
        assertEquals(binCalc.sub(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1","10", "1010", "11111111111111111111"})
    void multi(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        long actual = Long.parseLong(binary, 2) * Long.parseLong(binary, 2);
        assertEquals(binCalc.multi(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1","10", "1010", "11111111111111111111"})
    void div(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        double actual = (double) Long.parseLong(binary, 2) / (double) Long.parseLong(binary, 2);
        assertEquals(binCalc.div(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 99999999, Long.MAX_VALUE})
    void fromDecimal(long number) {
        BinaryCalculator binaryCalc = new BinaryCalculator();
        assertEquals(binaryCalc.fromDecimal(number), Long.toBinaryString(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10", "1101010", "111111111111111111111111111111111111111111111111111"})
    void toDecimal(String binary) {
        BinaryCalculator binaryCalc = new BinaryCalculator(new Binary(binary));
        BigInteger num = new BigInteger(binary + "", 2);
        assertEquals(binaryCalc.toDecimal(), Long.parseLong(num.toString()));
    }
}