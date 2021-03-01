package Test;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigIntCalculatorTest {

    @Test
    void addBigInteger() {
        assertEquals(new BigInteger("12").add(new BigInteger("34"))+"",12+34+"");
    }

    @Test
    void subBigInteger() {
        assertEquals(new BigInteger("12").subtract(new BigInteger("34"))+"",12-34+"");
    }

    @Test
    void multiBigInteger() {
        assertEquals(new BigInteger("12").multiply(new BigInteger("34"))+"",12*34+"");
    }

    @Test
    void divBigInteger() {
        assertEquals(new BigInteger("12").divide(new BigInteger("34"))+"",12/34+"");
    }
}