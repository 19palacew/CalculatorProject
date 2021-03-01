package Test;

import Controller.DecimalCalculator;
import Model.Decimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalCalculatorTest {

    @Test
    void addDecimal() {
        Decimal decimal = new Decimal(1.5);
        Decimal other = new Decimal(2);
        DecimalCalculator calc = new DecimalCalculator(decimal);
        assertEquals(calc.addDouble(other),1.5+2);
    }

    @Test
    void subDecimal() {
        Decimal decimal = new Decimal(1.5);
        Decimal other = new Decimal(2);
        DecimalCalculator calc = new DecimalCalculator(decimal);
        assertEquals(calc.subDouble(other),1.5-2);
    }

    @Test
    void multiDecimal() {
        Decimal decimal = new Decimal(1.5);
        Decimal other = new Decimal(2);
        DecimalCalculator calc = new DecimalCalculator(decimal);
        assertEquals(calc.multiDouble(other),1.5*2);
    }

    @Test
    void divDecimal() {
        Decimal decimal = new Decimal(1.5);
        Decimal other = new Decimal(2);
        DecimalCalculator calc = new DecimalCalculator(decimal);
        assertEquals(calc.divDouble(other),1.5/2);
    }
}
