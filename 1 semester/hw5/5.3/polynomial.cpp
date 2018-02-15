#include <iostream>
#include <cmath>
#include "polynmial.h"

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
    bool wasFirstNotZeroCoefficient = false;
    for (int i = 0; i < degree + 1; i++)
    {
        if (coefficients[i] != 0)
        {
            if (wasFirstNotZeroCoefficient)
            {
                lengthSimbols[i] = 2 + amountNumeral(abs(coefficients[i]));
                if (abs(coefficients[i]) != 1)
                    lengthSimbols[i]++;
            }
            else
            {
                lengthSimbols[i] = amountNumeral(abs(coefficients[i]));
                if (coefficients[i] < 0)
                    lengthSimbols[i]++;
                if (abs(coefficients[i]) != 1)
                    lengthSimbols[i]++;
                wasFirstNotZeroCoefficient = true;
            }
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
        if ((lengthSimbols[i] > 0) && (degree - i > 1))
            cout << degree - i;
        else if ((degree - i == 1) || (degree - i == 0))
            cout << ' ';
    }
    delete[] lengthSimbols;
}

void printSign(int number)
{
    if (number < 0)
        cout << "- ";
    else
        cout << "+ ";
    cout << abs(number);
}

void printSpaceBetweenCoefficient(int degree, int i)
{
    if (degree - i != 0)
    {
        for (int j = 0; j < amountNumeral(degree - i); j++)
            cout <<' ';
    }
}

void printFirstNotZeroCoefficient(int coefficient)
{
    if (coefficient < 0)
        cout <<"-";
    if (abs(coefficient) == 1)
        cout << "x";
    else
        cout << abs(coefficient) << "x";
}

void printtNotZeroCoefficient(int coefficient)
{
    if (abs(coefficient) > 1)
    {
        printSign(coefficient);
        cout << "x";
    }
    else if (coefficient == 1)
        cout << "+ x";
    else
        cout << "- x";
}

void printCoefficientOfZerotDegree(bool wasFirstNotZeroCoefficient,int coefficient)
{
    if ((wasFirstNotZeroCoefficient) && (coefficient != 0))
        printSign(coefficient);
    else if (!wasFirstNotZeroCoefficient)
        cout << coefficient;
}

void printCoefficients(int degree, int *coefficients)
{
    if (degree == 0)
        cout << coefficients[0];
    else
    {
        bool wasFirstNotZeroCoefficient = false;
        for (int i = 0; i < degree + 1; i++)
        {
            if ((coefficients[i] != 0) && (degree - i > 0))
            {
                if (!wasFirstNotZeroCoefficient)
                {
                    printFirstNotZeroCoefficient(coefficients[i]);
                    wasFirstNotZeroCoefficient = true;
                }
                else
                {
                    printtNotZeroCoefficient(coefficients[i]);
                }
                printSpaceBetweenCoefficient(degree, i);
            }
            else if (degree - i == 0)
            {
                printCoefficientOfZerotDegree(wasFirstNotZeroCoefficient, coefficients[i]);
            }
        }
    }
}
