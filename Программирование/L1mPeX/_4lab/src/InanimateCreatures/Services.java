package InanimateCreatures;

public enum Services {
    SellPromotions("Продажа акций"),
    BuyPromotions("Покупка акций");

    private final String service;

    Services(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
