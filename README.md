# java8
学习java8的新特性

# 第一章
略

# 第二章

### 1、Lambda 及函数式接口的例子
| 使用案例 | lambda例子 | 函数式接口 |
| :----:| :----: | :----: |
| 布尔表达式 | （List<String> list) ->list.isEmpty() | Predicate<List&lt;String>> |
| 创建对象 | ()->new Apple(10) | Supplier<Apple<j>> |
| 消费对象 | (Apple a)->System.out.println(a.getWeight()) | Consumer &lt;Apple&gt; |

### 方法引用
方法引用有三个<br>
（1）、指向静态方法的方法引用（Integer 的parseInt方法写作Integer::parseInt）<br>
（2）、指向任意实例对象的方法引用(String::length)<br>
（3）、调用了外部的对象，假设局部变量expensiveTransaction,用于存放Transaction类型的对象，它支持实例方法getValue,就可以写作Transaction::getValue<br>

### 注意点
谓词的复合 negate、and、or 非、与、或这些都是Predicate的默认方法<br>
使用函数式接口的时候必须要加上定义泛型的类型，其他的接口同样<br>
通过实践证明Predicate这种函数式接口的变量名即函数式接口的实现类名不可以和其他的变量名冲突<br>

# 第三章

### 一些概念
*流* 是JavaAPI的新成员，它允许以声明性的方式处理数据的集合<br>
filter接受一个lambda，从流中排除一些元素<br>
limit截断流，使其元素不能超过给定的数量<br>
collect 将流转换为其他的形式<br>
终端操作是从流的流水线上生成结果,其结果是任何不是流的值，比如List、Integer甚至是void<br>
所有的中间操作都会生成一个Stream<br>
中间操作有:<br>
filter map limit sorted distinct<br>
终端操作:<br>
forEach count collect <br>

### 注意点
流只能被消费一次<br>
limit有一种能够短路的技巧<br>


