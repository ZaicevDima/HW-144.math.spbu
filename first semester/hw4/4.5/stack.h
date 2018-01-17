#pragma once
#include <iostream>

typedef int TypeElement;

struct Stack;

Stack* createStack();
bool isEmptyString(Stack* stack);
void push(Stack* stack, TypeElement value);
TypeElement pop(Stack* stack);
TypeElement top(Stack* stack);
void deleteStack(Stack* stack);
