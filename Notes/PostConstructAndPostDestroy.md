**Special Note about @PostConstruct and @PreDestroy Method Signatures**

I want to provide additional details regarding the method signatures of @PostContruct and @PreDestroy methods.

Access modifier

The method can have any access modifier (public, protected, private)

Return type
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

Method name
The method can have any method name.

Arguments
The method can not accept any arguments. The method should be no-arg.

HEADS UP - FOR JAVA 9, 10 and 11 USERS - @PostConstruct and @PreDestroy

If you are using Java 9 or higher, then you will encounter an error when using @PostConstruct and @PreDestroy in your code. 

These are the steps to resolve it. Come back to the lecture if you hit the error. 

Error

Eclipse is unable to import @PostConstruct or @PreDestroy

This happens because of Java 9 and higher. 

When using Java 9 and higher, javax.annotation has been removed from its default classpath. That's why we Eclipse can't find it.

---

Solution

1. Download the javax.annotation-api-1.2.jar from 

http://central.maven.org/maven2/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar

2. Copy the JAR file to the lib folder of your project

---

Use the following steps to add it to your Java Build Path.

3. Right-click your project, select Properties

4. On left-hand side, click Java Build Path

5. In top-center of dialog, click Libraries

6. Click Classpath and then Click Add JARs ...

7. Navigate to the JAR file <your-project>/lib/javax.annotation-api-1.2.jar

8. Click OK then click Apply and Close
