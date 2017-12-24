#include <iostream>
#include "cyclelist.h"

using namespace std;

int main()
{
    cout << "enter amount warriors and murder period: \n";
    int n = 0;
    int m = 0;
    cin >> n >> m;

    CycleList* warriors = createCycle();
    addFirst(0, warriors);
    CycleListElement* current = firstElement(warriors);
    for (int i = 1; i < n; i++)
    {
        insert(i, current, warriors);
        current = next(current);
    }

    current = firstElement(warriors);
    int amountNow = size(warriors);
    while (amountNow > 1)
    {
        current = moveNext(current, m);
        CycleListElement* previousWarrior = previous(current);
        remove(current, warriors);
        current = previousWarrior;
        amountNow--;
    }
    cout << "The last warrior is ";
    printCycle(warriors);

    deleteCycle(warriors);
    return 0;
}
