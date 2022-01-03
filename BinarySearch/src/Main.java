public class Main {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{12,15,19,23,25,27,36,39,47,58,62,67};

        System.out.println(binarySearchIterative(sortedArray,15));

    }

    public static int binarySearchIterative(int[] numbers, int target) {
        boolean found = false;
        int first = 0;
        int last = numbers.length - 1;
        int targetLocation = -1;

        while (first <= last && !found) {
            int loopCount = 1;
            int mid = (first + last) / 2;

            if (numbers[mid] == target) {
                targetLocation = mid;
                found = true;
            } else if (numbers[mid] < target) {
                first = mid + 1;
            } else { // numbers[mid] > target
                last = mid - 1;
            }
            System.out.println("Loop "+ loopCount+". Mid value: "+mid );
            loopCount++;
        }
        return targetLocation;
    }



}

