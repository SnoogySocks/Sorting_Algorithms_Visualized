import model.SortingAlgorithms;
import view.VisualizedSortingArray;

import javax.swing.*;
import java.awt.*;

import static model.Constants.*;

public class Main {
    
    public static void main (String[] args) {
    
//        SortingArray shuffledArray = new VisualizedSortingArray(17);
//        VisualizedSortingArray array = new VisualizedSortingArray(shuffledArray);
//
//        System.out.println(array);
//        SortingAlgorithms.radixSort(array);
//        System.out.println(array);
//
////        long begin, end;
////
////        begin = System.nanoTime();
////        SortingAlgorithms.selectionSort(array);
////        end = System.nanoTime();
////        System.out.println(array+", time: "+(end-begin)/1000+"u");
////
////        array = new VisualizedSortingArray(shuffledArray);
////        begin = System.nanoTime();
////        SortingAlgorithms.insertionSort(array);
////        end = System.nanoTime();
////        System.out.println(array+", time: "+(end-begin)/1000+"u");
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH+FRAME_WIDTH_CORRECT, FRAME_HEIGHT+FRAME_HEIGHT_CORRECT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setSize(DISPLAY_PANEL_WIDTH, DISPLAY_PANEL_HEIGHT);
        panel.setLayout(null);
        frame.add(panel);
    
        VisualizedSortingArray array = new VisualizedSortingArray(500);
//        for (int i = 0; i<array.length(); ++i) {
//            panel.add(array.getBar(i));
//        }
//        Bar.barWidth = DISPLAY_PANEL_WIDTH/10;
//        Bar.barHeight = DISPLAY_PANEL_HEIGHT/10;
//        Bar bar = new Bar(0, 10);
//        bar.setColor(Color.RED);
//        panel.add(bar);
        array.setBounds(0, 0, DISPLAY_PANEL_WIDTH, DISPLAY_PANEL_HEIGHT);
        panel.add(array);
        
        frame.setVisible(true);
        array.generateBalancedArray();
        array.shuffle();
        SortingAlgorithms.radixSort(array);
        for (int i = 0; i<400; ++i) {
            array.repaint();
            array.sleep();
        }
    
    }
    
}
