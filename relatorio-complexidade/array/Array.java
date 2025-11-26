package array;

public class Array<T extends Comparable<T>> {
    private T[] elements;
    private int currentSize;

     @SuppressWarnings("unchecked")
     public Array() {
        this.elements = (T[]) new Comparable[16];
        this.currentSize = 0;
     }

     @SuppressWarnings("unchecked")
     public Array(int initialCapacity) {
         if (initialCapacity <= 0) {
             initialCapacity = 16;
         }
         this.elements = (T[]) new Comparable[initialCapacity];
         this.currentSize = 0;
     }
   
    public boolean isSorted() {
        for (int i = 0; i < currentSize - 1; i++) {
            if (elements[i].compareTo(elements[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

   
    public int getSize() {
        return currentSize;
    }

    public int getCapacity() {
        return elements.length;
    }

    public T getElement(int index) {
        validateIndex(index);
        return elements[index];
    }

    public void setElement(int index, T value) {
        validateIndex(index);
        elements[index] = value;
    }

    public void add(T value) {
        ensureCapacity(currentSize + 1);
        elements[currentSize++] = value;
    }

    public void addAt(int index, T value) {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        ensureCapacity(currentSize + 1);
        for (int i = currentSize; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        currentSize++;
    }

    public T removeAt(int index) {
        validateIndex(index);
        T removedValue = elements[index];
        for (int i = index; i < currentSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[currentSize - 1] = null;
        currentSize--;
        return removedValue;
    }

    public int indexOf(T value) {
        if (value == null) {
            for (int i = 0; i < currentSize; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (value.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Indice invalido: " + index + ", tamanho atual: " + currentSize);
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) return;
        int newCapacity = elements.length * 2;
        if (newCapacity < minCapacity) newCapacity = minCapacity;
        T[] newElements = (T[]) new Comparable[newCapacity];
        for (int i = 0; i < currentSize; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    
    public int sequentialSearch(T value) {
         for (int i = 0; i < currentSize; i++) {
             if (elements[i].equals(value)) {
                 return i;
             }
          }
          return -1;
    }
    public int binarySearchRecursive(T value) {
        return binarySearchRecursive(value, 0, currentSize - 1);
    }

   private int binarySearchRecursive(T value, int start, int end) {
       if (start > end) {
           return -1;
       }
   
       int mid = (start + end) / 2;
       int comparison = value.compareTo(elements[mid]);
   
       if (comparison == 0) {
           return mid;
       } else if (comparison > 0) {
           return binarySearchRecursive(value, mid + 1, end);
       } else {
           return binarySearchRecursive(value, start, mid - 1);
       }
   }



    @Override
    public String toString() {
        if (currentSize == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < currentSize; i++) {
            sb.append(elements[i]);
            if (i < currentSize - 1) sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
