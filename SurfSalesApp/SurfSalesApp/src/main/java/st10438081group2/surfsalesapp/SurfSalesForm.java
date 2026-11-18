package st10438081group2.surfsalesapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Surf Shop Sales Tracker form (2026 mock, Q.2.1 - Q.2.3).
 * - Two buttons load and save the sales data (Q.2.1).
 * - A read-only text area shows the results and a read-only label shows the
 *   number of years processed (Q.2.1, Q.2.2).
 * - Save writes the text area to sales_log.txt in the sample format (Q.2.2).
 * - A File menu (Exit) and a Tools menu (Load Sales Data, Save Sales Data,
 *   Clear) are provided; the menu items call the SAME methods as the buttons,
 *   so no logic is duplicated (Q.2.3).
 *
 * Techniques used:
 * - extending JFrame and implementing ActionListener, with getSource() to
 *   find which control was clicked (Farrell, 2023, pp.557, 563-567);
 * - BorderLayout and FlowLayout to place the controls (Farrell, 2023, p.555);
 * - JMenuBar, JMenu and JMenuItem, which are not covered in the textbook
 *   (Oracle, s.a.a);
 * - JTextArea set to read-only with setEditable(false) (Oracle, s.a.b);
 * - writing a text file with BufferedWriter inside try-catch
 *   (Farrell, 2023, pp.397, 457-458).
 *
 * References:
 * Farrell, J., 2023. Java programming. 10th ed. Boston: Cengage.
 * Oracle, [s.a.a]. How to use menus. [online] Available at:
 * <https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html>
 * [Accessed 18 November 2026].
 * Oracle, [s.a.b]. Class JTextArea (Java Platform SE 8). [online] Available at:
 * <https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextArea.html>
 * [Accessed 18 November 2026].
 *
 * AI disclosure: Claude (Anthropic, 2026) was used before the exam to prepare
 * study notes and practice code. This file was typed and tested by me.
 * Anthropic, 2026. Claude (Opus 5.5) [Computer program] Available at:
 * <https://claude.ai> [Accessed 18 November 2026].
 *
 * @author adria
 */
public class SurfSalesForm extends JFrame implements ActionListener {

    // ---------- data and constants ----------

    // the sales data "in memory": rows = years, columns = Surfboards, Wetsuits, Bodyboards
    private static final int[][] SALES_DATA = {
        {520, 380, 150},
        {610, 340, 210},
        {450, 290, 200}
    };

    // file name and layout lines, exactly as in the paper's sample
    private static final String FILE_NAME = "sales_log.txt";
    private static final String FILE_HEADING = "SALES LOG";
    private static final String STARS = "******************************";
    private static final String YEARS_LABEL = "Years Processed: ";

    // ---------- form controls (btn = button, txt = text area, lbl = label, mnu = menu item) ----------

    private final JButton btnLoad = new JButton("Load Sales Data");
    private final JButton btnSave = new JButton("Save Sales Data");
    private final JTextArea txtResults = new JTextArea(6, 28);
    private final JLabel lblYearsProcessed = new JLabel(YEARS_LABEL);

    private final JMenuItem mnuExit = new JMenuItem("Exit");
    private final JMenuItem mnuLoad = new JMenuItem("Load Sales Data");
    private final JMenuItem mnuSave = new JMenuItem("Save Sales Data");
    private final JMenuItem mnuClear = new JMenuItem("Clear");

    /**
     * Constructor: builds the window, the menu bar and the controls, and
     * registers this form as the listener for every button and menu item.
     */
    public SurfSalesForm() {
        super("Surf Shop Sales Tracker");                  // window title from the sample
        setSize(380, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // menu bar: File > Exit ; Tools > Load Sales Data, Save Sales Data, Clear
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuTools = new JMenu("Tools");
        mnuFile.add(mnuExit);
        mnuTools.add(mnuLoad);
        mnuTools.add(mnuSave);
        mnuTools.add(mnuClear);
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        // buttons side by side at the top, as in the sample screenshot
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);
        add(buttonPanel, BorderLayout.NORTH);

        // text area in the middle: read-only output, inside a scroll pane
        txtResults.setEditable(false);
        txtResults.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        add(new JScrollPane(txtResults), BorderLayout.CENTER);

        // label at the bottom: a JLabel cannot be typed into, so it is read-only
        add(lblYearsProcessed, BorderLayout.SOUTH);

        // the form listens to every button and menu item
        btnLoad.addActionListener(this);
        btnSave.addActionListener(this);
        mnuExit.addActionListener(this);
        mnuLoad.addActionListener(this);
        mnuSave.addActionListener(this);
        mnuClear.addActionListener(this);
    }

    /**
     * One place decides which shared method runs for each click. The Load
     * and Save menu items call the same methods as the buttons (Q.2.3).
     *
     * @param e the click event; getSource() returns the control clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btnLoad || source == mnuLoad) {
            loadSalesData();
        } else if (source == btnSave || source == mnuSave) {
            saveSalesData();
        } else if (source == mnuClear) {
            clearForm();
        } else if (source == mnuExit) {
            System.exit(0);                                 // close the application
        }
    }

    /**
     * Load: creates a SurfSales object from the data in memory, calculates the
     * results and displays them. The years processed come from the array via
     * GetYearsProcessed(), never from a typed-in value (Q.2.2).
     */
    private void loadSalesData() {
        SurfSales surfSales = new SurfSales(SALES_DATA);

        // the sample shows the average rounded to a whole number (350)
        txtResults.setText("Total Sales: " + surfSales.GetTotalSales() + "\n"
                + "Average Sales: " + Math.round(surfSales.GetAverageSales()) + "\n"
                + "Sales over target: " + surfSales.GetSalesOverTarget() + "\n"
                + "Sales under target: " + surfSales.GetSalesUnderTarget());

        lblYearsProcessed.setText(YEARS_LABEL + surfSales.GetYearsProcessed());
    }

    /**
     * Save: writes the heading, a line of stars, the text area's contents and
     * another line of stars to sales_log.txt (format from the paper's sample).
     * The file is created in the project folder.
     */
    private void saveSalesData() {
        // nothing to save until the data has been loaded
        if (txtResults.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please load the sales data first.");
            return;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(FILE_HEADING);
            writer.newLine();
            writer.write(STARS);
            writer.newLine();
            writer.write(txtResults.getText());
            writer.newLine();
            writer.write(STARS);
            writer.newLine();
            writer.close();                                 // close() makes sure the text is written
            JOptionPane.showMessageDialog(this, "Sales data saved to " + FILE_NAME);
        } catch (IOException ex) {
            // the compiler requires IOException to be handled (Farrell, 2023, p.397)
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    /**
     * Clear: empties the text area and clears the Years Processed label (Q.2.3).
     * The caption "Years Processed: " is kept so the user knows what the label shows.
     */
    private void clearForm() {
        txtResults.setText("");
        lblYearsProcessed.setText(YEARS_LABEL);
    }
}