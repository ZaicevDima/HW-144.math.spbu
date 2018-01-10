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

void add(Node *&node, int value)
{
    if (node == nullptr)
    {
        node = createNode(value);
        return;
    }

    if (node->value == value)
        return;

    if (node->value > value)
        add(node->left, value);
    else
        add(node->right, value);
}

void add(BinaryTree* tree, int value)
{
    add(tree->root, value);
}

void removeNode(Node *&node)
{
    if (node == nullptr)
        return;

    if ((node->left == nullptr) && (node->right == nullptr))
    {
        delete node;
        node = nullptr;
        return;
    }

    if ((node->left != nullptr) && (node->right == nullptr))
    {
        Node* tempNode = node;
        node = node->left;
        delete tempNode;
        return;
    }

    if ((node->left == nullptr) && (node->right != nullptr))
    {
        Node* tempNode = node;
        node = node->right;
        delete tempNode;
        return;
    }

    if ((node->left != nullptr) && (node->right != nullptr))
    {
        Node* tempNode = node->left;
        while ((tempNode)->right != nullptr)
            tempNode = (tempNode)->right;
        node->value = (tempNode)->value;
        removeNode(tempNode);
        return;
    }
}

void remove(Node *&node, int value)
{
    if (node == nullptr)
        return;

    if (node->value == value)
    {
        removeNode(node);
        return;
    }

    if (node->value < value)
        remove(node->right, value);
    else
        remove(node->left, value);
}

void remove(BinaryTree* tree, int value)
{
    remove(tree->root, value);
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

bool isEmpty(BinaryTree* tree)
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

