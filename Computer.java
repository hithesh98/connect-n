import java.util.Random;

public class Computer extends Participant{
    private char player;

    Computer(char player){
        this.player = player;

    }

    @Override
    public void placeCounter(int position) {
        this.setPlaced(false);
        for(int row = Board.board.length-1; row>=0; row--){
            if(!isPlaced() && (Board.board[row][position-1] != 'r' && Board.board[row][position-1] != 'y' && Board.board[row][position-1] != 'g')){
                Board.board[row][position-1] = player;
                this.setPlaced(true);
                break;
            }
        }
    }

     int randomColumn(){
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

     char getPlayer() {
        return player;
    }
}
