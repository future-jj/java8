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


}
