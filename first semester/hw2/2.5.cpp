#include <iostream>
using namespace std;

void siftUp(int newElement, int* p, int pSize)
{
    p[pSize - 1] = newElement;
    int parent = (pSize - 2) / 2;
    int numberNewElement = pSize - 1;

    while ((numberNewElement > 0) && (p[parent] < p[numberNewElement]))
    {
        swap(p[parent], p[numberNewElement]);
        numberNewElement = parent;
        parent = (numberNewElement - 1) / 2;
    }
}

void childSwap(int* p, int a, int b, int num, int marker)
{
    if (p[a] >= p[b])
    {
        swap(p[num], p[a]);
        num = a;
    }
    marker++;
}

void siftDown(int* p, int pSize)
{
    int number = 0;
    while (true)
    {
        int child = (2 * number) + 1;
        if ((child < pSize) && ((child + 1) < pSize))
        {
            if (p[number] >= max(p[child], p[child + 1]))
                break;
            int marker = 0;
            childSwap(p, child, child + 1, number, marker);
            if (marker != 0)
                continue;
            childSwap(p, child + 1, child, number, marker);
            continue;
        }
        if (child < pSize)
        {
            if (p[number] >= p[child])
                break;
            else
            {
                swap(p[number], p[child]);
                number = child;
                continue;
            }
        }
        break;
    }
}

void heapSort(int* p, int n)
{
    for (int i = n; i > 0; i--){
        swap(p[0], p[i - 1]);
        siftDown(p, i - 1);
    }
}

int main()
{
    int n = 0;
    cout << "enter length arrays \n";
    cin >> n;
    int const k = 1000;
    int p[k] = {0};
    cout << "enter array \n";
    for (int i = 0; i < n; i++)
    {
        int x = 0;
        cin >> x;
        siftUp(x, p, i + 1);
    }
    heapSort(p, n);
    cout <<"sort array: \n";
    for (int i = 0; i < n; i++)
        cout << p[i] << ' ';
}
