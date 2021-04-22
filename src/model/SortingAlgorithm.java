package model;

import view.VisualizedSortingArray;

public abstract class SortingAlgorithm {
    
    private String name;
    private String timeComplexity, spaceComplexity;
    
    SortingAlgorithm (String name, String timeComplexity, String spaceComplexity) {
        this.name = name;
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
    }
    
    public String getName () {
        return name;
    }
    
    public String getTimeComplexity () {
        return timeComplexity;
    }
    
    public String getSpaceComplexity () {
        return spaceComplexity;
    }
    
    public abstract void sort (VisualizedSortingArray array);
    
    @Override
    public String toString () {
        return "Sorting Algorithm: "+name+
                "\nTime Complexity: "+timeComplexity+
                "\bSpace Complexity: "+spaceComplexity;
    }
    
}
