public class MyList <T> {
    public int capacity=10;

    T[] array= (T[]) new Object[10];
    public MyList() {
        T[] array = (T[]) new Object[10];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        T[] array= (T[]) new Object[capacity];
    }
    public int size(){
        int count=0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]!=null){
                count++;

            }

        }
        return count;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void add(T data){

        if(this.size()==this.getCapacity())
        {
            this.capacity=capacity*2;
            T [] newArray= (T[]) new Object[capacity];
            for (int i = 0; i < array.length ; i++) {
                newArray[i]=array[i];
            }
            newArray[(array.length)]=data;
            this.array=newArray;

        }
        else{
            array[this.size()]=data;

        }
    }

    public T get(int index){
        return this.array[index];
    }
    public T remove(int index){

        this.array[index]=null;
        T removed=this.array[index];
        if(index>this.getCapacity()&&index<0){
            return null;
        }
        for (int i = index; i <this.size() ; i++) {
            this.array[i+1]=this.array[i];
            //1,2,null,3,4,5
            this.array[i]=removed;

        }
        return removed;

    }
    public T set(int index,T data){
        this.array[index]=data;
        T set =this.array[index];
        return set;

    }

    public int indexOf(T data){
        for (int i = 0; i <this.array.length ; i++) {
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        for (int i = this.array.length-1; i>=0; i--) {
            if(array[i]==data){
                return i;

            }
        }
        return -1;
    }
    public boolean isEmpty(){
        int count =0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]==null){
                count++;
            }

        }if(count==array.length){
            return true;
        }

        else{
            return false;
        }
    }
    public T []toArray(){
        T [] newlist= (T[]) new Object[getCapacity()];
        for (int i = 0; i <this.array.length ; i++) {
            newlist[i]=this.array[i];
        }
        return newlist;
    }
    public void clear(){
        for (int i = 0; i <this.array.length ; i++) {
            this.array[i]=null;
        }
    }
    public MyList <T> sublist(int start,int finish){
        int size=finish+1-start;
        MyList <T> myNewList =new MyList<>(size);
        int j=0;
        for (int i = start; i <=finish ; i++) {
            myNewList.add(array[i]);
        }
        return myNewList;
    }
    public boolean contains(T data){
        if(lastIndexOf(data)!=-1&&indexOf(data)!=-1){

            return true;
        }
        else{
            return false;
        }
    }
}