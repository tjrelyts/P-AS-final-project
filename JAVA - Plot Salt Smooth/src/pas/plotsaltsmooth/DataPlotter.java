// Probability and Applied Statistics
// Tyler Santosuosso

package pas.plotsaltsmooth;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// Class to create our Plot data
public class DataPlotter {
 
    public DataPlotter() {
    }

    // Currently simulates y = mx+b for simplicity sake
    public XYDataset plotData(int rangeLow, int rangeHigh) {

        double y = 0;
        XYSeriesCollection xyDataset = new XYSeriesCollection();
        XYSeries xySeries = new XYSeries("Plot Data");

        // For loop to generate dataset
        for (int i = rangeLow; i < rangeHigh + 1; i++) {
            y = .5*i;
            xySeries.add(i, y);
        }
        
        // Creates our chart 
        xyDataset.addSeries(xySeries);
        new ChartCreator(xyDataset, "Plot Data").setVisible(true);
        
        return xyDataset;
    }

}
