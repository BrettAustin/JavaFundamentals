import java.util.*;

public class HomeworkM7Driver {

	public static boolean qNotFollowedByU(String word) {
		// YOUR CODE HERE
		return false; // placeholder: delete and replace when you write your own method
	}

	public static void arrayReverse(int[] array) {
		// YOUR CODE HERE
	}

	public static int countPositives(BagInterface<Integer> bag) {
		// YOUR EXTRA CREDIT CODE HERE
		return 0; // placeholder: delete and replace when you write your own method
	}
	
	private static boolean allTestsPassed = true; 
	
	public static void main(String[] args) {
		
		System.out.println("\n-----------------------------TESTING ARRAY REVERSER-----------------------------");
		// parameter 1: the array to be reversed
		// parameter 2: a description of the test
		testArrayReverse(new int[] {1, 2, 3, 4, 5}, "odd length array");
		testArrayReverse(new int[] {1, 2, 3, 4, 5, 6}, "even length array");
		testArrayReverse(new int[] {7, 8}, "array length 2");
		testArrayReverse(new int[] {5}, "array length 1");
		testArrayReverse(new int[] {}, "empty array");

				
		System.out.println("\n-----------------------------TESTING Q WITHOUT U-----------------------------");
		System.out.println("Does the word contain a \'q\' that is NOT immediately followed by a \'u\'? These words do!");
		System.out.println("Note that they might *also* have a \"qu\" in them- they still pass the test because they have a \'q\' NOT followed by a \'u\'!");
		// parameter 1: the word to test
		// parameter 2: the expected result (true if the word contains a q that is NOT immidiately followed by a u)
		// parameter 3: a description of the test
		testQNotFollowedByU("qat",   true, "q-not-followed-by-u at the beginning of the word");
		testQNotFollowedByU("cinq",  true, "q-not-followed-by-u at the end of the word; even length");
		testQNotFollowedByU("drinq", true, "q-not-followed-by-u at the end of the word; odd length");
		testQNotFollowedByU("abqc",  true, "q-not-followed-by-u in the middle of the word, even length");
		testQNotFollowedByU("abqcd", true, "q-not-followed-by-u in the middle of the word, odd length");
		testQNotFollowedByU("squaq", true, "q-not-followed-by-u in a word that also has a \"qu\" before it");
		testQNotFollowedByU("bubqb", true, "q-not-followed-by-u in a word that also has a \"qu\" before it");
		testQNotFollowedByU("qaqu",  true, "q-not-followed-by-u in a word that also has a \"qu\" after it");
		testQNotFollowedByU("qiteu", true, "q-not-followed-by-u right away, but with a u later on, odd length");
		testQNotFollowedByU("qeut",  true, "q-not-followed-by-u right away, but with a u later on, even length ");
		testQNotFollowedByU("q",     true, "q all on its own- single letter");
		testQNotFollowedByU("qq",    true, "q all on its own- single letter");
		testQNotFollowedByU("uq",    true, "q all on its own- single letter");
		testQNotFollowedByU("QAT",   true, "q-not-followed-by-u in caps");

		System.out.println("\nThese words fail the test. They either have no \'q\' or they have a \'q\' that IS immediately followed by a \'u\'.");
		testQNotFollowedByU("hello",  false, "no q; odd length");
		testQNotFollowedByU("cats",   false, "no q; even length");
		testQNotFollowedByU("bulb",   false, "no q but has a u; odd length");
		testQNotFollowedByU("puts",   false, "no q but has a u; even length");
		testQNotFollowedByU("a",      false, "single letter, not a q");
		testQNotFollowedByU("",       false, "empty string");
		testQNotFollowedByU("quite",  false, "q-followed-by-u at the beginning of the word");
		testQNotFollowedByU("equal",  false, "q-followed-by-u in the middle of a word; odd length");
		testQNotFollowedByU("aqua",   false, "q-followed-by-u in the middle of a word; even length");
		testQNotFollowedByU("abcqu",  false, "q-followed-by-u q followed by u at the end of the word, odd length");
		testQNotFollowedByU("abcdqu", false, "q-followed-by-u q followed by u at the end of the word, even length");
		testQNotFollowedByU("qu",     false, "q-followed-by-u and nothing else");
		testQNotFollowedByU("QUOTE",  false, "q-followed-by-u in all-caps");
	
		
		System.out.println("\n-----------------------------TESTING GET FREQUENCY OF-----------------------------");
		// parameter 1: the contents of the bag
		// parameter 2: the target value
		// parameter 3: the expected return value- how often the target appears in the bag
		// parameter 4: a description of the test
		testGetFrequencyOf(new Integer[] {}, 12, 0, 	"empty bag"); 
		testGetFrequencyOf(new Integer[] {13}, 13, 1, 	"singleton bag that contains the target");
		testGetFrequencyOf(new Integer[] {13}, 5, 0, 	"singleton bag that does not contain the target");
		testGetFrequencyOf(new Integer[] {15, 2, 5, 4, 7, 5}, 15, 1,  "target is in the bag at the beginning");
		testGetFrequencyOf(new Integer[] {5, 2, 5, 4, 7, 25}, 25, 1,  "target is in the bag at the end");
		testGetFrequencyOf(new Integer[] {5, 2, 5, 4, 7, 5}, 4, 1, 	  "target is in the middle");
		testGetFrequencyOf(new Integer[] {5, 2, 5, 4, 7, 5}, 5, 3, 	  "target is in the bag multiple times");
		testGetFrequencyOf(new Integer[] {5, 2, 5, 4, 7, 5}, 8, 0, 	  "target not in the bag, even length");
		testGetFrequencyOf(new Integer[] {5, 2, 5, 4, 7, 5, 2}, 8, 0, "target not in the bag, odd length");
		testGetFrequencyOf(new String[] {"a", "b", "c", "d", "e", "a"}, new String("a"), 2, "test with Strings");
	
	
		System.out.println("\n-----------------------------TESTING EXTRA CREDIT COUNT POSITIVES-----------------------------");	
		// parameter 1: the contents of the bag
		// parameter 2: the expected result- the number of positives
		// parameter 3: a description of the test
		testCountPositives(new int[] {2, -1, 3, 5, -2, 4, 1}, 	5, "odd number of elements");
		testCountPositives(new int[] {1, -4, -2, 5, 3, -1, 2}, 	4, "even number of elements");
		testCountPositives(new int[] {-3, -4, -2, -5, -8}, 		0, "no positives");
		testCountPositives(new int[] {6, 4, 3, 2, 1, 7, 9}, 	7, "all positives");
		testCountPositives(new int[] {}, 						0, "empty bag");
		testCountPositives(new int[] {6}, 						1, "singleton bag with positive");
		testCountPositives(new int[] {-6},		 				0, "singleton bag without positive");
		
		
		System.out.println("\n\n-----------------------------TESTING COMPLETE-----------------------------");
		if(allTestsPassed) {
			System.out.println("----------Summary---------- \nAll automated tests have passed. \nBe sure to manually look at the output.\nBe sure to manually review your code for style and efficiency.");
		} else {
			System.out.flush();
			System.err.println("**********Summary********** ERROR: There is failure in at least one automated test. Review the output above for details.");
		}

	
	}


	/*----------------------------------------------------------------------------------------------------------*/
	/* TESTER METHODS */
	/*----------------------------------------------------------------------------------------------------------*/
	/*
	 * The methods below are designed to help support the tests cases run from main. You don't
	 * need to use, modify, or understand these methods. You can safely ignore them. :) 
	 * 
	 * Also, you can ignore the use of generics in the tester methods. These methods use
	 * generics at a level beyond which we use in our class. I only use them here to make this a robust 
	 * and useful testing file. You are NOT required to understand the use of generics in this way.
	 */	
	public static void testArrayReverse(int[] array, String testDescription) {
		int[] arrayToReverse = Arrays.copyOf(array, array.length);
		int[] originalArray = Arrays.copyOf(array, array.length);
		int[] correctReverseArray = new int[array.length];
		for(int i=array.length-1, j=0; i>=0; i--, j++ ) {
			correctReverseArray[j] = originalArray[i];
		}
		arrayReverse(arrayToReverse);
		System.out.println("\nOriginal array  = " + Arrays.toString(originalArray));
		System.out.println("Expected result = " + Arrays.toString(correctReverseArray));
		System.out.println("  Actual result = " + Arrays.toString(arrayToReverse));

		if(!Arrays.equals(correctReverseArray, arrayToReverse)) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: " + testDescription + "\n");
		}
	}
	
	public static void testQNotFollowedByU(String word, boolean expectedResult, String testDescription) {
		boolean actualResult =  qNotFollowedByU(word);
		System.out.println("\n\t   Word = " + word);
		System.out.println("Expected result = " + expectedResult + "\n  Actual result = " + actualResult);
		if(actualResult != expectedResult) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: " + testDescription + "\n");			
		} 
	}
	
	public static <T> void testGetFrequencyOf(T[] bagContents, T value, int expectedResult, String testDescription) {
		LinkedBag<T> originalBag = new LinkedBag<T>();
		LinkedBag<T> copyBag = new LinkedBag<T>();
		for(T n : bagContents) {
			originalBag.add(n);
			copyBag.add(n);
		}
		int actualResult = originalBag.getFrequencyOf(value);
		System.out.println("\nBag contains: " + Arrays.toString(bagContents) + "\nCounting frequency of: " + value);
		System.out.println("Expected result=" + expectedResult + "\n  Actual result=" + actualResult);
		
		if(actualResult!=expectedResult) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: " + testDescription + "\n");
		} 
		Object[] originalBagContentsAfterRemove = originalBag.toArray();
		Arrays.sort(originalBagContentsAfterRemove);
		Object[] copyBagContents = copyBag.toArray();
		Arrays.sort(copyBagContents);
	
		if(!Arrays.equals(originalBagContentsAfterRemove, copyBagContents)) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: " + testDescription);
			System.out.println("   The bag has been modified.\n\t   Sorted contents after invoking frequency: " + Arrays.toString(originalBagContentsAfterRemove) + "\n");
		}
	}
	
	public static void testCountPositives(int[] bagContents, int expectedResult, String testDescription) {
		LinkedBag<Integer> originalBag = new LinkedBag<Integer>();
		LinkedBag<Integer> copyBag =  new LinkedBag<Integer>();
		for(int n : bagContents) {
			originalBag.add(n);
			copyBag.add(n);
		}
		int actualResult = countPositives(originalBag);
		Object[] originalBagContentsAfterCount = originalBag.toArray();
		Arrays.sort(originalBagContentsAfterCount);
		Object[] copyBagContents = copyBag.toArray();
		Arrays.sort(copyBagContents);

		System.out.println("\n    Bag contains: " + Arrays.toString(copyBagContents));
		System.out.println("Expected result = " + expectedResult + "\n  Actual result = " + actualResult);
		
		if(actualResult!=expectedResult) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: " + testDescription + "\n");
		}
		if(!Arrays.equals(originalBagContentsAfterCount, copyBagContents)) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: " + testDescription);
			System.out.println("   The bag has been modified.\n   Sorted contents after invoking countPositives: " + Arrays.toString(originalBagContentsAfterCount) + "\n");
		}
	}
}

