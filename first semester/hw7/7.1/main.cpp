#include <iostream>
#include "commands.h"
using namespace std;

void printMenu()
{
    cout << "Supported operation: \n";
    cout << "0 - Exit \n";
    cout << "1 - Add \n";
    cout << "2 - Pop \n";
    cout << "3 - Check \n";
    cout << "4 - Print \n";
    cout << "5 - Menu \n";
}

int main()
{
    Tree *currentTree = createTree();

    printMenu();

    enum operations {exit, add, pop, check, print, menu};
    enum print {treeForm, increasingOrder, decreasingOrder};

    int operations;
    cin >> operations;

    while (operations != 0)
    {
        int value = 0;
        switch (operations)
        {
        case add:
            cout << "Enter number to add: ";
            cin >> value;
            addValue(currentTree, value);
            break;

        case pop:
            cout << "Enter number to delete: ";
            cin >> value;
            popValue(currentTree, value);
            break;

        case check:
            cout << "Enter number to check: ";
            cin >> value;
            if (isBelong(currentTree, value))
                cout << value << " is in Tree \n";
            else
                cout << value << " is not in Tree \n";
            break;

        case print:
            cout << "print operarion: \n0 - Tree form \n1 - Increasing Order \n2 - Decreasing order \n";
            cin >> value;
            switch (value)
            {
            case treeForm:
                printTree(currentTree);
                break;
            case increasingOrder:
                printLeft(currentTree);
                break;
            case decreasingOrder:
                printRight(currentTree);
                break;
            default:
                cout << "Wrong operation";
                break;

            }
            cout << "\n";
            break;

        case menu:
            printMenu();
            break;

        default:
            cout << "Wrong operation" << endl;
            break;
        }
        cin >> operations;
    }

    deleteTree(currentTree);
    return 0;
}
