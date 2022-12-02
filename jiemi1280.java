package org.example;

import java.util.Arrays;

public class jiemi1280 {
    public static int[] a =new int[0];
    public static int[] arraybig=new int[1280];
    public static void  add(int h){
        arraybig[a[0]]=h;
        if(a[0]==1279) return;
        a[0]++;
    }
    public static void jiemi(byte [] big,int [] array1280){
        for (int i = 0; i < 10; i++) {
            byte []ad=new byte[16];
            for (int j = 0; j < 16; j++) {
                ad[j]=big[i*16+j];
            }


            for (int j = 0; j < 16; j++) {
                for(int i2 = 7;i2 >= 0; i2--){
                    int h=ad[j] >>> i2 & 1;

                    array1280[128*i+i2+j*8]=h;
                }

            }

        }

    }

    public static void main(String[] args) {
        jiemi1280 p=new jiemi1280();
        int []aaaa=new int[1280];
        byte [] as=new byte[32];
        as[0]=3;as[1]=-71;as[2]=77;as[3]=-124;as[4]=9;as[5]=53;as[6]=-47;as[7]=111;
        as[8]=-71;as[9]=126;as[10]=-58;as[11]=87;as[12]=-72;as[13]=107;as[14]=-5;
        as[15]=-123;as[16]=3;as[17]=-71;as[18]=77;as[19]=-124;
        p.jiemi(as,aaaa);
        System.out.println(Arrays.toString(aaaa));
        System.out.println(aaaa[128]);
        System.out.println(aaaa[129]);
        System.out.println(aaaa[130]);
        System.out.println(aaaa[131]);
    }
}
