import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Node<Integer> nodeOne = new Node<Integer>(2,null);
       Node<Integer> nodeTwo = new Node<Integer>(3,nodeOne);
       Node<Integer> nodeThree = new Node<Integer>(5,nodeTwo);
       Node<Integer> nodeFour= new Node<Integer>(6,nodeThree);
       Node<Integer> nodeFive= new Node<Integer>(4,null);

       int[] holder = new int[]{2,3,4,5};
       // infiniteRecursion(5);
        //System.out.println(method1(4));
       // System.out.println(method2(4));
        //System.out.println(countOdds(holder));

    }

    public static int countCharacters(String word, char character){
        return countCharacterHelper(word,character,0);
    }

    private static int countCharacterHelper(String word, char character, int index){
        int count= 0;
        if(index<word.length()){
            if(word.charAt(index)==character){
                count = 1;
            }
            count = count + countCharacterHelper(word,character,index+1); //recursive case
        }
        return count;
    }

    private static int countCharacterHelperReturn(String word, char character, int index){
        if(index< word.length()){
            if(word.charAt(index)==character){
                return 1 + countCharacterHelper(word,character,index+1);
            }
            else{
                return 0 + countCharacterHelper(word,character,index+1);
            }
        }else{
            return 0;
        }
    }


    public static  int readUserInput(int lower, int upper){
        System.out.println("Enter a number between "+lower+" and "+upper);
        Scanner scan = new Scanner(System.in);
        int userNumber = Integer.parseInt(scan.nextLine());
        if(userNumber<lower||userNumber>upper){
            System.out.println("Input out of range. Try again.");
            userNumber= readUserInput(lower,upper);
        }
        return userNumber;
    }

    public static int sumToOneWithReturn(int number){
        if(number==1){
            return 1;
        } else {
            return number + sumToOneWithReturn(number-1);
        }
    }

    public static int sumToOneLocalVariable(int number){
        int sum = 0;
        if(number==1){
            sum = 1;
        } else{
            sum = number + sumToOneLocalVariable(number -1);
        }
        return sum;
    }


    public static int countOdds(int[] array) {
        return countOddsHelper(array, 0, array.length);
    }

    private static int countOddsHelper(int[] array, int start, int stop) {
        int count = 0;
        if(start < stop) {
            if(array[start] % 2 == 1) {
                count++;
            }
            countOddsHelper(array, start+1, stop);
        }
        return count;
    }

    public static int method1(int x) {
        if (x > 0) {
            return method1(x-1) + 1;
        } else {
            return 0;
        }
    }

    public static int method2(int x) {
        if (x <= 0) {
            return 0;
        } else {
            return 1 + method2(x-1);
        }
    }

    public static void infiniteRecursion(int n) {
        if (n > 0) {
            System.out.println("here");
            infiniteRecursion(n-1);
        } else if(n < 0){
            System.out.println("here");
            infiniteRecursion(n+1);
        } else {
            System.out.println("here");
        }
    }

    public static void recMethod(Node firstNode) {
        // print the chain of nodes headed by firstNode

        Node currentNode = firstNode;
        while(currentNode.next!=null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.getData());

        if(firstNode.next!=null) {
            //double the data in firstNode
            firstNode.setData(firstNode.getData()*2);
            recMethod(firstNode.next.next);
        } else {
            System.out.println("done");
        }

        Node newCurrentNode = firstNode;
        while(newCurrentNode.next!=null){
            System.out.println(newCurrentNode.getData());
            newCurrentNode = newCurrentNode.next;
        }
        System.out.println(newCurrentNode.getData());
    }
}
