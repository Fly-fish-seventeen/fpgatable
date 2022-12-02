package org.example;

import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.xjfme.encrypt.utils.Util;

import java.util.Arrays;

import static cn.xjfme.encrypt.utils.Util.hexStringToBytes;

public class sm4Demo {

    //key必须是16字节，即128位
    final static String key = "UUUU" +
            "UUUU" +
            "UUUU" +
            "UUUU";

    //指明加密算法和秘钥
    static SymmetricCrypto sm4 = new SymmetricCrypto("SM4/ECB/ZeroPadding", key.getBytes());

    //加密为16进制，也可以加密成base64/字节数组
    public static byte[] encryptSm4(byte[] b) {
        return sm4.encrypt(b);
    }

    //解密
    public static byte[] decryptSm4(byte[]  ciphertext) {
        return sm4.decrypt(ciphertext);
    }

    public static void main(String[] args) {
        String[] sss=new  String[3];
        sss[0]="55555555555555555555555555555550";
        sss[1]="f5555555555555555555555555555555";
        sss[2]="55555555555555555555555555555551";

        for (String s:sss)
              {

            byte [] as=encryptSm4(hexStringToBytes(s));
                  System.out.println(as[0]+" "+as[1]);
            String encodeHexString = Util.encodeHexString(as);//byte数组转16进制字符串。
            System.out.println(encodeHexString);

        }


        byte[]a2= {-88, -106, 120, 46, 98, 80, -41, 108, -84, -117, 122, -128, 22, -98, 93, 102};
        byte[] by=decryptSm4(a2);
        System.out.println(Arrays.toString(by));












//        String plain = Arrays.toString(encryptSm4(mingwen.getBytes()));
//
//        String cipher = Arrays.toString(decryptSm4(as));
//        System.out.println(plain);
//        System.out.println(cipher);


    }
}

