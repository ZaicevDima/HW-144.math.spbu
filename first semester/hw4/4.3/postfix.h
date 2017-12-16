#pragma once
#include "stack.h"

bool isOperator(char k);
int priority(char k);
void conversionToPostfix(char* symbols, char* result, int amount, int &amountSpaces);
