/*
the Store where the purchase was made (use the Store class for the type)
the number of items purchased
the total amount of money spent
a receipt ID that could contains letters and numbers
the email address where the digital receipt is sent
 */

public class Receipt {
    public Store purchaseLocation;
    public int numberOfItems;
    public int moneySpent;
    public String receiptID;

/*
    Write two constructors for the Receipt class.

    the first constructor takes in all four pieces of information as parameters (the Store, number of items, total amount spent, and receipt id)
    the second constructor takes only the Store, amount spent, and id.
            in this constructor, use a default value of 1 for the number of items.
*/

    public Receipt (Store storeValue, int numberOfItemsValue, int amountSpentValue,String receiptValue ){
        purchaseLocation = storeValue;
        numberOfItems = numberOfItemsValue;
        moneySpent = amountSpentValue;
        receiptID = receiptValue;
    }

    public Receipt(Store storeValue, int amountSpentValue,String receiptValue){
        purchaseLocation = storeValue;
        numberOfItems = 1;
        moneySpent = amountSpentValue;
        receiptID = receiptValue;
    }

    //this is good except for the syntax error at the end (it had a period instead of a semicolon
    public void setNumberOfItems(int numberOfItems) {
        if(numberOfItems<0) {
            System.out.println("Error- number of items cannot be negative.");
        }
        this.numberOfItems = numberOfItems;
    }

    public int getTotal(){
        return moneySpent;
    }

    public String getReceiptID(){
        return receiptID;
    }


    /*
    public String toString() {
        return "Circle: " + center.getX() + " Y: " + center.getY() + ", Radius: " + radius;
    }

        the text representation of the Store
        the number of items
        the total money spent
        the receipt ID
     */

    public String toString(){
        return "Store:" + getStore() + " | Items sold: " + getNumberOfItems() + " | Cost of: " +
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

    public String getStore(){
        return purchaseLocation.getStore();
    }

    public String getName(){
        return purchaseLocation.getName();
    }
    public String getLocation(){

    }

    public boolean idMeetsCriteria(){

    }


    /*
    the Stores are logically equivalent
    the number of items is the same
    the total money spent is the same
    the receipt IDs are the same ignoring case/capitals (e.g., "abc" is considered equivalent to "ABC")
     */

    @Override public boolean equals (){

    }
}
