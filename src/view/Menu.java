package view;

import model.SortingAlgorithm;

import javax.swing.*;
import java.awt.*;

import static model.Constants.*;

public class Menu extends JPanel {
    
    private JButton[] selectAlgorithmButton;
    
    public Menu (SortingAlgorithm[] algorithms) {
    
        int buttonWidth = (int) Math.ceil(algorithms.length/3.0);
        int buttonHeight = 3;
        setLayout(new GridLayout(buttonWidth, buttonHeight));
    
        selectAlgorithmButton = new JButton[algorithms.length];
        for (int i = 0; i<algorithms.length; ++i) {
    
            selectAlgorithmButton[i] = new JButton(algorithms[i].getName());
            // TODO add action listener to the button in main
            add(selectAlgorithmButton[i]);
            
        }
        
    }
    
    public JButton get (int index) {
        return selectAlgorithmButton[index];
    }

}
