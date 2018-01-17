#include <iostream>
#include "astar.h"
#include "matrix.h"

int heuristic(int x1, int y1, int x2, int y2)
{
    return abs(x1 - x2) + abs(y1 - y2);
}

void findMin(int &x, int &y, int **heuristics, int **currents, int **used, int n, int m)
{
    int minValue = inf;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if ((minValue > heuristics[i][j]) && (!used[i][j] && currents[i][j]))
            {
                minValue = heuristics[i][j];
                x = i;
                y = j;
            }
        }
    }
}

void aStar(int **matrix, int **used, int **distance, int **parent, int **heuristics, int **currents, int n, int m, int xStart, int yStart, int xFinish, int yFinish)
{
    distance[xStart][yStart] = 0;
    heuristics[xStart][yStart] = distance[xStart][yStart] + heuristic(xStart, yStart, xFinish, yFinish);
    int xCurrent = xStart;
    int yCurrent = yStart;
    currents[xStart][yStart] = 1;
    for (int i = 0; i < n * m; i++)
    {
        findMin(xCurrent, yCurrent, heuristics, currents, used, n, m);

        if (isEqual(xCurrent, yCurrent, xFinish, yFinish))
        {
            used[xFinish][yFinish] = 1;
            break;
        }

        used[xCurrent][yCurrent] = 1;
        for (int dx = -1; dx <= 1; dx++)
        {
            for (int dy = -1; dy <= 1; dy++)
            {
                if ((dx * dx + dy * dy == 1) && (inside(xCurrent + dx, yCurrent + dy, n, m)))
                {
                    int nextX = xCurrent + dx;
                    int nextY = yCurrent + dy;
                    if ((!used[nextX][nextY]) && (matrix[nextX][nextY] == 0) && (distance[xCurrent][yCurrent] + 1 < distance[nextX][nextY]))
                    {
                        setParent(parent, xCurrent, yCurrent, nextX, nextY);
                        distance[nextX][nextY] = distance[xCurrent][yCurrent] + 1;
                        heuristics[nextX][nextY] = distance[nextX][nextY] + heuristic(nextX, nextY, xFinish, yFinish);
                        currents[nextX][nextY] = 1;
                    }
                }
            }
        }
    }

    if (!used[xFinish][yFinish])
    {
        std::cout << "No way";
        return;
    }

    matrix[xFinish][yFinish] = 1000;
    while (getParent(parent, xFinish, yFinish) != -1000)
    {
        matrix[xFinish][yFinish] = 1000;
    }
    matrix[xFinish][yFinish] = 1000;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (matrix[i][j] == 1000)
            {
                std::cout << '*';
            }
            else
            {
                std::cout << matrix[i][j];
            }
        }
        std::cout << '\n';
    }
}
