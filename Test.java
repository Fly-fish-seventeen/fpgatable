package org.example;

import gnu.io.*;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.InputStream;
import java.util.*;
import java.util.List;

public class Test extends JFrame{


    public Test() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
      //  final String serialPortNo = "COM25";
        List<String> serialPortList = new ArrayList<>();

        // 获取本地所有串口

        Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();

        /**
         * 遍历所有串口，获取串口名
         */
        String pin = "";
        System.out.print("输出所有串口:");
        int iportnamearrey = 0;
        while (portIdentifiers.hasMoreElements()) {

            CommPortIdentifier portIdentifier = (CommPortIdentifier) portIdentifiers.nextElement();
            serialPortList.add(portIdentifier.getName().toLowerCase());

            pin = pin + " " + portIdentifier.getName();
        }

        System.out.println(serialPortList);

        String[] portname = serialPortList.toArray(new String[0]);


        //   JLabel label01 = new JLabel();
        //   label01.setText("port :"+pin);

        /**
         * 判断串口是否存在
         */



//        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(serialPortNo);
//
//        final SerialPort serialPort = (SerialPort) portIdentifier.open(serialPortNo, 1000);
//        serialPort.setSerialPortParams(9600, 8, 1, 0);

        setTitle("Java port obsever 程序");
        setLayout(null);

        setBounds(100, 20, 1750, 1000);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        final JTextArea jta = new JTextArea(" ", 6, 64);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行

        jta.setFont(new Font(null, Font.BOLD, 17));    //修改字体样式
        //设置按钮背景色
        JScrollPane jsp = new JScrollPane(jta);    //将文本域放入滚动窗口
        Dimension size = jta.getPreferredSize();    //获得文本域的首选大小
        jsp.setBounds(330, 807, 1380, size.height);
        add(jsp);    //将JScrollPane添加到JPanel容器中

        final JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(Color.PINK));
        panel_1.setBounds(330, 50, 1360, 750);
        add(panel_1);//将panel放入jframe界面
        String sbu = "to read,draw";
        JButton button = new JButton(sbu);
        button.setFont(new Font(null, Font.PLAIN, 20));
        button.setBounds(10, 5, 170, 40);
        add(button);
        if (serialPortList.isEmpty()) {
            System.out.println("串口不存在");
            button.setEnabled(false);

        }
        final JComboBox<String> comboBox_1 =  new JComboBox<>(portname);
       JButton button78 = new JButton("listening ");
       button78.setFont(new Font(null, Font.PLAIN, 20));
        button78.setBounds(700, 5, 160, 40);
       add(button78);
    //    final JButton button79 = new JButton("next 64bit");
    //    button79.setBounds(100, 5, 100, 40);
    //    add(button79);

    //    final JButton button769 = new JButton("last 64bit");
     //   button769.setBounds(220, 5, 100, 40);
     //   add(button769);
        //   label01.setBounds(450,5,200,40);
        //   add(label01);
        final JButton b2 = new JButton("state");
        b2.setFont(new Font(null, Font.PLAIN, 20));
        b2.setBounds(1230, 5, 120, 40);
        add(b2);


        JLabel label02 = new JLabel("  串口参数配置");
        add(label02);
        label02.setFont(new Font(null, Font.PLAIN, 20));
        label02.setBounds(40, 70, 150, 30);

        JLabel label03 = new JLabel("端口号");
        add(label03);
        label03.setFont(new Font(null, Font.PLAIN, 20));
        label03.setBounds(40, 120, 100, 30);



        add(comboBox_1);// 使用数组String添加下拉元素
        comboBox_1.setBounds(160, 120, 80, 30);// 下拉框列表坐标、大小

        JLabel label23 = new JLabel("波特率");
        add(label23);
        label23.setFont(new Font(null, Font.PLAIN, 20));
        label23.setBounds(40, 170, 100, 30);
        String[] items_2 = {"9600", "4800", "115200"};// 建立数组
        final JComboBox<String> comboBox_2 = new JComboBox<>(items_2);
        add(comboBox_2);// 使用数组String添加下拉元素
        comboBox_2.setBounds(160, 170, 80, 30);// 下拉框列表坐标、大小

        JLabel label33 = new JLabel("校检位");
        add(label33);
        label33.setFont(new Font(null, Font.PLAIN, 20));
        label33.setBounds(40, 220, 100, 30);
        String[] items_3 = {"none", "1", "2"};// 建立数组
        final JComboBox<String> comboBox_3 = new JComboBox<>(items_3);
        add(comboBox_3);// 使用数组String添加下拉元素
        comboBox_3.setBounds(160, 220, 80, 30);// 下拉框列表坐标、大小

        JLabel label4 = new JLabel("数据位数");
        add(label4);
        label4.setFont(new Font(null, Font.PLAIN, 20));
        label4.setBounds(40, 270, 100, 30);
        String[] items_4 = {"8", "9", "10"};// 建立数组
        final JComboBox<String> comboBox_4 = new JComboBox<>(items_4);
        add(comboBox_4);// 使用数组String添加下拉元素
        comboBox_4.setBounds(160, 270, 80, 30);// 下拉框列表坐标、大小

        JLabel label5 = new JLabel("停止位");
        add(label5);
        label5.setFont(new Font(null, Font.PLAIN, 20));
        label5.setBounds(40, 320, 100, 30);
        String[] items_5 = {"1", "1.5", "2"};

        final JComboBox<String> comboBox_5 = new JComboBox<>(items_5);
        add(comboBox_5);// 使用数组String添加下拉元素
        comboBox_5.setBounds(160, 320, 80, 30);// 下拉框列表坐标、大小


        final byte[] cashebig = new byte[160];

        class jbt1_hander implements ActionListener {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String port = (String) comboBox_1.getSelectedItem();
                System.out.println("选择的内容为：" + port);

                assert port != null;
                CommPortIdentifier portIdentifier1 = CommPortIdentifier.getPortIdentifier(port.toUpperCase());

                SerialPort serialPort1 = (SerialPort) portIdentifier1.open(port.toUpperCase(), 1000);
                serialPort1.setSerialPortParams(9600, 8, 1, 0);
                final int[] keep2 = new int[128];
                try {
                    InputStream inputStream;
                    inputStream = serialPort1.getInputStream();



                    //  获取可用数据
                    int availableBytes = inputStream.available();
                    System.out.println("readnumber-" + availableBytes);
                    int e2=0;
                    //如果可用数据大于0,则开始读取数据
                    if (availableBytes > 0) {
                        b2.setText("getnum-"+availableBytes);
                        b2.setBackground(Color.green);
                    //    button79.setEnabled(true);
                     //   button769.setEnabled(true);
                        e2 = inputStream.read(cashebig);
                        System.out.println("hear-");
                        //将获取到的数据进行转码并输出
                        for (int i = 0; i < e2; i++) {

                            System.out.print(cashebig[i] + " ");
                        }
                        System.out.println();




                    } else {
                        b2.setText("no data-"+e2);
                        b2.setBackground(Color.red);
                    ///    button79.setEnabled(false);
                     //   button769.setEnabled(false);

                       cashebig[0]=1;
                       cashebig[7]=1;
                       cashebig[8]=2;
                       cashebig[16]=4;

                    }
                } catch (Exception e6) {

                    e6.printStackTrace();
                }

                System.out.println("cilck");

                final int []aaaa=new int[1280];
                byte[] as=cashebig;
                byte [] asnew = new  byte[16];
                final byte [] newass=new byte[160];
                for (int i6 = 0; i6 < 10; i6++) {
                    for (int j = 0; j < 16; j++) {

                        asnew[j]=as[i6*16+j];
                    }
                    System.out.println(Arrays.toString(asnew));
                    for (int i = 0; i < asnew.length/2; i++) {
                        byte temp;
                        temp=asnew[i];
                        asnew[i]=asnew[15-i];
                        asnew[15-i]=temp;
                    }
                    System.out.println(Arrays.toString(asnew));

                    byte[] b=new byte[16];
                    for (int i = 0; i < b.length; i++) {
                        b[0]=0;
                    }
                   byte[] kk=sm4Demo.decryptSm4(asnew);
                    if(kk.length!=16)
                    System.out.println("see ghost");
                    for (int i = 0; i < kk.length; i++) {
                        b[i]=kk[i];
                    }
                    byte temp;
                    System.out.println(Arrays.toString(b));
                    for (int i = 0; i < (b.length)/2; i++) {

                        temp=b[i];
                        b[i]=b[15-i];
                        b[15-i]=temp;
                    }


                  //  System.out.println("b的前后颠倒");System.out.println(Arrays.toString(b));

                    for (int i = 0; i < 16; i++) {
                        newass[i+16*i6]=b[i];
//                        for(int i2 = 7;i2 >= 0; i2--){
//                            int h=b[i] >>> i2 & 1;
//
//                            System.out.print(h);
//                        }
//                        System.out.println("=");
                    }
                }

                jiemi1280 p2=new jiemi1280();


                p2.jiemi(newass,aaaa);
                System.out.println(Arrays.toString(aaaa));
                for (int i = 0; i < aaaa.length; i++) {
                    if(i%128==0) System.out.println();
                    System.out.print(aaaa[i]);

                }

                StringBuilder result = new StringBuilder();
                for (int ih = 0; ih < 10; ih++) {
                    for (int i = 0; i < 64; i++) {
                        keep2[i]=aaaa[64*ih+i];
                    }
                    for (int i = 64; i < 128; i++) {
                        keep2[i]=aaaa[64*ih+i+640-64];
                    }
                    //      System.out.println(Arrays.toString(keep2));

//                                for (int ijk = 0; ijk < 8; ijk++) {
//                                    int weishu = ijk + ih * 8;
//                                    for (int i3 = 7; i3 >= 0; i3--) {
//                                        int h = cashebig[weishu] >>> i3 & 1;
//                                        keep2[ijk * 8 + (i3)] = h;//从fpga发送数据要求如此。
//                                    }
//                                }
//                                for (int ijk = 0; ijk < 8; ijk++) {
//                                    int weishu = ijk + ih * 8+80;
//                                    for (int i3 = 7; i3 >= 0; i3--) {
//                                        int h = cashebig[weishu] >>> i3 & 1;
//
//                                        keep2[ijk * 8 + i3+64] = h;//从fpga发送数据要求如此。
//                                    }
//                                }

//
//
//                                System.out.println(ih + "元keep2");
//
//                                result = result.append(String.valueOf(ih + "-old-"));
//                                for (int j : keep2) {
//                                    System.out.print(j);
//                                    result = result.append(String.valueOf(j));
//                                }
//                                result = result.append("\n");
//                                result = result.append(String.valueOf(ih + "-new-"));
//
//                                System.out.println();
//                                staticways.tocorrect(keep2);
//
//                                System.out.println(ih + "keep解密");
//                                for (int j : keep2) {
//                                    System.out.print(j);
//                                }
//                                System.out.println();
//
                    result.append(ih).append("- ");
                    for (int j : keep2) {
                        result.append(String.valueOf(j));
                    }

                    if (ih != 9)
                        result.append("\n");


                }
                System.out.println("result");
                System.out.println(result);
                jta.setText(String.valueOf(result));
                jta.setEditable(false);


                System.out.println("2");
                panel_1.removeAll();
                panel_1.repaint();
                JScrollPane jsp = new JScrollPane();
                jsp.setBounds(0, 0, 1360, 750);
                jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                JPanel p;
                {
                    p = new JPanel() {
                        @Override
                        public void paintComponent(Graphics g) {

                            Graphics2D g2 = (Graphics2D) g;

                            Shape line2 = new Line2D.Double(0, 700, 2600, 700);
                            g2.draw(line2);
                            Stroke stroke = null;

                            //    String A=encodeHexString(asnew);String V=hexStringToBinary(A);System.out.println(V);


//        for (int i = 0; i < as.length; i++) {
//            asnew[i]=b2.reverseBits(as[i]);
//        }

 //  jiemi1280.jiemi(cashebig,aaaa);

                            for (int ih = 0; ih < 10; ih++) {
                                for (int i = 0; i < 64; i++) {
                                    keep2[i]=aaaa[64*ih+i];
                                }
                                for (int i = 64; i < 128; i++) {
                                    keep2[i]=aaaa[64*ih+i+640-64];
                                }
                          //      System.out.println(Arrays.toString(keep2));

//                                for (int ijk = 0; ijk < 8; ijk++) {
//                                    int weishu = ijk + ih * 8;
//                                    for (int i3 = 7; i3 >= 0; i3--) {
//                                        int h = cashebig[weishu] >>> i3 & 1;
//                                        keep2[ijk * 8 + (i3)] = h;//从fpga发送数据要求如此。
//                                    }
//                                }
//                                for (int ijk = 0; ijk < 8; ijk++) {
//                                    int weishu = ijk + ih * 8+80;
//                                    for (int i3 = 7; i3 >= 0; i3--) {
//                                        int h = cashebig[weishu] >>> i3 & 1;
//
//                                        keep2[ijk * 8 + i3+64] = h;//从fpga发送数据要求如此。
//                                    }
//                                }

//
//
//                                System.out.println(ih + "元keep2");
//
//                                result = result.append(String.valueOf(ih + "-old-"));
//                                for (int j : keep2) {
//                                    System.out.print(j);
//                                    result = result.append(String.valueOf(j));
//                                }
//                                result = result.append("\n");
//                                result = result.append(String.valueOf(ih + "-new-"));
//
//                                System.out.println();
//                                staticways.tocorrect(keep2);
//
//                                System.out.println(ih + "keep解密");
//                                for (int j : keep2) {
//                                    System.out.print(j);
//                                }
//                                System.out.println();
//


                                staticways.draw(g2, keep2, ih);
                            }

                            for (int i8 = 0; i8 < 128; i8++) {
                                int k = (i8 + 1);
                                if (k == 1 | k % 2 == 0) {

                                }
                                String H = String.valueOf(k);
                                Shape line5 = new Line2D.Double(30 + 20 * i8, 700, 30 + 20 * i8, 710);
                                g2.draw(line5);
                                stroke = g2.getStroke();
                                g2.drawString(H, 27 + i8 * 20, 722);
                            }
                            System.out.print("1");
                            //滑动会反复

                            float[] dash1 = {2f, 0f, 2f};
                            BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
                            g2.setStroke(bs1);

                            g2.setPaint(Color.RED);
                            g2.drawLine(20, 40, 20, 700);
                            g2.drawLine(2580, 40, 2580, 700);

                        }

                    };
                }
                p.setLayout(null);
                p.setBackground(Color.WHITE);
                p.setBorder(new LineBorder(Color.white));

                p.setPreferredSize(new Dimension(2635, 740));
                p.setOpaque( false );

                p.setVisible(true);

                jsp.getViewport().add(p);
                jsp.validate();
                panel_1.add(jsp);

                panel_1.updateUI();
            }
        }
        button.addActionListener(new jbt1_hander());
    //    button79.addActionListener(new jbt1_hander2());
     //   button769.addActionListener(new jbt1_hander3());
        setVisible(true);

    }
    public static void main(String[] args) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
        new Test();
    }

}