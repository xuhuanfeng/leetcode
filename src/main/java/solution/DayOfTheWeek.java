package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 11:52
 * @see <a href="https://leetcode.com/contest/weekly-contest-153/problems/day-of-the-week/">5183. Day of the Week</a>
 */
public class DayOfTheWeek {
    // 第一次知道原来有公式可以算出来，吉姆拉尔森公式
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month < 3) {
            month += 12;
            year--;
        }
        int weekDay = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7;
        return week[weekDay];
    }
}
