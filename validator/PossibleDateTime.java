package validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PossibleDateTimeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PossibleDateTime {

    String message() default "Invalid date format";

    Class<?>[] groups() default {};

    String pattern() default "";

    String[] fallbackPatterns() default {};

    Class<? extends Payload>[] payload() default {};

}