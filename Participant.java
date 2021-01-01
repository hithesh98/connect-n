public abstract class Participant {

    private boolean placed = false;

    public abstract void placeCounter(int position);

     void setPlaced(boolean placed) {
        this.placed = placed;
    }

    boolean isPlaced() {
        return placed;
    }

    boolean columnFull(){
         return !placed;
    }
}
