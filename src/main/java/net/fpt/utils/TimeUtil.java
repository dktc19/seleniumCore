package net.fpt.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TimeUtil {
    /**
     * Author: MinhLH5
     * Mô tả: trả về string thời gian hiện tại, theo định dạng được truyền vào trước
     * Các kiểu format https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * VD:  yyyy MM dd
     * @param formatTime
     * @return String
     */
    public static String getCurrentTimeByFormat(String formatTime){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatTime);
        return date.format(formatter);
    }

    /**
     * Author: MinhLH5
     * Mô tả: trả về string thời gian tương lai n ngày so với ngày hiện tại, theo định dạng được truyền vào trước
     * Các kiểu format https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     *
     * @param formatTime VD:  "yyyy MM dd"
     * @param day 1,2,3
     * @return String
     */
    public static String getDateStringPlusDays(String formatTime, Integer day){
        LocalDate date = LocalDate.now().plusDays(day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatTime);
        return date.format(formatter);
    }

    /**
     * Author: MinhLH5
     * Mô tả: trả về string thời gian quá khứ n ngày so với ngày hiện tại, theo định dạng được truyền vào trước
     * Các kiểu format https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * VD:  yyyy MM dd
     * @param formatTime VD:  "yyyy MM dd"
     * @param day 1,2,3
     * @return String
     */
    public static String getDateStringMinusDays(String formatTime, Integer day){
        LocalDate date = LocalDate.now().minusDays(day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatTime);
        return date.format(formatter);
    }

    // Random number
    private static final String CHAR_LIST = "0123456789";
    public String getRandomYMDHMS(){
        Date now = new Date();
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);
    }
    public String getRandomDHMS(){
        Date now = new Date();
        return new SimpleDateFormat("ddHHmmss", Locale.ENGLISH).format(now);
    }

    private static final int RANDOM_STRING_LENGTH = 7;


    public  static String generateRandomString()
    {
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++)
        {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }


    private static  int getRandomNumber()
    {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1)
        {
            return randomInt;
        }
        else
        {
            return randomInt - 1;
        }
    }
}
