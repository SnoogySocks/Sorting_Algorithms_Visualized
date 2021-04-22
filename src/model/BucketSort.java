package model;

import view.VisualizedSortingArray;

import java.util.Collections;
import java.util.LinkedList;

public class BucketSort extends SortingAlgorithm {
    
    public BucketSort() {
        super("Bucket Sort", "O(n+k)", "O(n)");
    }
    
    @Override
    public void sort (VisualizedSortingArray array) {
    
        int numBuckets = (int) Math.sqrt(array.getMax())+1;
        LinkedList<Integer>[] buckets = new LinkedList[numBuckets];
        for (int i = 0; i<numBuckets; ++i)
            buckets[i] = new LinkedList<>();
    
        for (int i = 0; i<array.length(); ++i) {
            buckets[array.get(i)/numBuckets].add(array.get(i));
        }
        int arrayIterator = 0;
        for (int i = 0; i<numBuckets; ++i) {
        
            Collections.sort(buckets[i]);
            for (int element: buckets[i])
                array.set(arrayIterator++, element);
        
        }
        
    }
    
}
