#include <iostream>
#include <fstream>

using namespace std;

void bfs(int** adjacencyMatrix, int amount, bool* isUsed, int current)
{
    if (isUsed[current])
        return;

    isUsed[current] = true;
    cout << current << ' ';
    for (int i = 0; i < amount; i++)
    {
        if (adjacencyMatrix[current][i] && !isUsed[i])
        {
            bfs(adjacencyMatrix, amount, isUsed, i);
        }
    }
}

void fill(bool* isUsed, int size, int value)
{
    for (int i = 0; i < size; i++)
        isUsed[i] = value;
}

int main()
{
    ifstream fin;
    fin.open("in.txt");
    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }

    int amount = 0;
    fin >> amount;
    int **adjacencyMatrix = new int*[amount];
    for (int i = 0; i < amount; i++)
        adjacencyMatrix[i] = new int;

    for (int i = 0; i < amount; i++)
        for (int j = 0; j < amount; j++)
            fin >> adjacencyMatrix[i][j];

    bool* isUsed = new bool[amount];
    fill(isUsed, amount, 0);

    cout << "vertices of the graph: \n";
    for (int i = 0; i < amount; i++)
    {
        if (!isUsed[i])
        {
            bfs(adjacencyMatrix, amount, isUsed, i);
        }
    }

    for (int i = 0; i < amount; i++)
        delete[] adjacencyMatrix[i];
    delete[] isUsed;
    delete[] adjacencyMatrix;
    fin.close();
    return 0;
}
