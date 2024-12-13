public class FCFS {
    private SchedulingGUI gui;

    public FCFS(SchedulingGUI gui) {
        this.gui = gui;
    }

    public void executeFCFS(ReadyQueue readyQueue) {
        int currentTime = 0;
        gui.appendOutput("Executing FCFS Algorithm:");

        while (!readyQueue.isEmpty()) {
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
