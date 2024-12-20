public class Process {
    private int processId;
    private int cpuTime;
    private final int originalCpuTime;
    private int processPriority;
    private ProcessState processState;
    private int arrivalTime;
    private int completionTime;

    public Process(int processId, int cpuTime, int processPriority, int arrivalTime, ProcessState processState) {
        this.processId = processId;
        this.cpuTime = cpuTime;
        this.originalCpuTime = cpuTime;
        this.processPriority = processPriority;
        this.arrivalTime = arrivalTime;
        this.processState = processState;
        this.completionTime = 0;
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
                ", priority=" + processPriority +
                ", state=" + processState +
                '}';
    }

    public enum ProcessState {
        READY,
        RUNNING,
        WAITING,
        TERMINATED
    }
}
