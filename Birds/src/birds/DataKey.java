package birds;

public class DataKey {
    
    private String birdName;
    private int birdSize;
    
    // default constructor
    public DataKey() {

    }

    // other constructors
    public DataKey(String name, int size){
        birdName = name;
        birdSize = size;
    }
    
    /**
     * Returns 0 if this DataKey is equal to k, returns -1 if input DataKey is larger
     * than k, and it returns 1 otherwise.
     * @param k 
     * @return 
     */
    public int compareTo(DataKey k) {
       if(k.birdName.equals(birdName) && k.birdSize == birdSize)
           return 0;
       else if(birdSize < k.birdSize) //****CHECK FOR PRECEDING
           return -1;
       else if(birdSize == k.birdSize && (birdName.compareTo(k.birdName) < 0))
           return -1;
       else
           return 1;
    }
    
    /**
     * sets the name of the bird
     * @param name this should be the name of the bird
     */
    public void setBirdName(String name){
        birdName = name;
    }
    
    /**
     * returns integer value of bird size (1,2, or 3)
     * @return returns integer value
     */
    public int getBirdSize(){
        return birdSize;
    }
    
    public String getBirdName() {
        return birdName;
    }
}
