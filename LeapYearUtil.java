/**
 * Utility class for leap year calculations under the Gregorian calendar rules.
 *
 * A year is a leap year if:
 *   - it is divisible by 4, AND
 *   - it is NOT divisible by 100, UNLESS it is also divisible by 400.
 *
 * This century-based exception is exactly why the Gregorian calendar's
 * weekday pattern only fully repeats every 400 years (146,097 days,
 * which is evenly divisible by 7).
 */
public class LeapYearUtil {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int daysInMonth(int month, int year) {
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysPerMonth[month - 1];
    }
}
