TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += main.cpp \
    phonebook.cpp \
    output.cpp

HEADERS += \
    phonebook.h \
    output.h

DISTFILES += \
    phonebook.txt \
    ../build-temp-Desktop_Qt_5_5_1_GCC_64bit-Debug/phonebook1.txt \
    ../build-temp-Desktop_Qt_5_5_1_GCC_64bit-Debug/Phonebook2.txt \
    ../build-temp-Desktop_Qt_5_5_1_GCC_64bit-Debug/Phonebook.txt

