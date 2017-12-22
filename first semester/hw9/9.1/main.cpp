#include <iostream>
#include <fstream>

using namespace std;

const int inf = 1000000;

int* deixtr(int **edge, int n)
{
    int *distance = new int[n];
    fill(distance, distance + n, inf);
    distance[0] = 0;
    bool used[n];
    fill (used, used + n, false);
    for (int i = 0; i < n; i++)
    {
        int minimum = inf;
        int minNumber = -1;
        for (int j = 0 ; j < n; j++)
        {
            if (!used[j] && (distance[j] < minimum))
            {
                minNumber = j;
                minimum = distance[j];
            }
        }
        used[minNumber] = true;
        for (int j = 0; j < n; j++)
            distance[j] = min(distance[j], distance[minNumber] + edge[minNumber][j]);
        cout << minNumber + 1 << ' ';
    }
    cout << "\n";
    return distance;
}

void printDistation(int* distance, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << "distance of " << i + 1 << " to 1 = ";
        if (distance[i] != inf)
            cout << distance[i] << '\n';
        else
            cout << "inf\n";
    }
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
    int n = 0;
    int m = 0;
    fin >> n >> m;
    int **a = new int*[n];
    for (int i = 0; i < n; i++)
        a[i] = new int[n];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            a[i][j] = inf;

    for (int k = 0; k < m; k++)
    {
        int i, j, len;
        fin >> i >> j >> len;
        i--;
        j--;
        a[i][j] = len;
        a[j][i] = len;
    }
    cout << "occupied cities: \n";
    printDistation(deixtr(a, n), n);
    return 0;
}
