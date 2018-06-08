package yahoo.garg.sharad.springmockitojunit.validators.annotations;

import yahoo.garg.sharad.springmockitojunit.validators.ValidateAPIKey;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { ValidateAPIKey.class })
public @interface ValidApiKey {
    String message () default "Invalid API Key supplied";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;
}
