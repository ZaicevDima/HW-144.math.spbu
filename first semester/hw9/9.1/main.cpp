#include <iostream>
#include <fstream>

using namespace std;

const int inf = 1000000;

void printWay(int* previous, int index)
{
    cout << index + 1 << ' ';
    while (previous[index] != -1)
    {
        cout << previous[index] + 1 << ' ';
        index = previous[index];
    }
}

void deixtra(int **adjacencyMatrix, int amountCities)
{
    int* previous = new int[amountCities];
    int* distance = new int[amountCities];
    fill(distance, distance + amountCities, inf);
    distance[0] = 0;
    bool* used = new bool[amountCities];
    fill (used, used + amountCities, false);

    int currentIndex = 0;
    previous[currentIndex] = -1;
    while (!used[currentIndex])
    {
         used[currentIndex] = true;
         cout << currentIndex + 1 << " ";
         for (int i = 0; i < amountCities; i++)
         {
             if (!used[i] && adjacencyMatrix[currentIndex][i] && (distance[currentIndex] + adjacencyMatrix[currentIndex][i] < distance[i]))
             {
                 previous[i] = currentIndex;
                 distance[i] = distance[currentIndex] + adjacencyMatrix[currentIndex][i];
             }
         }

         int minDistation = inf;
         for (int i = 0; i < amountCities; i++)
         {
             if (!used[i] && distance[i] < minDistation)
             {
                 minDistation = distance[i];
                 currentIndex = i;
             }
         }
     }

     cout << "\nInformation about cities: \n";
     for (int i = 0; i < amountCities; i++)
     {
        if (used[i])
        {
            cout <<"City: " << i + 1 << " distance = " << distance[i] <<" way to first city: ";
            printWay(previous, i);
            cout << "\n";
        }
     }

    delete[] previous;
    delete[] distance;
    delete[] used;
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
    int amountCities = 0;
    int amountRoads = 0;
    fin >> amountCities >> amountRoads;
    int **adjacencyMatrix = new int*[amountCities];
    for (int i = 0; i < amountCities; i++)
        adjacencyMatrix[i] = new int[amountCities];

    for (int i = 0; i < amountCities; i++)
        for (int j = 0; j < amountCities; j++)
            adjacencyMatrix[i][j] = inf;

    for (int k = 0; k < amountRoads; k++)
    {
        int i, j, len;
        fin >> i >> j >> len;
        i--;
        j--;
        adjacencyMatrix[i][j] = len;
        adjacencyMatrix[j][i] = len;
    }
    cout << "occupied cities: \n";
    deixtra(adjacencyMatrix, amountCities);

    for (int i = 0; i < amountCities; i++)
        delete[] adjacencyMatrix[i];
    delete[] adjacencyMatrix;
    return 0;
}
