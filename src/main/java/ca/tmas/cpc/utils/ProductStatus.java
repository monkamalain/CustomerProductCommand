package ca.tmas.cpc.utils;

public enum ProductStatus {

    AVAILABLE("AVAILABLE"),
    UNAVAILABLE("UNAVAILABLE");

    private String status;

    ProductStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
