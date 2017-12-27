#include <iostream>
#include <fstream>
#include "expressiontree.h"

using namespace std;

int main()
{
    ifstream fin;
    fin.open("in.txt");

    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }

    ExpressionTree* expression = createExpressionTree();
    scanfTree(expression, fin);
    cout << "Infix form: ";
    printExpression(expression);
    cout << " Result: " << result(expression) << "\n";

    deleteExpressionTree(expression);
    fin.close();

    return 0;
}
