#include <iostream>
#include "avl.h"

struct Node
{
    int value;
    int height;
    Node* left;
    Node* right;
};

struct AVLTree
{
    Node* root;
};

AVLTree* createAVLTree()
{
    AVLTree* newTree = new AVLTree;
    newTree->root = nullptr;
    return newTree;
}

void printLeftNode(Node* node)
{
    if (node == nullptr)
        return;

    printLeftNode(node->left);
    std::cout << node->value << " ";
    printLeftNode(node->right);
}

void printLeft(AVLTree* tree)
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

void printRight(AVLTree* tree)
{
    printRightNode(tree->root);
}

void printTreeNode(Node* node)
{
    if (node == nullptr)
    {
        std::cout << "null";
        return;
    }

    std::cout << "( " << node->value << " ";
    printTreeNode(node->left);
    printTreeNode(node->right);
    std::cout << " )";
}

void printAVLTree(AVLTree* tree)
{
    printTreeNode(tree->root);
}

Node* createNode(int value)
{
    Node* newNode = new Node;
    newNode->value = value;
    newNode->height = 1;
    newNode->left = nullptr;
    newNode->right = nullptr;
    return newNode;
}

int height(Node* node)
{
    if (node != nullptr)
        return node->height;
    else
        return 0;
}

int balanceFactor(Node* node)
{
    return height(node->right) - height(node->left);
}

void updateHeight(Node* node)
{
    int heightLeft = height(node->left);
    int heightRight = height(node->right);
    if (heightLeft > heightRight)
        node->height = heightLeft + 1;
    else
        node->height = heightRight + 1;
}

void rotateRight(Node *&root)
{
    Node* pivot = root->left;
    root->left = pivot->right;
    pivot->right = root;
    updateHeight(root);
    updateHeight(pivot);
    root = pivot;
}

void rotateLeft(Node *&root)
{
    Node* pivot = root->right;
    root->right = pivot->left;
    pivot->left = root;
    updateHeight(root);
    updateHeight(pivot);
    root = pivot;
}

void balance(Node *&p)
{
    updateHeight(p);

    if (balanceFactor(p) == 2)
    {
        if (balanceFactor(p->right) < 0)
            rotateRight(p->right);
        rotateLeft(p);
    }

    if (balanceFactor(p) == -2)
    {
        if (balanceFactor(p->left) > 0)
            rotateLeft(p->left);
        rotateRight(p);
    }
}

void addNode(Node *&node, int value)
{
    if (node == nullptr)
    {
        node = createNode(value);
        return;
    }

    if (node->value == value)
        return;

    if (node->value > value)
        addNode(node->left, value);
    else
        addNode(node->right, value);

    updateHeight(node);
    balance(node);
}

void add(AVLTree* tree, int value)
{
    addNode(tree->root, value);
}

Node* findMax(Node* node)
{
    while(node->right != nullptr)
        node = node->right;
    return node;
}

void removeNode(Node *&node, int value)
{
    if (node == nullptr)
        return;

    if (node->value == value)
    {
        if (node->left == nullptr && node->right == nullptr)
        {
            delete node;
            node = nullptr;
            return;
        }
        if (node->left == nullptr)
        {
            Node* temp = node->right;
            delete node;
            node = temp;
            return;
        }
        if (node->right == nullptr)
        {
            Node* temp = node->left;
            delete node;
            node = temp;
            return;
        }
        else
        {
            Node* maxNode = findMax(node->left);
            int maxValue = maxNode->value;
            removeNode(node, maxValue);
            node->value = maxValue;
            balance(node);
            return;
        }
    }

    if (value < node->value)
        removeNode(node->left, value);
    else
        removeNode(node->right, value);
    balance(node);
}

void remove(AVLTree* tree, int value)
{
    removeNode(tree->root, value);
}

bool isBelong(Node* node, int value)
{
    if (node == nullptr)
        return false;

    if (node->value == value)
        return true;

    if (node->value > value)
        return isBelong(node->left, value);
    else
        return isBelong(node->right, value);
}

bool isBelong(AVLTree* tree, int value)
{
    return isBelong(tree->root, value);
}


bool isEmpty(AVLTree* tree)
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

void deleteAVLTree(AVLTree *&tree)
{
    deleteTree(tree->root);
    delete tree;
    tree = nullptr;
}
