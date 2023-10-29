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
