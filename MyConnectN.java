import java.util.Scanner;

class MyConnectN {
    private static boolean win = false;
    private Display display = new Display();
    private Board board = new Board();
    private Player player = new Player();
    private Scanner input = new Scanner(System.in);
    private static char winner;

    MyConnectN(){
        display.printWelcomeMessage();
        display.printBoard();
        playGame();

     }

    static void setWin(boolean trueOrFalse) {
        win = trueOrFalse;
    }

    private void playGame(){
        Computer computerOne = new Computer('y');
        Computer computerTwo = new Computer('g');
        while(!win){
            playerMove();
            if (board.isTie()){
                display.printTieGame();
                break;
            }
            if(!win) {
                computerMove(computerOne);
                if (board.isTie()) {
                    display.printTieGame();
                    break;
                }
            }
            if(!win) {
                
                computerMove(computerTwo);
                if (board.isTie()) {
                    display.printTieGame();
                    break;
                }
            }
        }
        if(win){
            display.printWin();
        }
    }

    private void playerMove(){
        boolean isCorrectInput;
        do{
            if(input.hasNextInt()){
                int move = input.nextInt();
                if(move>0 && move <8) {
                    player.placeCounter(move);
                    isCorrectInput = true;
                } else{
                    display.printNotValidInput();
                    isCorrectInput = false;
                }
            } else{
                display.printNotValidInput();
                isCorrectInput = false;
                input.next();
            }
        } while (!(isCorrectInput));
        while(player.columnFull()) {
            display.printColumnFull();
            int move = input.nextInt();
            player.placeCounter(move);
        }
        board.checkIfWon('r');
        display.printBoard();
    }

    private void computerMove(Computer computer){
        computer.placeCounter(computer.randomColumn());
        while(computer.columnFull()){
            computer.placeCounter(computer.randomColumn());
        }
        board.checkIfWon(computer.getPlayer());
        display.printBoard();
    }

    static void setWinner(char player) {

        winner = player;
    }

    static char getWinner() {
        return winner;
    }
}
