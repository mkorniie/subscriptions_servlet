package ua.mkorniie.model.order.paymode;

/**
 * Created by safety on 30.05.2019.
 */
public enum PayMode {
    CARD(new CardHandler()),
    ONDELIVERY(new OnDeliveryHandler()),
    CREDIT (new CreditHandler());

    private PayModeHandler handler;

    PayMode(PayModeHandler handler) {
        this.handler = handler;
    }

    public void handlePayment() {
        this.handler.handlePayment();
    }
}
