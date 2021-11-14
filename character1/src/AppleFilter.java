import java.util.ArrayList;
import java.util.List;

public class AppleFilter {
    // 筛选出绿色的苹果
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:result){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
    // 需要将其抽象化,将颜色进行抽象化
    //将颜色进行参数化
    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:inventory){
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    //改变需求，判断重量大于150
    public static List<Apple> filterApplesByWeight(List<Apple> inventory,int weight){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:inventory){
            if(apple.getWeight()>weight){
                result.add(apple);
            }
        }
        return result;
    }
    //编写代码原则: DRY不要重复自己

    //对自己想要的任何属性进行筛选
    public static List<Apple> filterApples(List<Apple> inventory,String color,int weight,boolean flag){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:inventory){
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight()>weight)){
                result.add(apple);
            }
        }
        return result;
    }



}
