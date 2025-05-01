import java.util.*;

class Process {

int id;

boolean active;

Process(int id) {

this.id = id;

this.active = true;

}

}

public class RingElection {

static Process[] processes;

static int n;

static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {

System.out.print("Enter number of processes: ");

n = sc.nextInt();

processes = new Process[n]; for (int i = 0; i < n; i++) {

System.out.print("Enter ID for process " + (i + 1) + ": "); processes[i] = new Process(sc.nextInt());

}

System.out.println("Assuming last process is initially down.");

processes[n-1].active = false;

while (true) {

System.out.println("\n1. Start Election\n2. Activate Process\n3. Exit");

int ch = sc.nextInt();

switch (ch) {

case 1:

startElection();

break;

case 2:

System.out.print("Enter ID to activate: ");

int id = sc.nextInt();

activateProcess(id);

break;

case 3:

return;

}

}

}

static void startElection() {

System.out.print("Enter initiator ID: ");

int initiatorld = sc.nextInt();

int initiatorIndex = getIndexById(initiatorld);

if (initiatorIndex == -1 || !processes[initiatorIndex].active) {

System.out.println("Invalid initiator.");

return;

}

List<Integer> electionIds = new ArrayList<>();

int index = initiatorIndex;

do {

if (processes[index].active)

electionIds.add(processes[index].id);

index = (index + 1) % n;

} while (index != initiatorIndex);

int leader = Collections.max(electionIds);

System.out.println("Election complete. New Coordinator is: " + leader);

}

static void activateProcess(int id) {

int idx = getIndexById(id);

if (idx != -1) {

processes[idx].active = true;

System.out.println("Process " + id + " activated.");

} else {

System.out.println("Invalid process ID.");

}

}

static int getIndexById(int id) {

for (int i = 0; i < n; i++) {

if (processes[i].id == id)

return i;

}

return -1;

}

}