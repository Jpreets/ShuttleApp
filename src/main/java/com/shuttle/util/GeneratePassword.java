/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
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

    /**
     * This method generates a random password of 8 characters in length
     * @return 
     */
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
