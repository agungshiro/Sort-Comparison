package eduwmich.CS5310.CodeAssignment.AWahyudiono;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Doing compare and performance test for Quick Sort, Merge Sort and Insertion Sort
 * Produce the chart of comparison results with jfreechart
 * @author agung wahyudiono
 *
 */

public class Compare extends JFrame {
	
	/**
	 * Constructor
	 * Define the GUI as an extends of JFrame
	 */
	public Compare() {
		// Set title
		super("Sorting Performance Comparison");
		
		// Add a panel which is and instace of chart panel
		JPanel chartPanel = createChartPanel();
		add(chartPanel, BorderLayout.CENTER);
		
		// Set JFrame paramater
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Produce a chart Panel
	 * @return JPanel, ChartPanel instance
	 */
	private JPanel createChartPanel() {
		
		// Chart title and X, Y labels
		String chartTitle = "Sorting Performance Comparison";
	    String xAxisLabel = "Array Length";
	    String yAxisLabel = "Time";
	    
	    // Call createDataset method, to produce dataset for the chart
	    XYDataset dataset = createDataset();
	    
	    // Define the chart, by ChartFactory and create an XY Line Chart
	    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
	            xAxisLabel, yAxisLabel, dataset);
	    
	    // return the instance of chart panel
	    return new ChartPanel(chart);
	}
	
	/**
	 * Perform test and build data set for chart
	 * @return dataset
	 */
	private XYDataset createDataset() {
		
		// Define data set
		XYSeriesCollection dataset = new XYSeriesCollection();
	    
		// Define data series for insertion sort
		XYSeries insertionSort = new XYSeries("Insertion Sort");
	    
		// Define data series for merge sort
		XYSeries mergeSort = new XYSeries("Merge Sort");
	    
		// Define data series for quick sort
		XYSeries quickSort = new XYSeries("Quick Sort");
	    
	    int startCase = 100; // start array number
		int interval = 50; // array number interval fo each test
		int endCase = 15000; // maximum array number
		
		// Instantiate Iteration test
		IterationTest it = new IterationTest();
		
		// Instantiate Random Array factory
		RandomArrayInt rand = new RandomArrayInt();
		
		QuickSort qs = new QuickSort(); // instantiate Quick Sort
		MergeSort ms = new MergeSort(); // instantiate Merge Sort
		InsertionSort is = new InsertionSort(); // instantiate Insertion sort
		
		// Do test
		do {
			
			// Produce random array, with the length of array = startCase
			rand.setLength(startCase);
			
			// clone the random array for each different sorting algorithms/instance
			int qsArr[] = rand.generate();
			int msArr[] = qsArr.clone();
			int isArr[] = qsArr.clone();
			
			// each test will print the input and result just only for the lowest number of array
			// ============================= QUICK SORT ======================================
			it.setTest(10, qs, qsArr);
			if(startCase == 100) {
				System.out.printf("Quick Sort [100]\nInput : %s\n",Arrays.toString(qsArr));
			}
			quickSort.add(startCase,it.doTest()); // Add data to series
			if(startCase == 100) {
				System.out.printf("Output : %s\n\n",Arrays.toString(qsArr));
			}
			// ================================================================================
			
			// ============================= MERGE SORT =======================================
			it.setTest(10, ms, msArr);
			if(startCase == 100) {
				System.out.printf("Merge Sort [100] \nInput : %s\n",Arrays.toString(msArr));
			}
			mergeSort.add(startCase,it.doTest()); // Add data to series
			if(startCase == 100) {
				System.out.printf("Output : %s\n\n",Arrays.toString(msArr));
			}
			// ================================================================================
			
			// ============================= INSERTION SORT ===================================
			it.setTest(10, is, isArr);
			if(startCase == 100) {
				System.out.printf("Insertion Sort \nInput : %s\n",Arrays.toString(isArr));
			}
			insertionSort.add(startCase,it.doTest()); // Add data to series
			if(startCase == 100) {
				System.out.printf("Output : %s\n\n",Arrays.toString(isArr));
			}
			// ================================================================================
			
			// increase the startCase by interval
			startCase = startCase+interval;
			
		} while (startCase <= endCase); // Until the number of test array reach 15000
		
		// add each data series to dataset
		dataset.addSeries(quickSort);
		dataset.addSeries(mergeSort);
		dataset.addSeries(insertionSort);
		
		// return dataset
	    return dataset;
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Compare().setVisible(true);
            }
        });

	}

}
