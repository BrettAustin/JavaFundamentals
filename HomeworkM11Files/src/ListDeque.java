import java.util.LinkedList;
import java.util.List;

public class ListDeque<T> implements DequeInterface<T> {
    private List<T> list; // note: this is List from the Java standard library java.util package

    private List<T> deque;
    public int frontIndex; //head of the Deque
    public int backIndex; //tail of the Deque

    public ListDeque(){
        //queue = (T[]) new Object[initialCapacity + 1];
        deque = (List<T>) new LinkedList<Object>();
        frontIndex = 0;
        backIndex = frontIndex;
    }

    @Override
    public void addToFront(T newEntry) {
        deque.add(0,newEntry);
        backIndex = backIndex+1;
    }

    @Override
    public void addToBack(T newEntry) {
        deque.set(backIndex+1,newEntry);
        backIndex = backIndex +1;
    }

    @Override
    public T removeFront() {
        T front = null;

        if (!isEmpty()) {
            front = deque.get(frontIndex);
            deque.remove(0);
        }
        backIndex = backIndex-1;
        return front;
    }

    @Override
    public T removeBack() {
        T back = null;

        if (!isEmpty()) {
            back = deque.get(backIndex);
            deque.remove(deque.size()-1);
        }
        backIndex = backIndex-1;
        return back;
    }

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = deque.get(frontIndex);
        }
        return front;
    }

    @Override
    public T getBack() {
        T back = null;

        if (!isEmpty()) {
            back = deque.get(backIndex);
        }
        return back;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % deque.size());
    }

    @Override
    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion
            for (int index = frontIndex; index != backIndex; index = (index + 1)
                    % deque.size()) {
                deque.set(index,null);
            }
            deque.set(backIndex,null);
        }
        frontIndex = 0;
        backIndex = deque.size() - 1;
    }
}
