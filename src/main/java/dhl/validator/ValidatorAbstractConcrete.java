package dhl.validator;

public class ValidatorAbstractConcrete extends ValidatorAbstractFactory{

    IChecker checker;
    IJSONValidator jsonValidator;
    IValidator validator;

    @Override
    public IChecker getChecker() {
        if(checker == null) {
            checker = new Checker();
        }
        return checker;
    }

    @Override
    public void setChecker(IChecker checker) {
        this.checker = checker;
    }

    @Override
    public IJSONValidator getJsonValidator() {
        if(jsonValidator == null) {
            jsonValidator = new JSONValidator();
        }
        return jsonValidator;
    }

    @Override
    public void setJsonValidator(IJSONValidator jsonValidator) {
        this.jsonValidator = jsonValidator;
    }

    @Override
    public IValidator getValidator() {
        if(validator == null) {
            validator = new Validator();
        }
        return validator;
    }

    @Override
    public void setValidator(IValidator validator) {
        this.validator = validator;
    }
}
