package ru.rrozhkov.lib.crypt;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by rrozhkov on 3/9/2017.
 */
public class Encrypter {
    public static String encrypt(String text){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA");
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        try {
            md.update(text.getBytes("UTF-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        byte raw[] = md.digest();
        String hash = (new BASE64Encoder()).encode(raw); //step 5
        return hash;
    }

    public static void main(String[] args) {
        String password = "123";
        System.out.println(Encrypter.encrypt(password));
    }
}
