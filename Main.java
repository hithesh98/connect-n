public class Main {
    // default setting for n
    private static int n = 4;


    public static void main(String[] args){
        if(args.length>0) {
            checkCommandLineArgN(args[0]);
        }
        new MyConnectN();
    }

    private static void checkCommandLineArgN(String argN){
        Display display = new Display();
        try {
            int number = Integer.parseInt(argN);
            if (number > 1 && number < 8) {
                Main.n = number;
            } else {
                display.printArgumentNotValid();
                System.exit(0);
            }
        } catch (NumberFormatException e){
            display.printArgumentNotValid();
            System.exit(0);
        }
    }

    static int getN() {
        return n;
    }
}
