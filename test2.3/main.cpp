#include <iostream>
#include <vector>
#include <string.h>
#include <fstream>

using namespace std;
ofstream fout;

void output (vector<int> numbers)
{
    for (int i = 0; i < numbers.size(); i++)
        fout << numbers[i] << ' ';
}

int main()
{
    ifstream fin;
    fin.open("f.txt");
    fout.open("g.txt");
    if (!fin.good())
    {
        cout << "error, file not opened";
        return 1;
    }

    int numberA = 0;
    int numberB = 0;
    cout << "enter numbers A and B: \n";
    cin >> numberA >> numberB;
    vector<int> numbers;
    while(!fin.eof())
    {
        int number;
        fin >> number;
        numbers.push_back(number);
    }

    vector<int> firstString;
    vector<int> secondString;
    vector<int> thirdString;

    for (int i = 0; i < numbers.size(); i++)
    {
        if (numbers[i] < numberA)
            firstString.push_back(numbers[i]);
        else
        {
            if(numbers[i] > numberB)
                thirdString.push_back(numbers[i]);
            else
                secondString.push_back(numbers[i]);
        }
    }

    output(firstString);
    fout << "\n";
    output(secondString);
    fout << "\n";
    output(thirdString);

    numbers.clear();
    firstString.clear();
    secondString.clear();
    thirdString.clear();
    fin.close();
    fout.close();
}
