# CPU Scheduling Simulator

This repository contains a simulation of various CPU scheduling algorithms implemented in Java. It provides an interactive way to explore the behavior of four commonly used scheduling algorithms:

- **First Come First Serve (FCFS)**
- **Shortest Job First (SJF)**
- **Priority Scheduling**
- **Round Robin (RR)**

Each algorithm is implemented in a separate class, providing a clean and modular design. This allows for easy testing and comparison between different scheduling strategies.

## Algorithms

### 1. **First Come First Serve (FCFS)**

FCFS is the simplest CPU scheduling algorithm. In this algorithm, the processes are executed in the order in which they arrive in the ready queue. The first process that arrives will be executed first, and the next process is executed only after the current process has completed.

- **Advantages**: Simple and easy to implement.
- **Disadvantages**: Can cause long waiting times, especially when a long process arrives first.

### 2. **Shortest Job First (SJF)**

SJF is a preemptive or non-preemptive algorithm where the process with the smallest execution time (burst time) is selected next for execution. This algorithm aims to minimize the waiting time for processes by executing the shortest jobs first.

- **Advantages**: Minimizes average waiting time.
- **Disadvantages**: Requires knowing the burst time of processes in advance, which is not always practical.

### 3. **Priority Scheduling**

Priority Scheduling assigns a priority to each process. The process with the highest priority is executed first. This can be either preemptive or non-preemptive depending on whether a running process can be interrupted by a higher-priority process.

- **Advantages**: Prioritizes important tasks.
- **Disadvantages**: Can cause starvation, where lower-priority processes may never get executed if high-priority processes keep arriving.

### 4. **Round Robin (RR)**

Round Robin scheduling is a preemptive algorithm that assigns a fixed time slice (quantum) to each process in the ready queue. When a process’s time slice is over, it is moved to the back of the queue, and the next process is given the CPU.

- **Advantages**: Fair to all processes and prevents starvation.
- **Disadvantages**: The time slice must be chosen wisely; too short, and it leads to high overhead, too long, and it behaves similarly to FCFS.

## How to Run

### Prerequisites

Ensure that you have Java Development Kit (JDK) installed. This project is developed with Java 17.

### Compilation and Running

1. Clone the repository:

   ```bash
    git clone https://github.com/Muhammed-Amer/CpuSchedulingSimulator.git
   
    cd CpuSchedulingSimulator
   
    javac Main.java
    java Main