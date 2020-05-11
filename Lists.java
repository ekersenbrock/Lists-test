import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Iterator;

/**
 * Compare List, ArrayList, and LinkedList by storing identical information 
 * in each type of list, calling the same methods on each list, and tracking
 * the amount of time it take for each method to run.
 *
 * @author Erik K
 * @version 05/03/2020
 */
public class Lists
{
    // Each type of list to test
    // Condier making a seperate class for each type of list and an interface
    // or superclass that they all extend/implement from.
    private List<Integer> arrayList;
    private List<Integer> linkedList;
    
    // Random number generator to fill each list.
    private Random rando = new Random(1234);
    private final int MAX_RANDOM_INT = 1000;
    
    // Number of ints in list.
    private int listSize;

    /**
     * Constructor for objects of class Lists
     */
     public Lists(int listSize){
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        this.listSize = listSize;
    }
    
    public Lists(){
        this(1000);
    }
    
    /**
     * Returns current time in milliseconds.
     * @return The time in milliseconds.
     */
    private long time(){
        return System.currentTimeMillis(); 
    }
    
    /**
     * Test the add method for a List and prints the information.
     * @param testList The list to be tested.
     */
    private void testAdd(List<Integer> testList){
        long initialTime = time();
        for (int i = 0; i < listSize; i++){
            testList.add(rando.nextInt(MAX_RANDOM_INT));
        }
        long finalTime = time();
        long deltaT = finalTime - initialTime;
        System.out.println(testList.getClass() + " add time: " + deltaT +
        " milliseconds");
    }
    
    /**
     * Test all the add method for all list types and prints time for 
     * comparison.
     */
    public void testAddForLists(){
        testAdd(arrayList);
        testAdd(linkedList);
    }
    
    /**
     * Test the get method for each type of list.
     * @param testList The list to be tested.
     */
    private void testGet(List<Integer> testList){
        long initialTime = time();
        for (int i = 0; i < testList.size(); i++){
            if (i % 2 == 0){
                testList.get(i);
            }
        }
        long finalTime = time();
        long deltaT = finalTime - initialTime;
        System.out.println(testList.getClass() + " get time: " + deltaT +
        " milliseconds");
    }
    
    /**
     * Test all the add get method for all list types and prints time for 
     * comparison.
     */
    public void testGetForLists(){
        testGet(arrayList);
        testGet(linkedList);
    }
    
    /**
     * Test the remove method for each type of list.
     * @param testList The list to be tested.
     */
    private void testRemoveOdd(List<Integer> testList){
        long initialTime = time();
        // test the following pipeline against other looping type.
        // testList.stream().
            // filter(value -> value % 2 == 1);
        Iterator it = testList.iterator();
        while( it.hasNext()){
            int num = (int) it.next();
            if(num % 2 == 1){
                it.remove();
            }
        }
        long finalTime = time();
        long deltaT = finalTime - initialTime;
        System.out.println(testList.getClass() + " removal time: " + 
        deltaT + " milliseconds");
    }
    
    /**
     * Test all the remove method for all list types and prints time for 
     * comparison.
     */
    public void testRemoveOddForLists(){
        testRemoveOdd(arrayList);
        testRemoveOdd(linkedList);
    }
    
    public void print(){
        System.out.println("ArrayList: " + arrayList);
        System.out.println("linkedList: " + linkedList);
    }
    
    public void clearLists(){
        arrayList.clear();
        linkedList.clear();
    }
}
