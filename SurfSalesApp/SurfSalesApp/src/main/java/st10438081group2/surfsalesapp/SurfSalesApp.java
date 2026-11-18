package st10438081group2.surfsalesapp;

/**
 * Main class for Question 2 (2026 mock). NetBeans runs this class with F6;
 * it opens the Surf Shop Sales Tracker form in the centre of the screen.
 *
 * @author adria
 */
public class SurfSalesApp {

    public static void main(String[] args) {
        SurfSalesForm form = new SurfSalesForm();
        form.setLocationRelativeTo(null);   // centre the window on the screen
        form.setVisible(true);              // show the form
    }
}