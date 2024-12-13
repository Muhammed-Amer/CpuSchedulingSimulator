import java.util.LinkedList;

public class ReadyQueue {
    private LinkedList<Process> processes;

    public ReadyQueue() {
        processes = new LinkedList<>();
    }

    public void addProcess(Process process) {
        processes.addLast(process);
    }

    public LinkedList<Process> getProcesses() {
        return processes;
    }

    public Process getFirstProcess() {
        if (!processes.isEmpty()) {
            return processes.getFirst();
        }
        return null;
    }

    public void moveFirstToEnd() {
        if (!processes.isEmpty()) {
            Process firstProcess = processes.removeFirst();
            processes.addLast(firstProcess);
        }
    }

    public void printQueue() {
        for (Process process : processes) {
            System.out.println("Process ID: " + process.getProcessId() +
                    ", CPU Time: " + process.getCpuTime() +
                    ", Priority: " + process.getProcessPriority());
        }
    }

    public void removeProcess() {
        if (!processes.isEmpty()) {
            processes.removeFirst();
            System.out.println("One process terminated!");
        } else {
            System.out.println("Cpu is setting idle, NO processes here!");
        }
    }

    public boolean isEmpty() {
        return processes.isEmpty();
    }
}
