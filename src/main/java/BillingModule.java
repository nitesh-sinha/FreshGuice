import annotations.Paypal;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;


public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        // CreditCardProcessor interface annotated with @Paypal is bound to PaypalCreditCardProcessor class.
        bind(CreditCardProcessor.class).annotatedWith(Paypal.class).to(PaypalCreditCardProcessor.class);

        // CreditCardProcessor interface named with string “Bank” is bound to BankCreditCardProcessor class
        bind(CreditCardProcessor.class).annotatedWith(Names.named("Bank")).to(BankCreditCardProcessor.class);

        // CreditCardProcessor interface without any annotations is bound to BankCreditCardProcessor class
        bind(CreditCardProcessor.class).to(BankCreditCardProcessor.class);

        // All implementations of TransactionLog interface is bound to InMemoryTransactionLog
        bind(TransactionLog.class).to(InMemoryTransactionLog.class);
    }

    // Either use this method to bind BillingSevice to RealBillingService or use @Inject annotation
    // in the parametrized contructor of RealBillingService. Note that name of this method has no significance
    @Provides
    @Singleton
    public BillingService provideBillingService(CreditCardProcessor cp, TransactionLog tl) {
        return new RealBillingService(cp, tl);
    }
}