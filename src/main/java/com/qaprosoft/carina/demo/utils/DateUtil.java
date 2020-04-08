package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.demo.gui.components.Constants;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateUtil {
    private static Logger LOGGER = Logger.getLogger(DateUtil.class);

    public static LocalDate parseDate(String date) {
        //  Array of strings with the comment's date
        LOGGER.info("Date in String = " + date);
        String[] dateStrings = date.split(Constants.SPLIT_DATE);

        //  Parse string date to LocalDate
        //  If comment was added recently(during hour)
        LOGGER.info("'" + dateStrings[1] + "' compare to '" + Constants.MINUTES + "'");
        if (dateStrings[1].equalsIgnoreCase(Constants.MINUTES)) {
            return LocalDate.now();
        } else {
            //  If comment was added recently(during twenty-four hours)
            LOGGER.info("'" + dateStrings[1] + "' compare to '" + Constants.HOURS + "'");
            if (dateStrings[1].equalsIgnoreCase(Constants.HOURS)) {
                //  How many hours ago was added comment
                int hourComment = Integer.parseInt(dateStrings[0]);
                LOGGER.info(hourComment + " " + Constants.HOURS + " ago was added comment");
                //  What hour at the moment
                int hourNow = LocalTime.now().getHour();
                LOGGER.info(hourNow + " hour now");
                // If comment was added today or yesterday
                LOGGER.info(hourComment + " compare to " + hourNow);
                if (hourComment <= hourNow) {
                    LOGGER.info(hourComment + " <= " + hourNow);
                    return LocalDate.now();
                } else {
                    LOGGER.info(hourComment + " > " + hourNow);
                    return LocalDate.now().minusDays(1);
                }
            } else {
                //  If comment was added more than day ago
                //  Day of month
                int day = Integer.parseInt(dateStrings[0]);
                //  Month of year
                int month = 0;
                //  Year
                int year = Integer.parseInt(dateStrings[2]);

                //  Parse name month to number month of year
                LOGGER.info("If " + Constants.SHORT_NAME_MONTHS + " contains '" + dateStrings[1] + "'");
                if (Constants.SHORT_NAME_MONTHS.contains(dateStrings[1])) {
                    month = Constants.SHORT_NAME_MONTHS.indexOf(dateStrings[1]) + 1;
                    LOGGER.info(dateStrings[1] + " is " + month + "(-st/-rd/-th) month of year");
                }
                //  Date for compare
                return LocalDate.of(year, month, day);
            }
        }
    }
}