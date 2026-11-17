package st10438081group2.ticketsalesreport;

/**
 * Interface given in the 2026 mock exam
 * Declares the four calculations the TicketSales must provide
 * @author adria
 */
public interface ITicketSales {

    int TotalTicketSales(int[][] ticketSales);

    double AverageTicketSales(int[][] ticketSales);

    int HighestSale(int[][] ticketSales);

    int LowestSale(int[][] ticketSales);
}
