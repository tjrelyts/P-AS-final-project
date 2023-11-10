package pas.plotsaltsmooth;
import org.jfree.data.xy.XYDataset;

public class Main {
    
    public static void main(String[] args) {

        DataPlotter plotter = new DataPlotter();
        DataSalter salter = new DataSalter();
        DataSmoother smoother = new DataSmoother();

        XYDataset plotData = plotter.plotData(-50, 50);
        XYDataset saltData = salter.saltData(plotData, -25, 25);
        smoother.smoothData(saltData, 50);
        
        
    }

}
