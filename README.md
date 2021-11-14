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
方法引用有三个
（1）、指向静态方法的方法引用（Integer 的parseInt方法写作Integer::parseInt）<br>
（2）、指向任意实例对象的方法引用(String::length)<br>
（3）、调用了外部的对象，假设局部变量expensiveTransaction<br>