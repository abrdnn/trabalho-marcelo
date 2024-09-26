package projeto;

import javax.swing.*;


public class Main {

    
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
        ToDoListGUI frame = new ToDoListGUI();
        frame.setVisible(true);
    });
        
    }
    
}
