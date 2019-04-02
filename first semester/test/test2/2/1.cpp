#include <iostream>
#include <fstream>
using namespace std;

int amountDigits(int number)
{
    int amount = 0;
    while (number > 0)
    {
        amount++;
        number /= 10;
    }
    return amount;
}

int reverse(int number)
{
    int newNumber = 0;
    while (number > 0)
    {
        newNumber = newNumber * 10 + number % 10;
        number /= 10;
    }
    return newNumber;
}

int main()
{
    ifstream fin;
    ofstream fout;
    fin.open("in.txt");
    fout.open("out.txt");

    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }

    while (!fin.eof())
    {
        int number;
        fin >> number;
        fout << reverse(number) << ' ';
    }

    fin.close();
    fout.close();
    return 0;
}
