#include "btree.h"
#include <stdio.h>
#include <string.h>
#include <iostream>

int const stringSize = 256;

struct Node
{
    int value;
    Node* left;
    Node* right;
};

struct BinaryTree
{
    Node* root;
};

BinaryTree* createBinaryTree()
{
    BinaryTree* newTree = new BinaryTree;
    newTree->root = nullptr;
    return newTree;
}

Node* createNode(int value)
{
    Node* newNode = new Node;
    newNode->value = value;
    newNode->right = nullptr;
    newNode->left = nullptr;
    return newNode;
}

void addToHashTable(Node *&node, int value)
{
    if (node == nullptr)
    {
        node = createNode(value);
        return;
    }

    if (node->value == value)
        return;

    if (node->value > value)
        addToHashTable(node->left, value);
    else
        addToHashTable(node->right, value);
}

void addToHashTable(BinaryTree* tree, int value)
{
    addToHashTable(tree->root, value);
}

Node *findMax(Node *node)
{
    while (node->right != nullptr)
        node = node->right;
    return node;
}

void removeNode(Node *&node, int value)
{
    if (node == nullptr)
        return;

    if (node->value == value)
    {
        if ((node->left == nullptr) && (node->right == nullptr))
        {
            delete node;
            node = nullptr;
        }
        else if (node->left == nullptr)
        {
            Node *temp = node->right;
            delete node;
            node = temp;
        }
        else if (node->right == nullptr)
        {
            Node *temp = node->left;
            delete node;
            node = temp;
        }
        else
        {
            Node *maxNode = findMax(node->left);
            int maxValue = maxNode->value;
            removeNode(node, maxValue);
            node->value = maxValue;
        }
        return;
    }

    if (value < node->value)
        return removeNode(node->left, value);
    else
        return removeNode(node->right, value);
}

void remove(BinaryTree* tree, int value)
{
    return removeNode(tree->root, value);
}

bool isBelong(Node* node, int value)
{
    if (node == nullptr)
        return false;

    if (node->value == value)
        return true;

    if (node->value < value)
        isBelong(node->right, value);
    else
        isBelong(node->left, value);
}

bool isBelong(BinaryTree* tree, int value)
{
    isBelong(tree->root, value);
}

bool isEmptyString(BinaryTree* tree)
{
    return tree->root == nullptr;
}

void deleteTree(Node* node)
{
    if (node == nullptr)
        return;

    deleteTree(node->left);
    deleteTree(node->right);
    delete node;
}

void deleteBinaryTree(BinaryTree *&tree)
{
    deleteTree(tree->root);
    delete tree;
    tree = nullptr;
}

void printLeftNode(Node* node)
{
    if (node == nullptr)
        return;

    printLeftNode(node->left);
    std::cout << node->value << " ";
    printLeftNode(node->right);
}

void printLeft(BinaryTree* tree)
{
    printLeftNode(tree->root);
}

void printRightNode(Node* node)
{
    if (node == nullptr)
        return;

    printRightNode(node->right);
    std::cout << node->value << " ";
    printRightNode(node->left);
}

void printRight(BinaryTree* tree)
{
    printRightNode(tree->root);
}

void printTreeNode(Node* node)
{
    if (node == nullptr)
    {
        std::cout << "null ";
        return;
    }

    std::cout << "( " << node->value << " ";
    printTreeNode(node->left);
    printTreeNode(node->right);
    std::cout << " )";
}

void printTree(BinaryTree* tree)
{
    printTreeNode(tree->root);
}

