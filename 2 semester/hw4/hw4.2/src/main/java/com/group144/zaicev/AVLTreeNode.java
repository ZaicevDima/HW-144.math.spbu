package com.group144.zaicev;

/**
 * Class for working with AVL Tree node any Types
 *
 * @param <Type> Type, which you want to use
 */
class AVLTreeNode<Type extends Comparable<Type>> implements Comparable<AVLTreeNode<Type>> {
    private Type value;
    private AVLTreeNode<Type> left;
    private AVLTreeNode<Type> right;
    private AVLTreeNode<Type> parent;
    private int height;

    /**
     * Constructor AVL Tree node
     *
     * @param value  new node value
     * @param parent new node parent
     */
    AVLTreeNode(Type value, AVLTreeNode<Type> parent) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = parent;
        this.height = 1;
    }

    /**
     * Changes the height value
     *
     * @param newHeight new value of height
     */
    private void setHeight(int newHeight) {
        height = newHeight;
    }

    /**
     * Returns the node height
     */
    private int getHeight() {
        return height;
    }

    /**
     * Returns the node value
     */
    Type getValue() {
        return value;
    }

    /**
     * Changes the node value
     */
    private void setValue(Type newValue) {
        value = newValue;
    }

    /**
     * Returns the left node
     */
    AVLTreeNode<Type> getLeft() {
        return left;
    }

    /**
     * Changes the left node
     *
     * @param newLeftNode new left node
     */
    private void setLeft(AVLTreeNode<Type> newLeftNode) {
        left = newLeftNode;
    }

    /**
     * Returns the right node
     */
    AVLTreeNode<Type> getRight() {
        return right;
    }

    /**
     * Changes the right node
     *
     * @param newRightNode new right node
     */
    private void setRight(AVLTreeNode<Type> newRightNode) {
        right = newRightNode;
    }

    /**
     * Returns the node parent
     */
    AVLTreeNode<Type> getParent() {
        return parent;
    }

    private void setParent(AVLTreeNode<Type> newParent) {
        parent = newParent;
    }

    /**
     * Returns difference between right node height and left node height
     */
    private int balanceFactor() {
        int rightHeight = (getRight() == null) ? 0 : getRight().getHeight();
        int leftHeight = (getLeft() == null) ? 0 : getLeft().getHeight();
        return rightHeight - leftHeight;
    }

    /**
     * Changes right node height or left node height
     */
    private void updateHeight() {
        int heightLeft = getLeft() == null ? 0 : getHeight();
        int heightRight = getRight() == null ? 0 : getHeight();
        if (heightLeft > heightRight) {
            setHeight(heightLeft + 1);
        } else {
            setHeight(heightRight + 1);
        }
    }

    /**
     * Realize rotate right
     *
     * @param tree in which realised rotate
     */
    private void rotateRight(AVLTree<Type> tree) {
        AVLTreeNode<Type> pivot = getLeft();
        setLeft(pivot.getRight());
        if (pivot.getRight() != null) {
            pivot.getRight().setParent(this);
        }
        pivot.setRight(this);
        if (getParent() == null) {
            tree.setRoot(pivot);
        } else {
            if (equals(getParent().getLeft())) {
                parent.setLeft(pivot);
            } else {
                parent.setRight(pivot);
            }
        }
        pivot.setParent(parent);
        setParent(pivot);

        updateHeight();
        pivot.updateHeight();
    }

    /**
     * Realize rotate left
     *
     * @param tree in which realised rotate
     */
    private void rotateLeft(AVLTree<Type> tree) {
        AVLTreeNode<Type> pivot = getRight();
        setRight(pivot.getLeft());
        if (pivot.getLeft() != null) {
            pivot.getLeft().setParent(this);
        }
        pivot.setLeft(this);
        if (getParent() == null) {
            tree.setRoot(pivot);
        } else {
            if (equals(getParent().getLeft())) {
                parent.setLeft(pivot);
            } else {
                parent.setRight(pivot);
            }
        }
        pivot.setParent(parent);
        setParent(pivot);

        updateHeight();
        pivot.updateHeight();
    }

    /**
     * Realize balance
     *
     * @param tree in which realised balance
     */
    private void balance(AVLTree<Type> tree) {
        updateHeight();

        if (balanceFactor() == 2) {
            if (getRight().balanceFactor() < 0) {
                getRight().rotateRight(tree);
            }
            rotateLeft(tree);
        }

        if (balanceFactor() == -2) {
            if (getLeft().balanceFactor() > 0) {
                getLeft().rotateLeft(tree);
            }
            rotateRight(tree);
        }
    }

    /**
     * realize adding node
     *
     * @param value new value
     * @param tree  your avl tree
     */
    void addNode(Type value, AVLTree<Type> tree) {
        if (value.compareTo(getValue()) < 0) {
            if (getLeft() == null) {
                setLeft(new AVLTreeNode<>(value, this));
            } else {
                getLeft().addNode(value, tree);
            }
        } else if (value.compareTo(getValue()) > 0) {
            if (getRight() == null) {
                setRight(new AVLTreeNode<>(value, this));
            } else {
                getRight().addNode(value, tree);
            }
        }

        balance(tree);
    }

    /**
     * Checks if the tree contains this value
     *
     * @param value which you want to check
     * @param tree  your avl tree
     * @return true, if tree contains this value, else false
     */
    boolean isContainsNode(Type value, AVLTree<Type> tree) {
        AVLTreeNode<Type> temp = tree.getRoot();
        while (temp != null) {
            if (value.equals(temp.getValue())) {
                return true;
            } else if (value.compareTo(temp.getValue()) > 0) {
                temp = temp.getRight();
            } else if (value.compareTo(temp.getValue()) < 0) {
                temp = temp.getLeft();
            }
        }
        return false;
    }

    /**
     * Returns max value in this tree
     */
    private AVLTreeNode<Type> findMax() {
        AVLTreeNode<Type> temp = this;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    /**
     * Removes the node
     *
     * @param value which you want to remove
     * @param tree  your avl tree
     */
    void removeNode(Type value, AVLTree<Type> tree) {
        if (value.equals(getValue())) {
            if ((getRight() != null) && (getLeft() != null)) {
                AVLTreeNode<Type> maxNode = getLeft().findMax();
                removeNode(maxNode.getValue(), tree);
                setValue(maxNode.getValue());
            } else if (getRight() != null) {
                setValue(getRight().value);
                setRight(null);
            } else if (getLeft() != null) {
                setValue(getLeft().value);
                setLeft(null);
            } else {
                if (getParent() == null) {
                    tree.setRoot(null);
                } else {
                    if (equals(getParent().getLeft())) {
                        getParent().setLeft(null);
                    } else {
                        getParent().setRight(null);
                    }
                }
            }
        } else if (value.compareTo(getValue()) > 0) {
            getRight().removeNode(value, tree);
        } else {
            getLeft().removeNode(value, tree);
        }
    }

    /**
     * Compares the values
     *
     * @param node node, with which you want to compare
     * @return 0, if equals, < 0 if value < node value, > 0 else
     */
    @Override
    public int compareTo(AVLTreeNode<Type> node) {
        return value.compareTo(node.value);
    }

    /**
     * Converts the avl tree to string
     *
     * @return your avl tree to string
     */
    @Override
    public String toString() {
        String result = "( " + value.toString() + " ";
        if (getLeft() == null) {
            result += "null ";
        } else {
            result += getLeft().toString() + " ";
        }
        if (getRight() == null) {
            result += "null )";
        } else {
            result += getRight().toString() + ")";
        }
        return result;
    }
}