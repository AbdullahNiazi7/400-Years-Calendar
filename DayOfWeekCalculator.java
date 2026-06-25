/**
 * Calculates the day of the week for any given Gregorian calendar date
 * using Zeller's Congruence.
 *
 * This works for any year because it relies only on year/100 (century)
 * and year%100 (year-of-century) arithmetic - the same arithmetic that
 * makes the calendar repeat exactly every 400 years.
 */
public class DayOfWeekCalculator {

    /**
     * Returns the day of week for the given date.
     * 0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday,
     * 4 = Thursday, 5 = Friday, 6 = Saturday.
     */
    public static int getDayOfWeek(int day, int month, int year) {
        int m = month;
        int y = year;

        // Zeller's congruence treats January and February as months
        // 13 and 14 of the *previous* year.
        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int K = y % 100;       // year of the century
        int J = y / 100;       // zero-based century

        // h: 0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday
        int h = (day + (13 * (m + 1)) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;

        // Convert so that 0 = Sunday, ..., 6 = Saturday (easier for printing grids)
        return (h + 6) % 7;
    }
}
