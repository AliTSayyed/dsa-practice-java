package UtdDsa.HashTables;

/*
 * Creating a hash table that will take an excerpt one word at a time and line by line.
 * Hash the string word and add it to the table as a hash node (chaining method for collisions)
 * After table is created loop through each element in the has table and traverse the linked lists if there
 * Link all the hash nodes in alphabetical order and print their freq and what line numbers they were found on
 * Line numbers are stored in a linked list and traversed as well
 */

// Node that will store the linked list of line numbers
class ListNode {
    ListNode next;
    int number;

    public ListNode(int lineNumber) {
        number = lineNumber;
    }
}

// Node to store in each element of the hash table array
class HashNode {
    HashNode next;
    String word;
    int freq;
    ListNode lines;
    HashNode nextOrdered;

    public HashNode(String word, int lineNumber) {
        this.word = word;
        freq = 1;
        this.lines = new ListNode(lineNumber);
    }

}

// custom hash table class that will store inserted words as hash nodes (uses
// linked list for collisions)
public class CustomHashTable {
    HashNode[] hashTable;
    int tableSize;
    HashNode orderedHead;

    // currently no resizing implemented, using hard prime value of 47
    public CustomHashTable() {
        hashTable = new HashNode[47];
        tableSize = 47;
    }

    /*
     * each word will be hashed and entered into the array
     * the word will be a property of the 'HashNode' object that is inserted into
     * the array
     * if there is a collision then add it to the .next property of the current node
     * (traverse the linked list)
     * if the word is the same, then increment the freq and add the line number (if
     * its a new line)
     */
    public void insert(String word, int lineNumber) {
        int index = Math.abs(word.hashCode()) % tableSize;

        if (hashTable[index] == null) {
            hashTable[index] = new HashNode(word, lineNumber);
        } else {
            HashNode current = hashTable[index];
            while (current.next != null) {
                if (current.word.equals(word)) {
                    handleSameWord(current, lineNumber);
                    return;
                }
                current = current.next;
            }
            // must check the node we exit the loop on to see if it equals the an existing
            // word.
            if (current.word.equals(word)) {
                handleSameWord(current, lineNumber);
            } else {
                current.next = new HashNode(word, lineNumber);
            }
        }
    }

    /*
     * function that handles if a same word is inserted into the hash table
     */
    private void handleSameWord(HashNode current, int lineNumber) {
        current.freq++;
        ListNode currentLineNumber = current.lines;
        while (currentLineNumber.next != null) {
            currentLineNumber = currentLineNumber.next;
        }
        if (currentLineNumber.number != lineNumber) {
            currentLineNumber.next = new ListNode(lineNumber);
        }
    }

    /*
     * function to create the alphabetically ordered linked list from the hash map
     */
    private void createOrderedList() {
        orderedHead = null;
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != null) {
                HashNode current = hashTable[i];
                while (current != null) {
                    insertOrdered(current);
                    current = current.next;
                }
            }
        }
    }

    /*
     * function to create a insert linked list with the nodes in alphabetical order
     */
    private void insertOrdered(HashNode nodeToInsert) {
        if (orderedHead == null || nodeToInsert.word.compareTo(orderedHead.word) < 0) {
            nodeToInsert.nextOrdered = orderedHead;
            orderedHead = nodeToInsert;
            return;
        }

        HashNode currentOrdered = orderedHead;
        while (currentOrdered.nextOrdered != null && nodeToInsert.word.compareTo(currentOrdered.nextOrdered.word) > 0) {
            currentOrdered = currentOrdered.nextOrdered;
        }

        nodeToInsert.nextOrdered = currentOrdered.nextOrdered;
        currentOrdered.nextOrdered = nodeToInsert;
    }

    public void print() {
        createOrderedList();
        HashNode current = orderedHead;
        while (current != null) {
            printData(current);
            current = current.nextOrdered;
        }
    }

    private void printData(HashNode current) {
        System.out.print(
                "Word: " + current.word + ", " + "Frequency: " + current.freq + ", Found on Lines: ");
        ListNode currentLines = current.lines;
        while (currentLines != null) {
            System.out.print(currentLines.number + " ");
            currentLines = currentLines.next;
        }
        System.out.println();
    }
}
