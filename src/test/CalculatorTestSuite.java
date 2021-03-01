package test;


import controller.BandwidthCalculator;
import controller.BinaryCalculator;
import controller.DecimalCalculator;
import controller.HexCalculator;
import model.Bandwidth;
import model.Binary;
import model.Decimal;
import model.Hexadecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
public class CalculatorTestSuite {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1010", "11111111111111111111"})
    void binAdd(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        long actual = Long.parseLong(binary, 2) + Long.parseLong(binary, 2);
        assertEquals(binCalc.add(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1010", "11111111111111111111"})
    void binSub(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        long actual = Long.parseLong(binary, 2) - Long.parseLong(binary, 2);
        assertEquals(binCalc.sub(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1010", "11111111111111111111"})
    void binMulti(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        long actual = Long.parseLong(binary, 2) * Long.parseLong(binary, 2);
        assertEquals(binCalc.multi(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1010", "11111111111111111111"})
    void binDiv(String binary) {
        BinaryCalculator binCalc = new BinaryCalculator(new Binary(binary));
        double actual = (double) Long.parseLong(binary, 2) / (double) Long.parseLong(binary, 2);
        assertEquals(binCalc.div(new Binary(binary)), actual);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 99999999, Long.MAX_VALUE})
    void binFromDecimal(long number) {
        BinaryCalculator binaryCalc = new BinaryCalculator();
        assertEquals(binaryCalc.fromDecimal(number), Long.toBinaryString(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10", "1101010", "111111111111111111111111111111111111111111111111111"})
    void binToDecimal(String binary) {
        BinaryCalculator binaryCalc = new BinaryCalculator(new Binary(binary));
        BigInteger num = new BigInteger(binary + "", 2);
        assertEquals(binaryCalc.toDecimal(), Long.parseLong(num.toString()));
    }
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void hexAdd(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        long actual = Long.parseLong(hexadecimal, 16) + Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.add(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void hexSub(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        long actual = Long.parseLong(hexadecimal, 16) - Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.sub(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void hexMulti(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        long actual = Long.parseLong(hexadecimal, 16) * Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.multi(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFF"})
    void hexDiv(String hexadecimal) {
        HexCalculator binCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        double actual = (double) Long.parseLong(hexadecimal, 16) / (double) Long.parseLong(hexadecimal, 16);
        assertEquals(binCalc.div(new Hexadecimal(hexadecimal)), actual);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 99999999, Long.MAX_VALUE})
    void hexFromDecimal(long number) {
        HexCalculator hexadecimalCalc = new HexCalculator();
        assertEquals(hexadecimalCalc.fromDecimal(number).toLowerCase(), Long.toHexString(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "ad23", "FFFFFFFFFFF"})
    void hextoDecimal(String hexadecimal) {
        HexCalculator hexadecimalCalc = new HexCalculator(new Hexadecimal(hexadecimal));
        BigInteger num = new BigInteger(hexadecimal + "", 16);
        assertEquals(hexadecimalCalc.toDecimal(), Long.parseLong(num.toString()));
    }

    private BandwidthCalculator bandCalc;

    @SuppressWarnings("DuplicatedCode")
    @Test
    void dataUnitConvert() {
        bandCalc = new BandwidthCalculator(new Bandwidth(new BigDecimal("500"),"MB"));
        bandCalc.dataUnitConvert("b");
        assertEquals(bandCalc.getBandwidth()+"","4000000000b");
        bandCalc.dataUnitConvert("kb");
        assertEquals(bandCalc.getBandwidth()+"","4000000kb");
        bandCalc.dataUnitConvert("mb");
        assertEquals(bandCalc.getBandwidth()+"","4000mb");
        bandCalc.dataUnitConvert("gb");
        assertEquals(bandCalc.getBandwidth()+"","4gb");
        bandCalc.dataUnitConvert("tb");
        assertEquals(bandCalc.getBandwidth()+"","0.004tb");
        bandCalc.dataUnitConvert("B");
        assertEquals(bandCalc.getBandwidth()+"","500000000.000B");
        bandCalc.dataUnitConvert("KB");
        assertEquals(bandCalc.getBandwidth()+"","500000.000KB");
        bandCalc.dataUnitConvert("MB");
        assertEquals(bandCalc.getBandwidth()+"","500.000MB");
        bandCalc.dataUnitConvert("GB");
        assertEquals(bandCalc.getBandwidth()+"","0.500GB");
        bandCalc.dataUnitConvert("TB");
        assertEquals(bandCalc.getBandwidth()+"","0.0005TB");
    }

    @Test
    void downloadTimeCalc() {
        bandCalc = new BandwidthCalculator(new Bandwidth(new BigDecimal("500"),"MB"));
        //System.out.println(bandCalc.downloadTimeCalc(new Bandwidth(new BigDecimal("1"),"mb")));
        assertEquals(bandCalc.downloadTimeCalc(new Bandwidth(new BigDecimal("1"),"mb"))+"","Days: 0 Hours: 1 Minutes: 6 Seconds: 40.0");
    }

    @Test
    void websiteBandwidthCalculator() {
        bandCalc = new BandwidthCalculator(new Bandwidth(new BigDecimal("500"),"KB"));
        assertEquals(bandCalc.websiteBandwidthCalc(5000.0,4,2),"Actual bandwidth needed is 0.2314814814814814814814814814814814814814814814814814814814814814814814814814814814814814814814814816 Mbits/s \n" +
                "or 75.0 GB per month.\n" +
                "With redundancy factor of 1.3, the bandwidth needed is 0.46296296296296296296296296296296296296296296296296296296296296296296296296296296296296296296296296320 Mbits/s \n" +
                "or 150.00 GB per month.");
    }

    @Test
    void hostingBandwidthCalcRate() {
        bandCalc = new BandwidthCalculator(new Bandwidth(new BigDecimal("200"),"B"));
        assertEquals(bandCalc.hostingBandwidthCalcRate("gb"),"200 B per month is equivalent to 6.172839506172839506172839506172839506172839506172839506172839506172839506172839506172840E-13 gb/s");
    }
    @Test
    void hostingBandwidthCalcTotal() {
        bandCalc = new BandwidthCalculator(new Bandwidth(new BigDecimal("122"),"b"));
        assertEquals(bandCalc.hostingBandwidthCalcTotal("KB"),"122 b/s is equivalent to 39528.00000 KB per month.");
    }
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
