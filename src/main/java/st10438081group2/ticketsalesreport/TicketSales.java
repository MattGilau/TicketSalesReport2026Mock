package st10438081group2.ticketsalesreport;

/**
 * This is the class that will be used to calculate the total, average, highest
 * and lowest ticket sales. It implements ITicketSales.
 *
 * @author adria
 */
public class TicketSales implements ITicketSales {

    // Method to calculate the total ticket sales
    @Override
    public int TotalTicketSales(int[][] ticketSales) {

        // TOTAL: calculate the total of every value in the 2D array
        int total = 0;
        for (int row = 0; row < ticketSales.length; row++) {
            for (int col = 0; col < ticketSales[row].length; col++) {
                total += ticketSales[row][col];
            }
        }

        return total;
    }

    // Method to calculate the average ticket sales: total divided by the number of values
    @Override
    public double AverageTicketSales(int[][] ticketSales) {

        // AVERAGE: total / number of values, cast to double first
        int count = 0;
        for (int row = 0; row < ticketSales.length; row++) {
            count += ticketSales[row].length;
        }

        // cast to double so the division is not integer division
        double average = (double) TotalTicketSales(ticketSales) / count;
        return average;
    }

    // Method to determine the highest value
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

    // Method to determine the lowest value
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
