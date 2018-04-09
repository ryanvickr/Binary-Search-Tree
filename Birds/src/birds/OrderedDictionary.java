/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

/**
 *
 * @author Ryan Vickramasinghe
 */
public class OrderedDictionary implements OrderedDictionaryADT {
    
    private Node root;
    private int size;
    
    //default constructor
    public OrderedDictionary(){
        this.root = null;
        size = 0;
    }
    
    /* Returns the Record object with key k, or It throws a DictionaryException
       says: "There is no record matches the given key", if such a record
       is not in the dictionary. 

       @param k
       @return BirdRecord
       @throws DictionaryException
     */
    public BirdRecord find(DataKey k) throws DictionaryException {
        Node currentRecord = root;
        
        while(currentRecord != null) {
            if(currentRecord.getData().getDataKey().compareTo(k) == 0)
                return currentRecord.getData();
            else if(currentRecord.getData().getDataKey().compareTo(k) == 1)
                currentRecord = currentRecord.getLeft();
            else
                currentRecord = currentRecord.getRight();
        }
        
        throw new DictionaryException("There is no record matching the given key!");
    }
    
    /* Inserts r into the ordered dictionary. It throws a DictionaryException 
       if a record with the same key as r is already in the dictionary.  

       @param r
       @throws DictionaryException
     */
    public void insert(BirdRecord r) throws DictionaryException {
        Node newRecord = new Node(r);
        
        //first check if tree is empty:
        if(root == null) {
            root = newRecord;
            return;
        }
        
        Node currentRecord = root;
        Node parentRecord = null;
        
        while(true) {
            parentRecord = currentRecord;
            
            //check if 'r' is less than current
            if((r.getDataKey().compareTo(currentRecord.getData().getDataKey())) == -1) {
                currentRecord = currentRecord.getLeft();
                //insert in left if left is empty
                if(currentRecord == null) {
                    currentRecord = newRecord;
                    return;
                }
            } else {
                currentRecord = currentRecord.getRight();
                //check in right if right is empty;
                if(currentRecord == null) {
                    currentRecord = newRecord;
                    return;
                }
            }
        }
    }
    
    /*  Removes the record with Key k from the dictionary. It throws a 
        DictionaryException says: "No such record key exists", if the record
        is not in the dictionary. 
             
       @param k
       @throws DictionaryException
     */
    public void remove(DataKey k) throws DictionaryException {
        Node parentRecord = root;
        Node currentRecord = root;
        boolean isLeftChild = false;
        
        while((currentRecord.getData().getDataKey().compareTo(k)) != 0) {
            parentRecord = currentRecord;
            
            if((k.compareTo(currentRecord.getData().getDataKey())) == -1) {
                isLeftChild = true;
                currentRecord = currentRecord.getLeft();
            } else {
                isLeftChild = false;
                currentRecord = currentRecord.getRight();
            }
            
            //throw error if we get to a leaf without finding a match:
            if(currentRecord == null)
                throw new DictionaryException("No such record key exists!");
        }
        
        //Case1: Node found, has no children
        Node nullNode = new Node(null);
        if(currentRecord.getLeft() == null && currentRecord.getRight() == null) {
            if((currentRecord.getData().getDataKey().compareTo(root.getData().getDataKey())) == 0)
                root = null;
            if(isLeftChild) {
                parentRecord.setLeft(null);
            } else {
                parentRecord.setRight(null);
            }
        }
        
        //Case2: Node found, has only one child
        else if(currentRecord.getRight() == null) {
            if((currentRecord.getData().getDataKey().compareTo(root.getData().getDataKey())) == 0)
                root = null;
            if(isLeftChild) {
                parentRecord.setLeft(null);
            } else {
                parentRecord.setRight(null);
            }
        }
        else if(currentRecord.getLeft() == null) {
            if((currentRecord.getData().getDataKey().compareTo(root.getData().getDataKey())) == 0)
                root = null;
            if(isLeftChild) {
                parentRecord.setLeft(null);
            } else {
                parentRecord.setRight(null);
            }
        }else if(currentRecord.getLeft() != null && currentRecord.getRight() != null) {
            
        }
    }
    
    /* Returns the successor of k (the record from the ordered dictionary 
       with smallest key larger than k); It throws a DictionaryException says:
       "There is no successor for the given record key", if the given key has 
       no successor. The given key DOES NOT need to be in the dictionary. 
         
       @param k
       @return BirdRecord
       @throws DictionaryException
     */
    public BirdRecord successor(DataKey k) throws DictionaryException {
        try{
            find(k);
        } catch(DictionaryException ex){
            throw new DictionaryException("There is no successor for the given + "
                                            + "record key.");
        }
        BirdRecord temp = new BirdRecord();
        return temp;
    }
    
    /* Returns the predecessor of k (the record from the ordered dictionary 
       with largest key smaller than k; It throws a DictionaryException says:
       "There is no predecessor for the given record key", if the given key has 
       no predecessor. The given key DOES NOT need to be in the dictionary.  
     
       @param k
       @return BirdRecord
       @throws DictionaryException
     */
    public BirdRecord predecessor(DataKey k) throws DictionaryException {
         BirdRecord temp = null;
        return temp;
    }
    
    /* Returns the record with smallest key in the ordered dictionary. 
       It throws a DictionaryException says:"Dictionary is empty", if the 
       dictionary is empty.   

       @return BirdRecord
       @throws DictionaryException
     */
    public BirdRecord smallest() throws DictionaryException {
         BirdRecord temp = null;
        return temp;
    }
    
    /* Returns the record with largest key in the ordered dictionary. 
       It throws a DictionaryException says:"Dictionary is empty", if the 
       dictionary is empty.  
       @return BirdRecord
       @throws DictionaryException
     */
    public BirdRecord largest() throws DictionaryException {
         BirdRecord temp = null;
        return temp;
    }
    
    /* Returns true if the dictionary is empty, and true otherwise. 

       @return boolean
     */
    public boolean isEmpty() {
        return (root == null);
    }
}
