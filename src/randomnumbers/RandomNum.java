package randomnumbers;

import java.util.Random;

public class RandomNum {

	private static int count = 500;

	  public static void main(String[] args) { 
			/*
			 * 2. Generate 500 RANDOM numbers, 
			 * and find the Nth smallest number (range from
			 * 100 – 1000)
			 */
		
		
	    for(int i = 0;i <= count; i++) { //enter the range here
	    	
	    	  System.out.println("Random Num : " + getRandomNumbersInRange(100,1000));//gives you any number from 0-999
	    	  
	    }
	   
	  
	  }
	  
	  
	  private static int getRandomNumbersInRange(int min, int max) {
		  
		  if (min >= max) {
			  
				throw new IllegalArgumentException("max must be greater than min");
		  }
		
			// create instance of Random class 
			Random ran = new Random();
			System.out.println("Smallest number in array is : " + min);
			return ran.nextInt((max-min) + 1) + min;
		} 

	 
	 
}

