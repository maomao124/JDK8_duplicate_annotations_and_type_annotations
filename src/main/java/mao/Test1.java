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
