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
        if (people[v].numberOfPerson == people[i].copied && !people[i].numberOfWork)
        {
            people[i].numberOfWork = people[v].numberOfWork;
            bfs(people, amount, i);
        }
    }
}

int main()
{
    int amount = 0;
    cout << "enter amount students: \n";
    cin >> amount;
    Student* children = new Student[amount];
    cout << "enter number of the student and with whom he wrote off: \n";
    for (int i = 0;i < amount; i++)
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
    cout << "students:\n";
    for (int i = 0; i < amount; i++)
        cout << "number of student: " << children[i].numberOfPerson << " his variant number: " << children[i].numberOfWork << "\n";

}
