package vn.amisoft.orderservice.constant;

public enum ServiceConstant {
    INVENTORY_SERVICE("lb://inventory-service/api/"),
    ORDER_SERVICE("lb://order-service/api/"),
    PRODUCT_SERVICE("lb://product-service/api/");
    private final String url;

    ServiceConstant(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
    public String url(String path) {
        return url+path;
    }
}
