import java.util.ArrayList;
import java.util.List;

public class AppleFilterByInterface {
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
    }
}
