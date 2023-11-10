package pas.plotsaltsmooth;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;

public class ChartCreator extends JFrame {

	private XYDataset xyDataset;
	private String chartTitle;
	
    public ChartCreator(XYDataset xyDataset, String chartTitle) {  	
    	this.xyDataset = xyDataset;
    	this.chartTitle = chartTitle;
    	
    	JPanel chartPanel = createChartPanel(xyDataset, chartTitle);
    	add(chartPanel, BorderLayout.CENTER);
    	
    	setSize(640, 480);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    }

    private JPanel createChartPanel(XYDataset xyDataset, String chartTitle) {
    	String xAxisLabel = "X";
    	String yAxisLabel = "Y";
    		
    	JFreeChart xyChart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, xyDataset);
    	
    	return new ChartPanel(xyChart);
    }
	
}
