import java.util.Scanner;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number Of Nodes You Want In The Ring: ");
        int n = sc.nextInt();

        System.out.println("Ring Formed Is As Below: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            if (i != n - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" -> " + 0); // Closing the ring

        int token = 0;
        int choice;

        do {
            System.out.print("\nEnter Sender: ");
            int sender = sc.nextInt();

            System.out.print("Enter Receiver: ");
            int receiver = sc.nextInt();

            System.out.print("Enter Data To Send: ");
            int data = sc.nextInt();

            System.out.println("\nToken Passing:");
            for (int i = token; i != sender; i = (i + 1) % n) {
                System.out.print(i + " -> ");
            }
            System.out.println(sender);

            System.out.println("Sender " + sender + " is sending data: " + data);

            for (int i = sender; i != receiver; i = (i + 1) % n) {
                System.out.println("Data: " + data + " forwarded by: " + i);
            }

            System.out.println("Receiver " + receiver + " received the data: " + data);

            token = sender; // Update token position

            System.out.print("\nDo You Want To Send Data Again? If YES Enter 1, IF NO Enter 0: ");
            choice = sc.nextInt();

        } while (choice == 1);

        sc.close();
    }
}