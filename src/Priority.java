import java.util.Collections;
import java.util.Comparator;

public class Priority {
    private SchedulingGUI gui;

    public Priority(SchedulingGUI gui) {
        this.gui = gui;
    }

    public void executePriority(ReadyQueue readyQueue) {
        int currentTime = 0;
        gui.appendOutput("Executing Priority Algorithm:");

        readyQueue.getProcesses().sort(Comparator.comparingInt(Process::getProcessPriority));

        for (Process process : readyQueue.getProcesses()) {
            process.setProcessState(Process.ProcessState.RUNNING);
            gui.appendOutput("Executing Process: " + process);

            currentTime += process.getCpuTime();
            gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);

            process.setProcessState(Process.ProcessState.TERMINATED);
        }
    }
}
