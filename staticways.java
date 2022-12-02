package org.example;



import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class staticways {
    public static void drawandwrite(Graphics2D g2, int[] cache, int[] keep2, JTextArea jta){
        Shape line2 = new Line2D.Double(0, 700, 1320, 700);
        g2.draw(line2);
        Stroke stroke = null;
        StringBuilder result = new StringBuilder();

        for (int ih = 0; ih < 10; ih++) {
            for (int ijk = 0; ijk < 8; ijk++) {
                int weishu=ijk+ih*8;
                for(int i3 = 7;i3 >= 0; i3--){
                    int h= cache[weishu] >>> i3 & 1;
                    keep2[ijk*8+(i3)]=h;//从fpga发送数据要求如此。
                }
            }
            System.out.println(ih+"元keep2");
            result = result.append(String.valueOf(ih+"-old-"));
            for (int j:keep2) {
                System.out.print(j);
                result = result.append(String.valueOf(j));
            }
            result = result.append("\n");
            result = result.append(String.valueOf(ih+"-new-"));
            System.out.println();
            for (int jiemi = 0; jiemi <keep2.length; jiemi++) {
                int hilei = jiemi% 8;
                switch (hilei) {
                    case 0: //a分支
                        keep2[jiemi]=keep2[jiemi]^0;
                        //   System.out.println(keep2[jiemi]);
                        break;
                    case 1: //b分支
                        keep2[jiemi]=keep2[jiemi]^1;
                        break;

                    case 2: //c分支
                        keep2[jiemi]=keep2[jiemi]^0;
                        break;
                    case 3: //d分支
                        keep2[jiemi]=keep2[jiemi]^1;
                        break;
                    case 4: //d分支
                        keep2[jiemi]=keep2[jiemi]^0;
                        break;
                    case 5: //d分支
                        keep2[jiemi]=keep2[jiemi]^1;
                        break;
                    case 6: //d分支
                        keep2[jiemi]=keep2[jiemi]^0;
                        break;
                    case 7: //d分支
                        keep2[jiemi]=keep2[jiemi]^1;
                        break;
                    default:
                        break;
                }


            }
            System.out.println(ih+"keep解密");
            for (int j:keep2) {
                System.out.print(j);

                result = result.append(String.valueOf(j));
            }
            System.out.println();
            if(ih!=9)
                result = result.append("\n");



            int w = 0;
            while (w < keep2.length) {
                if (keep2[w] == 0) {
                    Shape line6 = new Line2D.Double(20 + 20 * w, 700-ih*60, 40 + 20 * w, 700-ih*60);
                    g2.draw(line6);
                    w++;
                    //    System.out.println("0");
                    continue;
                } else {
                    int s = 1;
                    while (true) {
                        w++;
                        if (w == keep2.length) {
                            Shape line7 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60);
                            g2.draw(line7);
                            Shape line11 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20, 660-ih*60+40);
                            g2.draw(line11);
                            Shape line12 = new Line2D.Double(20 + (w - s) * 20 + 20 * s, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60+40);
                            g2.draw(line12);

                            //    System.out.println("1的长度==" + s + (i - s));
                            break;
                        }
                        if (keep2[w] == 1) {
                            s++;
                        } else {
//
                            Shape line8 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60);
                            g2.draw(line8);
                            Shape line9 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20, 660-ih*60+40);
                            g2.draw(line9);
                            Shape line10 = new Line2D.Double(20 + (w - s) * 20 + 20 * s, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60+40);
                            g2.draw(line10);

                            //    System.out.println("1的长度==" + s + (i - s));
                            break;
                        }
                    }
                }


            }


        }
        System.out.println("result");
        System.out.println(result);
        jta.setText(String.valueOf(result));
        for (int i8 = 0; i8 < 64; i8++) {
            int k = (i8 + 1);
            if (k == 1 | k % 2 == 0) {

            }
            String H = String.valueOf(k);
            Shape line5 = new Line2D.Double(30 + 20 * i8, 700, 30 + 20 * i8, 710);
            g2.draw(line5);
            stroke = g2.getStroke();
            g2.drawString(H, 27 + i8 * 20, 722);
        }






        float[] dash1 = {2f, 0f, 2f};
        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        g2.setStroke(bs1);

        g2.setPaint(Color.RED);
        g2.drawLine(20, 40, 20, 700);
        g2.drawLine(1300, 40, 1300, 700);

    }

    public static void draw(Graphics2D g2, int[] keep2, int ih){
        int w = 0;
        while (w < keep2.length) {
            if (keep2[w] == 0) {
                Shape line6 = new Line2D.Double(20 + 20 * w, 700-ih*60, 40 + 20 * w, 700-ih*60);
                g2.draw(line6);
                w++;
                //    System.out.println("0");
                continue;
            } else {
                int s = 1;
                while (true) {
                    w++;
                    if (w == keep2.length) {
                        Shape line7 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60);
                        g2.draw(line7);
                        Shape line11 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20, 660-ih*60+40);
                        g2.draw(line11);
                        Shape line12 = new Line2D.Double(20 + (w - s) * 20 + 20 * s, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60+40);
                        g2.draw(line12);

                        //    System.out.println("1的长度==" + s + (i - s));
                        break;
                    }
                    if (keep2[w] == 1) {
                        s++;
                    } else {
//
                        Shape line8 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60);
                        g2.draw(line8);
                        Shape line9 = new Line2D.Double(20 + (w - s) * 20, 660-ih*60, 20 + (w - s) * 20, 660-ih*60+40);
                        g2.draw(line9);
                        Shape line10 = new Line2D.Double(20 + (w - s) * 20 + 20 * s, 660-ih*60, 20 + (w - s) * 20 + 20 * s, 660-ih*60+40);
                        g2.draw(line10);

                        //    System.out.println("1的长度==" + s + (i - s));
                        break;
                    }
                }
            }


        }


    }


    public static void tocorrect(int[] keep2){
        for (int jiemi = 0; jiemi <keep2.length; jiemi++) {
            int hilei = jiemi% 8;
            switch (hilei) {
                case 0: //a分支
                    keep2[jiemi]=keep2[jiemi]^0;
                    //   System.out.println(keep2[jiemi]);
                    break;
                case 1: //b分支
                    keep2[jiemi]=keep2[jiemi]^1;
                    break;

                case 2: //c分支
                    keep2[jiemi]=keep2[jiemi]^0;
                    break;
                case 3: //d分支
                    keep2[jiemi]=keep2[jiemi]^1;
                    break;
                case 4: //d分支
                    keep2[jiemi]=keep2[jiemi]^0;
                    break;
                case 5: //d分支
                    keep2[jiemi]=keep2[jiemi]^1;
                    break;
                case 6: //d分支
                    keep2[jiemi]=keep2[jiemi]^0;
                    break;
                case 7: //d分支
                    keep2[jiemi]=keep2[jiemi]^1;
                    break;
                default:
                    break;
            }


        }

    }
}
