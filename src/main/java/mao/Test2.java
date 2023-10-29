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
