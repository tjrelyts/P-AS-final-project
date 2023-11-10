package pas.plotsaltsmooth;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataSmoother {

    private DescriptiveStatistics stats;

    public DataSmoother() {
        stats = new DescriptiveStatistics();
    }

    public XYDataset smoothData(XYDataset xyDataInput, int windowValue) {
    	
        XYSeriesCollection xyDataset = new XYSeriesCollection();
        XYSeries xySeries = new XYSeries("Smooth Data");
        stats.setWindowSize(windowValue);

        for (int i = 0; i < xyDataInput.getItemCount(0); i++) {
            stats.addValue(xyDataInput.getYValue(0, i));
            xySeries.add(xyDataInput.getXValue(0, i), stats.getMean());
        }

        xyDataset.addSeries(xySeries);
        new ChartCreator(xyDataset, "Smooth Data").setVisible(true);
        
        return xyDataset;
    }
	
}
