package pas.plotsaltsmooth;

import java.util.Random;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataSalter {

    private Random rng;

    public DataSalter() {
        rng = new Random();
    }

    public XYDataset saltData(XYDataset xyDataInput, int rangeLow, int rangeHigh) {

        XYSeriesCollection xyDataset = new XYSeriesCollection();
        XYSeries xySeries = new XYSeries("Salt Data");
    	double newY = 0;
    	double saltValue = 0;
        
        for (int i = 0; i < xyDataInput.getItemCount(0); i++) {
            saltValue = rng.nextDouble(rangeLow, rangeHigh);
            if (rng.nextInt(100) >= 50) {
                newY = xyDataInput.getYValue(0, i) + saltValue;    
            } else {
                newY = xyDataInput.getYValue(0, i) - saltValue;
            }
            xySeries.add(xyDataInput.getXValue(0, i), newY);
        }

        xyDataset.addSeries(xySeries);
        new ChartCreator(xyDataset, "Salt Data").setVisible(true);
        
        return xyDataset;
    }
	
}
