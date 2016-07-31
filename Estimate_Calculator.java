/* Estimate_Calculator utility created for Caruso Bros. Inc by Andrew Caruso MODIFIED: 7/28/16
At the request of owners Mike and Dom, Caruso Bros. wanted a simple utility where they can broadly estimate
material and labor costs for asphalt driveway jobs for their business. Much of their estimate comes from
how difficult a job will be (how deep the driveway is, if there are corners, and many other factors), with
this, to accurately simulate how Mike and Dom estimate a lot of the variability in price ranges in the price per square
foot of material. An easier job will have a lower price, but a more difficult job will increase the price. The general
price per square foot of material is 3.5-6.0 dollars according to Dom, but the utility will take in any
integer for calculations. Also, according to Dom and Mike they mainly wanted a broad estimate to give to customers
which is why on the programming side simple ints and floats in this program will suffice. A lot of the final price is calculated
once the job is done, with any unseen issues resolved into the final price. If there was a call for more precision,
the BigDecimal data type would be used.
*/

import java.util.*;

public class EstimateCalculator {
  
  private static float materialFinal;
  private static int laborFinal;
  
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    
    materialEstimate();
    
    String contRequest;
    String totalRequest;
    
    /* labor estimate is asked because according to owner Dom, sometimes an increase in 
     * price per square foot is used instead of a labor cost depending on difficulty 
     * of job. The laborEstimate method was still including in case owners decide to get these
     * numbers separately. 
     * */
    
    System.out.println("Would you like to estimate labor? [y/n]");
    contRequest = scan.nextLine();
    
    if (contRequest.equals("y")) {
      laborEstimate();
    }
    else System.exit(0);
    
    System.out.println("Would you like to see your total estimate? [y/n]");
    totalRequest = scan.nextLine();
    
    if (totalRequest.equals("y")){
     totalEstimate();
    }
    else System.exit(0);
    
    
  }
    
  
  public static void materialEstimate() {
    
    Scanner scan = new Scanner(System.in);
    
    float length, width;
    
    // getting dimensions of job
    System.out.println("What is the length of area?");
    length = scan.nextFloat();

    System.out.println("What is the width of the area?");
    width = scan.nextFloat();
    
    float area = (length)*(width);
    // getting price per square foot
    System.out.println("What is your price per square foot? [3.50 - 6.00 dollars]");
    float pricePerSquareFoot = scan.nextFloat();
    
    float materialEstimate = area * pricePerSquareFoot;
    
    materialFinal = materialEstimate;
    
    System.out.println("The price estimate for these parameters is " + materialEstimate + " dollars");
 
    }
  
  public static void laborEstimate() {
    
    Scanner scan = new Scanner(System.in);
    
    // getting idea of how many workers, hours worked, and days needed for job
    System.out.println("How many men will work with you per day?");
    int numberOfMen = scan.nextInt();
    
    System.out.println("How many hours per day do you expect them to work?");
    int hoursWorked = scan.nextInt();
    
    System.out.println("What is your labor rate per man?");
    int laborRate = scan.nextInt();
    
    int laborEstimate = (numberOfMen)*(hoursWorked)*(laborRate);
    
    laborFinal = laborEstimate;
    
    System.out.println("The price estimate for these parameters is " + laborEstimate + " dollars");
    
  }
  
  public static void totalEstimate() {
    
    // final calculation based on both estimates 
    System.out.println("The final estimate would be " + (laborFinal + materialFinal) + " dollars");
    
  }
  
}
