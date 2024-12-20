public class RR {
    final private SchedulingGUI gui;
    private final int timeQuantum;
    int noOfProcesses;
    int totalWaitingTime;
    double averageWaitingTime;
    int totalTurnAroundTime;
    double averageTurnAroundTime;

    public RR(SchedulingGUI gui, int timeQuantum) {
        this.gui = gui;
        this.timeQuantum = timeQuantum;
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

    public void executeRR(ReadyQueue readyQueue) {
        int currentTime = 0;
        gui.appendOutput("Executing RR Algorithm, time quantum = " + timeQuantum);

        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.getFirstProcess();
            process.setProcessState(Process.ProcessState.RUNNING);
            gui.appendOutput("Executing Process: " + process);

            if (process.getCpuTime() <= timeQuantum) {
                currentTime += process.getCpuTime();
                process.setCompletionTime(currentTime);
                process.setProcessState(Process.ProcessState.TERMINATED);
                gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);

                int turnaroundTime = process.getCompletionTime(); // turnaround Time = tompletion Time
                int waitingTime = turnaroundTime - process.getOriginalCpuTime(); // waiting Time = turnaround time - burst Time

                totalTurnAroundTime += turnaroundTime;
                totalWaitingTime += waitingTime;

                noOfProcesses++;
                readyQueue.removeProcess();
            } else {
                process.setCpuTime(process.getCpuTime() - timeQuantum);
                currentTime += timeQuantum;

                readyQueue.moveFirstToEnd();
                gui.appendOutput("Process " + process.getProcessId() + " executed for " + timeQuantum
                        + " units, remaining time: " + process.getCpuTime());
            }
        }

        if (noOfProcesses > 0) {
            averageWaitingTime = (double) totalWaitingTime / noOfProcesses;
            averageTurnAroundTime = (double) totalTurnAroundTime / noOfProcesses;

            gui.appendOutput("Average Waiting Time: " + averageWaitingTime);
            gui.appendOutput("Average Turnaround Time: " + averageTurnAroundTime);
        } else {
            gui.appendOutput("No processes were executed in the Round Robin scheduling.");
        }
    }
}
