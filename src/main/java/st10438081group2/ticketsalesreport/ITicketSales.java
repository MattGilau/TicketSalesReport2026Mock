package st10438081group2.ticketsalesreport;

/**
 * Interface given in the 2026 mock exam (Q.1.2), copied exactly as printed. It
 * declares the four calculations the TicketSales class must provide. An
 * interface only says WHAT methods exist; the implementing class says HOW they
 * work (Farrell, 2023, p.371).
 *
 * References: Farrell, J., 2023. Java programming. 10th ed. Boston: Cengage.
 *
 * @author adria
 */
public interface ITicketSales {

    int TotalTicketSales(int[][] ticketSales);

    double AverageTicketSales(int[][] ticketSales);

    int HighestSale(int[][] ticketSales);

    int LowestSale(int[][] ticketSales);
}
