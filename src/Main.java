import controller.SortingVisualizationController;
import model.MergeSort;
import view.VisualizedSortingArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Constants.*;

public class Main {
    
    public static void main (String[] args) {
    
        new SortingVisualizationController();
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(FRAME_WIDTH+FRAME_WIDTH_CORRECT, FRAME_HEIGHT+FRAME_HEIGHT_CORRECT);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//        panel.setLayout(null);
//        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
//
//        VisualizedSortingArray array = new VisualizedSortingArray(100);
//        array.setBounds(0, 0, ARRAY_PANEL_WIDTH, ARRAY_PANEL_HEIGHT);
//        panel.add(array);
//
//        JButton button = new JButton("Start");
//        button.setBounds(0, ARRAY_PANEL_HEIGHT, 100, 70);
//        button.addActionListener(event->{
//            new MergeSort().sort(array);
//            array.clearSelected();
//        });
//        panel.add(button);
//
//        frame.setVisible(true);
//        array.generateBalancedArray();
//        array.shuffle();
    
    }
    
}
