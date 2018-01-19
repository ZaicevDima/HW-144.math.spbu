TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += main.cpp \
    huffman.cpp \
    queue.cpp \
    mystring.cpp

HEADERS += \
    huffman.h \
    queue.h \
    mystring.h

DISTFILES += \
    input.txt

