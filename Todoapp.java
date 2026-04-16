import javax.swing.*;
import java.awt.ScrollPane;
import java.awt.event.*;
public class Todoapp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do-List");
        
        JTextField taskField = new JTextField();
        taskField.setBounds(50,50,200,30);

        JButton addButton = new JButton("Add");
        addButton.setBounds(260,50,80,30);

        DefaultListModel<String>listmodel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listmodel);

        JScrollPane scrollpane = new JScrollPane(taskList);
        scrollpane.setBounds(50,100,290,150);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(120,260,100,30);

        addButton.addActionListener(e ->{
            String task = taskField.getText();
            if (!task.isEmpty()){
                listmodel.addElement(task);
                taskField.setText("");
            }
        });

        deleteButton.addActionListener(e ->{
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1){
                listmodel.remove(selectedIndex);
            }
        });

        frame.add(taskField);
        frame.add(addButton);
        frame.add(scrollpane);
        frame.add(deleteButton);

        frame.setSize(400,350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
