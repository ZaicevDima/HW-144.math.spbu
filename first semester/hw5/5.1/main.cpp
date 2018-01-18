#include <iostream>
using namespace std;

char sign(double number)
{
    unsigned char *bin = reinterpret_cast<unsigned char*> (&number);
    if (bin[7] & 0b10000000)
        return '-';
    return '+';
}

double mantissa(double number)
{
    unsigned char *bin = reinterpret_cast<unsigned char*> (&number);
    bin[7] = 0b00111111;
    bin[6] = bin[6] | 0b11110000;
    return number;
}

int exponent(double number)
{
    unsigned char *bin = reinterpret_cast<unsigned char*> (&number);
    int power = 0 | (bin[7] & 0b01111111);
    power = power << 4;
    power = power | ((bin[6] & 0b11110000) >> 4);
    power = power - ((1 << 10) - 1);

    return power;
}

void printNumber(double number)
{
    unsigned char* bin = reinterpret_cast<unsigned char*> (&number);

    bool isZero = true;
    for (int i = 0; i < 8; i++)
        if (bin[i] != 0)
            isZero = false;

    cout << "result: ";
    if (isZero == true)
    {
        cout << "0.0";
        return;
    }
    cout << sign(number) << mantissa(number) << "*2^" << exponent(number);
}

int main()
{
    double number = 0.0;
    cout << "Enter a number: ";
    cin >> number;
    cout.precision(20);
    printNumber(number);
    return 0;
}
