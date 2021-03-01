package view;

import controller.BandwidthCalculator;
import controller.BinaryCalculator;
import controller.DecimalCalculator;
import controller.HexCalculator;
import model.Bandwidth;
import model.Binary;
import model.Decimal;
import model.Hexadecimal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;

public class CalcGUI {
    private final JPanel startScreen;
    public static final JFrame frame = new JFrame("Calculator V1.0.3");

    public static void main(String[] args) {
        frame.setContentPane(new CalcGUI().startScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public CalcGUI(){
        startScreen = new JPanel();
        JButton binaryCalculatorButton = new JButton("Binary Calc");
        startScreen.add(binaryCalculatorButton);
        JButton hexadecimalCalculatorButton = new JButton("Hexadecimal Calc");
        startScreen.add(hexadecimalCalculatorButton);
        JButton bandwidthCalculatorButton = new JButton("Bandwidth Calc");
        startScreen.add(bandwidthCalculatorButton);
        JButton decimalCalculatorButton = new JButton("Decimal Calc");
        startScreen.add(decimalCalculatorButton);
        JButton bigIntCalculatorButton = new JButton("Big Integer Calc");
        startScreen.add(bigIntCalculatorButton);
        binaryCalculatorButton.addActionListener(new binaryMenuClicked());
        hexadecimalCalculatorButton.addActionListener(new hexMenuClicked());
        bandwidthCalculatorButton.addActionListener(new bandwidthMenuClicked());
        decimalCalculatorButton.addActionListener(new decimalMenuClicked());
        bigIntCalculatorButton.addActionListener(new bigIntMenuClicked());
    }

    private class binaryMenuClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(new BinaryMenu().binaryMenu);
            frame.setVisible(true);
        }
    }

    private class hexMenuClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(new HexadecimalMenu().hexadecimalMenu);
            frame.setVisible(true);
        }
    }

    private class bandwidthMenuClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(new BandwidthMenu().bandwidthMenu);
            frame.setVisible(true);
        }
    }

    private class decimalMenuClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(new DecimalMenu().decimalMenu);
            frame.setVisible(true);
        }
    }

    private class bigIntMenuClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(new BigIntMenu().bigIntMenu);
            frame.setVisible(true);
        }
    }

    @SuppressWarnings({"InnerClassMayBeStatic", "DuplicatedCode"})
    class BinaryMenu  {
        private final JPanel binaryMenu = new JPanel();

        public BinaryMenu(){
            JButton toDecimal = new JButton("Binary to Decimal");
            binaryMenu.add(toDecimal);
            JButton toBinary = new JButton("Decimal to Binary");
            binaryMenu.add(toBinary);
            JButton add = new JButton("Add");
            binaryMenu.add(add);
            JButton sub = new JButton("Subtract");
            binaryMenu.add(sub);
            JButton multi = new JButton("Multiply");
            binaryMenu.add(multi);
            JButton div = new JButton("Divide");
            binaryMenu.add(div);
            JButton backButton = new JButton("Back");
            binaryMenu.add(backButton);
            toDecimal.addActionListener(new toDecimal());
            toBinary.addActionListener(new toBinary());
            backButton.addActionListener(new mainBack());
            add.addActionListener(new add());
            sub.addActionListener(new sub());
            multi.addActionListener(new multi());
            div.addActionListener(new div());
        }

        private class mainBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CalcGUI().startScreen);
                frame.setVisible(true);
            }
        }

        private class toDecimal implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Binary binary;
                binary = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary",Long.MAX_VALUE));
                BinaryCalculator calc = new BinaryCalculator(binary);
                JOptionPane.showMessageDialog(frame,"Converted: " + calc.toDecimal());
            }
        }

        private class toBinary implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                long num;
                num = Long.parseLong(InputReader.protectUnit(frame,"Type a Number to be converted:", "decimal",Long.MAX_VALUE));
                System.out.println(num);
                Binary binary = new Binary(num);
                JOptionPane.showMessageDialog(frame,"Converted: " + binary);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class add implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Binary binary = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                Binary other = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                BinaryCalculator calc = new BinaryCalculator(binary);
                BinaryCalculator otherCalc = new BinaryCalculator(other);
                JOptionPane.showMessageDialog(frame,"Binary: " + binary + " + " + other + " = " + calc.fromDecimal(calc.add(other))
                +"\nDecimal: " + calc.toDecimal() + " + " + otherCalc.toDecimal() + " = " + calc.add(other),"Result",-1);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class sub implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Binary binary = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                Binary other = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                BinaryCalculator calc = new BinaryCalculator(binary);
                BinaryCalculator otherCalc = new BinaryCalculator(other);
                JOptionPane.showMessageDialog(frame,"Binary: " + binary + " - " + other + " = " + calc.fromDecimal(calc.sub(other))
                        +"\nDecimal: " + calc.toDecimal() + " - " + otherCalc.toDecimal() + " = " + calc.sub(other),"Result",-1);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class multi implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Binary binary = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                Binary other = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                BinaryCalculator calc = new BinaryCalculator(binary);
                BinaryCalculator otherCalc = new BinaryCalculator(other);
                JOptionPane.showMessageDialog(frame,"Binary: " + binary + " * " + other + " = " + calc.fromDecimal(calc.multi(other))
                        +"\nDecimal: " + calc.toDecimal() + " * " + otherCalc.toDecimal() + " = " + calc.multi(other),"Result",-1);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class div implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Binary binary = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                Binary other = new Binary(InputReader.protectUnit(frame,"Type a Binary String to be converted:","binary", (long) Integer.MAX_VALUE));
                BinaryCalculator calc = new BinaryCalculator(binary);
                BinaryCalculator otherCalc = new BinaryCalculator(other);
                JOptionPane.showMessageDialog(frame,"Binary: " + binary + " / " + other + " = " + calc.fromDecimal((long) calc.div(other))
                        +"\nDecimal: " + calc.toDecimal() + " / " + otherCalc.toDecimal() + " = " + calc.div(other),"Result",-1);
            }
        }
    }

    @SuppressWarnings({"InnerClassMayBeStatic", "DuplicatedCode"})
    class HexadecimalMenu {
        private final JPanel hexadecimalMenu = new JPanel();

        public HexadecimalMenu(){
            JButton toDecimal = new JButton("Hexadecimal to Decimal");
            hexadecimalMenu.add(toDecimal);
            JButton toHexadecimal = new JButton("Decimal to Hexadecimal");
            hexadecimalMenu.add(toHexadecimal);
            JButton add = new JButton("Add");
            hexadecimalMenu.add(add);
            JButton sub = new JButton("Subtract");
            hexadecimalMenu.add(sub);
            JButton multi = new JButton("Multiply");
            hexadecimalMenu.add(multi);
            JButton div = new JButton("Divide");
            hexadecimalMenu.add(div);
            JButton backButton = new JButton("Back");
            hexadecimalMenu.add(backButton);
            toDecimal.addActionListener(new toDecimal());
            toHexadecimal.addActionListener(new toHexadecimal());
            backButton.addActionListener(new mainBack());
            add.addActionListener(new add());
            sub.addActionListener(new sub());
            multi.addActionListener(new multi());
            div.addActionListener(new div());
        }

        private class mainBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CalcGUI().startScreen);
                frame.setVisible(true);
            }
        }

        private class toDecimal implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexadecimal hexadecimal;
                hexadecimal = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex",Long.MAX_VALUE));
                HexCalculator calc = new HexCalculator(hexadecimal);
                JOptionPane.showMessageDialog(frame,"Converted: " + calc.toDecimal());
            }
        }

        private class toHexadecimal implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                long num;
                num = Long.parseLong(InputReader.protectUnit(frame,"Type a Number to be converted:", "decimal",Long.MAX_VALUE));
                System.out.println(num);
                Hexadecimal hexadecimal = new Hexadecimal(num);
                JOptionPane.showMessageDialog(frame,"Converted: " + hexadecimal);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class add implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexadecimal hexadecimal = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                Hexadecimal other = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                HexCalculator calc = new HexCalculator(hexadecimal);
                HexCalculator otherCalc = new HexCalculator(other);
                JOptionPane.showMessageDialog(frame,"Hexadecimal: " + hexadecimal + " + " + other + " = " + calc.fromDecimal(calc.add(other))
                        +"\nDecimal: " + calc.toDecimal() + " + " + otherCalc.toDecimal() + " = " + calc.add(other),"Result",-1);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class sub implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexadecimal hexadecimal = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                Hexadecimal other = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                HexCalculator calc = new HexCalculator(hexadecimal);
                HexCalculator otherCalc = new HexCalculator(other);
                JOptionPane.showMessageDialog(frame,"Hexadecimal: " + hexadecimal + " - " + other + " = " + calc.fromDecimal(calc.sub(other))
                        +"\nDecimal: " + calc.toDecimal() + " - " + otherCalc.toDecimal() + " = " + calc.sub(other),"Result",-1);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class multi implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexadecimal hexadecimal = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                Hexadecimal other = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                HexCalculator calc = new HexCalculator(hexadecimal);
                HexCalculator otherCalc = new HexCalculator(other);
                JOptionPane.showMessageDialog(frame,"Hexadecimal: " + hexadecimal + " * " + other + " = " + calc.fromDecimal(calc.multi(other))
                        +"\nDecimal: " + calc.toDecimal() + " * " + otherCalc.toDecimal() + " = " + calc.multi(other),"Result",-1);
            }
        }

        @SuppressWarnings("DuplicatedCode")
        private class div implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexadecimal hexadecimal = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                Hexadecimal other = new Hexadecimal(InputReader.protectUnit(frame,"Type a Hexadecimal String to be converted:","hex", (long) Integer.MAX_VALUE));
                HexCalculator calc = new HexCalculator(hexadecimal);
                HexCalculator otherCalc = new HexCalculator(other);
                JOptionPane.showMessageDialog(frame,"Hexadecimal: " + hexadecimal + " / " + other + " = " + calc.fromDecimal((long) calc.div(other))
                        +"\nDecimal: " + calc.toDecimal() + " / " + otherCalc.toDecimal() + " = " + calc.div(other),"Result",-1);
            }
        }
    }
    
    @SuppressWarnings("InnerClassMayBeStatic")
    class BandwidthMenu {
        private final JPanel bandwidthMenu = new JPanel();
        private final String unitInstr = "Enter the Unit Value (b,B,kb,KB,etc.)";
        private final String sizeInstr = "Type a File Size (Numeric Only)";

        public BandwidthMenu(){
            JButton convert = new JButton("Data Unit Converter");
            bandwidthMenu.add(convert);
            JButton downTimeCalc = new JButton("Download Time Calculator");
            bandwidthMenu.add(downTimeCalc);
            JButton webBandCalc = new JButton("Website Bandwidth Calculator");
            bandwidthMenu.add(webBandCalc);
            JButton hostingRate = new JButton("Hosting Bandwidth Converter (Rate)");
            bandwidthMenu.add(hostingRate);
            JButton hostingTotal = new JButton("Hosting Bandwidth Converter (Total)");
            bandwidthMenu.add(hostingTotal);
            JButton backButton = new JButton("Back");
            bandwidthMenu.add(backButton);
            convert.addActionListener(new BandwidthMenu.convert());
            downTimeCalc.addActionListener(new BandwidthMenu.downTimeCalc());
            webBandCalc.addActionListener(new BandwidthMenu.webBandCalc());
            hostingRate.addActionListener(new BandwidthMenu.hostingRate());
            hostingTotal.addActionListener(new BandwidthMenu.hostingTotal());
            backButton.addActionListener(new BandwidthMenu.mainBack());
        }

        private class mainBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CalcGUI().startScreen);
                frame.setVisible(true);
            }
        }

        private class convert implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Bandwidth bandwidth = new Bandwidth(new BigDecimal(InputReader.protectUnit(frame,sizeInstr,"decimal",Long.MAX_VALUE)),InputReader.protectBandUnit(frame,unitInstr));
                BandwidthCalculator bandCalc = new BandwidthCalculator(bandwidth);
                String result = "";
                bandCalc.dataUnitConvert("b");
                result +=(bandCalc.getBandwidth() + "\n");
                bandCalc.dataUnitConvert("kb");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("mb");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("gb");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("tb");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("B");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("KB");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("MB");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("GB");
                result +=(bandCalc.getBandwidth()+ "\n");
                bandCalc.dataUnitConvert("TB");
                result +=(bandCalc.getBandwidth()+ "\n");
                JOptionPane.showMessageDialog(frame,result,"Result",-1);
            }
        }

        private class downTimeCalc implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Bandwidth bandwidth = new Bandwidth(new BigDecimal(InputReader.protectUnit(frame,sizeInstr,"decimal",Long.MAX_VALUE)),InputReader.protectBandUnit(frame,unitInstr));
                BandwidthCalculator bandCalc = new BandwidthCalculator(bandwidth);
                Bandwidth other = new Bandwidth(new BigDecimal(InputReader.protectUnit(frame,"Type the Rate Per Second (Numeric Only)","decimal",Long.MAX_VALUE)),InputReader.protectBandUnit(frame,unitInstr));
                System.out.println(bandwidth + " " + other);
                JOptionPane.showMessageDialog(frame,bandCalc.downloadTimeCalc(other),"Result",-1);
            }
        }

        private class webBandCalc implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String result;
                Bandwidth bandwidth = new Bandwidth(new BigDecimal(InputReader.protectUnit(frame,sizeInstr,"decimal",Long.MAX_VALUE)),InputReader.protectBandUnit(frame,unitInstr));
                BandwidthCalculator bandCalc = new BandwidthCalculator(bandwidth);
                double pgViews = InputReader.protectDouble(frame, "Enter the amount of Page Views (Accepts Decimal)");
                int pgRate = InputReader.protectDayUnit(frame,"Enter Time Span (Day, Week, Year, etc.)");
                int redunF = Integer.parseInt(InputReader.protectUnit(frame,"Enter the Redundancy Factor","decimal", (long) Integer.MAX_VALUE));
                result = bandCalc.websiteBandwidthCalc(pgViews,pgRate,redunF);
                JOptionPane.showMessageDialog(frame,result,"Result",-1);
            }
        }

        private class hostingRate implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Bandwidth bandwidth = new Bandwidth(new BigDecimal(InputReader.protectUnit(frame,"Enter Monthly Usage (Numeric Only)","decimal",Long.MAX_VALUE)),InputReader.protectBandUnit(frame,unitInstr));
                BandwidthCalculator bandCalc = new BandwidthCalculator(bandwidth);
                String result = bandCalc.hostingBandwidthCalcRate(InputReader.protectBandUnit(frame,"Enter rate of Bandwidth (b, kb, KB, etc.)"));
                JOptionPane.showMessageDialog(frame,result,"Result",-1);
            }
        }

        private class hostingTotal implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Bandwidth bandwidth = new Bandwidth(new BigDecimal(InputReader.protectUnit(frame,"Enter Bandwidth Usage (Numeric Only)","decimal",Long.MAX_VALUE)),InputReader.protectBandUnit(frame,"Enter rate of Bandwidth (b, kb, KB, etc.)"));
                BandwidthCalculator bandCalc = new BandwidthCalculator(bandwidth);
                String result = bandCalc.hostingBandwidthCalcTotal(InputReader.protectBandUnit(frame,"Enter Units for Total (b, kb, KB, etc.)"));
                JOptionPane.showMessageDialog(frame,result,"Result",-1);
            }
        }
    }

    @SuppressWarnings({"InnerClassMayBeStatic", "DuplicatedCode"})
    class DecimalMenu  {
        private final JPanel decimalMenu = new JPanel();

        public DecimalMenu(){
            JButton add = new JButton("Add");
            decimalMenu.add(add);
            JButton sub = new JButton("Subtract");
            decimalMenu.add(sub);
            JButton multi = new JButton("Multiply");
            decimalMenu.add(multi);
            JButton div = new JButton("Divide");
            decimalMenu.add(div);
            JButton backButton = new JButton("Back");
            decimalMenu.add(backButton);
            backButton.addActionListener(new mainBack());
            add.addActionListener(new add());
            sub.addActionListener(new sub());
            multi.addActionListener(new multi());
            div.addActionListener(new div());
        }

        private class mainBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CalcGUI().startScreen);
                frame.setVisible(true);
            }
        }

        private class add implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Decimal decimal = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                Decimal other = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                DecimalCalculator calc = new DecimalCalculator(decimal);
                JOptionPane.showMessageDialog(frame,decimal + " + " + other + " = " + calc.addDouble(other),"Result",-1);
            }
        }

        private class sub implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Decimal decimal = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                Decimal other = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                DecimalCalculator calc = new DecimalCalculator(decimal);
                JOptionPane.showMessageDialog(frame,decimal + " - " + other + " = " + calc.subDouble(other),"Result",-1);
            }
        }

        private class multi implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Decimal decimal = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                Decimal other = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                DecimalCalculator calc = new DecimalCalculator(decimal);
                JOptionPane.showMessageDialog(frame,decimal + " * " + other + " = " + calc.multiDouble(other),"Result",-1);
            }
        }

        private class div implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                Decimal decimal = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                Decimal other = new Decimal(InputReader.protectDouble(frame, "Enter a Decimal"));
                DecimalCalculator calc = new DecimalCalculator(decimal);
                JOptionPane.showMessageDialog(frame,decimal + " / " + other + " = " + calc.divDouble(other),"Result",-1);
            }
        }
    }

    @SuppressWarnings({"InnerClassMayBeStatic", "DuplicatedCode"})
    class BigIntMenu  {
        private final JPanel bigIntMenu = new JPanel();

        public BigIntMenu(){
            JButton add = new JButton("Add");
            bigIntMenu.add(add);
            JButton sub = new JButton("Subtract");
            bigIntMenu.add(sub);
            JButton multi = new JButton("Multiply");
            bigIntMenu.add(multi);
            JButton div = new JButton("Divide");
            bigIntMenu.add(div);
            JButton backButton = new JButton("Back");
            bigIntMenu.add(backButton);
            backButton.addActionListener(new mainBack());
            add.addActionListener(new add());
            sub.addActionListener(new sub());
            multi.addActionListener(new multi());
            div.addActionListener(new div());
        }

        private class mainBack implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CalcGUI().startScreen);
                frame.setVisible(true);
            }
        }

        private class add implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger num = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                BigInteger other = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                JOptionPane.showMessageDialog(frame,num + " + " + other + " = " + num.add(other),"Result",-1);
            }
        }

        private class sub implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger num = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                BigInteger other = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                JOptionPane.showMessageDialog(frame,num + " - " + other + " = " + num.subtract(other),"Result",-1);
            }
        }

        private class multi implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger num = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                BigInteger other = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                JOptionPane.showMessageDialog(frame,num + " * " + other + " = " + num.multiply(other),"Result",-1);
            }
        }

        private class div implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger num = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                BigInteger other = new BigInteger(InputReader.protectString(frame,"Enter a Number","[0123456789]"));
                JOptionPane.showMessageDialog(frame,num + " / " + other + " = " + num.divide(other),"Result",-1);
            }
        }
    }
}
