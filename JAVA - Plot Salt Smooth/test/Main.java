package pas.plotsaltsmooth;

import org.jfree.data.xy.XYDataset;

public class Main {
	
    public static void main(String[] args) {

        DataPlotter plotter = new DataPlotter();
        DataSalter salter = new DataSalter();
        DataSmoother smoother = new DataSmoother();

        XYDataset plotData = plotter.plotData(-25, 25);
        XYDataset saltData = salter.saltData(plotData, 0, 1000);
        XYDataset smoothData = smoother.smoothData(saltData, 5);
        
        
    }
    
}
