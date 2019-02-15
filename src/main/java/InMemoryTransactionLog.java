public class InMemoryTransactionLog implements TransactionLog {
    public void logChargeResult(ChargeResult chargeResult) {
        System.out.println("Charge has been processed for " + chargeResult.getAmount());
    }

    public void logException(RuntimeException e) {
        e.printStackTrace();
    }
}
