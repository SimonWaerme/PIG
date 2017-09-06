import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 * The Pig game
 * See http://en.wikipedia.org/wiki/Pig_%28dice_game%29
 *
 * For a similar game program see week1/samples/FuncDecompLCR
 */
public class Pig {

    public static void main(String[] args) {
        new Pig().program();
    }

    // The only allowed instance variables (i.e. declared outside any method)
    // Accessible from any method
    final Scanner sc = new Scanner(in);
    final Rand  om rand = new Random();

    void program() {
        //test();                 // <-------------- Uncomment run to tests!
        int winPts = 20;          // Points to win
        Player[] players;         // The players (array of Player objects)
        boolean aborted = false;  // Game aborted by player
        int playerNumber = 0;

        welcomeMsg(winPts);

        players = getPlayers();
        statusMsg(players);

        /*Player actual = players[0];
        actual = next(players, actual);*/

        // TODO Write game here!

        out.println(players[0].name + "'s turn");

        while (true) {
            out.println("Type r, n or q: ");
            String command = sc.nextLine();
            int dice = diceRoll();
            if (command.equals("r")) {

                if (dice != 1) {
                    players[playerNumber].roundPts = players[playerNumber].roundPts + dice;
                    players[playerNumber].totalPts += dice;
                    out.println("You rolled " + dice + ", your round score is " + players[playerNumber].roundPts + " and your total score is " + players[playerNumber].totalPts);

                } else {
                    players[playerNumber].roundPts = 0;
                    continue;
                    }

                }
                //ACTUAL = nextPlayer(playerNumber, players);


                if (command.equals("n")) {
                players[0].roundPts = 0;
                players[playerNumber].totalPts += players[playerNumber].roundPts;
                //byt player
                continue;

                }

                if (command.equals("q")) {
                break;

            }

        }




        // gameOverMsg
    }

    // ---- Game logic methods --------------

    // TODO Add methods

    int nextPlayer(int playerNumber, Player[] players) {
        if (playerNumber < players.length - 1) {
            playerNumber++;
        }
        else {
            playerNumber = 0;
        }
        return playerNumber;
    }

    // ---- IO methods ------------------

    void welcomeMsg(int winPoints) {
        out.println("Welcome to PIG!");
        out.println("First player to get " + winPoints + " points will win!" );
        out.println("Commands are: r = roll , n = next, q = quit");
        out.println();
    }

    void statusMsg(Player[] players) {
        out.print("Points: ");
        for (int i = 0 ; i < players.length ; i++) {
            out.print(players[i].name + " = " + players[i].totalPts + " ");
        }
        out.println();
    }

    Player[] getPlayers() {
        out.print("How many players? > ");
        int nPlayers = sc.nextInt();
        sc.nextLine();  // Read away \n
        Player[] players = new Player[nPlayers];

        // TODO add input
        for (int i = 0; i < players.length; i++) {
            out.println("Name of player " + (i + 1) + ": ");
            players[i] = new Player();
            players[i].name = sc.nextLine();
            players[i].roundPts = 0;
            players[i].totalPts = 0;

        }

        return players;
    }

    int diceRoll() {
        return rand.nextInt(6) + 1;
    }

    // ---------- Class -------------
    // A class makes it possible to keep all data for a Player in one place
    // Use the class to create (instantiate) Player objects
    class Player {
        String name;
        int totalPts;    // Total points for all rounds, default 0
        int roundPts;    // Points for a single round, default 0
    }

    // ----- Testing -----------------
    void test() {
        for(int i = 0; i < 20; i++) {
            out.print(diceRoll());
        }
    // This is hard coded test data
    // An array of (no name) Players (probably don't need any name to test)
        Player[] players = {new Player(), new Player(), new Player()};

        // TODO Add your tests here

        exit(0);   // End program
    }
}



