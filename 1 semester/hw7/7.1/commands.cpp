#include "commands.h"
#include "btree.h"

struct Tree
{
    BinaryTree* tree;
};

Tree* createTree()
{
    Tree* newTree = new Tree;
    newTree->tree = createBinaryTree();
    return newTree;
}

void addValue(Tree* currentTree, int value)
{
    addToHashTable(currentTree->tree, value);
}

void popValue(Tree* currentTree, int value)
{
    remove(currentTree->tree, value);
}

bool isBelong(Tree* currentTree, int value)
{
    return isBelong(currentTree->tree, value);
}

void deleteTree(Tree* currentTree)
{
    deleteBinaryTree(currentTree->tree);
    delete currentTree;
}

void printLeft(Tree* currentTree)
{
    printLeft(currentTree->tree);
}

void printRight(Tree* currentTree)
{
    printRight(currentTree->tree);
}

void printTree(Tree* currentTree)
{
    printTree(currentTree->tree);
}


