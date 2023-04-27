package br.com.api.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilsMd5 {

    private static UtilsMd5 instance;
    private MessageDigest md5;

    public String convert(String text) {
        md5.update(text.getBytes(), 0, text.length());
        return new BigInteger(1, md5.digest()).toString(16);
    }

    private UtilsMd5() throws NoSuchAlgorithmException {
        md5 = MessageDigest.getInstance("MD5");
    }

    public static UtilsMd5 getInstance() throws NoSuchAlgorithmException {
        return instance == null ? new UtilsMd5() : instance;
    }
}
