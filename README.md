# Java Annotation

애노테이션은 바인딩된 코드에 메타 데이터를 추가할 수 있다.  
애노테이션은 Java 5 부터 추가되었다.  

#### 애노테이션의 용도

- 애노테이션은 컴파일러에게 경고 및 오류에 대해 알린다.  
기본적으로 `@Deprecated`, `@Override`, `@SuppressWarnings` 세 가지 애노테이션을 제공한다.  
예를 들어 `@Override` 애노테이션은 메서드가 재정의 되었음을 컴파일러에게 알려주는데 사용된다.
- 애노테이션은 컴파일 타임에 명령을 제공할 수 있으며, 이 명령어는 코드, XML 파일 등을 생성하기 위한 소프트웨어 빌드 도구에 의해 추가로 사용될 수 있다.
- Java 리플렉션을 사용하여 런타임에 접근할 수 있는 애노테이션을 정의할 수 있고, 해당 애노테이션으로 런타임에 명령을 제공할 수 있다.  

#### 애노테이션을 정의하는 방법

애노테이션은 항상 기호 `@`에 이름을 붙여서 정의한다.  
기호 `@`는 애노테이션임을 컴파일러에게 알려준다.  

#### 애노테이션을 사용할 수 있는 곳

애노테이션은 클래스, 인터페이스, 메서드 및 필드에 적용할 수 있다.

## Built-in Annotations

#### @Override

자식 클래스의 메서드를 재정의할 때 이 애노테이션을 사용하여 해당 메서드를 표시할 수 있다.  
해당 애노테이션을 붙이면 코드 유지보수에 도움이 된다.  
만약, 상위 클래스의 메서드 시그니처가 변경되면 해당 애노테이션을 붙인 자식 클래스의 재정의된 메서드 시그니처도 변경해야 한다.  
그렇지 않으면 컴파일러가 컴파일 오류를 발생시킨다.  
이 애노테이션을 붙이지 않았다면 컴파일 오류가 발생하지 않아 추적하기 어려울 수 있다.  

```java
public class AnnotationSuper {

    public void print() {
        System.out.println("This is Super Class");
    }
}
```
```java
public class AnnotationSub extends AnnotationSuper {

    @Override
    public void print() {
        System.out.println("This is Sub Class");
    }
}
```

#### @Deprecated

해당 애노테이션은 표시된 요소(클래스, 메서드 또는 필드)가 더이상 사용되지 않음 및 사용되지 않아야 함을 나타낸다.  
컴파일러는 애플리케이션에서 해당 애노테이션이 붙은 클래스, 메서드 또는 필드를 사용할 때마다 경고를 표시한다.  
요소가 사용되지 않는 경우 다음 예와 같이 Javadoc `@deprecated` 태그를 사용하여 문서화해야 한다.  
`@deprecated` 는 문서 용도로 사용된다.

```java
public class AnnotationStudy {

    /**
     * @deprecated
     * reason for why it was deprecated
     */
    @Deprecated
    public void anyMethodHere(){
        // Do something
    }
}
```

#### @SuppressWarnings

해당 애노테이션은 컴파일러에게 특정 경고를 무시하도록 지시한다.  
예를 들어, 더이상 사용되지 않는 메서드에 `@Deprecated` 애노테이션을 붙여 어딘가에서 사용하게 될 경우 경고를 표시해야 하지만, 해당 애노테이션을 붙이면 경고를 억제한다.  

```java
public class DeprecatedClass {
    
    @Deprecated
    public void deprecatedMethod() {
        System.out.println("This is Deprecated Method..");
    }
}
```
```java
public class SuppressWarningsClass {
    
    private DeprecatedClass deprecatedClass = new DeprecatedClass();
    
    @SuppressWarnings("deprecation")
    public void myMethod() {
        deprecatedClass.deprecatedMethod();
    }
}
```

## Creating Custom Annotations

애노테이션은 아래 예와 같이 `@interface` 를 사용하여 작성되고 이름이 뒤에 나온다.

애노테이션에는 요소도 포함될 수 있다. 예를 들어 아래 코드에는 세가지 요소가 있고, 이러한 요소들에 대한 구현을 제공하지는 않는다.

모든 애노테이션은 `java.lang.annotation.Annotation` 인터페이스를 상속받는다. 그러나 애노테이션은 상속이 허용되지 않는다. 상속이안됨에도 불구하고 컴파일한 뒤에는 상속이 되어 있다. 

```java
@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    int age() default 20;
    String name();
    String introduce() default "Hello";
}
```

모든 요소들은 기본값을 지정할 수 있고, 기본값이 지정된 요소들은 별도 값을 설정하지 않을 수 있다.

```java
@MyCustomAnnotation(
        name = "hyukjae"
)
public class MyClass {
}
```

#### @Documented

@Documented 애노테이션은 Custom 애노테이션을 사용하는 요소가 JavaDoc 에 의해 문서화되어야 함을 나타낸다.

#### @Target

Custom 애노테이션을 사용할 수 있는 위치를 지정한다.  
만약 @Target 을 특별히 지정하지 않았다면 모든 요소에 Custom 애노테이션을 사용할 수 있음을 의미한다.

#### @Inherited

Custom 애노테이션을 사용하는 클래스는 모든 하위 클래스에도 Custom 애노테이션이 상속된다. 

#### @Retention

Custom 애노테이션이 유지되는 기간을 나타낸다.  

- RetentionPolicy.RUNTIME: 클래스 파일에 존재하며 런타임에 사용 가능하다.
- RetentionPolicy.CLASS: 클래스 파일에 존재하며 런타임에 사용 불가능하다. (기본값)
- RetentionPolicy.SOURCE: 소스 파일에만 존재. 클래스파일에는 존재하지 않는다.

## Annotation Processor

애노테이션들이 실제 코드에 녹아지고 사용되기 위해서는 애노테이션 프로세싱이라는 과정이 필요하다.  
애노테이션 프로세싱은 컴파일 타임에 애노테이션들을 스캐닝하고 프로세싱하는 javac 에 속한 빌드툴이다.  

특정 애노테이션들을 위해 애노테이션 프로세서를 만들어서 등록할 수 있다.  
특정 애노테이션을 위한 애노테이션 프로세서는 자바 코드를 인풋으로 받아서 아웃풋으로 파일을 생성한다.

#### AbstractProcessor

모든 프로세서들은 AbstractProcessor 를 상속받아야 한다.  

init(ProcessingEnvironment processingEnv)

모든 애노테이션 프로세서 클래스는 empty 생성자를 반드시 가져야한다.  
대신, ProcessingEnvironment 를 매개변수로 받아 애노테이션 프로세싱 툴이 호출하는 특별한 init() 메서드를 가지고 있다.  
ProcessingEnvironment 는 Elements, Types, Filer 와 같이 유용한 유틸 클래스들을 제공한다.

process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
  
각각의 프로세서의 main() 메서드의 역할을 한다. 여기에 애노테이션을 스캐닝, 평가 및 처리하고 Java 파일 생성을 위한 코드를 작성한다.  
RoundEnvironment 매개변수로 특정 애노테이션이 달린 것들을 찾을 수 있다.

getSupportedAnnotationTypes()

여기에 애노테이션 프로세서가 처리할 애노테이션들을 명시한다.  
리턴 타입은 이 애노테이션 프로세서가 처리하길 원하는 애노테이션의 full qualified name 을 포함한 Set<String> 이다.  
즉, 여기에 애노테이션 프로세서가 처리하길 원하는 애노테이션들을 정의해야한다.  

getSupportedSourceVersion()

사용하는 특정 Java 버전을 명시하는데 사용한다.  
보통 SourceVersion.latestSupported() 를 리턴하면 된다.

<hr>

#### References

> 웹 문서
> - [geeksforgeeks | Annotations in Java](https://www.geeksforgeeks.org/annotations-in-java/)
> - [baeldung | Overview of Java Built-in Annotations](https://www.baeldung.com/java-default-annotations)
> - [baeldung | Creating a Custom Annotation in Java](https://www.baeldung.com/java-custom-annotation)
> - [beginnersbook | Java Annotations tutorial with examples](https://beginnersbook.com/2014/09/java-annotations/)
> - [hannesdorfmann | Annotation Processing 101](https://hannesdorfmann.com/annotation-processing/annotationprocessing101/)
