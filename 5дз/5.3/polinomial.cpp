#include <iostream>
#include <cmath>
#include "polinomial.h"

using namespace std;

int amountNumeral(int number)
{
    int amount = 0;
    while (number > 0)
    {
        number /= 10;
        amount++;
    }
    return amount;
}

void lengthSpace(int *lengthSimbols,int *coefficients, int degree)
{
    for (int i = 0; i < degree + 1; i++)
    {
        if (i == 0)
        {
            if (abs(coefficients[i]) > 1)
            {
                lengthSimbols[i] = amountNumeral(abs(coefficients[i]));
                if (coefficients[i] < 0)
                    lengthSimbols[i]++;
            }
            else if (coefficients[i] != 1)
                lengthSimbols[i] = 1;
            else
                lengthSimbols[i] = 0;
            lengthSimbols[i]++;
        }
        else if (coefficients[i] != 0)
        {
            lengthSimbols[i] = 3 + amountNumeral(abs(coefficients[i]));
            if (abs(coefficients[i]) != 1)
                lengthSimbols[i]++;
        }
        else
            lengthSimbols[i] = 0;
    }
}

void printDegrees(int degree, int *coefficients)
{
    int *lengthSimbols = new int[degree + 1];
    lengthSpace(lengthSimbols, coefficients, degree);
    for (int i = 0; i < degree + 1; i++)
    {
        for (int j = 0; j < lengthSimbols[i]; j++)
            cout << " ";
        if (lengthSimbols[i] > 0 && degree - i > 1)
            cout << degree - i;
        else if(degree - i == 1 || degree - i == 0)
            cout << ' ';
    }
    delete[] lengthSimbols;
}

void printSign(int number)
{
    if (number < 0)
        cout << " - ";
    else
        cout << " + ";
    cout << abs(number);
}

void printSpaceBetweenCoefficient(int degree, int i)
{
    if (degree - i != 1)
    {
        for (int j = 0; j < amountNumeral(degree - i); j++)
            cout <<' ';
    }
}

void printCoefficients(int degree, int *coefficients)
{
    if (degree == 0)
        cout << coefficients[0];
    else
    {
        for (int i = 0; i < degree + 1; i++)
        {
            if (i == 0)
            {
                if (abs(coefficients[i]) != 1)
                    cout << coefficients[i] << "x";
                else if (coefficients[i] == 1)
                    cout << "x";
                else
                    cout << "-x";
                printSpaceBetweenCoefficient(degree, i);
            }
            else if (coefficients[i] != 0 && degree - i > 0)
            {
                if (abs(coefficients[i]) > 1)
                {
                    printSign(coefficients[i]);
                    cout << "x";
                }
                else if (coefficients[i] == 1)
                    cout << " + x";
                else
                    cout << " - x";
                printSpaceBetweenCoefficient(degree, i);
            }
            else if (degree - i == 0 && coefficients[i] != 0)
                printSign(coefficients[i]);
        }
    }
}
