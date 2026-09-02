public interface ArrayListADT<E> {
    
    boolean isEmpty();
    int size();
    E get(int index);
    boolean contains(Object o);
    int indexOf(Object o);
    void add(E e);
    void add(int index, E e);
    boolean remove(Object o);
    E remove(int index);
    void clear();

}
