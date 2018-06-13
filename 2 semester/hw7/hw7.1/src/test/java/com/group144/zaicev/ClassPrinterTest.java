package com.group144.zaicev;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import static com.group144.zaicev.ClassInformation.classInformation;

public class ClassPrinterTest {

    @Test
    public void printListClassTest() throws MalformedURLException, ClassNotFoundException {
        File file = new File("resources/");

        URL url = file.toURL();
        URL[] urls = new URL[]{url};

        ClassLoader classLoader = new URLClassLoader(urls);

        Class clazz = classLoader.loadClass("com.group144.zaicev.List");
        String clazzInformation = classInformation(clazz);
        String EXPECTED = "full class name: com.group144.zaicev.List\n" +
                "class name: List\n" +
                "\n" +
                "amount modifiers: 1\n" +
                "is abstract: false\n" +
                "is final: false\n" +
                "is interface: false\n" +
                "is native: false\n" +
                "is private: false\n" +
                "is protected: false\n" +
                "is public: true\n" +
                "is static: false\n" +
                "is strict: false\n" +
                "is synchronized: false\n" +
                "is transient: false\n" +
                "is volatile: false\n" +
                "\n" +
                "package: package com.group144.zaicev\n" +
                "\n" +
                "Superclass: class java.lang.Object\n" +
                "\n" +
                "Constructors: [public com.group144.zaicev.List()]\n" +
                "amount of parameters of class public com.group144.zaicev.List(): 0\n" +
                "\n" +
                "fields: [private com.group144.zaicev.List$ListElement com.group144.zaicev.List.head, private int com.group144.zaicev.List.size]\n" +
                "\n" +
                "all methods: [public void com.group144.zaicev.List.printList(), public java.lang.Object com.group144.zaicev.List.valueOfIndex(int), public void com.group144.zaicev.List.add(java.lang.Object), public void com.group144.zaicev.List.clear(), public int com.group144.zaicev.List.size(), public void com.group144.zaicev.List.pop(), public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]\n" +
                "method name: printList\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: valueOfIndex\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [int arg0]\n" +
                "types parameters of method: [int]\n" +
                "return type: class java.lang.Object\n" +
                "\n" +
                "method name: add\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [Type arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: void\n" +
                "\n" +
                "method name: clear\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: size\n" +
                "amount of method parameters: 0\n" +
                "return type: int\n" +
                "\n" +
                "method name: pop\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 2\n" +
                "parameters of method: [long arg0, int arg1]\n" +
                "types parameters of method: [long, int]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [long arg0]\n" +
                "types parameters of method: [long]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: equals\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Object arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: boolean\n" +
                "\n" +
                "method name: toString\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: hashCode\n" +
                "amount of method parameters: 0\n" +
                "return type: int\n" +
                "\n" +
                "method name: getClass\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Class\n" +
                "\n" +
                "method name: notify\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: notifyAll\n" +
                "amount of method parameters: 0\n" +
                "return type: void";
        Assert.assertEquals(EXPECTED, clazzInformation);
    }

    @Test
    public void printStackClassTest() throws MalformedURLException, ClassNotFoundException {
        File file = new File("resources/");

        URL url = file.toURL();
        URL[] urls = new URL[]{url};

        ClassLoader classLoader = new URLClassLoader(urls);

        Class clazz = classLoader.loadClass("com.group144.zaicev.Stack");
        String clazzInformation = classInformation(clazz);
        String EXPECTED = "full class name: com.group144.zaicev.Stack\n" +
                "class name: Stack\n" +
                "\n" +
                "amount modifiers: 1\n" +
                "is abstract: false\n" +
                "is final: false\n" +
                "is interface: false\n" +
                "is native: false\n" +
                "is private: false\n" +
                "is protected: false\n" +
                "is public: true\n" +
                "is static: false\n" +
                "is strict: false\n" +
                "is synchronized: false\n" +
                "is transient: false\n" +
                "is volatile: false\n" +
                "\n" +
                "package: package com.group144.zaicev\n" +
                "\n" +
                "Superclass: class java.lang.Object\n" +
                "\n" +
                "Constructors: [public com.group144.zaicev.Stack()]\n" +
                "amount of parameters of class public com.group144.zaicev.Stack(): 0\n" +
                "\n" +
                "fields: [private com.group144.zaicev.Stack$StackElement com.group144.zaicev.Stack.head]\n" +
                "\n" +
                "all methods: [public java.lang.Object com.group144.zaicev.Stack.top(), public boolean com.group144.zaicev.Stack.isEmpty(), public void com.group144.zaicev.Stack.push(java.lang.Object), public java.lang.Object com.group144.zaicev.Stack.pop(), public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]\n" +
                "method name: top\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Object\n" +
                "\n" +
                "method name: isEmpty\n" +
                "amount of method parameters: 0\n" +
                "return type: boolean\n" +
                "\n" +
                "method name: push\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [Type arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: void\n" +
                "\n" +
                "method name: pop\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Object\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 2\n" +
                "parameters of method: [long arg0, int arg1]\n" +
                "types parameters of method: [long, int]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [long arg0]\n" +
                "types parameters of method: [long]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: equals\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Object arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: boolean\n" +
                "\n" +
                "method name: toString\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: hashCode\n" +
                "amount of method parameters: 0\n" +
                "return type: int\n" +
                "\n" +
                "method name: getClass\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Class\n" +
                "\n" +
                "method name: notify\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: notifyAll\n" +
                "amount of method parameters: 0\n" +
                "return type: void";
        Assert.assertEquals(EXPECTED, clazzInformation);
    }

    @Test
    public void printListElementClassTest() throws MalformedURLException, ClassNotFoundException {
        File file = new File("resources/");

        URL url = file.toURL();
        URL[] urls = new URL[]{url};

        ClassLoader classLoader = new URLClassLoader(urls);

        Class clazz = classLoader.loadClass("com.group144.zaicev.List$ListElement");
        String clazzInformation = classInformation(clazz);

        String EXPECTED = "full class name: com.group144.zaicev.List$ListElement\n" +
                "class name: ListElement\n" +
                "\n" +
                "amount modifiers: 2\n" +
                "is abstract: false\n" +
                "is final: false\n" +
                "is interface: false\n" +
                "is native: false\n" +
                "is private: true\n" +
                "is protected: false\n" +
                "is public: false\n" +
                "is static: false\n" +
                "is strict: false\n" +
                "is synchronized: false\n" +
                "is transient: false\n" +
                "is volatile: false\n" +
                "\n" +
                "package: package com.group144.zaicev\n" +
                "\n" +
                "Superclass: class java.lang.Object\n" +
                "\n" +
                "Constructors: []\n" +
                "\n" +
                "fields: [java.lang.Object com.group144.zaicev.List$ListElement.value, com.group144.zaicev.List$ListElement com.group144.zaicev.List$ListElement.next, final com.group144.zaicev.List com.group144.zaicev.List$ListElement.this$0]\n" +
                "\n" +
                "all methods: [public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 2\n" +
                "parameters of method: [long arg0, int arg1]\n" +
                "types parameters of method: [long, int]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [long arg0]\n" +
                "types parameters of method: [long]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: equals\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Object arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: boolean\n" +
                "\n" +
                "method name: toString\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: hashCode\n" +
                "amount of method parameters: 0\n" +
                "return type: int\n" +
                "\n" +
                "method name: getClass\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Class\n" +
                "\n" +
                "method name: notify\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: notifyAll\n" +
                "amount of method parameters: 0\n" +
                "return type: void";
        Assert.assertEquals(EXPECTED, clazzInformation);
    }

    @Test
    public void printStackElementClassTest() throws MalformedURLException, ClassNotFoundException {
        File file = new File("resources/");

        URL url = file.toURL();
        URL[] urls = new URL[]{url};

        ClassLoader classLoader = new URLClassLoader(urls);

        Class clazz = classLoader.loadClass("com.group144.zaicev.Stack$StackElement");
        String clazzInformation = classInformation(clazz);

        String EXPECTED = "full class name: com.group144.zaicev.Stack$StackElement\n" +
                "class name: StackElement\n" +
                "\n" +
                "amount modifiers: 2\n" +
                "is abstract: false\n" +
                "is final: false\n" +
                "is interface: false\n" +
                "is native: false\n" +
                "is private: true\n" +
                "is protected: false\n" +
                "is public: false\n" +
                "is static: false\n" +
                "is strict: false\n" +
                "is synchronized: false\n" +
                "is transient: false\n" +
                "is volatile: false\n" +
                "\n" +
                "package: package com.group144.zaicev\n" +
                "\n" +
                "Superclass: class java.lang.Object\n" +
                "\n" +
                "Constructors: [public com.group144.zaicev.Stack$StackElement(com.group144.zaicev.Stack,java.lang.Object,com.group144.zaicev.Stack$StackElement)]\n" +
                "amount of parameters of class public com.group144.zaicev.Stack$StackElement(com.group144.zaicev.Stack,java.lang.Object,com.group144.zaicev.Stack$StackElement): 3\n" +
                "types of parameters of class public com.group144.zaicev.Stack$StackElement(com.group144.zaicev.Stack,java.lang.Object,com.group144.zaicev.Stack$StackElement): [class com.group144.zaicev.Stack, class java.lang.Object, class com.group144.zaicev.Stack$StackElement]\n" +
                "\n" +
                "fields: [public java.lang.Object com.group144.zaicev.Stack$StackElement.value, public com.group144.zaicev.Stack$StackElement com.group144.zaicev.Stack$StackElement.next, final com.group144.zaicev.Stack com.group144.zaicev.Stack$StackElement.this$0]\n" +
                "field name: value\n" +
                "field type: class java.lang.Object\n" +
                "field name: next\n" +
                "field type: class com.group144.zaicev.Stack$StackElement\n" +
                "\n" +
                "all methods: [public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 2\n" +
                "parameters of method: [long arg0, int arg1]\n" +
                "types parameters of method: [long, int]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [long arg0]\n" +
                "types parameters of method: [long]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: equals\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Object arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: boolean\n" +
                "\n" +
                "method name: toString\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: hashCode\n" +
                "amount of method parameters: 0\n" +
                "return type: int\n" +
                "\n" +
                "method name: getClass\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Class\n" +
                "\n" +
                "method name: notify\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: notifyAll\n" +
                "amount of method parameters: 0\n" +
                "return type: void";
        Assert.assertEquals(EXPECTED, clazzInformation);
    }

    @Test
    public void printIncorrectTreeExeptionClassTest() throws MalformedURLException, ClassNotFoundException {
        File file = new File("resources/");

        URL url = file.toURL();
        URL[] urls = new URL[]{url};

        ClassLoader classLoader = new URLClassLoader(urls);

        Class clazz = classLoader.loadClass("com.group144.zaicev.IncorrectTreeException");
        String clazzInformation = classInformation(clazz);

        String EXPECTED = "full class name: com.group144.zaicev.IncorrectTreeException\n" +
                "class name: IncorrectTreeException\n" +
                "\n" +
                "amount modifiers: 0\n" +
                "is abstract: false\n" +
                "is final: false\n" +
                "is interface: false\n" +
                "is native: false\n" +
                "is private: false\n" +
                "is protected: false\n" +
                "is public: false\n" +
                "is static: false\n" +
                "is strict: false\n" +
                "is synchronized: false\n" +
                "is transient: false\n" +
                "is volatile: false\n" +
                "\n" +
                "package: package com.group144.zaicev\n" +
                "\n" +
                "Superclass: class java.lang.Exception\n" +
                "\n" +
                "Constructors: []\n" +
                "\n" +
                "fields: []\n" +
                "\n" +
                "all methods: [public void java.lang.Throwable.printStackTrace(), public void java.lang.Throwable.printStackTrace(java.io.PrintWriter), public void java.lang.Throwable.printStackTrace(java.io.PrintStream), public synchronized java.lang.Throwable java.lang.Throwable.fillInStackTrace(), public synchronized java.lang.Throwable java.lang.Throwable.getCause(), public synchronized java.lang.Throwable java.lang.Throwable.initCause(java.lang.Throwable), public java.lang.String java.lang.Throwable.toString(), public java.lang.String java.lang.Throwable.getMessage(), public java.lang.String java.lang.Throwable.getLocalizedMessage(), public java.lang.StackTraceElement[] java.lang.Throwable.getStackTrace(), public void java.lang.Throwable.setStackTrace(java.lang.StackTraceElement[]), public final synchronized void java.lang.Throwable.addSuppressed(java.lang.Throwable), public final synchronized java.lang.Throwable[] java.lang.Throwable.getSuppressed(), public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]\n" +
                "method name: printStackTrace\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: printStackTrace\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.io.PrintWriter arg0]\n" +
                "types parameters of method: [class java.io.PrintWriter]\n" +
                "return type: void\n" +
                "\n" +
                "method name: printStackTrace\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.io.PrintStream arg0]\n" +
                "types parameters of method: [class java.io.PrintStream]\n" +
                "return type: void\n" +
                "\n" +
                "method name: fillInStackTrace\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Throwable\n" +
                "\n" +
                "method name: getCause\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Throwable\n" +
                "\n" +
                "method name: initCause\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Throwable arg0]\n" +
                "types parameters of method: [class java.lang.Throwable]\n" +
                "return type: class java.lang.Throwable\n" +
                "\n" +
                "method name: toString\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: getMessage\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: getLocalizedMessage\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.String\n" +
                "\n" +
                "method name: getStackTrace\n" +
                "amount of method parameters: 0\n" +
                "return type: class [Ljava.lang.StackTraceElement;\n" +
                "\n" +
                "method name: setStackTrace\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.StackTraceElement[] arg0]\n" +
                "types parameters of method: [class [Ljava.lang.StackTraceElement;]\n" +
                "return type: void\n" +
                "\n" +
                "method name: addSuppressed\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Throwable arg0]\n" +
                "types parameters of method: [class java.lang.Throwable]\n" +
                "return type: void\n" +
                "\n" +
                "method name: getSuppressed\n" +
                "amount of method parameters: 0\n" +
                "return type: class [Ljava.lang.Throwable;\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 2\n" +
                "parameters of method: [long arg0, int arg1]\n" +
                "types parameters of method: [long, int]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [long arg0]\n" +
                "types parameters of method: [long]\n" +
                "return type: void\n" +
                "\n" +
                "method name: wait\n" +
                "exceptions: [class java.lang.InterruptedException]\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: equals\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [java.lang.Object arg0]\n" +
                "types parameters of method: [class java.lang.Object]\n" +
                "return type: boolean\n" +
                "\n" +
                "method name: hashCode\n" +
                "amount of method parameters: 0\n" +
                "return type: int\n" +
                "\n" +
                "method name: getClass\n" +
                "amount of method parameters: 0\n" +
                "return type: class java.lang.Class\n" +
                "\n" +
                "method name: notify\n" +
                "amount of method parameters: 0\n" +
                "return type: void\n" +
                "\n" +
                "method name: notifyAll\n" +
                "amount of method parameters: 0\n" +
                "return type: void";
        Assert.assertEquals(EXPECTED, clazzInformation);
    }

    @Test
    public void printSorterInterfaceClassTest() throws MalformedURLException, ClassNotFoundException {
        File file = new File("resources/");

        URL url = file.toURL();
        URL[] urls = new URL[]{url};

        ClassLoader classLoader = new URLClassLoader(urls);

        Class clazz = classLoader.loadClass("com.group144.zaicev.Sorter");
        String clazzInformation = classInformation(clazz);

        String EXPECTED = "full class name: com.group144.zaicev.Sorter\n" +
                "class name: Sorter\n" +
                "\n" +
                "amount modifiers: 1537\n" +
                "is abstract: true\n" +
                "is final: false\n" +
                "is interface: true\n" +
                "is native: false\n" +
                "is private: false\n" +
                "is protected: false\n" +
                "is public: true\n" +
                "is static: false\n" +
                "is strict: false\n" +
                "is synchronized: false\n" +
                "is transient: false\n" +
                "is volatile: false\n" +
                "\n" +
                "package: package com.group144.zaicev\n" +
                "\n" +
                "Superclass: null\n" +
                "\n" +
                "Constructors: []\n" +
                "\n" +
                "fields: []\n" +
                "\n" +
                "all methods: [public abstract void com.group144.zaicev.Sorter.qsort(int[])]\n" +
                "method name: qsort\n" +
                "amount of method parameters: 1\n" +
                "parameters of method: [int[] arg0]\n" +
                "types parameters of method: [class [I]\n" +
                "return type: void";
        Assert.assertEquals(EXPECTED, clazzInformation);
    }
}