import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Get input
        Scanner scanner = new Scanner(System.in);
        int numberOfExistingRestaurant = scanner.nextInt();
        scanner.nextLine();


        // Build MinHeap
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(numberOfExistingRestaurant);


        // Insert restaurants to heap
        String temp = null;
        String[] tempArr = null;

        for (int i = 0; i < numberOfExistingRestaurant; i++) {
            Restaurant tempRestaurant = new Restaurant(null, 0);
            temp = scanner.nextLine();
            tempArr = temp.split(" ");
            tempRestaurant.setRestaurantName(tempArr[0]);
            tempRestaurant.setRestaurantDistance(Integer.parseInt(tempArr[1]));
            minHeap.insert(tempRestaurant);
        }

        // testing heap
//        minHeap.print();
//        System.out.println("The Min val is " + minHeap.remove().getRestaurantName());


        // Get number of Queries
        int numberOfQueries = scanner.nextInt();
        scanner.nextLine();


        // Store them in an arraylist
        ArrayList<Query> queryArrayList = new ArrayList<>(numberOfQueries);
        temp = null;
        tempArr = null;
        for (int i = 0; i < numberOfQueries; i++) {
            Query tempQuery = new Query(0, null);
            temp = scanner.nextLine();
            tempArr = temp.split(" ");
            tempQuery.setFirstNQueries(Integer.parseInt(tempArr[0]));
            tempQuery.setPrefix(tempArr[1]);
            queryArrayList.add(tempQuery);
        }

        // testing our query array list
//        System.out.println("=======================");
//        for (int i = 0; i < numberOfQueries; i++) {
//            System.out.println(queryArrayList.get(i).getFirstNQueries() + " "
//                    + queryArrayList.get(i).getPrefix());
//        }
//
//        System.out.println("=======================");


        // ========== Main Part ==========
        Stack stack = new Stack(numberOfExistingRestaurant);
        Trie trie = new Trie();

        for (int i = 0; i < numberOfQueries; i++) {
            // if items in our trie tree is less than what we need,
            // we should add it from our heap.
            if (stack.getSize() < queryArrayList.get(i).getFirstNQueries()) {
                int stackSize = stack.getSize();
                for (int j = 0; j < queryArrayList.get(i).getFirstNQueries() - stackSize; j++) {
                        Restaurant thisRestaurant = minHeap.remove();
                        stack.push(thisRestaurant);
                        trie.insert(thisRestaurant.getRestaurantName());
                }
            // if items in our trie tree is more than what we need,
            // we should delete them, and return them to the heap.
            } else {
                int stackSize = stack.getSize();
                for (int j = 0;
                     j < stackSize - queryArrayList.get(i).getFirstNQueries(); j++) {
                        Restaurant thisRestaurant = stack.pop();
                        trie.removeTrie(Trie.trieroot, thisRestaurant.getRestaurantName(), 0);
                        minHeap.insert(thisRestaurant);
                }
            }
            // After maintaining trie tree, now it's time to print
            // the name of the restaurant if the restaurant prefix
            // name exist in the trie tree. So, we go through the
            // tree for search.
            Trie.searchTrie(queryArrayList.get(i).getPrefix());
        }

    }
}