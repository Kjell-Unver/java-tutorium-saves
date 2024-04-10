package Ueb08;

import java.util.Scanner;

import static Ueb08.Data.*;
import static Ueb08.Election.orderFirstPassThePost;
import static Ueb08.Election.orderInstantRunoff;

/**
 * Kommunikation mit dem Benutzer zur Untersuchung unterschiedlicher Wahlen.
 */
public class Ueb08 {
    private static Scanner scanner;

    /**
     * Der Benutzer wird wiederholt nach Eingabe einer ID für die zu
     * untersuchende Wahl gefragt und die Ergebnisse dieser Wahl werden auf
     * stdout ausgegeben.
     *
     * @param args Nicht genutzt.
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            int electionId = chooseElection();
            if (electionId == -1) break;

            int[][] resultFirstPassThePost = orderFirstPassThePost(getVotes(electionId));
            System.out.println("Ergebnis nach Mehrheitswahlrecht:");
            printElectionResults(resultFirstPassThePost);

            int[][] resultInstantRunoff = orderInstantRunoff(getVotes(electionId));
            System.out.println("Ergebnis nach Rangfolgewahl:");
            printElectionResults(resultInstantRunoff);
        }
        scanner.close();
    }

    public static int chooseElection() {
        while (true) {
            System.out.printf("Die Daten von %s Wahlen sind vorhanden.\n", getNumberOfElections());
            System.out.printf("Geben Sie die Nummer einer Wahl (0 - %s) ein oder -1 zum Beenden.\n", getNumberOfElections() - 1);

            int electionId = scanner.nextInt();
            if (electionId == -1 || isValidElectionId(electionId)) {
                return electionId;
            }
        }
    }

    public static void printElectionResults(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%2s) %-13s : %s\n", i + 1, getCandidateNameById(result[i][0]), result[i][1]);
        }
    }
}
