package projeto;
import javax.swing.*;
import java.awt.*;

public class ToDoListGUI extends JFrame {
    
    private final TaskManager taskManager;
    private final DefaultListModel<Task> taskListModel;
    private final JList<Task> taskList;
    private final JTextField taskInput;

    public ToDoListGUI() {
        taskManager = new TaskManager();

        
        setTitle("Lista de afazeres");
        setSize(720, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        taskInput = new JTextField(20);

        JButton addButton = new JButton("Adicionar Tarefa");
        JButton removeButton = new JButton("Remover Tarefa");
        JButton completeButton = new JButton("Completar Tarefa");

        removeButton.setBackground(Color.RED);
        completeButton.setBackground(Color.green);
        addButton.setBackground(Color.GRAY);
        
        
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(removeButton);
        buttonPanel.add(completeButton);

        
        JScrollPane scrollPane = new JScrollPane(taskList);

        
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(_ -> addTask());

        removeButton.addActionListener(_ -> removeTask());

        completeButton.addActionListener(_ -> completeTask());
    }


    private void addTask() {
        String description = taskInput.getText();
        if (!description.isEmpty()) {
            taskManager.addTask(description);
            taskListModel.addElement(taskManager.getTask(taskManager.getTaskCount() - 1));
            taskInput.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "A descrição da tarefa não pode estar vazia.");
        }
    }


    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskManager.removeTask(selectedIndex);
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para remover.");
        }
    }

    
    private void completeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskManager.completeTask(selectedIndex);
            taskList.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para completar.");
        }
    }

    
}
