#pragma once;
#include "stack.h"

bool isOperator(char k);
int prioritet (char k);
void conversionToPostfix(char* simbol, char* result, int amount, int &amountSpaces);
