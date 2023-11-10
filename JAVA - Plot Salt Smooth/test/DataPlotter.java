import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataPlotter {

    public DataPlotter() {
    }

    // Currently simulates y = x^3
    public XYDataset plotData(int rangeLow, int rangeHigh) {

        double y = 0;
        XYSeriesCollection xyDataset = new XYSeriesCollection();
        XYSeries xySeries = new XYSeries("Plot Data");

        for (int i = rangeLow; i < rangeHigh + 1; i++) {
            y = Math.pow(i, 2);
            xySeries.add(i, y);
        }
        
        xyDataset.addSeries(xySeries);
        new ChartCreator(xyDataset, "Plot Data").setVisible(true);
        
        return xyDataset;
    }
	
}
