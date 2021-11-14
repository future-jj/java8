import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class ReferenceLambda {
    public static void main(String[] args) {
        Function <Integer,Integer> f=x->x+1;
        Function <Integer,Integer> g=x->x*2;
        Function<Integer,Integer> h=f.andThen(g);
        // 先计算f然后再去计算g
        int result=h.apply(12);
        System.out.println(result);
        Function<Integer,Integer> r=f.compose(g);
        //先计算g再去计算f
        result=r.apply(12);
        System.out.println(result);

        List<String> list= Arrays.asList("zjj","zjj","zjj","zjj","zjj","xjj");
        BiPredicate<List<String>,String> contains=(inventory,element)->inventory.contains(element);
//        contains代表的是BiPredicate的一个实体类的名字
        System.out.println(contains.test(list, "hfdhfdsj"));
        //改写为方放的引用为
        BiPredicate<List<String>,String> containsReference=List::contains;
        System.out.println(containsReference.test(list, "zjj"));

        //方法的引用之构造函数
        //创建对象使用Supplier函数式接口
        Supplier<Apple> c1=()->new Apple("grenn",120);
        System.out.println(c1);
        //改造为方法引用
        Supplier<Apple> c2=Apple::new;
        // c2是Supplier的一个实体类的类名
        System.out.println(c2.get());

        //有参构造函数使用Function
        Function<Integer,Apple> c3=Apple::new;
        System.out.println(c3.apply(120));

        List<Integer> weights=Arrays.asList(1,3,5,189,90);
        List<Apple> apples=map(weights,Apple::new);
        System.out.println(apples);

        //具有两个参数的构造函数
        BiFunction<String,Integer,Apple> c4=Apple::new;
        System.out.println(c4.apply("green", 110));

        List<Apple> inventory=new ArrayList<>();
        inventory=Arrays.asList(new Apple("green",123),new Apple("red",123),new Apple("green",89));
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());//按照重量的递减进行排序
        System.out.println(inventory);

        //比较器链
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println(inventory);

        //谓词复合

    }
    public static List<Apple> map(List<Integer> list, Function<Integer,Apple> f){
        List<Apple> result=new ArrayList<>();
        for(Integer e:list){
            result.add(f.apply(e));
        }
        return result;
    }



}
