import java.util.Comparator;

public class SJF {
    int noOfProcesses;
    int totalWaitingTime;
    double averageWaitingTime;

    int totalTurnAroundTime;
    double averageTurnAroundTime;
    final private SchedulingGUI gui;

    public SJF(SchedulingGUI gui) {
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

    public void executeSJF(ReadyQueue readyQueue) {
        int currentTime = 0;
        gui.appendOutput("Executing SJF Algorithm:");

        while (!readyQueue.isEmpty()) {
            readyQueue.getProcesses().sort(Comparator.comparingInt(Process::getCpuTime));

            Process process = readyQueue.getFirstProcess();
            process.setProcessState(Process.ProcessState.RUNNING);
            gui.appendOutput("Executing Process: " + process);

            noOfProcesses++;
            totalWaitingTime += currentTime;

            currentTime += process.getCpuTime();

            totalTurnAroundTime += currentTime;

            process.setProcessState(Process.ProcessState.TERMINATED);
            gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);

            readyQueue.removeProcess();
        }

        averageWaitingTime = (double) totalWaitingTime / noOfProcesses;
        averageTurnAroundTime = (double) totalTurnAroundTime / noOfProcesses;

        gui.appendOutput("Average Waiting Time: " + this.getAverageWaitingTime());
        gui.appendOutput("Average Turnaround Time: " + this.getAverageTurnAroundTime());
    }
}
