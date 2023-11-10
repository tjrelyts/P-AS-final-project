// Probability and Applied Statistics
// Tyler Santosuosso

package pas.plotsaltsmooth;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// Class to create the smoothing data
public class DataSmoother {
    
    // Uses Apache Commons Stats library
    private DescriptiveStatistics stats;

    public DataSmoother() {
        stats = new DescriptiveStatistics();
    }

    public XYDataset smoothData(XYDataset xyDataInput, int windowValue) {
    	
        XYSeriesCollection xyDataset = new XYSeriesCollection();
        XYSeries xySeries = new XYSeries("Smooth Data");
        // Defines window value for the rolling average
        stats.setWindowSize(windowValue);

        // For loop to generate smoothing data
        for (int i = 0; i < xyDataInput.getItemCount(0); i++) {
            // Adds each Y value in the window to stats temp object
            stats.addValue(xyDataInput.getYValue(0, i));
            // Generates the Y axis data
            xySeries.add(xyDataInput.getXValue(0, i), stats.getMean());
        }

        // Creates our chart for smoothing data
        xyDataset.addSeries(xySeries);
        new ChartCreator(xyDataset, "Smooth Data").setVisible(true);
        
        return xyDataset;
    }

}
