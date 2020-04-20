import java.util.ArrayList;

public class PriorityQueueMax {
    private ArrayList<Integer> heap;
    public PriorityQueueMax(){
        heap = new ArrayList<>();
    }
    public int getSize(){
        return heap.size();
    }
    public boolean isEmpty(){
        return heap.size()==0;
    }
    public int getMax(){
        if(heap.size()==0){
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }
    public void insert(int e){
        heap.add(e);
        int cI = heap.size()-1;
        int pI = (cI-1)/2;
        while(cI>0){
            if(heap.get(cI)>heap.get(pI)){
                int temp = heap.get(pI);
                heap.set(pI,heap.get(cI));
                heap.set(cI,temp);
                cI = pI;
                pI = (cI-1)/2;
            }else{
                return;
            }
        }
    }

    public int removeMax(){
        if(heap.size()==0){
            return Integer.MIN_VALUE;
        }
        int max = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int pI = 0;
        int lcI = 2*pI+1;
        int rcI = 2*pI+2;
        while(lcI<heap.size()){
            int maxI = pI;
            if(heap.get(maxI)<heap.get(lcI)){
                maxI = lcI;
            }
            if(rcI<heap.size() && heap.get(maxI)<heap.get(rcI)){
                maxI = rcI;
            }
            if(maxI==pI){
                break;
            }
            int temp = heap.get(maxI);
            heap.set(maxI,heap.get(pI));
            heap.set(pI,temp);
            pI = maxI;
            lcI = 2*pI+1;
            rcI = 2*pI+2;
        }
        return max;
    }
}
