package st10438081group2.ticketsalesreport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for TicketSales (2026 mock, Q.1.3).
 * Test names match the paper exactly.
 *
 * @author adria
 */
public class TicketSalesTest {

    // same data as the paper, so the expected answers are known
    private final int[][] ticketSales = {
        {420, 310, 180, 390},
        {450, 280, 220, 390}
    };

    private final TicketSales sales = new TicketSales();

    @Test
    public void CalculateTotalTicketSales_ReturnsTotalTicketSales() {
        // 420+310+180+390 + 450+280+220+390 = 2640
        assertEquals(2640, sales.TotalTicketSales(ticketSales));
    }

    @Test
    public void AverageTicketSales_ReturnsAverageTicketSales() {
        // 2640 / 8 values = 330.0 (double, so a delta is needed)
        assertEquals(330.0, sales.AverageTicketSales(ticketSales), 0.01);
    }
}