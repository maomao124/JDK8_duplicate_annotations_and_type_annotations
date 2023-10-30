

## 重复注解

### 概述

自从Java 5中引入注解以来，注解开始变得非常流行，并在各个框架和项目中被广泛使用。不过注解有一个很大的限制是：在同一个地方不能多次使用同一个注解。JDK8引入了重复注解的概念，允许在同一个地方多次使用同一个注解。在JDK 8中使用@Repeatable注解定义重复注解





### 使用

定义重复的注解容器注解

```java
package mao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnos
{
    MyAnno[] value();
}
```



定义一个可以重复的注解

```java
package mao;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnos.class)
public @interface MyAnno
{
    String value();
}

```





配置多个重复的注解

```java
package mao;

/**
 * Project name(项目名称)：JDK8_duplicate_annotations_and_type_annotations
 * Package(包名): mao
 * Class(类名): Test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/29
 * Time(创建时间)： 13:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@MyAnno("123")
@MyAnno("456")
public class Test1
{
    @MyAnno("789")
    @MyAnno("10")
    public void test()
    {
        System.out.println("hello");
    }
}
```





解析得到指定注解

```java
package mao;

/**
 * Project name(项目名称)：JDK8_duplicate_annotations_and_type_annotations
 * Package(包名): mao
 * Class(类名): Test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/29
 * Time(创建时间)： 13:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test2
{
    public static void main(String[] args) throws NoSuchMethodException
    {
        MyAnno[] myAnnos = Test1.class.getAnnotationsByType(MyAnno.class);
        for (MyAnno myAnno : myAnnos)
        {
            System.out.println(myAnno.value());
        }
        MyAnno[] myAnnos1 = Test1.class.getMethod("test").getAnnotationsByType(MyAnno.class);
        for (MyAnno myAnno : myAnnos1)
        {
            System.out.println(myAnno.value());
        }
    }
}
```







## 类型注解

### 概述

JDK 8为@Target元注解新增了两种类型：

* TYPE_PARAMETER：表示该注解能写在类型参数的声明语句中。 类型参数声明如： \<T>
* TYPE_USE：表示注解可以再任何用到类型的地方使用





### 使用

```java
package mao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_PARAMETER)
public @interface TyptParam
{

}
```



```java
package mao;

/**
 * Project name(项目名称)：JDK8_duplicate_annotations_and_type_annotations
 * Package(包名): mao
 * Class(类名): Test3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/29
 * Time(创建时间)： 13:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test3<@TyptParam T>
{
    public static void main(String[] args)
    {

    }

    public <@TyptParam E> void test(String a)
    {

    }
}
```







```java
package mao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
public @interface NotNull
{
}
```

```java
package mao;

/**
 * Project name(项目名称)：JDK8_duplicate_annotations_and_type_annotations
 * Package(包名): mao
 * Class(类名): Test4
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/10/29
 * Time(创建时间)： 13:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test4<@TyptParam T extends String>
{
    private @NotNull int a = 10;

    public static void main(@NotNull String[] args)
    {
        @NotNull int x = 1;
        @NotNull String s = new @NotNull String();
    }

    public <@TyptParam E> void test(String a)
    {
    }
}
```



通过@Repeatable元注解可以定义可重复注解，TYPE_PARAMETER可以让注解放在泛型上。TYPE_USE 可以让注解放在类型的前面





