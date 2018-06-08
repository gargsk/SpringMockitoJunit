package yahoo.garg.sharad.springmockitojunit.validators;

import yahoo.garg.sharad.springmockitojunit.validators.annotations.ValidApiKey;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateAPIKey implements ConstraintValidator<ValidApiKey, String> {

    //private static final String SERVER_KEY;
    //private static final String CLIENT_KEY;

    @Override
    public void initialize(ValidApiKey validApiKey) {
        //SERVER_KEY = "";
        //CLIENT_KEY = "";
    }

    @Override
    public boolean isValid(String apiKey, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
