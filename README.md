# Dependency 
Dependency - зависимость одного класса от другого, посредством представления первому обьекта второго.
```java
class ClassA {
var classB: Class
  fun someMethodOrConstructor() {
    classB = ClassB()
     classB.doSomething()
  }
}
```
Внутри класса А мы вызываем класс B.
Такой вариант имеент место быть, но вместе с ним приходят проблемы:
1. ClassA и ClassB тесно связаны друг с другом. Поэтому всякий раз, когда нам нужно использовать ClassA, мы будем вынуждены использовать и ClassB, и заменить ClassB чем-то другим будет невозможно.
2. При любом изменении в инициализации класса ClassB потребуется корректировать код и внутри класса ClassA (и всех остальных зависимых от ClassB классов). Это усложняет процесс изменения зависимости.
3. ClassA невозможно протестировать. Если вам необходимо протестировать класс, а ведь это один из важнейших аспектов разработки ПО, то вам придётся проводить модульное тестирование каждого класса в отдельности. Это означает, что если вы захотите проверить корректность работы исключительно класса ClassA и создадите для его проверки несколько модульных тестов, то, как это было показано в примере, вы в любом случае создадите и экземпляр класса ClassB, даже когда он вас не интересует. 

Поэтому мы не хотим, чтобы классы отвечали за что-либо, кроме своих собственных задач. Внедрение зависимостей при этом является дополнительной задачей, которую мы ставим перед ними.
Один из возможных вариантов это сделать - внедрение зависиомстей.
***
## Dependency Injection

> Внедрение зависимостей (DI) - это способ обработки зависимостей вне зависимого класса.
```java
class ProvideSomeClass {

  fun provideClassC(){
    return ClassC() 
  }

  fun provideClassB(classC: ClassC){
    return ClassB(classC)
  }

  fun provideClassA(classB: ClassB){
    return ClassA(classB)
  }
}
```
В данном примере зависимости предоставляются через третий класс. У такого варианта много плюсов:

1. Все максимально просто. И зависимый класс, и класс, предоставляющий зависимости, понятны и просты.
2. Классы слабо связаны и легко заменяемы другими классами. Допустим, мы хотим заменить ClassC на AssumeClassC, который является подклассом ClassC. Для этого нужно лишь изменить код провайдера следующим образом, и везде, где используется ClassC, теперь автоматически будет использоваться новая версия:
3. Обратите внимание, никакой код внутри приложения не меняется, только метод провайдера. Кажется, что ничего не может быть ещё проще и гибче.
4. Отличная тестируемость. Можно легко заменить зависимости тестовыми версиями во время тестирования. Фактически, внедрение зависимостей — ваш главный помощник, когда речь заходит о тестировании.
5. Улучшение структуры кода, т.к. в приложении есть отдельное место для обработки зависимостей. В результате остальные части приложения могут сосредоточиться на выполнении исключительно своих функций и не пересекаться с зависимостями.

Из минусов можно указать определенный порог вхождения, нужно много в чем разобраться.

Так же нужно придерживаться одного из принципов SOLID - принципа инверсии зависимостей(IOC). Он подразумевает

>Объектом зависимости должна быть абстракция, а не что-то конкретное.
1. Модули верхних уровней не должны зависеть от модулей нижних уровней. Оба типа модулей должны зависеть от абстракций.
2. Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций.

Проблемы, которые решает внедрение IOC в проект:
1. Жесткость. Изменение одного модуля ведет к изменению других модулей.
2. Хрупкость. Изменения в одной части приводят к неконтролируемым ошибкам в других частях программы.
3. Неподвижность. Модуль сложно отделить от остальной части приложения для повторного использования.

## Dagger2
Dagger2 - фреймворк, позволяющий реализовать паттерн DI и принцип IOC.

Плюсы:
- Простой доступ к “расшаренным” реализациям.
- Простая настройка сложных зависимостей. Чем больше у вас приложение, тем больше становится зависимостей. Dagger 2 позволяет вам по-прежнему легко контролировать все зависимости.
- Облегчение Юнит-тестирования и интеграционного тестирования.
- Кодогенерация. Полученный код понятен и доступен для отладки.
- Малые размеры библиотеки.

### Основные аннотации библиотеки
- @Inject - аннотация для полей, конструкторов, методов, которая показывает какие зависимости нужно предоставить в данный класс.
[Пример](https://github.com/BLRHennessy/DaggerUtils/blob/master/app/src/main/java/by/makarevich/daggerutils/ui/activity/AuthActivity.kt)
- @Module – аннотация которая определяет класс, из которого будут обеспечиваться зависимости.
[Пример](https://github.com/BLRHennessy/DaggerUtils/blob/master/app/src/main/java/by/makarevich/daggerutils/dagger/application/AppModule.kt)
- @Provides - аннотация которая определяет метод, предоставляющий зависимость. Описываются в @Module классе.
[Пример](https://github.com/BLRHennessy/DaggerUtils/blob/master/app/src/main/java/by/makarevich/daggerutils/dagger/application/AppModule.kt)
- @Component -  аннотация определяющая класс, который будет «связующим звеном» между @Module и @Inject, внутри определяются классы, в которые будут вставлятся поля. Возможно создавать наследников @Subcomponent, с функционалом предков.
[Пример](https://github.com/BLRHennessy/DaggerUtils/blob/master/app/src/main/java/by/makarevich/daggerutils/dagger/application/AppComponent.kt)
- @Scope – аннотация, создающая механизм, реализующий создание и хранение единственного экземпляра необходимого класса до тех пор, пока соответствующий scope существует (default scope annotation - Singleton).
[Объявление](https://github.com/BLRHennessy/DaggerUtils/blob/master/app/src/main/java/by/makarevich/daggerutils/dagger/Scopes.kt) [Реализация](https://github.com/BLRHennessy/DaggerUtils/blob/master/app/src/main/java/by/makarevich/daggerutils/dagger/activity/AuthActivityComponent.kt)
- @Qualifire - аннотация, создающий механизм, реализующий возможность создание нескольких зависимостей одного типа (default qualifier annotation - Named)

### Структура сгенерированного файла

1)Для каждого component Dagger генерирует один final class с названием Dagger+[Имя компонента] который имплементит компонент.
 Внутри объявляются все поля, которые провайдятся в модулях или наследуются из модулей [dependency component]. 
Конструктор принимает на вход обьекты всех своих и зависимых модулей. В методе Builder инициализируется статичексий инстанс класса Builder, описанный ниже.
Внутри создается класс Builder который можно переопределить в компоненте. У него есть методы сеттеров модулей и зависимых модулей а так же метод build, который создает обьект компонента. Так же есть метод get для каждого поля зависимых модулей.

2)Для каждого предоставленного в модуле класса, создается отдельный класс с названием [Имя_модуля]+[Имя_метода для провайда]+[Factory]
Внутри объявляются модули компонента и поля зависимых модулей. В конструктор принимаются они же.
Есть три метода 
•	Метод [Имя_метода для провайда] – который возвращает обьект, проинициализированный в модуле.
•	create() – метод инициализирующий данный класс со всеми нужными полями (вызывается в классе компонента, описанного выше) 
•	get() – метод возвращающий первый [Имя_метода для провайда]


