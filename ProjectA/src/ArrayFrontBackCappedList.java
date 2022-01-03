public class ArrayFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

    private T[] list;
    private int numberOfElements;
    private int numberOfEntries;
    private boolean initialized = false;
    public static final int MAX_CAPACITY = 100000;

    public ArrayFrontBackCappedList(int desiredCapacity) {
        T[] tempList = (T[]) new Object[desiredCapacity];
        list = tempList;
    }


    /**
     * Adds a new entry to the beginning of the list if the list is not full.
     * If the entry is added, entries currently in the list are shifted down and
     * the list size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     * @return true if the object was added, false if the list was full and thus the object was not added
     */
    public boolean addFront(T newEntry){
        return true;
    }


    /**
     * Adds a new entry to the end of the list if the list is not full.
     * Entries currently in the list are unaffected.
     * If the entry is added, the list size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     * @return true if the object was added, false if the list was full and thus the object was not added
     */
    public boolean addBack(T newEntry){
        return true;
    }

    /**
     * Removes an entry from the beginning of the list.
     * Entries currently in the list are shifted up.
     * If an entry is removed, the list size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    public T removeFront(){
        T object = (T) new Object();
        return object;
    }


    /**
     * Removes an entry from the end of the list.
     * Entries currently in the list are unaffected.
     * If an entry is removed, the list size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    public T removeBack(){
        T object = (T) new Object();
        return object;
    }

    /** Removes all entries from this list. */
    public void clear(){
        //while loop and remove
    }


    public T getEntry(int givenPosition){
        T object = (T) new Object();
        return object;
    }


    public int indexOf(T anEntry){
        return 0;
    }

    public int lastIndexOf(T anEntry){
        return 0;
    }

    /**
     * Determines whether an entry is in the list.
     *
     * @param anEntry the object to search for in the list.
     * @return true if the list contains the entry, false otherwise
     */
    public boolean contains(T anEntry){
        return true;
    }


    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    public int size(){
        return 0;
    }

    /**
     * Checks whether this list is empty.
     *
     * @return True if the list is empty, or false if the list contains one or more elements.
     */
    public boolean isEmpty(){
        return true;
    }

    /**
     * Checks whether this list is full.
     *
     * @return True if the list is full, or false otherwise.
     */
    public boolean isFull(){
        return true;
    }


    public String toString(){
        return "String format of this";
    }




}