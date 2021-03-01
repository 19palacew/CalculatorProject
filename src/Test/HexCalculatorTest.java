package Test;

import Controller.BinaryCalculator;
import Controller.HexCalculator;
import Model.Binary;
import Model.Hexadecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class HexCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void add(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        long actual = Long.parseLong(hexadecimal, 16) + Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.add(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void sub(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        long actual = Long.parseLong(hexadecimal, 16) - Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.sub(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void multi(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        long actual = Long.parseLong(hexadecimal, 16) * Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.multi(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void div(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        double actual = (double) Long.parseLong(hexadecimal, 16) / (double) Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.div(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 99999999, Long.MAX_VALUE})
    void fromDecimal(long number) {
        HexCalculator hexadecimalCalc = new HexCalculator();
        assertEquals(hexadecimalCalc.fromDecimal(number).toLowerCase(), Long.toHexString(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFFFFFFFFFF"})
    void toDecimal(String hexadecimal) {
        HexCalculator hexadecimalCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        BigInteger num = new BigInteger(hexadecimal + "", 16);
        assertEquals(hexadecimalCalc.toDecimal(), Long.parseLong(num.toString()));
    }
}