public class BankCreditCardProcessor implements CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, Double amount) {
        // Bank debits the amount

        return new ChargeResult(true , amount);
    }

}
