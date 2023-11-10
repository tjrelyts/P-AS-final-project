public class Main {
    
    public static void main(String[] args) {

        StatsLibrary statsLib = new StatsLibrary();

        System.out.println("P(X=5) = " + statsLib.poissonDist(5, 1.749));

    }

}
