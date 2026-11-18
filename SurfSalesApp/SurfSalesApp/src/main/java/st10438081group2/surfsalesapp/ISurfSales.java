package st10438081group2.surfsalesapp;

/**
 * Interface given in the 2026 mock exam (Q.2.4), copied exactly as printed.
 * It lists the methods the SurfSales class must provide. An interface only
 * says WHAT methods exist; the implementing class says HOW they work
 * (Farrell, 2023, p.371).
 *
 * References:
 * Farrell, J., 2023. Java programming. 10th ed. Boston: Cengage.
 *
 * @author adria
 */
public interface ISurfSales {

    int[][] GetProductSales();

    int GetTotalSales();

    int GetSalesOverTarget();

    int GetSalesUnderTarget();

    int GetYearsProcessed();

    double GetAverageSales();
}