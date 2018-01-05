TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += main.cpp \
    hashtable.cpp \
    mystring.cpp

HEADERS += \
    hashtable.h \
    mystring.h

DISTFILES += \
    input.txt

