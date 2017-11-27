#include <iostream>
#include <fstream>
using namespace std;

ifstream fin;

int amountNotEmpty(int amount)
{
    bool isEmpty = false;
    while (!fin.eof())
    {
        char c;
        c = fin.get();
        if (c != '\t' && c != ' ' && c != '\n' && !isEmpty)
            isEmpty = true;

        if (c == '\n' || fin.eof())
        {
            if (isEmpty)
                amount++;
            isEmpty = false;
        }
    }
    return amount;
}

int main()
{
    fin.open("text.txt");
    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }
    int counter = 0;
    cout << amountNotEmpty(counter) << '\n';
    fin.close();
    return 0;
}
