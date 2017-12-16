#pragma once
#include <iostream>

typedef char TypeElement;
struct Stack;

Stack* createStack();
bool isEmpty(Stack* stack);
void push( Stack* stack, TypeElement value);
TypeElement pop(Stack* stack);
TypeElement top(Stack* stack);
void deleteStack(Stack* stack);
