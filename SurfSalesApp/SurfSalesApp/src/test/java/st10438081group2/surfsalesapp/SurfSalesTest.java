package st10438081group2.surfsalesapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the SurfSales class (2026 mock, Q.2.5).
 * The test names are copied exactly from the paper. assertEquals takes the
 * expected value first and the actual value second (JUnit, s.a.).
 *
 * References:
 * JUnit, [s.a.]. JUnit 5 user guide. [online] Available at:
 * <https://junit.org/junit5/docs/current/user-guide/> [Accessed 18 November 2026].
 *
 * @author adria
 */
public class SurfSalesTest {

    // the same data as the paper's table, so the expected answers are known
    private final int[][] salesData = {
        {520, 380, 150}, // year 1: Surfboards, Wetsuits, Bodyboards
        {610, 340, 210}, // year 2
        {450, 290, 200}  // year 3
    };

    @Test
    public void GetSalesOverTarget_ReturnsNumberOfSales() {
        SurfSales surfSales = new SurfSales(salesData);
        // over 400: 520, 610 and 450 = 3 sales
        assertEquals(3, surfSales.GetSalesOverTarget());
    }

    @Test
    public void GetSalesUnderTarget_ReturnsNumberOfSales() {
        SurfSales surfSales = new SurfSales(salesData);
        // 9 sales in total - 3 over target = 6 sales at 400 or less
        assertEquals(6, surfSales.GetSalesUnderTarget());
    }
}