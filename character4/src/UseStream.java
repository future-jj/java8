import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // 给定两个数字列表，返回对应的数对
        // 可以使用两个Map来迭代这两个列表，并生成数对。但这样会返回一个Stream<Stream<Integer[]>>,你需要进行流的扁平化处理，得到一个Stream<Integer[]>
        List<Integer> numbers1=Arrays.asList(1,2,3);
        List<Integer> numbers2=Arrays.asList(3,4);
        List<int[]> pairs=numbers1.stream()
                .flatMap(i->numbers2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());

        // 查找和匹配
        //检查谓词是否至少匹配一个元素,anyMatch返回一个boolean类型
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly");
        }

        //检查谓词是否匹配所有的元素,检查所有的菜品中的卡路里是否都低于1000
        boolean isHealthy=menu.stream().allMatch(d->d.getCalories()<1000);
        System.out.println(isHealthy);

        //和allMatch相对的是noneMatch,以确保流中没有元素和给定的谓词匹配。
        boolean isHealthyNone=menu.stream().noneMatch(d->d.getCalories()>=1000);
        System.out.println(isHealthyNone);

        // 查找元素
        // findAny方法将返回当前流中的任意的元素
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d->System.out.println(d.getName()));

        //查找第一个元素
        List<Integer> someNumbers=Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree=someNumbers.stream()
                .map(x->x*x)
                .filter(x->x%3==0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree.get());

        //归约
        int sum=numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

        int sum2=numbers.stream().reduce(0,Integer::sum);
        System.out.println(sum2);

        Optional<Integer> max=numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        Optional<Integer> min=numbers.stream().reduce(Integer::min);
        System.out.println(min.get());

        //如何使用map和reduce数一数流中有多少的菜呢
        int count=menu.stream()
                .map(d->1)
                .reduce(0,(a,b)->a+b);
        System.out.println(count);

        //map和reduce的链接通常称之为map-reduce模式，因为它很容易进行并行化
        long count2=menu.stream().count();
        System.out.println(count2);
    }
}
