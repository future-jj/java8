import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class AppleFilterByInterface<T> {
    //使用多态的编程思想
    //将filterApples进行参数化了
    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> results=new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                results.add(apple);
            }
        }
        return results;
    }

    //将list类型进行抽象
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List <T> result=new ArrayList<>();
        for (T e:list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory=new ArrayList<>();
        Apple apple1=new Apple("green",171);
        Apple apple2=new Apple("red",90);
        Apple apple3=new Apple("red",90);
        Apple apple4=new Apple("green",90);
        Apple apple5=new Apple("red",170);
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);
        List<Apple> redAndHeavyApples=filterApples(inventory,new AppleRedAndHeavyPredicate());
        List<Apple> greenHeavyApples=filterApples(inventory,new AppleGreenColorPredicate());
        //多种行为一种参数
        System.out.println(redAndHeavyApples);
        System.out.println(greenHeavyApples);

        //使用匿名类
        List<Apple> redApples=filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println(redApples);

        //使用lambda
        List<Apple> result=filterApples(inventory,(Apple apple)->apple.getColor().equals("red"));
        System.out.println(result);

        List<Apple> greenApples=filter(inventory,(Apple apple)->apple.getColor().equals("green"));
        System.out.println(greenApples);

        List<Integer> numbers= Arrays.asList(1,2,3,89,90,1,23,1,23,41);
        List<Integer> evenNumbers=filter(numbers,(Integer i)->i%2==0);
        System.out.println(evenNumbers);

        //example
        inventory.sort((Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);


    }
}
