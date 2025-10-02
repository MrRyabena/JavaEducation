import java.lang.annotation.*;
import javax.annotation.processing.AbstractProcessor;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.TypeElement;


@Target(ElementType.TYPE_USE)
@interface TypeAnno {
}

@Target(ElementType.TYPE_USE)
@interface NotZeroLen {
}

@Target(ElementType.TYPE_USE)
@interface Unique {
}

@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int value();
}

@Target(ElementType.TYPE_PARAMETER)
@interface What {
    String description();
}

@Target(ElementType.FIELD)
@interface EmptyOk {

}

@Target(ElementType.METHOD)
@interface Reccomended {
}


@SupportedAnnotationTypes("NotZeroLen")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class NotZeroLenProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
    {
        for (Element elem : roundEnv.getElementsAnnotatedWith(NotZeroLen.class)) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Zero-length array not allowed!", elem);
        }
        return true;
    }
}

public class Annotations<@What(description = "Type") T> {
    public @Unique Annotations() {
    }

    @TypeAnno
    String str;
    @EmptyOk
    String test;

    public int f(@TypeAnno Annotations<T> this, int x) {
        return 10;
    }

    public @Reccomended Integer f3(String str) {
        return str.length() / 2;
    }

    public void f4() throws @TypeAnno NullPointerException {

    }

    String @MaxLen(10) [] @NotZeroLen [] w;

    @TypeAnno
    Integer[] vec;

    public static void myMeth(int i) {
        var ob = new Annotations<@TypeAnno Integer>();
        var ob2 = new @Unique Annotations<Integer>();

        Object x = Integer.valueOf(10);
        Integer y;

        y = (@TypeAnno Integer) x;
    }

    public static void main(String[] args) {
        myMeth(10);
    }

}
