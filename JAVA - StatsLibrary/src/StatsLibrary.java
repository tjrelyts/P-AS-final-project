// Probability and Applied Statistics
// Tyler Santosuosso
// 10/25/2022

import java.util.ArrayList;

public class StatsLibrary {
    
    // Helper function that uses recursion to get n factorial
    public double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }

     // Performs the calcuation of the mean of a given set of values
     public double mean(ArrayList<Double> set) {
        // Declare initial variables
        double sum = 0; 
        double mean = 0;
                    
        // For-loop to calculate the sum of the set
        for (int i = 0; i < set.size(); i++) {
            sum += set.get(i);
        }
        // Calculate the mean using the formula
        mean = sum / set.size();
            
        return mean;
    }

    // Finds the median of a given set of values
    public double median(ArrayList<Double> set) {
        // Declare initial variable
        double median = 0;

        // if-statement handles an even length set case
        if (set.size() % 2 == 0) {
            double x = set.get((set.size()/2)-1);
            double y = set.get(set.size()/2);

            median = (x+y)/2;
        // else-statement handles an odd length set case
        } else {
            double x = set.get(Math.floorDiv(set.size(), 2));

            median = x;
        }

        return median;
    }

    // Finds the mode of a given set of values
    public double mode(ArrayList<Double> set) {
        // Declare initial variables 
        double mode = 0;
        double maxCount = 0;

        // For-loop counts each values occurrence
        for (int i = 0; i < set.size(); i++) {
            int count = 0;
            for (int j = i+1; j < set.size(); j++) {
                if (set.get(j).equals(set.get(i))) {
                    count++;
                }
            }
            // After each run of for-loop, this if-statement
            // determines if the current value occurred
            // more often than the previous most common value
            if (count > maxCount) {
                maxCount = count;
                mode = set.get(i);
            }
        }

        return mode;
    }

    // Calculates the possible permutations of given values
    // Order matters, no replacement
    public double perm(int n, int r) {
        // Declare initial variable
        double result = 0;

        // Factorial helper function used for equation
        result = (factorial(n) / factorial(n-r));
        
        return result;
    }  
    
    // Calculates the possible combinations of given values
    // Order doesn't matter, no replacement
    public double comb(double n, double r) {
        // Declare initial variable 
        double result = 0;

        // Factorial helper function used for equation
        result = factorial(n) / (factorial(n-r)*factorial(r));
        
        return result;
    }   

    // Calculates the variance of a given set of values
    // Makes use of StatsLibrary.mean() function
    public double stdVariance(ArrayList<Double> set) {
        // Declare initial variables 
        double mean = mean(set);
        double result = 0;

        for (int i = 0; i < set.size(); i++) {
            result += (Math.pow((set.get(i) - mean), 2));
        }

        return result;
    }

    // Calculates the standard deviation of a given set of values
    // Makes use of StatsLibrary.stdVariance() function
    public double std(ArrayList<Double> set) {
        // Declare initial variables
        double sum = stdVariance(set);
        double result = 0;

        result = Math.sqrt(sum / set.size());     
        return result;
    }

    // Calculates the binomial distribution
    public double binDist(double p, double n, double y) {
        // Declare initial variables
        double q = 1 - p;
        double result = 0;
    
        // Our pmt for binomial distribution
        result = comb(n, y) * (Math.pow(p, y) * Math.pow(q, n-y));
        return result;
    
    }

    // Calculates the geometric distribution for case x
    public double geoDist(double p, int x) {
        // Declare initial variables
        double q = 1 - p;
        double result = 0;
        
        // Zero-case handler
        if ((x - 1) == 0) {
            return p;
        }

        result = Math.pow(q, (x - 1)) * p;
        return result;
    }
    
    // Calculates the hypergeometric distribution for case x
    // Makes use of StatsLibrary.comb() function 
    public double hyperGeoDist(double r, double x, double m, double n) {
        // Declare initial variables
        double result = 0;

        result = (comb(r, x) * comb(m-r,n-x)) / comb(m, n);
        
        return result;
    }

    public double poissonDist(double x, double d) {
        // Declare initial variables
        double result = 0;

        result = (Math.pow(d, x) * Math.exp(-d)) / factorial(x);

        return result;
    }
}
