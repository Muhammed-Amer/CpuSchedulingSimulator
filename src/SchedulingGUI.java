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

        // Input Fields
        processIdField = new JTextField(5);
        priorityField = new JTextField(5);
        cpuTimeField = new JTextField(5);

        JButton addProcessButton = new JButton("Add Process");
        addProcessButton.addActionListener(this::addProcess);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Process ID:"));
        inputPanel.add(processIdField);
        inputPanel.add(new JLabel("Priority:"));
        inputPanel.add(priorityField);
        inputPanel.add(new JLabel("CPU Time:"));
        inputPanel.add(cpuTimeField);
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

        // Layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("CPU Scheduling Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addProcess(ActionEvent e) {
        try {
            int processId = Integer.parseInt(processIdField.getText());
            int priority = Integer.parseInt(priorityField.getText());
            int cpuTime = Integer.parseInt(cpuTimeField.getText());

            Process newProcess = new Process(processId, priority, cpuTime, Process.ProcessState.READY);
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
        FCFS fcfs = new FCFS(this); // Pass the GUI instance
        outputArea.setText(""); // Clear previous output
        fcfs.executeFCFS(readyQueue);
    }

    private void runSJF(ActionEvent e) {
        SJF sjf = new SJF(this); // Pass the GUI instance
        outputArea.setText(""); // Clear previous output
        sjf.executeSJF(readyQueue);
    }

    private void runRR() {
        int timeQuantum = 4; // Example time quantum
        RR rr = new RR(this, timeQuantum); // Pass the GUI instance
        outputArea.setText(""); // Clear previous output
        rr.executeRR(readyQueue);
    }

    private void runPriority() {
        Priority priority = new Priority(this); // Pass the GUI instance
        outputArea.setText(""); // Clear previous output
        priority.executePriority(readyQueue);
    }

    // Append output to the JTextArea
    public void appendOutput(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchedulingGUI::new);
    }
}
