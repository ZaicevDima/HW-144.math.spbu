#include "commands.h"
#include "avl.h"

struct Tree
{
    AVLTree* tree;
};

Tree* createTree()
{
    Tree* newTree = new Tree;
    newTree->tree = createAVLTree();
    return newTree;
}

void addValue(Tree* currentTree, int value)
{
    add(currentTree->tree, value);
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
    deleteAVLTree(currentTree->tree);
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
    printAVLTree(currentTree->tree);
}
