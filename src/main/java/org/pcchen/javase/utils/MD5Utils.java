package org.pcchen.javase.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ceek
 * @create 2020-01-16 17:27
 **/
public class MD5Utils {
    public static void main(String[] args) {
        try {
            List<String> strList = new ArrayList<String>();
            strList.add("CGSISIJM");
            strList.add("001vupjK1h2bG1033RIK1UDtjK1vupj7");

            Collections.sort(strList);

            byte[] contentBytes = getContentBytes(strList.toString(), "GBK");
            System.out.println(Arrays.toString(contentBytes));
            String sign = null;

//            cn.com.infosec.util.encoders.Base64.encode(WechatProfileController.digest(contentBytes));

            System.out.println(new BASE64Encoder().encode(MD5Utils.getMD5OfStr(contentBytes)));
            System.out.println(sign);


//            System.out.println(cn.com.infosec.util.encoders.Base64.encode(MD5Utils.digest(contentBytes)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final byte[] digest(byte[] abyte0) {
        byte abyte1[];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(abyte0);
            abyte1 = messageDigest.digest();
            System.out.println(Arrays.toString(abyte1));
            return abyte1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] getContentBytes(String content, String charset) {
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到字符串经过MD5转换后的字符串
     *
     * @return
     */
    public static byte[] getMD5OfStr(byte by[]) {
        String origMD5 = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            byte[] abc = new byte[] {52,73,-30,9,72,-106,20,87,102,-12,120,-110,-86,85};
//            md5.update(by);
//            byte result[] = md5.digest();
            byte result[] = md5.digest(by);
            return result;
//            byte[] result = md5.digest(abc);
//            origMD5 = byteArray2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
