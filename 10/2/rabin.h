#pragma once

int const d = 2;
int const p = 97;

long long pow(int degree);
int mod(int number1, int number2);
int hash(char* string, int length);
bool search(char* string1,int start,char* string2, int length);
void algRabinKarp(char* string, char* subString, int length1, int length2);
