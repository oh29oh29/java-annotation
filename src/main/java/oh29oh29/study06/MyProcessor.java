package oh29oh29.study06;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public class MyProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("애노테이션 프로세싱");

        final Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(CustomAnnotation.class);

        for (Element element: elements) {
            System.out.println(element.getSimpleName());
        }

        return true;
    }
}
