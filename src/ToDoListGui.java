import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGui extends JFrame implements ActionListener {

    /// taskPanel will act as the container for the taskcompanentpanel
    /// task component panel will store all the task component

    private JPanel taskPanel, taskComponentPanel;


    public ToDoListGui(){
        super(" To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponent();
    }

    private void addGuiComponent(){

        /// banner text

        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setBounds(
                (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
                15,
                CommonConstants.BANNER_SIZE.width,
                CommonConstants.BANNER_SIZE.height
        );

        /// taskPanel

        taskPanel = new JPanel();

        /// taskComponentPanel

        taskComponentPanel  = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        /// add scrolling to the task panel

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8,70,CommonConstants.GUI_SIZE.width, CommonConstants.GUI_SIZE.height);
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        /// adding task button

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(-5,CommonConstants.GUI_SIZE.height - 88,
                CommonConstants.ADDTASK_BUTTON_SIZE.width, CommonConstants.ADDTASK_BUTTON_SIZE.height);
        addTaskButton.addActionListener(this);



        ///  add to frame

        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
