public class FCFS {
    int noOfProcesses;
    int totalWaitingTime;
    double averageWaitingTime;

    int totalTurnAroundTime;
    double averageTurnAroundTime;
    final private SchedulingGUI gui;

    public FCFS(SchedulingGUI gui) {
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

    public void executeFCFS(ReadyQueue readyQueue) {
        int currentTime = 0; // timeline
        gui.appendOutput("Executing FCFS Algorithm:");

        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.getFirstProcess();
            process.setProcessState(Process.ProcessState.RUNNING);
            gui.appendOutput("Executing Process: " + process);

            noOfProcesses++;

            totalWaitingTime += currentTime;
            currentTime += process.getCpuTime();
            totalTurnAroundTime += currentTime;

            process.setProcessState(Process.ProcessState.TERMINATED);
            gui.appendOutput("Executing Process: " + process);
            gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);

            readyQueue.removeProcess();
        }

        averageWaitingTime = (double) totalWaitingTime / noOfProcesses;
        averageTurnAroundTime = (double) totalTurnAroundTime / noOfProcesses;

        gui.appendOutput("Average waiting Time: " + this.getAverageWaitingTime());
        gui.appendOutput("Average Turnaround Time: " + this.getAverageTurnAroundTime());
    }

}
