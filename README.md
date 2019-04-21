# Arithmetic

## 面向对象的六大原则

1.单一职责原则  

> Single Responsibility Principle，简称SRP；  
> 定义：就一个类而言，应该仅有一个引起它变化的原因（一个类中应该是一组相关性很高的函数、数据的封装）

2.开闭原则  

> Open Close Principle，缩写OCP  
> 定义：软件中的对象（类、模块、函数等）应该对于扩展开放，但对于修改封闭（依赖抽象）

3.里氏替换原则  

> Liskov Substitution Principle，缩写LSP  
> 定义：如果对每一个类型为S的对象O1，都有类型为T的对象O2，使得以T定义的所有程序P在所有的O1对象都代换
成O2时，程序P的行为没有发生变化，那么类型S是类型T的子类型  
> 第二种定义：所有引用类的地方必须能透明地使用其子类的对象（继承，父类能出现的地方，子类也能出现）

4.依赖倒置原则  

> Dependence Inversion Principle，缩写DIP  
> 指代了一种特定的解耦形式，使得高层次的模块不依赖于低层次的模块的实现细节，依赖模块被颠倒了
（模块间的依赖通过抽象发生，实现类之间不发生直接依赖关系，依赖关系通过接口或抽象类产生）  
>
> 几个关键点：  
> （1）高层模块不应该依赖于低层模块，两者都应该依赖抽象  
> （2）抽象不应该依赖细节  
> （3）细节应该依赖抽象  

5.接口隔离原则  

> InterfaceSegregation Principle，缩写ISP  
> 定义：客户端不应该依赖它不需要的接口（类间的依赖关系应建立在最小的接口上）  

6.迪米特原则  

> Law of Demeter，缩写LOD，又称最少知识原则  
> 定义：一个对象应该对其他对象有最少的了解（一个类应对自己耦合或调用的类知道得最少，类的内部实现与
调用者或者依赖者没有任何关系）  

## 设计模式

- [单例模式](./src/designmodel/singleton)  
    1.[懒汉模式](./src/designmodel/singleton/Singleton1.java)  
    2.[线程安全的懒汉式](./src/designmodel/singleton/Singleton2.java)  
    3.[饿汉式](./src/designmodel/singleton/Singleton3.java)  
    4.[双重检验（DCL）](./src/designmodel/singleton/Singleton4.java)  
    5.[内部类形式](./src/designmodel/singleton/Singleton5.java)  
    6.[枚举单例](./src/designmodel/singleton/Singleton.java)  

- [Builder模式](./src/designmodel/builder)  
    定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示  
    使用场景：  
    > （1）相同的方法，不同的执行顺序，产生不同的时间结果  
    > （2）多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时  
    > （3）产品类非常复杂，或者产品类中的调用顺序不同产生了不同的作用  
    > （4）当初始化一个对象特别复杂，如参数多，且很多参数都具有默认值时

- [原型模式](./src/designmodel/prototype)  
    定义：用原型示例指定创建对象的种类，并通过拷贝这些原型创建新的对象  
    使用场景：  
    > （1）类初始化需要消化非常多的资源，可以通过原型拷贝减少这些消耗   
    > （2）通过new产生一个对象需要繁琐的数据准备或访问权限  
    > （3）一个需要提供给其他对象访问，而且各个调用者可能都需要修改，可以通过拷贝对象供其使用（保护性拷贝）  

- [工厂模式](./src/designmodel/factory)  
    定义：定义一个用于创建对象的接口，让子类决定实例化哪个类  
    使用场景：任何需要生成复杂对象的地方  

- [抽象工厂模式](./src/designmodel/factory/abstractfactory)  
    定义：为创建一组相关或者是相互依赖的对象提供一个接口，而不需要指定它们的具体类

- [策略模式](./src/designmodel/strategy)  
    定义：策略模式定义了一些的算法，并将每一个算法封装起来，而且使它们还可以相互替换。让算法独立于使用它的客户而独立变化  
    使用场景：  
    > （1）针对同一类型问题的多种处理方式，仅仅是具体行为有差别  
    > （2）需要安全地封装多种同一类型的操作时  
    > （3）出现同一抽象类有多个子类，而又需要使用if-else或者switch-case来选择子类时  

## 一些算法记录，Java实现

- [递归经典——斐波那契数列](./src/acm/Fib.java)
- [深度优先遍历](./src/acm/DFS.java)
- [宽度优先遍历](./src/acm/BFS.java)


## 剑指offer的算法