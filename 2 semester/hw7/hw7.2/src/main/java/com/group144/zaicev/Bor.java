package com.group144.zaicev;

import java.io.*;

/**
 * Class for working with bor
 */
class Bor implements Serializable {
    private int ALPHABET_SIZE = 26;
    private Node root = new Node();
    private int size = 0;

    /**
     * Method, which checks whether the bor contains the element
     *
     * @param element - element, which you want to check
     * @return true, if the bor contains the element, else false
     */
    boolean contains(String element) {
        return root.nodeIsContains(element, 0);
    }

    /**
     * Method, which adds the element, if bor doesn't contain an element
     *
     * @param element - element, which you want to add
     * @return true, if bor added an element, else false
     * @throws IncorrectSymbolException - if your word contains incorrect symbols
     */
    boolean add(String element) throws IncorrectSymbolException {
        if (contains(element)) {
            return false;
        }
        size++;
        root.addNode(element, 0);
        return true;
    }

    /**
     * Method, which removes the element, if bor contains an element
     *
     * @param element element, which you want to remove
     * @return true, if bor removed an element, else false
     */
    boolean remove(String element) {
        if (!contains(element)) {
            return false;
        }
        size--;
        return root.removeNode(element, 0);
    }

    /**
     * Method, which returns the size of your bor
     */
    int size() {
        return size;
    }

    /**
     * Method, which returns the amount of words starting with this prefix
     *
     * @param prefix - prefix, with which the words begin
     */
    int howManyStartWithPrefix(String prefix) {
        return root.getAmountStartFromPrefix(prefix, 0);
    }

    /**
     * Method, which writes an object to a stream to save it
     *
     * @param out - output stream
     * @throws IOException - if I / O operations are failed or interrupted
     */
    void serialize(OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(this);
    }

    /**
     * Method, which replaces the old tree with data from the stream
     *
     * @param in - input stream
     * @throws IOException            if I / O operations are failed or interrupted
     * @throws ClassNotFoundException if file .class isn't in the classpath
     */
    void deserialize(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Bor bor = (Bor) objectInputStream.readObject();
        root = bor.root;
        size = bor.size;
    }

    /**
     * Class for working with node of bor
     */
    class Node implements Serializable {
        Node[] next = new Node[ALPHABET_SIZE];
        boolean isTerminal = false;
        int amountStartFromPrefix = 0;

        /**
         * Method, which adds the element with the current index in the bor
         *
         * @param element      element, which you add
         * @param currentIndex current index of your element
         * @throws IncorrectSymbolException - if your element contains an incorrect symbols
         */
        void addNode(String element, int currentIndex) throws IncorrectSymbolException {
            if (currentIndex == element.length()) {
                isTerminal = true;
                amountStartFromPrefix++;
                return;
            }
            if (isIncorrectSymbol(element.charAt(currentIndex))) {
                throw new IncorrectSymbolException("symbol is incorrect");
            }
            if (next[element.charAt(currentIndex) - 'a'] == null) {
                next[element.charAt(currentIndex) - 'a'] = new Node();
            }
            amountStartFromPrefix++;

            next[element.charAt(currentIndex) - 'a'].addNode(element, currentIndex + 1);
        }

        /**
         * Method, which checks whether the bor contains the element
         *
         * @param element      element, which you check
         * @param currentIndex current index of your element
         * @return true, if element contains, else false
         */
        boolean nodeIsContains(String element, int currentIndex) {
            if (currentIndex == element.length()) {
                return isTerminal;
            }

            return (next[element.charAt(currentIndex) - 'a'] != null)
                    && (next[element.charAt(currentIndex) - 'a'].nodeIsContains(element, currentIndex + 1));
        }

        /**
         * Method, which removes the element
         *
         * @param element      element, which you want to remove
         * @param currentIndex current index of your element
         * @return true, if bor removed an element, else false
         */
        boolean removeNode(String element, int currentIndex) {
            if (currentIndex == element.length()) {
                isTerminal = false;
                next = new Node[ALPHABET_SIZE];
                amountStartFromPrefix--;
                return true;
            }

            boolean isRemoved = next[element.charAt(currentIndex) - 'a'].removeNode(element, currentIndex + 1);
            if (isRemoved) {
                amountStartFromPrefix--;
            }
            return isRemoved;
        }

        /**
         * Method, which returns the amount of words starting with this prefix
         *
         * @param prefix       your prefix
         * @param currentIndex current index of your element
         */
        int getAmountStartFromPrefix(String prefix, int currentIndex) {
            if (currentIndex == prefix.length()) {
                return amountStartFromPrefix;
            }
            if (next[prefix.charAt(currentIndex) - 'a'] == null) {
                return 0;
            }
            return next[prefix.charAt(currentIndex) - 'a'].getAmountStartFromPrefix(prefix, currentIndex + 1);
        }

        /**
         * Method, which checks whether a symbol is incorrect
         *
         * @param symbol symbol, which you want to check
         * @return true, if symbol is incorrect, else false
         */
        private boolean isIncorrectSymbol(char symbol) {
            return (symbol < 'a') || (symbol > 'z');
        }
    }
}
