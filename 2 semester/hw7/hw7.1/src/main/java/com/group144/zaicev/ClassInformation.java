package com.group144.zaicev;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Class for reflection
 */
class ClassInformation {

    /**
     * Get information about the class
     *
     * @param clazz class about which you want know information
     * @return information about class in the char[]
     */
    static String classInformation(Class clazz) {
        StringBuilder information = new StringBuilder();
        getNameInformation(clazz, information);
        getModifiersInformation(clazz, information);
        getPackageInformation(clazz, information);
        getSuperclassInformation(clazz, information);
        getInterfacesInformation(clazz, information);
        getConstructorsInformation(clazz, information);
        getFieldsInformation(clazz, information);
        getMethodsInformation(clazz, information);

        return String.valueOf(information).trim();
    }

    /**
     * adds information about methods in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getMethodsInformation(Class clazz, StringBuilder information) {
        information.append("all methods: ").append(Arrays.toString(clazz.getMethods())).append("\n");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            methodInformation(method, information);
        }
    }

    /**
     * adds information about method in the buffer
     *
     * @param method      method about which you want know information
     * @param information buffer for new information about the class
     */
    private static void methodInformation(Method method, StringBuilder information) {
        information.append("method name: ").append(method.getName()).append("\n");
        if (method.getExceptionTypes().length > 0) {
            information.append("exceptions: ").append(Arrays.toString(method.getExceptionTypes())).append("\n");
        }
        information.append("amount of method parameters: ").append(method.getParameterCount()).append("\n");
        if (method.getParameterCount() > 0) {
            information.append("parameters of method: ").append(Arrays.toString(method.getParameters())).append("\n");
            information.append("types parameters of method: ").append(Arrays.toString(method.getParameterTypes())).append("\n");
        }
        information.append("return type: ").append(method.getReturnType()).append("\n\n");
    }

    /**
     * adds information about fields in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getFieldsInformation(Class clazz, StringBuilder information) {
        information.append("fields: ").append(Arrays.toString(clazz.getDeclaredFields())).append("\n");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            fieldInformation(field, information);
        }
        information.append("\n");
    }

    /**
     * adds information about field in the buffer
     *
     * @param field       field about which you want know information
     * @param information buffer for new information about the class
     */
    private static void fieldInformation(Field field, StringBuilder information) {
        information.append("field name: ").append(field.getName()).append("\n");
        information.append("field type: ").append(field.getType()).append("\n");
    }

    /**
     * adds information about constructors in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getConstructorsInformation(Class clazz, StringBuilder information) {
        information.append("Constructors: ").append(Arrays.toString(clazz.getConstructors())).append("\n");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            constructorInformation(constructor, information);
        }
        information.append("\n");
    }

    /**
     * adds information about the constructor in the buffer
     *
     * @param constructor constructor about which you want know information
     * @param information buffer for new information about the class
     */
    private static void constructorInformation(Constructor constructor, StringBuilder information) {
        information.append("amount of parameters of class ").append(constructor.toString()).append(": ")
                .append(constructor.getParameterCount()).append("\n");
        if (constructor.getParameterCount() > 0) {
            information.append("types of parameters of class ").append(constructor.toString()).append(": ")
                    .append(Arrays.toString(constructor.getParameterTypes())).append("\n");
        }
    }

    /**
     * adds information about interface in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getInterfacesInformation(Class clazz, StringBuilder information) {
        if (clazz.getInterfaces().length > 0) {
            information.append("Interfaces: ").append(Arrays.toString(clazz.getInterfaces())).append("\n\n");
        }
    }

    /**
     * adds information about superclasses in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getSuperclassInformation(Class clazz, StringBuilder information) {
        information.append("Superclass: ").append(clazz.getSuperclass()).append("\n\n");
    }


    /**
     * adds information about packages in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getPackageInformation(Class clazz, StringBuilder information) {
        information.append("package: ").append(clazz.getPackage()).append("\n\n");
    }

    /**
     * adds information about modifiers in your class in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getModifiersInformation(Class clazz, StringBuilder information) {
        information.append("amount modifiers: ").append(clazz.getModifiers()).append("\n");
        information.append("is abstract: ").append(Modifier.isAbstract(clazz.getModifiers())).append("\n");
        information.append("is final: ").append(Modifier.isFinal(clazz.getModifiers())).append("\n");
        information.append("is interface: ").append(Modifier.isInterface(clazz.getModifiers())).append("\n");
        information.append("is native: ").append(Modifier.isNative(clazz.getModifiers())).append("\n");
        information.append("is private: ").append(Modifier.isPrivate(clazz.getModifiers())).append("\n");
        information.append("is protected: ").append(Modifier.isProtected(clazz.getModifiers())).append("\n");
        information.append("is public: ").append(Modifier.isPublic(clazz.getModifiers())).append("\n");
        information.append("is static: ").append(Modifier.isStatic(clazz.getModifiers())).append("\n");
        information.append("is strict: ").append(Modifier.isStrict(clazz.getModifiers())).append("\n");
        information.append("is synchronized: ").append(Modifier.isSynchronized(clazz.getModifiers())).append("\n");
        information.append("is transient: ").append(Modifier.isTransient(clazz.getModifiers())).append("\n");
        information.append("is volatile: ").append(Modifier.isVolatile(clazz.getModifiers())).append("\n");
        information.append("\n");
    }

    /**
     * adds information about your class name in the buffer
     *
     * @param clazz       class about which you want know information
     * @param information buffer for new information about the class
     */
    private static void getNameInformation(Class clazz, StringBuilder information) {
        information.append("full class name: ").append(clazz.getName()).append("\n");

        information.append("class name: ").append(clazz.getSimpleName()).append("\n");
        information.append("\n");
    }
}