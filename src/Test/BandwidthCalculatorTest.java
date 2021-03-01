package Test;

import Controller.BandwidthCalculator;
import Controller.BinaryCalculator;
import Model.Bandwidth;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BandwidthCalculatorTest {
    private BandwidthCalculator bandCalc;

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
}