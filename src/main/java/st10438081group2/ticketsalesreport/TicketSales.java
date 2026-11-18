package st10438081group2.ticketsalesreport;

/**
 * TicketSales implements ITicketSales (2026 mock, Q.1.2). It calculates the
 * total, average, highest and lowest ticket sales from a 2D array (rows =
 * years, columns = seasons). The data is passed in as a parameter, so the class
 * needs no fields.
 *
 * Techniques used: - implementing an interface with @Override (Farrell, 2023,
 * pp.337, 371); - passing an array to a method (Farrell, 2023, p.289); - nested
 * for loops over a 2D array using .length (Farrell, 2023, pp.220, 300-303); -
 * casting to double to avoid integer division (Farrell, 2023, p.595).
 *
 * References: Farrell, J., 2023. Java programming. 10th ed. Boston: Cengage.
 *
 * AI disclosure: Claude (Anthropic, 2026) was used before the exam to prepare
 * study notes and practice code. This file was typed and tested by me.
 * Anthropic, 2026. Claude (Opus 5.5) [Computer program] Available at:
 * <https://claude.ai> [Accessed 18 November 2026].
 *
 * @author adria
 */
public class TicketSales implements ITicketSales {

    /**
     * Adds every value in the 2D array.
     *
     * @param ticketSales the sales data, one row per year
     * @return the total ticket sales
     */
    @Override
    public int TotalTicketSales(int[][] ticketSales) {
        int total = 0;
        // outer loop picks a year (row), inner loop walks its seasons (columns)
        for (int row = 0; row < ticketSales.length; row++) {
            for (int col = 0; col < ticketSales[row].length; col++) {
                total += ticketSales[row][col];
            }
        }
        return total;
    }

    /**
     * Average = total / number of values.
     *
     * @param ticketSales the sales data, one row per year
     * @return the average sale per season (not rounded; the report rounds it)
     */
    @Override
    public double AverageTicketSales(int[][] ticketSales) {
        // count how many values are in the array
        int count = 0;
        for (int row = 0; row < ticketSales.length; row++) {
            count += ticketSales[row].length;
        }
        // cast to double so the division is not integer division
        return (double) TotalTicketSales(ticketSales) / count;
    }

    /**
     * Finds the highest value: start with the first value and replace it
     * whenever a larger value is found.
     *
     * @param ticketSales the sales data, one row per year
     * @return the highest single season sale
     */
    @Override
    public int HighestSale(int[][] ticketSales) {
        int highest = ticketSales[0][0];
        for (int row = 0; row < ticketSales.length; row++) {
            for (int col = 0; col < ticketSales[row].length; col++) {
                if (ticketSales[row][col] > highest) {
                    highest = ticketSales[row][col];
                }
            }
        }
        return highest;
    }

    /**
     * Finds the lowest value: start with the first value and replace it
     * whenever a smaller value is found.
     *
     * @param ticketSales the sales data, one row per year
     * @return the lowest single season sale
     */
    @Override
    public int LowestSale(int[][] ticketSales) {
        int lowest = ticketSales[0][0];
        for (int row = 0; row < ticketSales.length; row++) {
            for (int col = 0; col < ticketSales[row].length; col++) {
                if (ticketSales[row][col] < lowest) {
                    lowest = ticketSales[row][col];
                }
            }
        }
        return lowest;
    }
}
