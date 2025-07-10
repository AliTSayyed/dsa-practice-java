package UtdDsa.concordance;
// take in one line at a time (lines are a linked list)

// regexp the line to get rid of digits and anything not a letter, ' "" - 
// create bst tree
// print alphabetical order of all words, their frequency, and what lines they appear on
// linked lists should be 1-2-3... not 1-1-1-.. if they appear on the same line 

class listNode {
    int num;
    listNode next;

    public listNode(int num) {
        this.num = num;
    }
}

class treeNode {
    String word;
    treeNode left;
    treeNode right;
    listNode lines;
    int frequency;

    public treeNode(String word, int lineNumber) {
        this.word = word;
        frequency++;
    }
}

// create the binary search tree with recursion and comparing strings
public class concordence {

    // create a method to insert a word and its line number
    // compare the word from the root node, if the word les less go left, if it is
    // greater go right
    // use recursion to travel down the tree and return the root
    // if the word is equal to the word we just increment the frequency and check if
    // we need to add a new line number

    // create a method to print the nodes in order
    // print the word, its frequency, and the line numbers it showed on
}
