/**
 * Handles formatted console output of calendar grids.
 */
public class CalendarPrinter {

    private static final String[] MONTH_NAMES = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    public static void printMonth(int month, int year) {
        System.out.println();
        String header = MONTH_NAMES[month - 1] + " " + year;
        int padding = Math.max(0, (28 - header.length()) / 2);
        System.out.println(" ".repeat(padding) + header);
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");

        int startDay = DayOfWeekCalculator.getDayOfWeek(1, month, year);
        int totalDays = LeapYearUtil.daysInMonth(month, year);

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        int column = startDay;
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%2d  ", day);
            column++;
            if (column == 7) {
                System.out.println();
                column = 0;
            }
        }
        System.out.println();
    }

    public static void printYear(int year) {
        System.out.println("=================================");
        System.out.println("              " + year);
        System.out.println("=================================");
        for (int month = 1; month <= 12; month++) {
            printMonth(month, year);
        }
    }
}
