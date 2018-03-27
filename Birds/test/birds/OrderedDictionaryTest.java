/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abdelkader
 */
public class OrderedDictionaryTest {
    String[] birds = {"Bluejay", "Cardinal", "Eagle", "Falcon", "Merlin"};
    String descriptions[] = {"The blue jay (Cyanocitta cristata) is a passerine bird in the family Corvidae",
        "The Northern Cardinal is a fairly large, long-tailed songbird with a short",
        "Eagle is the common name for many large birds of prey of the family Accipitridae",
        "A diurnal bird of prey characterized by long, pointed wings and swift, powerful flight.",
        "A merlin is a large hawk that is also known as a pigeon hawk."
    };
    DataKey[] keys;
    BirdRecord[] records = new BirdRecord[5];

    public OrderedDictionaryTest() {
        keys = new DataKey[5];
        records = new BirdRecord[5];
        for (int i = 0; i < 3; ++i) {
            keys[i] = new DataKey(birds[i], 1);
            records[i] = new BirdRecord(keys[i], descriptions[i], "", "");
        }
        for (int i = 3; i < 5; ++i) {
            keys[i] = new DataKey(birds[i], 3);
            records[i] = new BirdRecord(keys[i], descriptions[i], "", "");
        }
    }

    @Test
    public void testFind() {
        System.out.println("find");
        OrderedDictionary instance = new OrderedDictionary();
        // Insert 5 words in the dictionary and test the Find method
        try {
            for (int i = 0; i < 5; ++i) {
                instance.insert(records[i]);
            }
        } catch (DictionaryException e) {
            fail("Fail Insertion test.");
        }
        BirdRecord record;
        try {
            String expResult = records[3].getAbout();
            record = instance.find(new DataKey("Falcon",3));
            String result = record.getAbout();
            assertEquals(expResult, result);
        } catch (DictionaryException ex) {
             fail("Fail find test.");
        }
        BirdRecord record2;
        try {
            record2 = instance.find(new DataKey("Empty",1));
            fail("Fail find test (fail to find a non-exist record).");
        } catch (DictionaryException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        OrderedDictionary instance = new OrderedDictionary();
        BirdRecord r = records[0];
        instance.insert(r);
        // Try to insert the same word again
        try {
            instance.insert(r);
        } catch (DictionaryException e) {
        }
    }

    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        OrderedDictionary instance = new OrderedDictionary();        
        DataKey k = keys[3];
        try {
            instance.remove(k);
        } catch (DictionaryException e) {

        }
        BirdRecord r = records[1];
        instance.insert(r);
        k = keys[1];
        try {
            instance.remove(k);
        } catch (DictionaryException e) {
            fail("Fail in removing existing record.");
        }
    }

    @Test
    public void testSuccessor() {
        System.out.println("successor");
        OrderedDictionary instance = new OrderedDictionary();
        // Insert 5 words in the dictionary and test the successor method
        try {
            for (int i = 0; i < 5; ++i) {
                instance.insert(records[i]);
            }
        } catch (DictionaryException e) {
            fail("Fail Insertion test.");
        }
           
        BirdRecord record;
        try {
            String expResult = records[2].getAbout();
            record = instance.successor(keys[1]);
            String result = record.getAbout();
            assertEquals(expResult, result);
        } catch (DictionaryException ex) {
            fail("Fail successor test.");
        }

        BirdRecord record2;
        try {
            String expResult2 = records[3].getAbout();
            record2 = instance.successor(new DataKey("Ew",1));
            String result2 = record2.getAbout();
            assertEquals(expResult2, result2);
        } catch (DictionaryException ex) {
            fail("Fail successor test. If the key doesn't exist.");
        }
    }

    @Test
    public void testPredecessor() {
        System.out.println("predecessor");
            OrderedDictionary instance = new OrderedDictionary();
        // Insert 5 words in the dictionary and test the predecessor method
        try {
            for (int i = 0; i < 5; ++i) {
                instance.insert(records[i]);
            }
        } catch (DictionaryException e) {
            fail("Fail Insertion test.");
        }
            
        BirdRecord record;
        try {
            String expResult = records[0].getAbout();
            record = instance.predecessor(keys[1]);
            String result = record.getAbout();
            assertEquals(expResult, result);
        } catch (DictionaryException ex) {
            fail("Fail Predecessor test.");
        }

        BirdRecord record2;
        try {
            String expResult2 = records[2].getAbout();
            record2 = instance.predecessor(new DataKey("Fa",3));
            String result2 = record2.getAbout();
            assertEquals(expResult2, result2);
        } catch (DictionaryException ex) {
            fail("Fail successor test. If the key doesn't exist.");
        }
    }

    @Test
    public void testSmallest() {
        System.out.println("smallest");
        OrderedDictionary instance = new OrderedDictionary();
        // Insert 5 words in the dictionary and test the smallest method
        try {
            for (int i = 0; i < 5; ++i) {
                instance.insert(records[i]);
            }
            String expResult = records[0].getAbout();
            BirdRecord record = instance.smallest();
            String result = record.getAbout();
            assertEquals(expResult, result);
        } catch (DictionaryException e) {
            fail("Fail Smallest/Insertion test.");
        }
    }

    @Test
    public void testLargest() {
        System.out.println("largest");
        OrderedDictionary instance = new OrderedDictionary();
        // Insert 5 words in the dictionary and test the largest method
        try {
            for (int i = 0; i < 5; ++i) {
                instance.insert(records[i]);
            }
            String expResult = records[4].getAbout();
            BirdRecord record = instance.largest();
            String result = record.getAbout();
            assertEquals(expResult, result);
        } catch (DictionaryException e) {
            fail("Fail Smallest/Insertion test.");
        }
    }
}
