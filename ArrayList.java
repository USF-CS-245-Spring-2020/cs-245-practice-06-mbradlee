import java.lang.reflect.Array;

public class ArrayList<T>{

    protected Class<T> type;
    protected T[] array;
    protected int size;

    public ArrayList(Class<T> typeInit, int sizeInit){
        type = typeInit;
        size = sizeInit;
        array = (T[])Array.newInstance(type, size);
    }

    public void add(int pos, T data){
        if(size == array.length){
            double_array();
            for(int i = size - 1; i > pos; i--){
                array[i] = array [i-1];
            }
            array[pos] = data;
            size++;
        }else{
            for(int i = size - 1; i > pos; i--){
                array[i] = array [i-1];
            }
            array[pos] = data;
            size++;
        }
    }

    public void add(T data){
        if(size == array.length){
            int oldSize = size;
            double_array();
            for(int i = size - 1; i > oldSize; i--){
                array[i] = array [i-1];
            }
            array[oldSize + 1] = data;
            size++;
        }else{
            //how do you know where the end of the array is? (Where the last number is in current arr size.)
        }
    }

    public T remove(int pos){
        if(pos < 0 || pos > size - 1){
            throw new IndexOutOfBoundsException();
        }

        if(pos == size - 1){
            size--;
        }else{
            for(int i = pos; i < size - 1; i++){
                array[i] = array[i+1];
            }
            size--;
        }
        return array[pos];
    }

    public T get(int pos){
        if(pos < 0 || pos > size - 1){
            throw new IndexOutOfBoundsException();
        }

        return array[pos];
    }

    public int size(){
        return size;
    }

    protected void double_array(){
        T[] tempArray;
        size *= 2;

        tempArray = (T[])Array.newInstance(type, size);

        for(int i = 0; i < size; i++){
            tempArray[i] = array[i];
        }

        array = tempArray;
    }

}
