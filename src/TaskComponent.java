import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private  JTextPane taskField;
    private  JButton deleteButton;

    public JTextPane getTaskField() {
        return taskField;
    }

    ///  this panel is used so that we can make updates to the task component panel when deleting tasks
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel) {
        this.parentPanel = parentPanel;


        /// task field

        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        /// checkbox

        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.addActionListener(this);


        /// add delete button

        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);

        ///  add to this tasKComponent
        add(checkBox);
        add(taskField);
        add(deleteButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            /// replaces all html to empty string to grab the main text
            String taskText = taskField.getText().replaceAll("<[^>]*>","");

        /// add strikethrough text
        taskField.setText("html><s>" + taskText + "</></html>");
        }else if(!checkBox.isSelected()){
            String taskText = taskField.getText().replaceAll("<[^>]*>","");

            taskField.setText(taskText);
        }
    }
}
