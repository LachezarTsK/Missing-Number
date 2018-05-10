import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		int size_FirstList = reader.nextInt();
		int[] firstArray = new int[size_FirstList];
		for (int i = 0; i < size_FirstList; i++) {
			firstArray[i] = reader.nextInt();
		}

		int size_SecondList = reader.nextInt();
		int[] secondArray = new int[size_SecondList];
		for (int i = 0; i < size_SecondList; i++) {
			secondArray[i] = reader.nextInt();
		}

		TreeSet<Integer> results = missingNumbers(firstArray, secondArray);
		int counter = 0;
		for (Integer n : results) {
			System.out.print(n + (counter != results.size() - 1 ? " " : ""));
			counter++;
		}
	}

	public static TreeSet<Integer> missingNumbers(int[] firstArray, int[] secondArray) {
		
		TreeSet<Integer> results = new TreeSet<Integer>();
		int[] first_occurances = new int[(int) (2 * Math.pow(10, 5))];
		int[] second_occurances = new int[(int) (2 * Math.pow(10, 5))];
		for (int i = 0; i < secondArray.length; i++) {
			second_occurances[secondArray[i]]++;
		}

		for (int i = 0; i < firstArray.length; i++) {
			first_occurances[firstArray[i]]++;
		}

		for (int i = 0; i < secondArray.length; i++) {
			if (second_occurances[secondArray[i]] != first_occurances[secondArray[i]]) {
				results.add(secondArray[i]);
			}
		}
		return results;
	}
}
