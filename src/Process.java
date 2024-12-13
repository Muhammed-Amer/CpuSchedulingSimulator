public class Process {
    private int processId;
    private int cpuTime;
    private int processPriority;
    private ProcessState processState;

    public Process(int processId, int cpuTime, int processPriority, ProcessState processState) {
        this.processId = processId;
        this.cpuTime = cpuTime;
        this.processPriority = processPriority;
        this.processState = processState;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public void setProcessPriority(int processPriority) {
        this.processPriority = processPriority;
    }

    public void setProcessState(ProcessState processState) {
        this.processState = processState;
    }

    public int getProcessId() {
        return processId;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public int getProcessPriority() {
        return processPriority;
    }

    public ProcessState getProcessState() {
        return processState;
    }

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
