package com.shuttle.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author baldeep
 */
public class GenerateFileName {

    static SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String createFileName(String fileName) {
        return formatDate.format(new Date()) + "." + FilenameUtils.getExtension(fileName);
    }
}
