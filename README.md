# 400 Years Calendar

A console-based Java application that displays the Gregorian calendar for any month or year, computed mathematically rather than hard-coded.

# Why "400 Years"?

The Gregorian calendar's weekday pattern repeats exactly every 400 years (146,097 days, which divides evenly by 7). This only works because of the century leap-year exception:
Divisible by 4 -> leap year
...unless also divisible by 100 -> NOT a leap year
...unless also divisible by 400 -> leap year after all
(e.g. 1700, 1800, 1900 are NOT leap years, but 1600 and 2000 ARE.)
Because the program calculates leap years and weekdays with this exact rule (via LeapYearUtil and Zeller's Congruence in DayOfWeekCalculator), it produces a correct calendar for any year in the cycle, not just a pre-stored range.


# Project Structure

src/
  Main.java                 - menu-driven console UI
  LeapYearUtil.java         - leap year + days-in-month logic
  DayOfWeekCalculator.java  - Zeller's Congruence day-of-week calculation
  CalendarPrinter.java      - formats and prints month/year grids

  
# How to Compile and Run

javac -d out src/*.java
java -cp out Main


Features

View the calendar for any single month/year
View the full calendar for any year
Check whether a given year is a leap year
Team / Contribution Workflow
This project is developed collaboratively via Git. Each member should:
Clone the repository
Work on a feature branch (git checkout -b yourname-feature)
Commit changes with clear messages
Push and open a Pull Request into main
Commit history for all members is included as a screenshot in the accompanying project report.
