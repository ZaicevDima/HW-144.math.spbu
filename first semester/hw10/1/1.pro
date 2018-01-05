TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += main.cpp \
    matrix.cpp \
    astar.cpp

DISTFILES += \
    input.txt

HEADERS += \
    matrix.h \
    astar.h

