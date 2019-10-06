package blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain myBC = new Blockchain();

        for(int j=0; j<5; j++) {
            myBC.appendBlock();
        }

        System.out.println(myBC);

        //System.out.println("Is the blockchain valid? ");
        //System.out.println(myBC.checkChain());
    }
}
