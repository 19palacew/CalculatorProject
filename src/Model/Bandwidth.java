package Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Stores and Manipulates Data, specifically it's numerical size and its size category or "type"
 */
public class Bandwidth {
    private BigDecimal size;
    private String type;
    private static final RoundingMode mode = RoundingMode.HALF_UP;
    private static final int scale = 100;
    private static final long secInMonth = 2592000;

    /**
     * Creates a new Bandwidth of 0 size of the type bit
     */
    public Bandwidth(){
        size = new BigDecimal("0");
        type = "b";
    }

    /**
     * Creates a new Bandwidth of size and type
     * @param size Numerical size of data
     * @param type Size type, (Ex. bits, Bytes, Megabytes)
     */
    public Bandwidth(BigDecimal size, String type){
        this.size = size;
        this.type = type;
    }

    /**
     * Sets the size and type of the data
     * @param size Numerical size of date
     * @param type Size type, (Ex. bits, Bytes, Megabytes)
     */
    public void setSize(BigDecimal size, String type){
        this.size = size;
        this.type = type;
    }

    /**
     * Converts units of data
     * @param newType Size type that the current data gets converted to
     * @return Returns a String of the converted data amount and type
     */
    public BigDecimal dataUnitConvert(String newType){
        return dataUnitConvert(size, type, newType);
    }

    /**
     * Converts units of data
     * @param num Numerical value of data
     * @param getType Unit type of data
     * @param returnType Desired data unit
     * @return Returns a String of the converted data amount and type
     */
    public static BigDecimal dataUnitConvert(BigDecimal num, String getType, String returnType){
        try{
            if(getType.equals("kb")){
                num = num.multiply(BigDecimal.valueOf(1000L));
            }
            else if(getType.equals("mb")){
                num = num.multiply(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(getType.equals("gb")){
                num = num.multiply(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(getType.equals("tb")){
                num = num.multiply(BigDecimal.valueOf(1000L).pow(4));
            }
            else if(getType.equals("B")){
                num = num.multiply(BigDecimal.valueOf(8));
            }
            else if(getType.equals("KB")){
                num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L));
            }
            else if(getType.equals("MB")){
                num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(getType.equals("GB")){
                num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(getType.equals("TB")){
                num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4));
            }
            if(returnType.equals("b")){
                return num;
            }
            else if(returnType.equals("kb")){
                return num.divide(BigDecimal.valueOf(1000L));
            }
            else if(returnType.equals("mb")){
                return num.divide(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(returnType.equals("gb")){
                return num.divide(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(returnType.equals("B")){
                return num.divide(BigDecimal.valueOf(8));
            }
            else if(returnType.equals("KB")){
                return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L));
            }
            else if(returnType.equals("MB")){
                return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2));
            }
            else if(returnType.equals("GB")){
                return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3));
            }
            else if(returnType.equals("TB")){
                return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4));
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
            return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4));
        }
        catch (ArithmeticException e) {
            switch (getType) {
                case "kb" -> num = num.multiply(BigDecimal.valueOf(1000L));
                case "mb" -> num = num.multiply(BigDecimal.valueOf(1000L).pow(2));
                case "gb" -> num = num.multiply(BigDecimal.valueOf(1000L).pow(3));
                case "tb" -> num = num.multiply(BigDecimal.valueOf(1000L).pow(4));
                case "B" -> num = num.multiply(BigDecimal.valueOf(8));
                case "KB" -> num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L));
                case "MB" -> num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2));
                case "GB" -> num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3));
                case "TB" -> num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4));
            }
            switch (returnType) {
                case "b":
                    return num;
                case "kb":
                    return num.divide(BigDecimal.valueOf(1000L), scale, mode);
                case "mb":
                    return num.divide(BigDecimal.valueOf(1000L).pow(2), scale, mode);
                case "gb":
                    return num.divide(BigDecimal.valueOf(1000L).pow(3), scale, mode);
                case "B":
                    return num.divide(BigDecimal.valueOf(8), scale, mode);
                case "KB":
                    return num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L), scale, mode);
                case "MB":
                    return num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(2), scale, mode);
                case "GB":
                    return num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(3), scale, mode);
                case "TB":
                    return num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(4), scale, mode);
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
            return num.divide(BigDecimal.valueOf(8), scale, mode).divide(BigDecimal.valueOf(1000L).pow(4), scale, mode);
        }
    }

    /**
     * Calculates the Time needed for downloads and uploads
     * @param fileSize Size of the transferring file
     * @param fileSizeType Unit type of the file
     * @param bandwidth Amount of bandwidth
     * @param bandwidthSizeType Unit type of the bandwidth
     * @return Returns a String that gives the time for a download/upload
     */
    public static String downloadTimeCalc(BigInteger fileSize, String fileSizeType, BigInteger bandwidth, String bandwidthSizeType){
        BigDecimal time;
        try {
            time = dataUnitConvert(new BigDecimal(fileSize),fileSizeType,"b").divide(dataUnitConvert(new BigDecimal(bandwidth),bandwidthSizeType,"b"));
        }
        catch (ArithmeticException e){
            time = dataUnitConvert(new BigDecimal(fileSize),fileSizeType,"b").divide(dataUnitConvert(new BigDecimal(bandwidth),bandwidthSizeType,"b"), scale, mode);
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
     * @param avgPgSize Size of the page
     * @param pgUnit Units for size of page
     * @param redunF Redundancy Frequency
     */
    public static void websiteBandwidthCalc(Double pgViews,int pgRate, long avgPgSize, String pgUnit, double redunF){
        BigDecimal bandwidthTotal;
        BigDecimal bandwidthRate;
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
            //Per Month
            pgViews *= secInMonth;
            pgViews /= 60;
            pgViews /= 60;
            pgViews /= 24;
            pgViews /= 30;
        }
        String standardUnit = "MB";
        try{
            bandwidthTotal = new BigDecimal(String.valueOf(dataUnitConvert(new BigDecimal(avgPgSize), pgUnit, standardUnit))).multiply(new BigDecimal(pgViews));
            bandwidthRate = bandwidthTotal.divide(new BigDecimal(secInMonth));
        }
        catch (ArithmeticException e) {
            bandwidthTotal = new BigDecimal(String.valueOf(dataUnitConvert(new BigDecimal(avgPgSize), pgUnit, standardUnit))).multiply(new BigDecimal(pgViews));
            bandwidthRate = bandwidthTotal.divide(new BigDecimal(secInMonth), scale, mode);
        }
        System.out.println("Actual bandwidth needed is "+dataUnitConvert(bandwidthRate,standardUnit,"mb") + " Mbits/s \nor " + dataUnitConvert(bandwidthTotal,"MB","GB") +" GB per month.");
        if(redunF>1){
            System.out.println("With redundancy factor of 1.3, the bandwidth needed is "+dataUnitConvert(bandwidthRate.multiply(BigDecimal.valueOf(redunF)),standardUnit,"mb") + " Mbits/s \nor " + dataUnitConvert(bandwidthTotal.multiply(BigDecimal.valueOf(redunF)),"MB","GB") +" GB per month.");
        }
    }

    /**
     * Calculates the rate of Bandwidth needed for hosting
     * @param monthUse Amount of data used in a month
     * @param monthUseType Unit of Bandwidth
     * @param bandwidthType Return unit
     */
    public static void hostingBandwidthCalcRate(long monthUse, String monthUseType, String bandwidthType){
        //Seconds in Month 2628000
        BigDecimal num;
        try {
            num = dataUnitConvert(new BigDecimal(monthUse), monthUseType, bandwidthType).divide(new BigDecimal(secInMonth));
        }
        catch (ArithmeticException e){
            num = dataUnitConvert(new BigDecimal(monthUse), monthUseType, bandwidthType).divide(new BigDecimal(secInMonth),scale,mode);
        }
        System.out.println(monthUse + " " + monthUseType + " per month is equivalent to " + num + " " + bandwidthType + "/s");
    }

    /**
     * Calculates the Total amount of data needed for a month of hosting
     * @param bandwidthSize Amount of Bandwidth
     * @param bandwidthType Unit of Bandwidth
     * @param monthUseType Return unit
     */
    public static void hostingBandwidthCalcTotal(long bandwidthSize, String bandwidthType, String monthUseType){
        //Seconds in Month 2628000
        BigDecimal num = dataUnitConvert(new BigDecimal(bandwidthSize),bandwidthType,monthUseType).multiply(new BigDecimal(secInMonth));
        System.out.println(bandwidthSize + " " + bandwidthType + "/s is equivalent to " + num + " " + monthUseType + " per month.");
    }

    /**
     * Returns a String of Bandwidth
     * @return Makes a String of the size and type in the format "1b"
     */
    public String toString(){
        return size + type;
    }
}
