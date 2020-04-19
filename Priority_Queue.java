import java.util.ArrayList;

public class Priority_Queue<T> {
    private ArrayList<Element<T>> heap;
    public Priority_Queue(){
        heap = new ArrayList<Element<T>>();
    }
    public void insert(T value,int priority){
        Element<T> e = new Element<>(value,priority);
        heap.add(e);
        int cIndex = size()-1;
        int pIndex = (cIndex-1)/2;
        while (cIndex>0) {
            if (heap.get(cIndex).priority < heap.get(pIndex).priority) {
                Element<T> temp = heap.get(pIndex);
                heap.set(pIndex, heap.get(cIndex));
                heap.set(cIndex, temp);
                cIndex = pIndex;
                pIndex = (cIndex - 1) / 2;
            } else {
                return;
            }
        }
    }
    public T getMin() throws Priority_QueueException{
        if(isEmpty()){
            throw new Priority_QueueException();
        }
        return heap.get(0).value;
    }
    public T removeMin() throws Priority_QueueException{
        if(isEmpty()) {
            throw new Priority_QueueException();
        }
        Element<T> removalElement = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int pIndex = 0;
        int lcIndex = 2*pIndex + 1;
        int rcIndex = 2*pIndex + 2;
        int minPriorityIndex = pIndex;
        while (lcIndex<heap.size())
        {
            if(heap.get(lcIndex).priority<heap.get(minPriorityIndex).priority){
                minPriorityIndex = lcIndex;
            }
            if(rcIndex<heap.size() && heap.get(rcIndex).priority<heap.get(minPriorityIndex).priority){
                minPriorityIndex = rcIndex;
            }
            if(minPriorityIndex==pIndex){break;}
            Element<T> temp = heap.get(pIndex);
            heap.set(pIndex,heap.get(minPriorityIndex));
            heap.set(minPriorityIndex,temp);
            pIndex = minPriorityIndex;
            lcIndex = 2*pIndex + 1;
            rcIndex = 2*pIndex + 2;
        }
        return removalElement.value;
    }
    public int size(){
        return heap.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }
}
