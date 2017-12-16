#pragma once
#include "stack.h"

bool isOperator(char k);
int prior (char k);
void conversionToPostfix(char* symbols, char* result, int amount, int &amountSpaces);
