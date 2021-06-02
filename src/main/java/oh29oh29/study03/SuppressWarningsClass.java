package oh29oh29.study03;

public class SuppressWarningsClass {

    private DeprecatedClass deprecatedClass = new DeprecatedClass();

    @SuppressWarnings("deprecation")
    public void myMethod() {
        deprecatedClass.deprecatedMethod();
    }
}
