package blockchain;

public class Block {
    private long id;
    private long timeStamp;
    private String myHash;
    private String myPredecessorsHash;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getMyHash() {
        return myHash;
    }
    public void setMyHash(String myHash) {
        this.myHash = myHash;
    }
    public String getMyPredecessorsHash() {
        return myPredecessorsHash;
    }
    public void setMyPredecessorsHash(String myPredecessorsHash) {
        this.myPredecessorsHash = myPredecessorsHash;
    }


    public Block() {
    }
    public Block(long id, long timeStamp) {
        super();
        this.id = id;
        this.timeStamp = timeStamp;
    }
    public Block(long id, long timeStamp, String myHash, String myPredecessorsHash) {
        this(id, timeStamp);
        this.myHash = myHash;
        this.myPredecessorsHash = myPredecessorsHash;
    }

    @Override
    public String toString() {
        return "Block:\nId: "+id+"\nTimestamp: "+timeStamp+"\nHash of the previous block:\n"+myPredecessorsHash+
                "\nHash of the block:\n"+myHash+"\n";
    }
}
