public class Process {
    private int processId;
    private int cpuTime; // Remaining CPU time
    private int originalCpuTime; // Total CPU time required by the process
    private int processPriority;
    private ProcessState processState;
    private int arrivalTime; // The time the process arrives in the queue
    private int completionTime; // The time when the process finishes
    private int lastExecutionTime; // The last time the process was executed
    private int waitingTime; // Accumulated waiting time

    public Process(int processId, int cpuTime, int processPriority, int arrivalTime, ProcessState processState) {
        this.processId = processId;
        this.cpuTime = cpuTime;
        this.originalCpuTime = cpuTime; // Store the original CPU time
        this.processPriority = processPriority;
        this.arrivalTime = arrivalTime;
        this.processState = processState;
        this.completionTime = 0;
        this.lastExecutionTime = 0; // Initialize to 0
        this.waitingTime = 0; // Initialize to 0
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getOriginalCpuTime() {
        return originalCpuTime;
    }

    public int getProcessPriority() {
        return processPriority;
    }

    public void setProcessPriority(int processPriority) {
        this.processPriority = processPriority;
    }

    public ProcessState getProcessState() {
        return processState;
    }

    public void setProcessState(ProcessState processState) {
        this.processState = processState;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return originalCpuTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    // String representation of the process
    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                ", cpuTime=" + cpuTime +
                ", originalCpuTime=" + originalCpuTime +
                ", priority=" + processPriority +
                ", state=" + processState +
                ", arrivalTime=" + arrivalTime +
                ", waitingTime=" + waitingTime +
                ", completionTime=" + completionTime +
                '}';
    }

    // Process state enum
    public enum ProcessState {
        READY,
        RUNNING,
        WAITING,
        TERMINATED
    }
}
