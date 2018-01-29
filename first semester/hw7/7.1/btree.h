#pragma once

struct BinaryTree;

BinaryTree* createBinaryTree();

void addToHashTable(BinaryTree* tree, int value);
void remove(BinaryTree* tree, int value);
bool isBelong(BinaryTree* tree, int value);
bool isEmptyString(BinaryTree* tree);
void deleteBinaryTree(BinaryTree *&tree);
void printTree(BinaryTree* tree);
void printLeft(BinaryTree* tree);
void printRight(BinaryTree* tree);
