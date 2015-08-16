import java.util.*;

/**
 * AverageDriver class to preform various task with arrays
 *
 */
public class Average {

	private final int ARRAY_LENGTH = 5;
	private Integer[] score = new Integer[ARRAY_LENGTH];

	/**
	 * This method will reverse the
	 * @return The reverse sorting of the array
	 */
	public List<Integer> getReverseSortArray() {

		// Sort now for reverse later
		Arrays.sort(score);

		// Create array list and populate with score array
		List<Integer> reverseOrder = new ArrayList<>();
		Collections.addAll(reverseOrder, score);

		// Reverse order and print results
		Collections.reverse(reverseOrder);

		return reverseOrder;

		/*
		 * I choose to use a combination of the Arrays and Collections class to reverse sort the array
		 * I included it here to show I can code up a reverse sort algorithm.
		 *
		int start, idx, maxIdx, maxVal;

		for (start = 0; start < (this.score.length-1); start++) {
			maxIdx = start;
			maxVal = this.score[start];
			for(idx = start + 1; idx < this.score.length; idx++) {
				if (this.score[idx] > maxVal) {
					maxVal = this.score[idx];
					maxIdx = idx;
				}
			}
			this.score[maxIdx] = this.score[start];
			this.score[start] = maxVal;
		}
		return score;
		*/

	}

	/**
	 * @return
	 */
	public double getMean() {
		double sum = 0;
		for (int idx = 0; idx < ARRAY_LENGTH; idx++) {
			sum += score[idx];
		}

		return sum /ARRAY_LENGTH;

	}

	/**
	 *
	 */
	public  void promptUser() {
		Scanner in = new Scanner(System.in);
		System.out.println("please enter five(5) test scores and I will average them for you");
		for (int idx = 0; idx < score.length; idx++) {
			System.out.print("Please enter score # " + (idx + 1) + " ");
			score[idx] = in.nextInt();

		}
		// If I actually used the reverse sort I commented out
		//System.out.println("Your score from highest to lowest is\n" + Arrays.toString(getReverseSortArray(score)));

		System.out.println("Your score from highest to lowest is\n" + getReverseSortArray());
		System.out.printf("Your mean score is: %.2f", getMean());

	}
}
