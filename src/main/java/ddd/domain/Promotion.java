package ddd.domain;

public interface Promotion {

    Price promotionalPriceFor(ProductCode product, PriceList priceList);

}
