import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SchedulingGUI extends JFrame {
    private ReadyQueue readyQueue;
    private JTextArea outputArea;
    private JTextField processIdField;
    private JTextField priorityField;
    private JTextField cpuTimeField;

    public SchedulingGUI() {
        readyQueue = new ReadyQueue();
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        processIdField = new JTextField(5);
        priorityField = new JTextField(5);
        cpuTimeField = new JTextField(5);

        JButton addProcessButton = new JButton("Add Process");
        addProcessButton.addActionListener(this::addProcess);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Process ID:"));
        inputPanel.add(processIdField);
        inputPanel.add(new JLabel("CPU Time:"));
        inputPanel.add(cpuTimeField);
        inputPanel.add(new JLabel("Priority:"));
        inputPanel.add(priorityField);
        inputPanel.add(addProcessButton);

        // Buttons for Algorithms
        JButton fcfsButton = new JButton("Run FCFS");
        fcfsButton.addActionListener(this::runFCFS);

        JButton sjfButton = new JButton("Run SJF");
        sjfButton.addActionListener(this::runSJF);

        JButton rrButton = new JButton("Run RR");
        rrButton.addActionListener(e -> runRR());

        JButton priorityButton = new JButton("Run Priority");
        priorityButton.addActionListener(e -> runPriority());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fcfsButton);
        buttonPanel.add(sjfButton);
        buttonPanel.add(rrButton);
        buttonPanel.add(priorityButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("CPU Scheduling Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addProcess(ActionEvent e) {
        try {
            int processId = Integer.parseInt(processIdField.getText());
            int priority = Integer.parseInt(priorityField.getText());
            int cpuTime = Integer.parseInt(cpuTimeField.getText());
            Process newProcess = new Process(processId, cpuTime, priority, 0, Process.ProcessState.READY);
            readyQueue.addProcess(newProcess);

            outputArea.append("Added Process: " + newProcess + "\n");
            clearInputFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers for Process ID, Priority, and CPU Time.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInputFields() {
        processIdField.setText("");
        priorityField.setText("");
        cpuTimeField.setText("");
    }

    private void runFCFS(ActionEvent e) {
        FCFS fcfs = new FCFS(this);
        fcfs.executeFCFS(readyQueue);
        String averageMessage = "Average Waiting Time: " + fcfs.getAverageWaitingTime() + "\n" +
                "Average Turnaround Time: " + fcfs.getAverageTurnAroundTime();
        JOptionPane.showMessageDialog(null, averageMessage,  "Average", JOptionPane.INFORMATION_MESSAGE);
        outputArea.setText("");
    }

    private void runSJF(ActionEvent e) {
        SJF sjf = new SJF(this);
        sjf.executeSJF(readyQueue);

        String averageMessage = "Average Waiting Time: " + sjf.getAverageWaitingTime() + "\n" +
                "Average Turnaround Time: " + sjf.getAverageTurnAroundTime();
        JOptionPane.showMessageDialog(null, averageMessage,  "Average", JOptionPane.INFORMATION_MESSAGE);
        outputArea.append("---------------");
    }

    private void runRR() {
        int timeQuantum;
        String input = JOptionPane.showInputDialog(null, "Enter timeQuantum:", "Input", JOptionPane.PLAIN_MESSAGE);

            timeQuantum = Integer.parseInt(input);
            System.out.println("The timeQuantum is: " + timeQuantum);

        RR rr = new RR(this, timeQuantum);
        outputArea.setText("");
        rr.executeRR(readyQueue);

        String averageMessage = "Average Waiting Time: " + rr.getAverageWaitingTime() + "\n" +
                "Average Turnaround Time: " + rr.getAverageTurnAroundTime();
        JOptionPane.showMessageDialog(null, averageMessage,  "Average", JOptionPane.INFORMATION_MESSAGE);
        outputArea.setText("");
    }

    private void runPriority() {
        Priority priority = new Priority(this);
        priority.executePriority(readyQueue);

        String averageMessage = "Average Waiting Time: " + priority.getAverageWaitingTime() + "\n" +
                "Average Turnaround Time: " + priority.getAverageTurnAroundTime();
        JOptionPane.showMessageDialog(null, averageMessage,  "Average", JOptionPane.INFORMATION_MESSAGE);
        outputArea.setText("");
    }

    public void appendOutput(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchedulingGUI::new);
    }
}
