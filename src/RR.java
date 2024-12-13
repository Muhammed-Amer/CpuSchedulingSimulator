public class RR {
    private SchedulingGUI gui;
    private int timeQuantum;

    public RR(SchedulingGUI gui, int timeQuantum) {
        this.gui = gui;
        this.timeQuantum = timeQuantum;
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
                process.setProcessState(Process.ProcessState.TERMINATED);
                gui.appendOutput("Process " + process.getProcessId() + " completed at time " + currentTime);

                readyQueue.removeProcess();
            } else {
                process.setCpuTime(process.getCpuTime() - timeQuantum);
                currentTime += timeQuantum;

                readyQueue.moveFirstToEnd();
                gui.appendOutput("Process " + process.getProcessId() + " executed for " + timeQuantum + " units, remaining time: " + process.getCpuTime());
            }
        }
    }
}
