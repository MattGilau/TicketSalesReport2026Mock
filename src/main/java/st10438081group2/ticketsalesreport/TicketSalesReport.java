package st10438081group2.ticketsalesreport;

/**
 * Prints the Harbourlight Theatre ticket sales report (2026 mock, Q.1.1).
 * Season names are stored in a 1D array and the ticket sales in a 2D array
 * (rows = years, columns = seasons). The calculations are done by TicketSales.
 *
 * AI disclosure: study templates prepared with Claude (Anthropic) were used
 * while revising; this code was typed, adapted and tested by me.
 *
 * @author adria
 */
public class TicketSalesReport {

    public static void main(String[] args) {

        // 1D arrays: season headings (in capitals, as in the sample) and year labels
        String[] seasons = {"SUMMER", "AUTUMN", "WINTER", "SPRING"};
        String[] years = {"YEAR 1", "YEAR 2"};

        // 2D array: rows = years, columns = seasons
        int[][] ticketSales = {
            {420, 310, 180, 390}, // row 0 = Year 1
            {450, 280, 220, 390}  // row 1 = Year 2
        };

        // object that does the calculations
        TicketSales sales = new TicketSales();

        // report title and dashed line
        String line = "----------------------------------------------";
        System.out.println("THEATRE TICKET SALES REPORT - 2026");
        System.out.println(line);

        // heading row: an empty 8-wide cell, then each season 9 wide
        System.out.printf("%-8s", "");
        for (int col = 0; col < seasons.length; col++) {
            System.out.printf("%9s", seasons[col]);
        }
        System.out.println();

        // data rows: year label left-aligned, sales right-aligned under the headings
        for (int row = 0; row < ticketSales.length; row++) {
            System.out.printf("%-8s", years[row]);
            for (int col = 0; col < ticketSales[row].length; col++) {
                System.out.printf("%9d", ticketSales[row][col]);
            }
            System.out.println();
        }

        // summary lines: labels match the sample output
        System.out.println(line);
        System.out.println("Total tickets sold: " + sales.TotalTicketSales(ticketSales));
        // the paper asks for the average rounded to the nearest whole number
        System.out.println("Average per season: " + Math.round(sales.AverageTicketSales(ticketSales)));
        System.out.println("Highest season: " + sales.HighestSale(ticketSales));
        System.out.println("Lowest season: " + sales.LowestSale(ticketSales));
        System.out.println(line);
    }
}