package blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockChain = new ArrayList<>();

     void appendBlock() {
        int currentId = 0;
        String prevHash = "0";
        if(null == blockChain || blockChain.isEmpty() || blockChain.size()==0) {
            currentId = 1;
            prevHash = "0";
        }else{
            currentId = blockChain.size();
            prevHash = blockChain.get(currentId-1).getMyHash();
            currentId++;
        }
        long currTimeStamp = System.nanoTime();//new Date().getTime();
        //System.out.println(currTimeStamp);
        Block b = new Block(currentId, currTimeStamp, StringUtil.applySha256(currentId+""+currTimeStamp), prevHash);
        this.blockChain.add(b);
        //System.out.println(this.blockChain.size());
    }

     boolean checkChain() {

        int l = blockChain.size();
        boolean isABlockchain = true;
        for(int i=0; i<l; i++) {
            if(i==0) {
                if(blockChain.get(i).getMyPredecessorsHash()!="0") {
                    return false;
                }
            }else {
                isABlockchain = isABlockchain && blockChain.get(i-1).getMyHash().equals(blockChain.get(i).getMyPredecessorsHash());
                if(!isABlockchain) {
                    return false;
                }
            }
        }

        return isABlockchain;
    }

    public List<Block> getBlockchain() {
        return blockChain;
    }

    public void setBlockchain(List<Block> blockChain) {
        this.blockChain = blockChain;
    }


    @Override
    public String toString() {
        String outPut ="";
        for(Block b:blockChain) {
            outPut+=b.toString()+"\n";
        }
        return outPut;
    }

    public static void main(String[] args) {

        Blockchain myBC = new Blockchain();

        for(int j=0; j<10; j++) {
            myBC.appendBlock();
        }

        System.out.println(myBC);

        System.out.println("Is the blockchain valid? ");
        System.out.println(myBC.checkChain());

    }

}
