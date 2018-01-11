#include <iostream>

using namespace std;

struct Student
{
    int numberOfPerson;
    int copied;
    int numberOfWork;
};

void bfs(Student* people, int amount, int v)
{
    for (int i = 0; i < amount;i++)
    {
        if ((people[v].numberOfPerson == people[i].copied) && (!people[i].numberOfWork))
        {
            people[i].numberOfWork = people[v].numberOfWork;
            bfs(people, amount, i);
        }
    }
}

int* workOptions(int amountOfStudents, int amountOfPairs, Student* people)
{
    int* variants = new int[amountOfStudents];
    for (int i = 0; i < amountOfStudents; i++)
        variants[i] = 0;

    for (int i = 0; i < amountOfPairs; i++)
        variants[people[i].numberOfPerson - 1] = people[i].numberOfWork;

    return variants;
}

int main()
{
    int amount = 0;
    cout << "enter amount students: \n";
    cin >> amount;

    Student* children = new Student[amount];
    int numberOfPairs = 0;
    cout << "Enter the number of pairs: ";
    cin >> numberOfPairs;
    for (int i = 0; i < amount; i++)
    {
        children[i].numberOfPerson = 0;
        children[i].copied = 0;
        children[i].numberOfWork = 0;
    }

    cout << "enter number of the student and with whom he wrote off: \n";
    for (int i = 0; i < numberOfPairs; i++)
    {
        cin >> children[i].numberOfPerson  >> children[i].copied;
        children[i].numberOfWork = 0;
    }
    int variantNumber = 1;
    for (int i = 0; i < amount; i++)
    {
        if (children[i].numberOfPerson == children[i].copied)
        {
            children[i].numberOfWork = variantNumber;
            bfs(children, amount, i);
            variantNumber++;
        }
    }

    int* works = workOptions(amount, numberOfPairs, children);

    cout << "students:\n";
    for (int i = 0; i < amount; i++)
    {
        cout << "number of student: " << i + 1;
        if (works[i] != 0)
            cout << " his variant number: " << works[i] << "\n";
        else
            cout << " did nothing! \n";
    }

    delete[] works;
    delete[] children;
    return 0;
}
