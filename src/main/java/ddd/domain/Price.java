package ddd.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Price {

    private int priceInCents;

    private Price(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public static void main(String[] args) {
        
    }
    
    public static Price of(String price) {
        
        Pattern pattern = Pattern.compile("(\\d+),(\\d{2})");
        Matcher matcher = pattern.matcher(price.trim());
        if(!matcher.matches()){
            throw new IllegalArgumentException("Invalid price: " + price);
        }
        
        int dollars = Integer.parseInt(matcher.group(1));
        int cents = Integer.parseInt(matcher.group(2));
        
        return new Price(dollars*100 + cents);
    }

    @Override
    public int hashCode() {
        return priceInCents;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(!(obj instanceof Price)){
            return false;
        }
        
        Price other = (Price) obj;
        
        return this.priceInCents == other.priceInCents;
    }
    
    @Override
    public String toString() {
        return String.format("%d,%02d", priceInCents/100, priceInCents%100);
    }

    public Price add(Price other) {
        return new Price(this.priceInCents + other.priceInCents);
    }
}
