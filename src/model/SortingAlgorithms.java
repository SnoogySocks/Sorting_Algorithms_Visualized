package model;

import view.VisualizedSortingArray;

import java.util.Collections;
import java.util.LinkedList;

public class SortingAlgorithms {
    
    public static void bubbleSort (VisualizedSortingArray array) {
        
        for (int endBound = array.length()-1; endBound>0; --endBound)
            for (int i = 0; i<endBound; ++i)
                if (array.isGreater(array.get(i), array.get(i+1)))
                    array.swap(i, i+1);
        
    }
    
    public static void selectionSort (VisualizedSortingArray array) {
        
        for (int min = 0; min<array.length()-1; ++min)
            for (int i = min+1; i<array.length(); ++i)
                if (array.isGreater(array.get(min), array.get(i)))
                    array.swap(min, i);
        
    }
    
    public static void insertionSort (VisualizedSortingArray array) {
        
        for (int endBound = 1; endBound<array.length(); ++endBound) {
            
            int insertingElement, i;
            insertingElement = array.get(endBound);
            
            for (i = endBound-1; i>=0
                    && array.isGreater(array.get(i), insertingElement); --i)
                array.set(i+1, array.get(i));
            
            array.set(i+1, insertingElement);
            
        }
        
    }
    
    public static void countingSort (VisualizedSortingArray array) {
        
        int[] count = new int[array.getMax()+1];
        for (int i = 0; i<array.length(); ++i) {
            ++count[array.get(i)];
        }
        
        int arrayIterator = 0;
        for (int number = 0; number<count.length; ++number) {
            while (count[number]>0) {
                array.set(arrayIterator, number);
                ++arrayIterator;
                --count[number];
            }
        }
        
    }
    
    public static void bucketSort (VisualizedSortingArray array) {
    
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
    
    public static void radixSort (VisualizedSortingArray array) {
        
        LinkedList<Integer>[] digis = new LinkedList[10];
        for (int i = 0; i<digis.length; ++i)
            digis[i] = new LinkedList<>();
        
        for (int currentDigi = 1; currentDigi<=array.getMax(); currentDigi *= 10) {
            
            for (int i = 0; i<array.length(); ++i)
                digis[array.get(i)/currentDigi%10].add(array.get(i));
            
            int digisIndex, arrIndex;
            for (digisIndex = arrIndex = 0; arrIndex<array.length(); ++digisIndex)
                while (digis[digisIndex].size()!=0)
                    array.set(arrIndex++, digis[digisIndex].pop());
            
        }
        
    }
    
    public static void shellSort (VisualizedSortingArray array) {
        
        for (int gap = array.length()/2; gap>0; gap /= 2) {
            
            for (int beginBound = gap; beginBound<array.length(); ++beginBound) {
                
                int insertingElement, i;
                insertingElement = array.get(beginBound);
                
                for (i = beginBound; i>=gap&&array.isGreater(array.get(i-gap), insertingElement); i -= gap)
                    array.set(i, array.get(i-gap));
                
                array.set(i, insertingElement);
                
            }
            
        }
    
    }
    
    public static void quickSort (VisualizedSortingArray array) {
        quickSort(array, 0, array.length()-1);
    }
    
    private static void quickSort (VisualizedSortingArray array, int begin, int end) {
        
        if (begin>=end) return;
        
        int pivotIndex = begin;
        int pivotValue = array.get(end);
    
        for (int i = begin; i<end; ++i) {
            if (array.isGreater(array.get(i), pivotValue)) continue;
            array.swap(pivotIndex, i);
            ++pivotIndex;
        }
        array.swap(pivotIndex, end);
        
        int middle = pivotIndex;
        quickSort(array, begin, middle-1);
        quickSort(array, middle+1, end);
        
    }
    
    public static void mergeSort (VisualizedSortingArray array) {
        
        int[] leftSegment, rightSegment;
        leftSegment = new int[array.length()-1];
        rightSegment = new int[array.length()/2];
        
        for (int segmentLength = 1; segmentLength<array.length(); segmentLength *= 2) {
        
            for (int left = 0; left+segmentLength<array.length(); left += 2*segmentLength) {
    
                int right, middle, leftLength, rightLength;
                right = Math.min(left+2*segmentLength-1, array.length()-1);
                middle = left+segmentLength-1;
                
                leftLength = middle-left+1;
                rightLength = right-middle;
                
                for (int i = left; i<=middle; ++i)
                    leftSegment[i-left] = array.get(i);
                for (int i = middle+1; i<=right; ++i)
                    rightSegment[i-middle-1] = array.get(i);
                
                int l, r, i;
                l = r = 0;
                for (i = left; l<leftLength&&r<rightLength; ++i) {
                    
                    if (array.isGreater(leftSegment[l], rightSegment[r]))
                        array.set(i, rightSegment[r++]);
                    else
                        array.set(i, leftSegment[l++]);
                    
                }
                
                while (l<leftLength)
                    array.set(i++, leftSegment[l++]);
                while (r<rightLength)
                    array.set(i++, rightSegment[r++]);
                    
            }
        
        }
        
    }
    
    /**
     * Merge the two halves arr[l..m] and arr[m+1..r] from arr
     * in place; O(1) extra space
     *
     * @param arr = original array
     * @param beg = Left most boundary
     * @param mid = End of left boundary/Start of right
     * @param end = end of right boundary
     */
    public static void merge (int[] arr, int max, int beg, int mid, int end) {
        
        int l, r, cur;
        l = beg;
        r = mid+1;
        
        for (cur = beg; l<=mid && r<=end; ++cur) {
            // Take the remainder of the element in order to
            // cancel out all the multiplication by max to get
            // the og value
            int ogLeft, ogRight;
            ogLeft = arr[l]%max;
            ogRight = arr[r]%max;
            
            // Multiply by max so modulus
            // cancels out the new element
            if (ogLeft<=ogRight) {
                arr[cur] += ogLeft*max;
                ++l;
            } else {
                arr[cur] += ogRight*max;
                ++r;
            }
        }
        
        for (; l<=mid; ++l, ++cur)
            arr[cur] += arr[l]%max*max;
        for (; r<=end; ++r, ++cur)
            arr[cur] += arr[r]%max*max;
        
        // Obtain the actual values by canceling max.
        // Removes the remainder (og value) and keeps
        // the new value (max cancels out)
        for (int i = beg; i<=end; ++i)
            arr[i] /= max;
        
    }
    
}
