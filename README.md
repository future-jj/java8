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

