package ddd.domain;

public class TenPercentDiscount implements Promotion {

    @Override
    public Price promotionalPriceFor(ProductCode product, PriceList priceList) {
        return priceList.priceFor(product);
    }

}
