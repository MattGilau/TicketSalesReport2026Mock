# TicketSalesReport – PROG6112 2026 Practice Exam, Question 1

**Student:** Adrian Gilau (ST10438081)
**Module:** Programming 1B (PROG6112)
**Package:** `st10438081group2.ticketsalesreport`

## About

A console application that prints the Harbourlight Theatre ticket sales report. The season names are stored in a single-dimensional array and the ticket sales in a two-dimensional array (rows = years, columns = seasons). The report prints the sales in rows and columns, followed by the total, average (rounded to the nearest whole number), highest and lowest season sales.

## Files

| File | Purpose |
| --- | --- |
| `ITicketSales.java` | Interface given in the paper (Q.1.2) |
| `TicketSales.java` | Implements `ITicketSales`: total, average, highest and lowest |
| `TicketSalesReport.java` | Main class: arrays and the formatted console report (Q.1.1) |
| `TicketSalesTest.java` | JUnit 5 tests (Q.1.3) |

## How to run

1. Open the project in NetBeans (Java with Maven, JDK 17 or later).
2. Run the report with **F6** (Run Project).
3. Run the tests with **Alt+F6** (Test Project), or right-click `TicketSalesTest.java` > **Test File**.

## Expected output

```text
THEATRE TICKET SALES REPORT - 2026
----------------------------------------------
           SUMMER   AUTUMN   WINTER   SPRING
YEAR 1        420      310      180      390
YEAR 2        450      280      220      390
----------------------------------------------
Total tickets sold: 2640
Average per season: 330
Highest season: 450
Lowest season: 180
----------------------------------------------
```

## Unit tests

| Test | Expected result |
| --- | --- |
| `CalculateTotalTicketSales_ReturnsTotalTicketSales` | 2640 |
| `AverageTicketSales_ReturnsAverageTicketSales` | 330.0 (delta 0.01) |

## AI disclosure

Claude (Anthropic, 2026) was used before the exam to prepare study notes, practice memos and code templates. The code in this repository was typed and tested by me.

## How to cite this repository

Gilau, A., 2026b. TicketSalesReport2026Mock [Source code] Available at: <https://github.com/MattGilau/TicketSalesReport2026Mock> [Accessed 18 November 2026].

In-text: (Gilau, 2026b)

## Reference list

Anthropic, 2026. Claude (Opus 5.5) [Computer program] Available at: <https://claude.ai> [Accessed 18 November 2026].

Farrell, J., 2023. *Java programming*. 10th ed. Boston: Cengage.

JUnit, [s.a.]. JUnit 5 user guide. [online] Available at: <https://junit.org/junit5/docs/current/user-guide/> [Accessed 18 November 2026].
