#pragma once

int heuristic(int x1, int y1, int x2, int y2);
void findMin(int &x, int &y, int **heuristics, int **currents, int **used, int n, int m);
void aStar(int **matrix, int **used, int **distance, int **parent, int **heuristics, int **currents, int n, int m, int xStart, int yStart, int xFinish, int yFinish);



