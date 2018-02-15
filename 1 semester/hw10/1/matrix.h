#pragma once
#include <iostream>
#include <fstream>

const int inf = 1000000;

int **fillMatrix(int n, int m, int fill);
void scanfMatrix(int **matrix, int n, int m, std::ifstream &fin);
void deleteMatrix(int **matrix, int n);
bool inside(int x, int y, int n, int m);
void setParent(int **parent, int xParent, int yParent, int xChild, int yChild);
int getParent(int **parent, int &x, int &y);
bool isEqual(int x1, int y1, int x2, int y2);





