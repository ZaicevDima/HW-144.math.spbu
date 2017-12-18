#include <iostream>

using namespace std;

char getSign(double num)
{
    char *bin = (char*)(&num);

    int signMask = 0b10000000;
    bool negative = false;

    if (bin[7] & signMask)
        negative = true;

    return negative ? '-' : '+';
}

void printExponential(double num)
{
    char sign = getSign(num);
    double mantissa = getMantissa(num);
    int exponent = getExponent(num);

    cout << sign << mantissa << " * 2 ^ " << exponent << endl;
}

int main()
{
    cout.precision(20);

    double num = 0;
    cout << "Enter number: ";
    cin >> num;

    cout << "Exponential form: ";
    printExponential(num);
    cout << endl;

    return 0;
}
