package solution;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-11 10:32
 * @see <a href="https://leetcode.com/contest/weekly-contest-149/problems/ordinal-number-of-date/">1154. Day of the Year</a>
 */
public class DayOfTheYear {
    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        switch (month) {
            case 12:
                day += 30;
            case 11:
                day += 31;
            case 10:
                day += 30;
            case 9:
                day += 31;
            case 8:
                day += 31;
            case 7:
                day += 30;
            case 6:
                day += 31;
            case 5:
                day += 30;
            case 4:
                day += 31;
            case 3:
                day += 28;
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    day++;
                }
            case 2:
                day += 31;
        }
        return day;
    }

    @Test
    public void test01() {
        assertEquals(41, dayOfYear("2019-02-10"));
        assertEquals(9, dayOfYear("2019-01-09"));
        assertEquals(60, dayOfYear("2003-03-01"));
        assertEquals(61, dayOfYear("2004-03-01"));
        assertEquals(60, dayOfYear("2016-02-29"));
    }
}
