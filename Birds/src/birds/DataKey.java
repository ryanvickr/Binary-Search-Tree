package birds;

public class DataKey {
        static String DEFAULTNAME = "null";
        static int DEFAULTSIZE = 0;
        String birdName;
        int birdSize;
        
	// default constructor
	public DataKey() {
            birdName = DEFAULTNAME;
            birdSize = DEFAULTSIZE;
	}
        
	// other constructors
        public DataKey(String name, int size){
            birdName = name;
            birdSize = size;
        }

	/**
	 * Returns 0 if this DataKey is equal to k, returns -1 if this DataKey is smaller
	 * than k, and it returns 1 otherwise. 
	 */
	public int compareTo(DataKey k) {
           if(k.birdName == birdName && k.birdSize == birdSize) 
               return 0;
           else if(birdSize < k.birdSize) 
               return -1;
           else 
               return 1;
	}
}
