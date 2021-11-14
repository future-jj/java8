import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseStream {
    private static List<Dish> menu= Arrays.asList(new Dish("pork",false,800, Dish.Type.MEAT),
            new Dish("beef",false,700, Dish.Type.MEAT),
            new Dish("chicken",false,400, Dish.Type.MEAT),
            new Dish("french fries",true,530, Dish.Type.OTHER),
            new Dish("rice",true,350, Dish.Type.OTHER),
            new Dish("season fruit",true,120, Dish.Type.OTHER),
            new Dish("pizza",true,550, Dish.Type.OTHER),
            new Dish("prawns",false,300, Dish.Type.FISH),
            new Dish("salmon",false,450, Dish.Type.FISH));

    public static void main(String[] args) {
        List<Dish> vegetarianDishes=menu.stream()
                .filter(d->d.isVegetarian())
                .collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        //用谓词进行筛选
        List<Integer> numbers=Arrays.asList(1,2,3,1,3,4,5,6,2,3,2);
        numbers.stream()
                .filter(d->d%2==0)
                .distinct()
                .forEach(System.out::println);

        //截断
        List<Dish> dishes=menu.stream()
                .filter(d->d.getCalories()>300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(dishes);

        //跳过元素
        List<Dish> dishSkip=menu.stream()
                .filter(d->d.getCalories()>300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(dishSkip);

        //使用流筛选前两个荤菜
        List<Dish> dishMeat=menu.stream()
                .filter(d->d.getType()== Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(dishMeat);

        //给定一组单词，显示每一个单词有几个字母
        List<String> words=Arrays.asList("Java 8","Lambda","In","Action");
        List<Integer> wordLengths=words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        //显示每道菜的菜名有多长
        List<Integer> dishLength=menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishLength);

        //流的扁平化 将各个生成流扁平为一个流
        //给定单词列表最后显示不重复的字符
        //使用flatMap

        String [] arrayOfWords={"Goodbye","World"};
        List<String> wordsArray=Arrays.asList("Goodbye","World");
//        Stream<String> streamOfWords=Arrays.stream(arrayOfWords);
        List<String> uniqueCharacters=wordsArray.stream()
                .map(w->w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);

    }
}
