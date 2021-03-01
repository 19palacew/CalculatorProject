package Controller;

import Model.Bandwidth;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BandwidthCalculator {
    private final Bandwidth bandwidth;
    private static final RoundingMode mode = RoundingMode.HALF_UP;
    private static final int scale = 100;
    private static final long secInMonth = 2592000;
    
    public BandwidthCalculator(){
        bandwidth = new Bandwidth();
    }

    public BandwidthCalculator(Bandwidth bandwidth){
        this.bandwidth = bandwidth;
    }

    public Bandwidth getBandwidth(){
        return bandwidth;
    }
    
    /**
     * Converts units of data
     * @param returnType Desired data unit
     */
    public void dataUnitConvert(String returnType){
        try{
            if(bandwidth.getType().equals(Bandwidth.Type.kb)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.mb)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(2)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.gb)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(3)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.tb)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(4)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.B)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.KB)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.MB)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.GB)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3)));
            }
            else if(bandwidth.getType().equals(Bandwidth.Type.TB)){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4)));
            }
            switch (returnType) {
                case "b":
                    bandwidth.setSize(bandwidth.getSize());
                    break;
                case "kb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L)));
                    break;
                case "mb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(2)));
                    break;
                case "gb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(3)));
                    break;
                case "tb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(4)));
                    break;
                case "B":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)));
                    break;
                case "KB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L)));
                    break;
                case "MB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2)));
                    break;
                case "GB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3)));
                    break;
                case "TB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4)));
                    break;
                    /*)
                default:
                    System.out.println(num + " bits (b)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L)) + " kilobits (kb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(2)) + " megabits (mb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(3)) + " gigabits (gb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(4)) + " terabits (tb)");
                    System.out.println(num.divide(BigDecimal.valueOf(8)) + " Bytes (B)");
                    System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L)) + " Kilobytes (KB)");
                    System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2)) + " Megabytes (MB)");
                    System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3)) + " Gigabytes (GB)");
                    break;
                     */
            }
            //bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4)));
            bandwidth.setType(returnType);
        }
        catch (ArithmeticException e) {
            switch (bandwidth.getType()) {
                case kb -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L)));
                case mb -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(2)));
                case gb -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(3)));
                case tb -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(4)));
                case B -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)));
                case KB -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L)));
                case MB -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2)));
                case GB -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3)));
                case TB -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4)));
            }
            switch (returnType) {
                case "b":
                    bandwidth.setSize(bandwidth.getSize());
                case "kb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L), scale, mode));
                case "mb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(2), scale, mode));
                case "gb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(3), scale, mode));
                case "B":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode));
                case "KB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L), scale, mode));
                case "MB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(2), scale, mode));
                case "GB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(3), scale, mode));
                case "TB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(4), scale, mode));
                    /*
                default:
                    System.out.println(num + " bits (b)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L), scale, mode) + " kilobits (kb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(2), scale, mode) + " megabits (mb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(3), scale, mode) + " gigabits (gb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(4), scale, mode) + " terabits (tb)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode) + " Bytes (B)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L), scale, mode) + " Kilobytes (KB)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(2), scale, mode) + " Megabytes (MB)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(3), scale, mode) + " Gigabytes (GB)");
                    break;
                     */
            }
            bandwidth.setType(returnType);
            //bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(4), scale, mode);
        }
    }
    /*
    try{
            if(getType.equals("kb")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L));
            }
            else if(getType.equals("mb")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(getType.equals("gb")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(getType.equals("tb")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(4));
            }
            else if(getType.equals("B")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8));
            }
            else if(getType.equals("KB")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L));
            }
            else if(getType.equals("MB")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(getType.equals("GB")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(getType.equals("TB")){
                bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4));
            }
            if(returnType.equals("b")){
                bandwidth.setSize(bandwidth.getSize();
            }
            else if(returnType.equals("kb")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L));
            }
            else if(returnType.equals("mb")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(returnType.equals("gb")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(returnType.equals("B")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8));
            }
            else if(returnType.equals("KB")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L));
            }
            else if(returnType.equals("MB")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(returnType.equals("GB")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(returnType.equals("TB")){
                bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4));
            }
            else {
                System.out.println(num + " bits (b)");
                System.out.println(num.divide(BigDecimal.valueOf(1000L)) + " kilobits (kb)");
                System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(2)) + " megabits (mb)");
                System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(3)) + " gigabits (gb)");
                System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(4)) + " terabits (tb)");
                System.out.println(num.divide(BigDecimal.valueOf(8)) + " Bytes (B)");
                System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L)) + " Kilobytes (KB)");
                System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2)) + " Megabytes (MB)");
                System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3)) + " Gigabytes (GB)");
            }
            bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4));
        }
        catch (ArithmeticException e) {
            switch (getType) {
                case "kb" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L));
                case "mb" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(2));
                case "gb" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(3));
                case "tb" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(1000L).pow(4));
                case "B" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8));
                case "KB" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L));
                case "MB" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2));
                case "GB" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3));
                case "TB" -> bandwidth.setSize(bandwidth.getSize().multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4));
            }
            switch (returnType) {
                case "b":
                    bandwidth.setSize(bandwidth.getSize();
                case "kb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L), scale, mode);
                case "mb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(2), scale, mode);
                case "gb":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(1000L).pow(3), scale, mode);
                case "B":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode);
                case "KB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L), scale, mode);
                case "MB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(2), scale, mode);
                case "GB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(3), scale, mode);
                case "TB":
                    bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(4), scale, mode);
                default:
                    System.out.println(num + " bits (b)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L), scale, mode) + " kilobits (kb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(2), scale, mode) + " megabits (mb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(3), scale, mode) + " gigabits (gb)");
                    System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(4), scale, mode) + " terabits (tb)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode) + " Bytes (B)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L), scale, mode) + " Kilobytes (KB)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(2), scale, mode) + " Megabytes (MB)");
                    System.out.println(num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(3), scale, mode) + " Gigabytes (GB)");
                    break;
            }
            bandwidth.setSize(bandwidth.getSize().divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(4), scale, mode);
        }
     */

    /**
     * Calculates the Time needed for downloads and uploads
     * @param availBandwidth
     * @return Returns a String that gives the time for a download/upload
     */
    public String downloadTimeCalc(Bandwidth availBandwidth){
        BigDecimal time;
        dataUnitConvert("b");
        BandwidthCalculator avaBandCalc = new BandwidthCalculator(availBandwidth);
        avaBandCalc.dataUnitConvert("b");
        try {
            time = bandwidth.getSize().divide(availBandwidth.getSize());
        }
        catch (ArithmeticException e){
            time = bandwidth.getSize().divide(availBandwidth.getSize(), scale, mode);
        }
        BigInteger days = new BigInteger("0");
        int hours = 0;
        int minutes = 0;
        double seconds = 0;
        days = time.divide(BigDecimal.valueOf(86400), scale, mode).toBigInteger();
        //hours = time.remainder(BigDecimal.valueOf(86400)).divide(BigDecimal.valueOf(3600),scale, mode).intValue();
        hours = (time.intValue()%86400)/3600;
        //minutes = time.remainder(BigDecimal.valueOf(86400)).remainder(BigDecimal.valueOf(3600)).divide(BigDecimal.valueOf(60),scale, mode).intValue();
        minutes = (time.intValue()%86400)%3600/60;
        //seconds = time.remainder(BigDecimal.valueOf(86400)).remainder(BigDecimal.valueOf(3600)).remainder(BigDecimal.valueOf(60)).intValue();
        seconds = (time.doubleValue()%86400)%3600%60;
        return "Days: " + days + " Hours: " + hours + " Minutes: " + minutes + " Seconds: " + seconds;
    }

    /**
     * Calculates the Model.Bandwidth for a Website
     * @param pgViews Page Views
     * @param pgRate Length of time views occurred
     * @param redunF Redundancy Frequency
     * @return Returns a String
     */
    public String websiteBandwidthCalc(Double pgViews, int pgRate, double redunF){
        String str;
        Bandwidth bandwidthTotal;
        Bandwidth bandwidthRate;
        //long secInMonth = 2628000;
        //long secInMonth = 2592000;
        if(pgRate == 1){
            //Per Second
            pgViews *= secInMonth;
        }
        else if(pgRate == 2){
            //Per Minute
            pgViews *= secInMonth;
            pgViews /= 60;
        }
        else if(pgRate == 3){
            //Per Hour
            pgViews *= secInMonth;
            pgViews /= 60;
            pgViews /= 60;
        }
        else if(pgRate == 4){
            //Per Day
            pgViews *= secInMonth;
            pgViews /= 60;
            pgViews /= 60;
            pgViews /= 24;
        }
        else if(pgRate == 5){
            //Per Week
            pgViews *= secInMonth;
            pgViews /= 60;
            pgViews /= 60;
            pgViews /= 24;
            pgViews /= 30;
            pgViews /= 12;
            pgViews *= 52.143;
        }
        else if(pgRate == 6){
            //Per Month
            pgViews *= secInMonth;
            pgViews /= 60;
            pgViews /= 60;
            pgViews /= 24;
            pgViews /= 30;
        }
        else if(pgRate == 7){
            //Per Year
            pgViews *= secInMonth;
            pgViews /= 60;
            pgViews /= 60;
            pgViews /= 24;
            pgViews /= 30;
            pgViews /= 12;
        }
        Bandwidth.Type standardUnit = Bandwidth.Type.MB;
        dataUnitConvert(standardUnit.toString());
        bandwidthTotal = bandwidth;
        bandwidthTotal.setSize(bandwidthTotal.getSize().multiply(new BigDecimal(pgViews)));
        try{
            bandwidthRate = new Bandwidth(bandwidthTotal.getSize().divide(new BigDecimal(secInMonth)),standardUnit.toString());
        }
        catch (ArithmeticException e) {
            bandwidthRate = new Bandwidth(bandwidthTotal.getSize().divide(new BigDecimal(secInMonth), scale, mode),standardUnit.toString());
        }
        BandwidthCalculator totalCalc = new BandwidthCalculator(bandwidthTotal);
        BandwidthCalculator rateCalc = new BandwidthCalculator(bandwidthRate);
        totalCalc.dataUnitConvert("GB");
        rateCalc.dataUnitConvert("mb");
        //System.out.println("Actual bandwidth needed is "+ bandwidthRate.getSize()
        //        + " Mbits/s \nor " + bandwidthTotal.getSize() +" GB per month.");
        str = "Actual bandwidth needed is "+ bandwidthRate.getSize()
                + " Mbits/s \nor " + bandwidthTotal.getSize() +" GB per month.";
        if(redunF>1){
            bandwidthTotal.setSize(bandwidthTotal.getSize().multiply(BigDecimal.valueOf(redunF)));
            bandwidthRate.setSize(bandwidthRate.getSize().multiply(BigDecimal.valueOf(redunF)));
            //System.out.println("With redundancy factor of 1.3, the bandwidth needed is "+ bandwidthRate.getSize()
            //        + " Mbits/s \nor " + bandwidthTotal.getSize() + " GB per month.");
            str += "\nWith redundancy factor of 1.3, the bandwidth needed is "+ bandwidthRate.getSize()
                            + " Mbits/s \nor " + bandwidthTotal.getSize() + " GB per month.";
        }
        return str;
    }

    /**
     * Calculates the rate of Bandwidth needed for hosting
     * @param bandwidthType Return unit
     * @return Returns a String
     */
    public String hostingBandwidthCalcRate(String bandwidthType){
        BigDecimal monthUse = bandwidth.getSize();
        String monthUseType = bandwidth.getType().toString();
        //Seconds in Month 2628000
        dataUnitConvert(bandwidthType);
        try {
            //num = dataUnitConvert(new BigDecimal(monthUse), monthUseType, bandwidthType).divide(new BigDecimal(secInMonth));
            bandwidth.setSize(bandwidth.getSize().divide(new BigDecimal(secInMonth)));
        }
        catch (ArithmeticException e){
            bandwidth.setSize(bandwidth.getSize().divide(new BigDecimal(secInMonth),scale,mode));
        }
        //dataUnitConvert(monthUseType);
        //System.out.println(monthUse + " " + monthUseType + " per month is equivalent to " + bandwidth.getSize() + " " + bandwidthType + "/s");
        return monthUse + " " + monthUseType + " per month is equivalent to " + bandwidth.getSize() + " " + bandwidthType + "/s";
    }

    /**
     * Calculates the Total amount of data needed for a month of hosting
     * @param monthUseType Return unit
     * @return Returns a String
     */
    public String hostingBandwidthCalcTotal(String monthUseType){
        //Seconds in Month 2628000
        BigDecimal bandwidthSize = bandwidth.getSize();
        String bandwidthType = bandwidth.getType().toString();
        dataUnitConvert(monthUseType);
        bandwidth.setSize(bandwidth.getSize().multiply(new BigDecimal(secInMonth)));
        //System.out.println(bandwidthSize + " " + bandwidthType + "/s is equivalent to " + bandwidth.getSize() + " " + monthUseType + " per month.");
        return bandwidthSize + " " + bandwidthType + "/s is equivalent to " + bandwidth.getSize() + " " + monthUseType + " per month.";
    }
}
