import java.util.Comparator;

public class SJF {
    private SchedulingGUI gui;

    public SJF(SchedulingGUI gui) {
        this.gui = gui;
    }

    public void executeSJF(ReadyQueue readyQueue) {
        int currentTime = 0;
        gui.appendOutput("Executing SJF Algorithm:");

        while (!readyQueue.isEmpty()) {
            readyQueue.getProcesses().sort(Comparator.comparingInt(Process::getCpuTime));

            Process process = readyQueue.getFirstProcess();
            process.setProcessState(Process.ProcessState.RUNNING);
            gui.appendOutput("Executing Process: " + process);

            currentTime += process.getCpuTime();
            gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);

            process.setProcessState(Process.ProcessState.TERMINATED);
            readyQueue.removeProcess();
        }
    }
}
