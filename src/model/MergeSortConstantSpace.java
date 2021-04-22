package model;

import view.VisualizedSortingArray;

public class MergeSortConstantSpace extends MergeSort {
    
    public MergeSortConstantSpace (String name, String timeComplexity, String spaceComplexity) {
        super("Merge Sort Constant Space", "O(nlogn)", "O(1)");
    }
    
    @Override
    protected void merge (VisualizedSortingArray array, int left, int middle, int right) {
    
        int l, r, cur;
        l = left;
        r = middle+1;
    
        for (cur = left; l<=middle && r<=right; ++cur) {
            
            // Take the remainder of the element in order to
            // cancel out all the multiplication by max to get
            // the og value
            int ogLeft, ogRight;
            ogLeft = array.get(l)%array.getMax();
            ogRight = array.get(r)%array.getMax();
        
            // Multiply by max so modulus
            // cancels out the new element
            if (array.isGreater(ogLeft, ogRight)) {
                array.set(cur, array.get(cur)+ogRight*array.getMax());
                ++r;
            } else {
                array.set(cur, array.get(cur)+ogLeft*array.getMax());
                ++l;
            }
            
        }
    
        for (; l<=middle; ++l, ++cur)
            array.set(cur, array.get(cur)+array.get(l)%array.getMax()*array.getMax());
        for (; r<=right; ++r, ++cur)
            array.set(cur, array.get(cur)+array.get(r)%array.getMax()*array.getMax());
    
        // Obtain the actual values by canceling max.
        // Removes the remainder (og value) and keeps
        // the new value (max cancels out)
        for (int i = left; i<=right; ++i)
            array.set(i, array.get(i)/array.getMax());
        
    }
    
}

