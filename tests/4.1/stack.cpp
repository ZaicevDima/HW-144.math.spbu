#include <iostream>
#include "stack.h"
using namespace std;

Stack *createStack()
{
    return new Stack;
}

bool isEmpty(Stack *myStack)
{
    return (myStack->head == nullptr);
}

void push(Stack *myStack, int value)
{
    StackElement* element = new StackElement;
    element->value = value;
    element->next = myStack->head;
    myStack->head = element;
}

int top(Stack *myStack)
{
    return myStack->head->value;
}

void pop(Stack *myStack)
{
   StackElement* buffer = myStack->head;
   myStack->head = buffer->next;
   delete buffer;
}

void deleteStack(Stack *myStack)
{
    while (!myStack->head)
    {
        pop(myStack);
    }
    delete myStack;
}
