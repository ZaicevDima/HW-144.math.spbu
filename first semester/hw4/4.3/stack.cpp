#include "stack.h"

struct StackElement {
    TypeElement value;
    StackElement* next;
};

struct Stack {
    StackElement* head;
};

void push(Stack* stack, TypeElement value)
{
    stack->head = new StackElement{value, stack->head};
}

TypeElement pop(Stack* stack)
{
    if (stack->head != nullptr) {
        TypeElement value = stack->head->value;
        StackElement* next = stack->head->next;
        delete stack->head;
        stack->head = next;
        return value;
    }
    else
        return {};
}

TypeElement top(Stack* stack)
{
    if (stack->head != nullptr)
        return stack->head->value;
    else
        return {};
}

bool isEmpty(Stack* stack)
{
    return (stack->head == nullptr);
}

Stack* createStack()
{
    return new Stack{};
}

void deleteStack(Stack* stack)
{
    while (!isEmpty(stack)) {
        pop(stack);
    }
    delete stack;
}
