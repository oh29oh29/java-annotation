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

<hr>

#### References

> 웹 문서
> - [geeksforgeeks | Annotations in Java](https://www.geeksforgeeks.org/annotations-in-java/)
> - [baeldung | Overview of Java Built-in Annotations](https://www.baeldung.com/java-default-annotations)
> - [baeldung | Creating a Custom Annotation in Java](https://www.baeldung.com/java-custom-annotation)
> - [beginnersbook | Java Annotations tutorial with examples](https://beginnersbook.com/2014/09/java-annotations/)
