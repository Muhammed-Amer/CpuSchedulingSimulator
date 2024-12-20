import java.util.Comparator;

public class Priority {
    int noOfProcesses;
    int totalWaitingTime;
    double averageWaitingTime;

    int totalTurnAroundTime;
    double averageTurnAroundTime;
    final private SchedulingGUI gui;

    public Priority(SchedulingGUI gui) {
        this.gui = gui;
        noOfProcesses = 0;
        totalWaitingTime = 0;
        averageWaitingTime = 0;

        totalTurnAroundTime = 0;
        averageTurnAroundTime = 0;
    }

    double getAverageWaitingTime() {
        return averageWaitingTime;
    }

    double getAverageTurnAroundTime() {
        return averageTurnAroundTime;
    }

    public void executePriority(ReadyQueue readyQueue) {
        int currentTime = 0;
        gui.appendOutput("Executing Priority Algorithm:");

        readyQueue.getProcesses().sort(Comparator.comparingInt(Process::getProcessPriority));

        for (Process process : readyQueue.getProcesses()) {
            process.setProcessState(Process.ProcessState.RUNNING);
            gui.appendOutput("Executing Process: " + process);

            noOfProcesses++;
            totalWaitingTime += currentTime;

            currentTime += process.getCpuTime();

            totalTurnAroundTime += currentTime;

            process.setProcessState(Process.ProcessState.TERMINATED);
            gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);
        }

        averageWaitingTime = (double) totalWaitingTime / noOfProcesses;
        averageTurnAroundTime = (double) totalTurnAroundTime / noOfProcesses;

        gui.appendOutput("Average Waiting Time: " + this.getAverageWaitingTime());
        gui.appendOutput("Average Turnaround Time: " + this.getAverageTurnAroundTime());
    }
}
