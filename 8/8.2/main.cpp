#include <stdio.h>
#include "string.h"

int main() {
    String* epic = createString("Hello, ");
    String* win = createString("World!");
    String* wut = concate(epic, win);
    char *tmp = rawString(wut);
    
    printf("%s", tmp);
    
    delete tmp;
    deleteString(epic);
    delete epic;
    deleteString(win);
    delete win;
    deleteString(wut);
    delete wut;
    return 0;
}

