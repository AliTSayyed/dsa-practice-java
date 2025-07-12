package UtdDsa.concordance;
// take in one line at a time (lines are a linked list)

// regexp the line to get rid of digits and anything not a letter, ' "" - 
// create bst tree
// print alphabetical order of all words, their frequency, and what lines they appear on
// linked lists should be 1-2-3... not 1-1-1-.. if they appear on the same line 

// Node that stores the line number
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

    // when we come across a new word we create a new treeNode
    // tree node will contian the word, have an initial frequency of 1, and store
    // the line number it was found on.
    public treeNode(String word, int lineNumber) {
        this.word = word;
        frequency = 1;
        lines = new listNode(lineNumber);
    }

}

// create the binary search tree with recursion and comparing strings
public class Concordance {
    // Store the root of the tree
    treeNode root;

    // create a method to insert a word and its line number
    // compare the word from the root node, if the word is less go left, if it is
    // greater go right and if it is the same word, we increment the frequency, and
    // make lines.next = new listNode(lineNumber) IF the line number is not the same
    // as the current line (i.e 1-2-3 not 1-1-2)
    // use recursion to travel down the tree and return the root
    public void insert(String word, int lineNumber) {
        root = insertRec(root, word, lineNumber);
    }

    private treeNode insertRec(treeNode root, String word, int lineNumber) {
        if (root == null) {
            root = new treeNode(word, lineNumber);
        } else {
            int comparison = word.compareTo(root.word);
            if (comparison < 0) {
                root.left = insertRec(root.left, word, lineNumber);
            } else if (comparison > 0) {
                root.right = insertRec(root.right, word, lineNumber);
            } else if (comparison == 0) {
                root.frequency++;
                // traverse the linked list, if the line number is not there, then add the new
                // listNode lineNumber
                // use a current node for traversing
                listNode current = root.lines;
                while (true) {
                    if (current.num == lineNumber) {
                        break;
                    } else if (current.next == null) {
                        current.next = new listNode(lineNumber);
                        break;
                    } else {
                        current = current.next;
                    }
                }
            }
        }
        return root;
    }

    // create a method to print the nodes in order
    // print the word, its frequency, and the line numbers it showed on
    public void printTree() {
        inOrderPrintRec(root);
    }

    private void inOrderPrintRec(treeNode root) {
        if (root != null) {
            inOrderPrintRec(root.left);
            System.out.print("Word: " + root.word + ", " + "Frequency: " + root.frequency + ", Found on Lines: ");
            printLineNumbers(root.lines);
            System.out.println();
            inOrderPrintRec(root.right);
        }
    }

    private void printLineNumbers(listNode lines) {
        listNode current = lines;
        while (current != null) {
            System.out.print(current.num + " ");
            current = current.next;
        }
    }

}
