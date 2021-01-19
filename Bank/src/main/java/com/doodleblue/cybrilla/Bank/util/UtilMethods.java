package com.doodleblue.cybrilla.Bank.util;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class UtilMethods {

    public String getIfscCode() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        int n = 8;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
        public long getAccountNo() {
        long randomPin   =(int) (Math.random()*900000000)+100000000;
        return randomPin;
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public boolean isValidMobileNumber(String num){

        Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        Matcher m = p.matcher(num);
        return (m.find() && m.group().equals(num));
    }
    public boolean isValidZipCode(String num){
        Pattern p = Pattern.compile("^[1-9][0-9]{5}$");
        Matcher m = p.matcher(num);
        return (m.find() && m.group().equals(num));
    }
    public boolean isValidPan(String num){
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        if (num == null) {
            return false;
        }
        Matcher m = p.matcher(num);
        return m.matches();
    }
    /*public String encrypt(String en) {
        String hashedPassword=null;
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(en);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return hashedPassword;

    }
    public boolean passwordMatch(String password,String enpassword) {
        boolean status=false;
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            status=passwordEncoder.matches(password, enpassword);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }*/
}

