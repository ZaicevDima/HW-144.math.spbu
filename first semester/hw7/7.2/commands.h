#pragma once

struct Tree;

Tree* createTree();
void deleteTree(Tree* currentTree);
void addValue(Tree* currentTree, int value);
void popValue(Tree* currentTree, int value);
bool isBelong(Tree* currentTree, int value);

void printLeft(Tree* currentTree);
void printRight(Tree* currentTree);
void printTree(Tree* currentTree);
