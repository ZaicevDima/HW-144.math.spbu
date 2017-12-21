#include <iostream>
#include <fstream>
#include "expressiontree.h"

using namespace std;

int main()
{
    ifstream inputFile;
    inputFile.open("in.txt");

    if (!inputFile.good())
    {
        cout << "error, file not opened";
        return 1;
    }

    ExpressionTree* expression = createExpressionTree();
    scanfTree(expression, inputFile);
    cout << "Infix form: ";
    printExpression(expression);
    cout << "Result: " << result(expression) << "\n";

    deleteExpressionTree(expression);
    inputFile.close();

    return 0;
}
