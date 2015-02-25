package ddd.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    public class OrderItem {
        
        private ProductCode product;
        private Price price;
        
        public OrderItem(ProductCode product) {
            this.product = product;
        }

        public ProductCode getProduct() {
            return product;
        }

        public Price getPrice() {
            return price;
        }
    }

    private List<OrderItem> items = new ArrayList<>();
    
    public void addItem(ProductCode product) {
        items.add(new OrderItem(product));
    }

    public List<OrderItem> items(){
        return Collections.unmodifiableList(items);
    }

    public Price totalPrice(){
        Price total = Price.of("0,00");
        
        for (OrderItem orderItem : items) {
            total = total.add(orderItem.price);
        }
        
        return total;
    }
    
    public void apply(Promotion promotion, PriceList priceList) {
        
        for (OrderItem orderItem : items) {
            orderItem.price = promotion.promotionalPriceFor(orderItem.product, priceList);
        }
    }

}
