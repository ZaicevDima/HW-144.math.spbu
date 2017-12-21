#pragma once

struct Node;
struct AVLTree;

AVLTree* createAVLTree();

void add(AVLTree* tree, int value);
void remove(AVLTree* tree, int value);
bool isBelong(AVLTree* tree, int value);

bool isEmpty(AVLTree* tree);
void deleteAVLTree(AVLTree *&tree);
void printAVLTree(AVLTree* tree);
void printRight(AVLTree* tree);
void printLeft(AVLTree* tree);
