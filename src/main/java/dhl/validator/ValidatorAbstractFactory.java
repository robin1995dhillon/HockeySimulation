package dhl.validator;

public abstract class ValidatorAbstractFactory {

    private static ValidatorAbstractFactory instance = null;

    public static ValidatorAbstractFactory instance() {

        if (instance == null) {
            instance = new ValidatorAbstractConcrete();
        }
        return instance;
    }

    public abstract IChecker getChecker();

    public abstract void setChecker(IChecker checker);

    public abstract IJSONValidator getJsonValidator();

    public abstract void setJsonValidator(IJSONValidator jsonValidator);

    public abstract IValidator getValidator();

    public abstract void setValidator(IValidator validator);
}
