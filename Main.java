import java.util.Scanner;

/**
 * 400 Years Calendar
 *
 * A console application that displays Gregorian calendars for any month
 * or year. It works correctly across the entire 400-year Gregorian cycle
 * (the calendar's weekday pattern repeats every 400 years) because the
 * day-of-week and leap-year logic are computed mathematically rather than
 * looked up from a fixed table.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===================================");
        System.out.println("        400 YEARS CALENDAR");
        System.out.println("===================================");
        System.out.println("Supports any year from 1582 onward");
        System.out.println("(the start of the Gregorian calendar).");

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View calendar for a month");
            System.out.println("2. View calendar for a full year");
            System.out.println("3. Check if a year is a leap year");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    int month = readMonth(scanner);
                    int year1 = readYear(scanner);
                    CalendarPrinter.printMonth(month, year1);
                    break;
                case 2:
                    int year2 = readYear(scanner);
                    CalendarPrinter.printYear(year2);
                    break;
                case 3:
                    int year3 = readYear(scanner);
                    boolean leap = LeapYearUtil.isLeapYear(year3);
                    System.out.println(year3 + " is " + (leap ? "a leap year." : "NOT a leap year."));
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int readMonth(Scanner scanner) {
        System.out.print("Enter month (1-12): ");
        int month = readInt(scanner);
        while (month < 1 || month > 12) {
            System.out.print("Month must be between 1 and 12. Try again: ");
            month = readInt(scanner);
        }
        return month;
    }

    private static int readYear(Scanner scanner) {
        System.out.print("Enter year (1582 or later): ");
        int year = readInt(scanner);
        while (year < 1582) {
            System.out.print("The Gregorian calendar starts at 1582. Enter a valid year: ");
            year = readInt(scanner);
        }
        return year;
    }
}
