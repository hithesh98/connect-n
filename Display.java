class Display {

    Display(){

    }

    void printWelcomeMessage(){
        System.out.println("Welcome to Connect 4\n" +
                            "There are 2 players red and yellow\n" +
                            "Player 1 is Red (You), Player 2 is Yellow (Computer)\n" +
                            "To play the game type in the number of the column you want to drop your counter in\n" +
                            "A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally\n");
    }

    void printBoard(){
        for(int row = 0; row<Board.board.length; row++){
            for(int col=0; col<Board.board[row].length; col++){
                if(Board.board[row][col] == 'r'){
                    System.out.print("| r ");
                } else if(Board.board[row][col] == 'y') {
                    System.out.print("| y ");
                } else if(Board.board[row][col] == 'g') {
                    System.out.print("| g ");
                } else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    void printColumnFull(){
        System.out.println("This column is full, try a different one");
    }

    void printTieGame(){
        System.out.println("Game is a Tie. No one Wins");
    }

    void printNotValidInput(){
        System.out.println("Input invalid. Enter a number between 1 and 7.");
    }

    void printArgumentNotValid(){
        System.out.println("Command line argument is not valid. Please enter a number between 2 and 7.");
    }

    void printWin(){
        System.out.print(MyConnectN.getWinner());
        System.out.print(" has won the game!");
    }
}
