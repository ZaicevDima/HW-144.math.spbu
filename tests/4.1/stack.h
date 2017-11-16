#pragma once

struct StackElement
{
    int value;
    StackElement* next;
};

struct Stack
{
    StackElement* head;
};

Stack* createStack();

void push(Stack* myStack, int value);
void pop(Stack* myStack);
int top(Stack* myStack);
bool isEmpty(Stack* myStack);
void deleteStack(Stack* myStack);
