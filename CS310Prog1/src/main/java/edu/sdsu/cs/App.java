package edu.sdsu.cs;
import edu.sdsu.cs.datastructures.ArrayPriQueue;
import edu.sdsu.cs.datastructures.HeapPriQueue;
import edu.sdsu.cs.datastructures.UnorderedPriQueue;
import java.io.IOException;
import java.lang.Math;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Code written by Thomas Martinson (cssc0208) and Blake Meyers (cssc0226)
 */
public class App
{
    private static int[] randomArray;
    private static int[] ascendingArray;
    private static int[] descendingArray;
    private static long enqueueEndN;
    private static long enqueueStartN;
    private static long enqueueEnd2N;
    private static long enqueueStart2N;
    private static long enqueueEnd4N;
    private static long enqueueStart4N;
    private static long pollEndN;
    private static long pollStartN;
    private static long pollEnd2N;
    private static long pollStart2N;
    private static long pollEnd4N;
    private static long pollStart4N;
    private static String testResultsFileData = "";
    private static String classToTest = "";

    public static void main( String[] args ) {


        /**Test Array Initialization */
        randomArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            randomArray[i] = (int) (Math.random() * 1000) + 1;
        }

        /**Ascending Array Initialization */
        ascendingArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            ascendingArray[i] = i;
        }

        /**Descending Array Initialization*/
        descendingArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            descendingArray[i] = 1000000 - i;
        }

        /**TEST CALLS*/
        tester(randomArray,"Random Array");
        tester(ascendingArray, "Ascending Array");
        tester(descendingArray, "Descending Array");

        /**Display File Contents*/
        Path target = Paths.get("./output.txt");
        displayFileContents(target);
    }

    private static void tester(int[] testArray, String arrayName)
    {
        /**HEAPPRIQUEUE TESTS **********************************************************************************/
        /**HeapPriQueue test size N, enqueue() method ----------------------------------------------------------*/
        HeapPriQueue heapTestQueue = new HeapPriQueue();
        enqueueStartN = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            heapTestQueue.enqueue(testArray[i]);
        }
        enqueueEndN = System.nanoTime();

        /**HeapPriQueue test size N, poll() method ----------------------------------------------------------*/
        pollStartN = System.nanoTime();
        heapTestQueue.poll();
        pollEndN = System.nanoTime();
        heapTestQueue.clear();


        /**HeapPriQueue test size 2N, enqueue() method ----------------------------------------------------------*/
        enqueueStart2N = System.nanoTime();
        for (int i = 0; i < 40000; i++) {
            heapTestQueue.enqueue(testArray[i]);
        }
        enqueueEnd2N = System.nanoTime();

        /**HeapPriQueue test size 2N, poll() method ----------------------------------------------------------*/
        pollStart2N = System.nanoTime();
        heapTestQueue.poll();
        pollEnd2N = System.nanoTime();
        heapTestQueue.clear();


        /**HeapPriQueue test size 4N, enqueue() method ----------------------------------------------------------*/
        enqueueStart4N = System.nanoTime();
        for (int i = 0; i < 80000; i++) {
            heapTestQueue.enqueue(testArray[i]);
        }
        enqueueEnd4N = System.nanoTime();

        /**HeapPriQueue test size 4N, poll() method ----------------------------------------------------------*/
        pollStart4N = System.nanoTime();
        heapTestQueue.poll();
        pollEnd4N = System.nanoTime();
        heapTestQueue.clear();

        /**HeapPriQueue results */
        classToTest = "HeapPriQueue";
        testResultsToFile(classToTest, arrayName);

        /**ARRAYPRIQUEUE TESTS **********************************************************************************/
        /**ArrayPriQueue test size N, enqueue() method ----------------------------------------------------------*/
        ArrayPriQueue arrayTestQueue = new ArrayPriQueue();
        enqueueStartN = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            arrayTestQueue.enqueue(testArray[i]);
        }
        enqueueEndN = System.nanoTime();

        /**ArrayPriQueue test size N, poll() method ----------------------------------------------------------*/
        pollStartN = System.nanoTime();
        arrayTestQueue.poll();
        pollEndN = System.nanoTime();
        arrayTestQueue.clear();

        /**ArrayPriQueue test size 2N, enqueue() method ----------------------------------------------------------*/
        enqueueStart2N = System.nanoTime();
        for (int i = 0; i < 40000; i++) {
            arrayTestQueue.enqueue(testArray[i]);
        }
        enqueueEnd2N = System.nanoTime();

        /**ArrayPriQueue test size 2N, poll() method ----------------------------------------------------------*/
        pollStart2N = System.nanoTime();
        arrayTestQueue.poll();
        pollEnd2N = System.nanoTime();
        arrayTestQueue.clear();

        /**ArrayPriQueue test size 4N, enqueue() method ----------------------------------------------------------*/
        enqueueStart4N = System.nanoTime();
        for (int i = 0; i < 80000; i++) {
            arrayTestQueue.enqueue(testArray[i]);
        }
        enqueueEnd4N = System.nanoTime();

        /**ArrayPriQueue test size 4N, poll() method ----------------------------------------------------------*/
        pollStart4N = System.nanoTime();
        arrayTestQueue.poll();
        pollEnd4N = System.nanoTime();
        arrayTestQueue.clear();

        /**ArrayPriQueue results */
        classToTest = "ArrayPriQueue";
        testResultsToFile(classToTest, arrayName);

        /**UNORDEREDPRIQUEUE TESTS **********************************************************************************/
        /**UnorderedPriQueue test size N, enqueue() method ----------------------------------------------------------*/
        UnorderedPriQueue unorderedTestQueue = new UnorderedPriQueue();
        enqueueStartN = System.nanoTime();
        for (int i = 0; i < 20000; i++) {
            unorderedTestQueue.enqueue(testArray[i]);
        }
        enqueueEndN = System.nanoTime();
        /**UnorderedPriQueue test size N, poll() method ----------------------------------------------------------*/
        pollStartN = System.nanoTime();
        unorderedTestQueue.poll();
        pollEndN = System.nanoTime();
        unorderedTestQueue.clear();

        /**UnorderedPriQueue test size 2N, enqueue() method ----------------------------------------------------------*/
        enqueueStart2N = System.nanoTime();
        for (int i = 0; i < 40000; i++) {
            unorderedTestQueue.enqueue(testArray[i]);
        }
        enqueueEnd2N = System.nanoTime();

        /**UnorderedPriQueue test size 2N, poll() method ----------------------------------------------------------*/
        pollStart2N = System.nanoTime();
        unorderedTestQueue.poll();
        pollEnd2N = System.nanoTime();
        unorderedTestQueue.clear();

        /**UnorderedPriQueue test size 4N, enqueue() method ----------------------------------------------------------*/
        enqueueStart4N = System.nanoTime();
        for (int i = 0; i < 80000; i++) {
            unorderedTestQueue.enqueue(testArray[i]);
        }
        enqueueEnd4N = System.nanoTime();

        /**UnorderedPriQueue test size 4N, poll() method ----------------------------------------------------------*/
        pollStart4N = System.nanoTime();
        unorderedTestQueue.poll();
        pollEnd4N = System.nanoTime();
        unorderedTestQueue.clear();

        /**UnorderedPriQueue results*/
        classToTest = "UnorderedPriQueue";
        testResultsToFile(classToTest, arrayName);


    }
    /**Output Results To A File*/

    private static void testResultsToFile(String className, String arrayName){
        Path dest = Paths.get("./output.txt");
        testResultsFileData += "Testing " + className + " with " + arrayName + ":\n"+className + " enqueue() call, input size N takes "+(double)(enqueueEndN-enqueueStartN) +" nanoseconds" +
                "\n" + className + " enqueue() call, input size 2N takes "+(double)(enqueueEnd2N-enqueueStart2N) +" nanoseconds" +
                "\n" + className + "  enqueue() call, input size 4N takes "+(double)(enqueueEnd4N-enqueueStart4N) +" nanoseconds" +
                "\n" + className + "  poll() call, input size N takes "+(double)(pollEndN-pollStartN) +" nanoseconds" +
                "\n" + className + "  poll() call, input size 2N takes "+(double)(pollEnd2N-pollStart2N) +" nanoseconds" +
                "\n" + className + "  poll() call, input size 4N takes "+(double)(pollEnd4N-pollStart4N) +" nanoseconds\n\n";
        try{
            Files.write(dest, testResultsFileData.getBytes());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void displayFileContents(Path target) {
        try{
            List<String> fileContents;
            fileContents =  Files.readAllLines(target,Charset.defaultCharset());

            for( String curLine : fileContents){
                System.out.println(curLine);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}