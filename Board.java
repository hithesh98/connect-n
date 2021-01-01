class Board {
    static char[][] board = new char[6][7];

    Board(){


    }

    void checkIfWon(char player){
        checkHorizontal(player);
        checkVertical(player);
        checkDiagonal(player);

    }

    private void checkHorizontal(char player){
        int count = 0;
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                if(board[row][col] == player){
                    count = count + 1;
                    if(count >= Main.getN()){
                        MyConnectN.setWin(true);
                        MyConnectN.setWinner(player);
                    }
                }
                else{
                    count = 0;
                }
            }
            count = 0;
        }
    }

    private void checkVertical(char player){
        int count = 0;
        for(int col=0; col<board[0].length; col++){
            for(int row=0; row<board.length; row++){
                if(board[row][col] == player){
                    count = count + 1;
                    if(count >= Main.getN()){
                        MyConnectN.setWin(true);
                        MyConnectN.setWinner(player);
                    }
                }
                else{
                    count = 0;
                }
            }
        count = 0;
        }
    }

    private void checkDiagonal(char player) {
        int count = 0;
        for (int row = board.length-1; row >= 0; row--) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == player) {
                    count = count + 1;
                    try {
                        //  Check for Diagonal going up left to right
                        for (int i = 1; i < Main.getN(); i++) {
                            if (board[row - i][col + i] == player) {
                                count = count + 1;
                            } else {
                                count = 0;
                                break;
                            }
                            if (count >= Main.getN()) {
                                MyConnectN.setWin(true);
                                MyConnectN.setWinner(player);
                            }
                        }

                    } catch (ArrayIndexOutOfBoundsException e){
                            // Do nothing
                    }
                    try {
                        //  Check for Diagonal going down left to right
                        count = 1;
                        for (int i = 1; i < Main.getN(); i++) {
                            if (board[row + i][col + i] == player) {
                                count = count + 1;
                            } else {
                                count = 0;
                                break;
                            }
                            if (count >= Main.getN()) {
                                MyConnectN.setWin(true);
                                MyConnectN.setWinner(player);
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        // Do Nothing
                    }
                }
                count = 0;
            }
        }
    }

    boolean isTie() {
        boolean isTie = true;
        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == 'r' || board[0][col] == 'y' || board[0][col] == 'g'){
            } else{
                isTie = false;
                break;
            }
        }
        return isTie;
    }
}
