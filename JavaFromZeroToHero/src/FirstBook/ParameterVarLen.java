package FirstBook;

// 可变参数: 声明+调用
// 声明...
// 调用，当做数组循环
public class ParameterVarLen {
    public ParameterVarLen(String... vars){
        for(String var : vars) {
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        ParameterVarLen p = new ParameterVarLen("hujun", "love", "ljh");
    }
}
