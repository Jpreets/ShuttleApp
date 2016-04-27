/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.util;

/**
 *
 * @author baldeep
 */
import java.security.SecureRandom;
import java.util.Random;

public class GeneratePassword {

    private static final Random RANDOM = new SecureRandom();

    public static final int PASSWORD_LENGTH = 8;

    public static String randomPassword() {
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
        String pw = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = (int) (RANDOM.nextDouble() * letters.length());
            pw += letters.substring(index, index + 1);
        }
        return pw;
    }
}
