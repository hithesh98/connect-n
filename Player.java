public class Player extends Participant {


    @Override
    public void placeCounter(int position) {
        this.setPlaced(false);
        for(int row = Board.board.length-1; row>=0; row--){
            if(!this.isPlaced() && (Board.board[row][position-1] != 'r' && Board.board[row][position-1] != 'y' && Board.board[row][position-1] != 'g')){
                Board.board[row][position-1] = 'r';
                this.setPlaced(true);
            }
        }
    }



}
