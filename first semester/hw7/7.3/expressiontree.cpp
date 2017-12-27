#include <stdio.h>
#include <string.h>
#include <iostream>
#include "expressiontree.h"

int const stringSize = 256;

struct Node
{
    char operation;
    int value;
    bool isLeaf;
    Node *left;
    Node *right;
};

struct ExpressionTree
{
    Node *root;
};

Node* createNode(int value)
{
    Node* newNode = new Node;
    newNode->value = value;
    newNode->right = nullptr;
    newNode->left = nullptr;
    return newNode;
}

ExpressionTree* createExpressionTree()
{
    ExpressionTree* newTree = new ExpressionTree;
    newTree->root = nullptr;
    return newTree;
}

void deleteNode(Node *node)
{
    if (node == nullptr)
        return;

    deleteNode(node->left);
    deleteNode(node->right);
    delete node;
}

void deleteExpressionTree(ExpressionTree *&tree)
{
    deleteNode(tree->root);
    delete tree;
    tree = nullptr;
}

int resultOperation(Node* node)
{
    if (node->isLeaf)
        return node->value;

    if (node->operation == '+')
        return resultOperation(node->left) + resultOperation(node->right);

    if (node->operation == '-')
        return resultOperation(node->left) - resultOperation(node->right);

    if (node->operation == '*')
        return resultOperation(node->left) * resultOperation(node->right);

    if (node->operation == '/')
        return resultOperation(node->left) / resultOperation(node->right);

    cout << "not operation";
    return 0;
}

int result(ExpressionTree* tree)
{
    resultOperation(tree->root);
}

bool isNumber(char symbol)
{
    return ((symbol >= '0') && (symbol <= '9'));
}

Node* scanfNode(ifstream &file)
{
    char symbol = file.get();
    Node* newNode = new Node;

    if (isNumber(symbol))
    {
        int number = symbol - '0';
        char next = file.get();
        while (isNumber(next))
        {
            number = number * 10 + (next - '0');
            next = file.get();
        }
        file.unget();
        newNode->value = number;
        newNode->isLeaf = true;
        newNode->left = nullptr;
        newNode->right = nullptr;
    }
    else if (symbol == '(')
    {
        symbol = file.get();
        if (symbol == ' ')
            symbol = '*';
        else
            file.get();
        newNode->operation = symbol;
        newNode->isLeaf = false;
        newNode->left = scanfNode(file);
        file.get();
        newNode->right = scanfNode(file);
        file.get();
    }

    return newNode;
}

void scanfTree(ExpressionTree* tree, ifstream &file)
{
    tree->root = scanfNode(file);
}


void printNode(Node* node)
{
    if (node->isLeaf)
    {
        cout << node->value;
        return;
    }
    cout << "(";
    printNode(node->left);
    cout << " " << node->operation << " ";
    printNode(node->right);
    cout << ")";
}

void printExpression(ExpressionTree* tree)
{
    printNode(tree->root);
}
