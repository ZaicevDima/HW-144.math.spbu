#pragma once

struct BinaryTree;

BinaryTree* createBinaryTree();

void add(BinaryTree* tree, int value);
void remove(BinaryTree* tree, int value);
bool isBelong(BinaryTree* tree, int value);
bool isEmpty(BinaryTree* tree);
void deleteBinaryTree(BinaryTree *&tree);
void printTree(BinaryTree* tree);
void printLeft(BinaryTree* tree);
void printRight(BinaryTree* tree);

