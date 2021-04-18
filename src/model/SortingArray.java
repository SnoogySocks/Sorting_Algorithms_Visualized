package model;

import java.util.Arrays;
import java.util.Random;

public abstract class SortingArray {
    
    private final Random random;
    
    private int[] array;
    private int max;
    private int comparisonsCount, setsCount;
    
    public SortingArray () {
        
        random = new Random();
        array = null;
        max = Integer.MIN_VALUE;
        resetCounts();
        
    }
    
    public SortingArray (int length) {
        this();
        updateLength(length);
    }
    
    public SortingArray (SortingArray sortingArray) {
        this(sortingArray, 0, sortingArray.length());
    }
    
    public SortingArray (SortingArray sortingArray, int begin, int end) {
        
        this();
        max = sortingArray.max;
        
        int length = end-begin;
        array = new int[length];
        System.arraycopy(sortingArray.array, begin, array, 0, length);
        
    }
    
    public void updateLength (int length) {
        
        array = new int[length];
        generateBalancedArray();
        shuffle();
        resetCounts();
        
    }
    
    /**
     * Fill the array with values in the range [1, array.length]
     * such that there are no duplicate numbers in the range
     */
    public void generateBalancedArray () {
        for (int i = 0; i<array.length; ++i)
            set(i, i+1);
    }
    
    /** Shuffle the elements in the array */
    public void shuffle () {
        for (int i = array.length-1; i>=1; --i)
            swap(i, random.nextInt(i+1));
    }
    
    public int length() {
        return array.length;
    }
    
    public int getMax() {
        return max;
    }
    
    public int get (int index) {
        return array[index];
    }
    
    public void set (int index, int value) {
        ++setsCount;
        max = Math.max(max, value);
        array[index] = value;
    }
    
    public void swap (int i, int j) {
        
        setsCount += 2;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
    }
    
    public boolean isGreater (int val1, int val2) {
        ++comparisonsCount;
        return val1>val2;
    }
    
    public int getCountSets () {
        return setsCount;
    }
    
    public int getComparisonsCount () {
        return comparisonsCount;
    }
    
    private void resetCounts () {
        comparisonsCount = setsCount = 0;
    }
    
    @Override
    public String toString () {
        return "SortingArray{\n"+
                "array="+Arrays.toString(array)+",\n"+
                "\tmax="+max+
                ", comparisonsCount="+comparisonsCount+
                ", setsCount="+setsCount+
                '}';
    }
    
}
