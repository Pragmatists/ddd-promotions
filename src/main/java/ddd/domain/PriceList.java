package ddd.domain;

import java.util.HashMap;
import java.util.Map;

public class PriceList {

    private Map<ProductCode, Price> prices = new HashMap<>();
    
    public void definePriceFor(ProductCode product, Price price) {
        prices.put(product, price);
    }

    public Price priceFor(ProductCode product) {
        
        Price price = prices.get(product);
        
        if(price == null){
            throw new IllegalStateException("No price for: " + product);
        }
        
        return price;
    }

}
