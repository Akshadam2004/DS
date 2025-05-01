import java.util.Scanner;

public class BullyElection {

static int n;

static int[] process;

static boolean[] active;

static int coordinator;

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter number of processes: ");

n = sc.nextInt();

process = new int[n];

active = new boolean[n];

System.out.println("Enter process IDs:");

for (int i = 0; i < n; i++) {

process[i] = sc.nextInt();

active[i] = true;

}

coordinator = process[n - 1];

System.out.println("Initially, Coordinator is: " + coordinator);

while (true) {

System.out.println("\n1.Crash process\n2.Activate process\n3. Display coordinator\n4.Exit");

int ch = sc.nextInt();

switch (ch) {

case 1:

System.out.print("Enter process ID to crash: ");

int crashld = sc.nextInt();

crashProcess(crashld);

break;

case 2:

System.out.print("Enter process ID to activate: ");

int activateld = sc.nextInt();
activateProcess(activateld);

break;

case 3:

System.out.println("Current Coordinator: " + coordinator);

break;

case 4:

System.exit(0);

}
}
}

static void crashProcess(int id) {

for (int i = 0; i < n; i++) {

if (process[i] == id) {

active[i] = false;

System.out.println("Process " + id + " crashed.");

if (id == coordinator) {

System.out.println("Coordinator crashed! Hold election.");

holdElection();

}

return;

}

}

System.out.println("Process not found.");

}

static void activateProcess(int id) {

for (int i = 0; i < n; i++) {

if (process[i] == id) {

active[i] = true;

System.out.println("Process " + id + " activated.");

holdElection();

return;

} }

System.out.println("Process not found.");

}

static void holdElection() {

int newCoordinator = -1;

for (int i = n - 1; i >= 0; i--) {

if (active[i]) {

newCoordinator = process[i];

break;
}
}
coordinator = newCoordinator;
System.out.println("New Coordinator is: " + coordinator);
}
}