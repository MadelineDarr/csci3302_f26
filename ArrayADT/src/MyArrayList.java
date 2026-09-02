public class MyArrayList<E> implements ArrayListADT<E> {

    private E[] arr;
    private int numOfElements;
    private int capacity = 10;

    public MyArrayList() {
        arr = (E[]) new Object[capacity];
        numOfElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    private boolean isFull() {
        return numOfElements == capacity;
    }

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public E get(int index){
        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("Index is out of range");
        return arr[index];
    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            throw new NullPointerException("The object o can't be null");
        }
        for(int i = 0; i < numOfElements; i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null)
            throw new NullPointerException("The object o can't be null");

        for(int i = 0; i < numOfElements; i++){
            if(arr[i].equals(o))
                return i;
        }

        return -1;

    }

    private void ensureCapacity() {
        this.capacity = 2 * arr.length;
        E[] dest = (E[]) new Object[this.capacity];
        for(int i = 0; i < numOfElements; i++){
            dest[i] = arr[i];
        }
        this.arr = dest;
    }

    @Override
    public void add(E e) {
        if(e == null) {
            throw new NullPointerException("Element can't be null");
        }

        if(isFull()) {
            ensureCapacity();
        }

        arr[numOfElements] = e;
        numOfElements++;
    }

    @Override
    public void add(int index, E e) {
        if(e == null)
            throw new NullPointerException("Element can't be null");

        if(index < 0 || index > numOfElements)
            throw new IndexOutOfBoundsException("Index is out of range");

        if(isFull())
            ensureCapacity();

        for(int i = numOfElements; i > index; i++) {
            arr[i] = arr[i - 1];
        }
        arr[index] = e;
        numOfElements++;
    }

    @Override
    public E remove(int index) {
    
        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("Index is out of range");

        E temp = arr[index];

        for(int i = index; i < numOfElements - 1; i++)
            arr[i] = arr[i+1];
        
        arr[numOfElements - 1] = null;
        numOfElements--;
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null)
            throw new NullPointerException("The object o can't be null");

        int index = indexOf(o);

        if(index == -1)
            return false;

        remove(index);
        return true;
    }

    @Override
    public void clear() {
        arr = (E[]) new Object[10];
        numOfElements = 0;
    }
    
}
