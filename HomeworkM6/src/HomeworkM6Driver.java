import java.util.*;

public class HomeworkM6Driver {

    public static List<Integer> findDuplicatesLinear(List<Integer> numbers) {
        Collections.sort(numbers);
        int lengthOfArray = numbers.size();
        int lowestValue = lengthOfArray*-5;
        int highestValue = lengthOfArray*5;
        int slotsNeeded = highestValue - lowestValue +1;
        ArrayList<Integer> counterArray = new ArrayList<Integer>(slotsNeeded);

        for(int i =0;i<slotsNeeded;i++){//initialize array to 0
            counterArray.add(i,0);
        }


        for(int i = 0; i<lengthOfArray;i++){ //count the occurence of each number
            int transformedValue = numbers.get(i)+highestValue;
            int currentCounterValue = counterArray.get(transformedValue);
            int updatedValue = currentCounterValue+1;
            counterArray.set(transformedValue,updatedValue);
        }

        //System.out.println("Counter Array after" +counterArray);

        int maxNumberOfDuplicates = 0;
        for(int i = 0;i<slotsNeeded;i++){
            int currenCounterValue = counterArray.get(i);
            if(currenCounterValue>maxNumberOfDuplicates){
                maxNumberOfDuplicates = currenCounterValue;
            }
        }

        //System.out.println("Counter Array "+ counterArray);
        //System.out.println("Max number "+maxNumberOfDuplicates);
        int maxNumberToAdd = maxNumberOfDuplicates-1;

        ArrayList<Integer> duplicateList = new ArrayList<Integer>();

        for(int i=0;i<maxNumberToAdd;i++) {

            for (int j = 0; j < slotsNeeded; j++) {

                if (counterArray.get(j) > (i+1)) {
                    int valueToAdd = j - highestValue;
                    duplicateList.add(valueToAdd);
                }
            }
        }



        return duplicateList; // placeholder: replace this when you write the method
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int numberOfTimesToTest = 5; // consider starting with 1 test until you are certain it is working correctly
        boolean passedAllTests = true;

        for(int i=0; i<numberOfTimesToTest && passedAllTests; i++) {
            System.out.println("\n-----------------------------TESTING findDuplicatesLinear METHOD TEST #" + (i+1) + "-----------------------------");

            /* consider making these values smaller until you have a working method.
             * it might be easier to debug with a smaller list.
             * you can then increase the numbers again for more robust testing.
             */
            int listSize = 100;
            int minimumSingleSuplicates = 10; // minimum number of numbers on the list that will appear twice (have a "single duplicate")
            int minimumDoubleDuplicates = 5;  // minimum number of numbers on the list that will appear three times (have a "double duplicate")
            fillNumberList(numbers, listSize, minimumSingleSuplicates, minimumDoubleDuplicates);

            // print the list sorted (might help with testing)
            Collections.sort(numbers);
            System.out.println("\nThe original list (sorted for display purposes only):");
            System.out.println(numbers);

            // reshuffle the list
            Collections.shuffle(numbers);

            // the results should be the same for both methods
            System.out.println("\nThe duplicate lists from both methods- these should match! (Note: methods are sorted for display purposes only.)");
            List<Integer> duplicateListFromBad = findDuplicatesBad(new ArrayList<Integer>(numbers));
            Collections.sort(duplicateListFromBad);
            System.out.println("Duplicate list from bad method:  \t" + duplicateListFromBad);

            List<Integer> duplicateListFromLinear = findDuplicatesLinear(new ArrayList<Integer>(numbers));
            Collections.sort(duplicateListFromLinear);
            System.out.println("Duplicate list from linear method:\t" + duplicateListFromLinear);

            boolean match = duplicateListFromBad.equals(duplicateListFromLinear);
            if(!match) {
                passedAllTests = false;
                System.out.flush();
                System.err.println("\n*****TEST FAILED: The duplicate lists do not match.");
            } else {
                System.out.println("\nTest #" + (i+1) + ": The duplicate lists match. Test passed!");
            }
        }
        if (passedAllTests) {
            System.out.println("\n-----------------------------TESTING findDuplicatesLinear METHOD FOR EFFICIENCY -----------------------------");
            System.out.println("\nAll tests of functionality passed. Now trying to examine efficiency... ");
            System.out.println("Note: If this takes more than a minute, you might not have a linear solution. If that happens, you should force the program to quit and double check all method calls and loops!");
            efficiencyTest();
            System.out.println("Efficiency test complete.");
        }
    }

    public static List<Integer> findDuplicatesBad(List<Integer> numbers) {
        List<Integer> duplicateList = new ArrayList<Integer>();

        // loop a: this loop is O(n)- it iterates over the whole list
        for(int i=0; i<numbers.size(); i++) {
            int numberEvaluating = numbers.get(i);
            boolean duplicateFound = false;

            // loop b: this loop starts at i+1 and goes to the end of the list OR until a duplicate is found
            for(int j=i+1; j<numbers.size() && !duplicateFound; j++) {
                int numberChecking = numbers.get(j);

                // we have found a duplicate that hasn't yet been put on the duplicateList
                if(numberEvaluating==numberChecking && !duplicateList.contains(numberEvaluating)) {
                    duplicateFound = true;

                    // loop c: after a duplicate is found, we won't return to loop b
                    // instead, loop c finishes checking the rest of the list and puts all copies of
                    // of the current duplicate on the duplicateList
                    for(int k=j; k<numbers.size(); k++) {
                        if(numberChecking==Integer.valueOf(numbers.get(k))) {
                            duplicateList.add(numberChecking);
                        }
                    }
                }
            }
        }
        return duplicateList;
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

    public static void fillNumberList(List<Integer> numbers, int listSize, int minimumSingleSuplicates, int minimumDoubleDuplicates) {
        Random generator = new Random();
        int max = 5 * listSize;
        int min = -1 * max;
        int randomRange = max - min + 1;

        // add the first round of numbers
        int numberOfNumbersToAdd = listSize - minimumSingleSuplicates - minimumDoubleDuplicates;
        numbers.add(min); // adding the min and max number to help test for array out of bounds errors
        numbers.add(min);
        numbers.add(max);
        numbers.add(max);
        numbers.add(0);
        numbers.add(0); // adding zero as a special test case
        numberOfNumbersToAdd -= 6;
        for (int i = 0; i < numberOfNumbersToAdd; i++) {
            numbers.add(generator.nextInt(randomRange) + min);
        }

        // add duplicate numbers
        Collections.shuffle(numbers);
        for (int i = 0; i < minimumSingleSuplicates; i++) {
            numbers.add(numbers.get(i));
        }
        for (int i = 0; i < minimumDoubleDuplicates; i++) {
            numbers.add(numbers.get(i));
        }
    }

    public static void efficiencyTest() {
        System.out.println("Testing...");
        List<Integer> numbers = new ArrayList<Integer>();
        int listSize = 1000000;
        int minimumSingleSuplicates = 100;
        int minimumDoubleDuplicates = 50;
        fillNumberList(numbers, listSize, minimumSingleSuplicates, minimumDoubleDuplicates);

        long startTime = System.currentTimeMillis();
        List<Integer> duplicateListFromLinear = findDuplicatesLinear(new ArrayList<Integer>(numbers));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        //System.out.println("Elapsed time = " + (elapsedTime));

        if (elapsedTime>500) {
            System.out.flush();
            System.err.println("**********WARNING! Your solution might not be linear. Double check all method calls and loops!");
        } else {
            System.out.println("Your solution appears to be linear. This test cannot know for sure, but it does appear to be!");
        }

    }


}
