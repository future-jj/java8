import java.util.*;
import java.util.stream.Collectors;

public class ExampleStream {

    private static Trader raoul=new Trader("Raoul","Cambridge");
    private static Trader mario=new Trader("Mario","Milan");
    private static Trader alan=new Trader("Alan","Cambridge");
    private static Trader brian=new Trader("Brian","Cambridge");

    private static List<Transaction> transactions= Arrays.asList(
            new Transaction(brian,2011,300),
            new Transaction(raoul,2012,1000),
            new Transaction(raoul,2011,400),
            new Transaction(mario,2012,710),
            new Transaction(mario,2012,700),
            new Transaction(alan,2012,950)
    );

    public static void main(String[] args) {

        //找出所有2011年的交易额并且按照交易额排序
        List<Transaction> transaction2011=transactions.stream()
                .filter(d->d.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transaction2011);

        //交易员都在那些不同的城市工作过
        List<String> cities=transactions.stream()
                .map(transaction ->transaction.getTrader().getCity() )
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        //还可以去掉distinct使用toSet()
        Set<String> citiesSet=transactions.stream()
                .map(transactions -> transactions.getTrader().getCity())
                .collect(Collectors.toSet());

        //查找所有来自剑桥的交易员，并且按照姓名排序
        List<Trader> traders=transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        //返回所有交易员的姓名字符串，按照字母顺序进行排序
        String traderStr=transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(n1,n2)->n1+n2);
        System.out.println(traderStr);
        //请注意，这种写法的效率不是很高，所有的字符都需要反复的链接，每一次迭代都需要建立一个新的String对象，使用joining其内部会使用StringBuilder

        String traderStrStringBuilder=transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(Comparator.comparing(String::valueOf))
                .collect(Collectors.joining());
        System.out.println(traderStrStringBuilder);

        //有没有在米兰打工的
        boolean milanBased=transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //打印生活在剑桥的交易员的交易额
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //所有的交易额种交易额最多的
        Optional<Integer> highestValue=transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue.get());

        //所有交易额种最小的交易额
        Optional<Integer> smallestValue=transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(smallestValue.get());

        //你可以做得更好
        Optional<Transaction> smallestTransaction=
                transactions.stream()
                        .min(Comparator.comparing(Transaction::getValue));
        System.out.println(smallestTransaction.get());


    }

}
