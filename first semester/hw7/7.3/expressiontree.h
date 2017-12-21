#pragma once
#include <fstream>
using namespace std;

struct ExpressionTree;

ExpressionTree* createExpressionTree();
void deleteExpressionTree(ExpressionTree *&tree);
void scanfTree(ExpressionTree* tree, fstream &file);
int result(ExpressionTree* tree);
void printExpression(ExpressionTree* tree);
