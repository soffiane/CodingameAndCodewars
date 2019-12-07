package codingame;

import java.util.Arrays;

public class LargestNumber {
	
	static int findLargest (int[] numbers){
		Arrays.sort(numbers); //return numbers[numbers.length -1];
		if(numbers.length > 1){
			int max = 0;
			for(int i = 0;i<numbers.length;i++){
				if(numbers[i] > max){
					max = numbers[i];
					if(max == Integer.MAX_VALUE){
						return max;
					}
				}
			}
			return max;
		} else {
			return numbers[0];
		}
	}
	
	public static void main(String[] args){
		int [] numbers = {100,50,150};
		System.out.println(LargestNumber.findLargest(numbers));
	}

}
