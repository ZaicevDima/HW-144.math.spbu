TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += main.cpp \
    mystring.cpp \
    hashtable.cpp \
    list.cpp

HEADERS += \
    hashtable.h \
    mystring.h \
    list.h

DISTFILES += \
    input.txt

