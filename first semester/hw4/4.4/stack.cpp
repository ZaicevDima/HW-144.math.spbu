#include "stack.h"

struct StackElement
{
    TypeElement value;
    StackElement* next;
};

struct Stack
{
    StackElement* head;
};

void push(Stack* stack, TypeElement value)
{
    StackElement* newElement = new StackElement;
    newElement->value = value;
    newElement->next = stack->head;
    stack->head = newElement;
}

TypeElement pop(Stack* stack)
{
    if (stack->head != nullptr)
    {
        TypeElement value = stack->head->value;
        StackElement* next = stack->head->next;
        delete stack->head;
        stack->head = next;
        return value;
    }
    std::cout << "stack is Empty \n";
    return -1;
}

TypeElement top(Stack* stack)
{
    if (stack->head != nullptr)
        return stack->head->value;
    std::cout << "stack is Empty \n";
    return -1;
}

bool isEmpty(Stack* stack)
{
    return (stack->head == nullptr);
}

Stack* createStack()
{
    Stack *stack = new Stack;
    stack->head = nullptr;
    return stack;
}

void deleteStack(Stack* stack)
{
    while (!isEmpty(stack))
        pop(stack);
    delete stack;
}
