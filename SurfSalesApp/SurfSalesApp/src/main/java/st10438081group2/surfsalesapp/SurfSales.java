package st10438081group2.surfsalesapp;

/**
 * SurfSales stores the Southcoast Surf Co. sales data and performs the
 * calculations required by the ISurfSales interface (2026 mock, Q.2.4).
 * The 2D array has one row per year and one column per product
 * (Surfboards, Wetsuits, Bodyboards).
 *
 * Techniques used:
 * - implementing an interface with @Override (Farrell, 2023, pp.337, 371);
 * - a private field set through a constructor using "this" (Farrell, 2023,
 *   pp.126, 131-134);
 * - a static final constant for the sales target (Farrell, 2023, p.140);
 * - nested for loops over a 2D array and .length (Farrell, 2023, pp.220, 300-303).
 *
 * References:
 * Farrell, J., 2023. Java programming. 10th ed. Boston: Cengage.
 *
 * AI disclosure: Claude (Anthropic, 2026) was used before the exam to prepare
 * study notes and practice code. This file was typed and tested by me.
 * Anthropic, 2026. Claude (Opus 5.5) [Computer program] Available at:
 * <https://claude.ai> [Accessed 18 November 2026].
 *
 * @author adria
 */
public class SurfSales implements ISurfSales {

    // The paper says the sales target of 400 must be stored as a constant
    public static final int SALES_TARGET = 400;

    // The sales data: private so it can only be reached through the getter
    private final int[][] productSales;

    /**
     * Constructor: receives the sales data and stores it in the field.
     *
     * @param productSales the sales figures, one row per year
     */
    public SurfSales(int[][] productSales) {
        this.productSales = productSales;
    }

    /**
     * @return the sales data stored in this object
     */
    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    /**
     * Adds every sales figure in the 2D array.
     *
     * @return the total of all sales
     */
    @Override
    public int GetTotalSales() {
        int total = 0;
        // outer loop picks a year (row), inner loop walks its products (columns)
        for (int row = 0; row < productSales.length; row++) {
            for (int col = 0; col < productSales[row].length; col++) {
                total += productSales[row][col];
            }
        }
        return total;
    }

    /**
     * Counts the sales that are over the target.
     * Paper rule: a sale is over target if it is GREATER THAN 400.
     *
     * @return the number of sales above SALES_TARGET
     */
    @Override
    public int GetSalesOverTarget() {
        int count = 0;
        for (int row = 0; row < productSales.length; row++) {
            for (int col = 0; col < productSales[row].length; col++) {
                if (productSales[row][col] > SALES_TARGET) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Counts the sales that are under target.
     * Paper rule: under target means 400 OR LESS, which is every sale that is
     * not over target, so the over-target method is reused instead of
     * repeating the loop (code efficiency).
     *
     * @return the number of sales at or below SALES_TARGET
     */
    @Override
    public int GetSalesUnderTarget() {
        return countSales() - GetSalesOverTarget();
    }

    /**
     * The number of years is the number of rows in the array. It is worked
     * out from the array, not typed in as a fixed value (paper Q.2.2).
     *
     * @return the number of years processed
     */
    @Override
    public int GetYearsProcessed() {
        return productSales.length;
    }

    /**
     * Average = total / number of sales. The total is cast to double first
     * so that the division is not integer division (Farrell, 2023, p.595).
     *
     * @return the average sales figure (not rounded; the form rounds it)
     */
    @Override
    public double GetAverageSales() {
        return (double) GetTotalSales() / countSales();
    }

    /**
     * Helper method so the counting loop is only written once.
     *
     * @return how many sales figures are in the array
     */
    private int countSales() {
        int count = 0;
        for (int row = 0; row < productSales.length; row++) {
            count += productSales[row].length;
        }
        return count;
    }
}