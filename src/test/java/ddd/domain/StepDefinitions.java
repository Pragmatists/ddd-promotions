package ddd.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ddd.domain.Order.OrderItem;

public class StepDefinitions {

    private Map<PromotionCode, Promotion> promotions = new HashMap<PromotionCode, Promotion>(){{
        put(new PromotionCode("10% discount"), new TenPercentDiscount());
    }};
    
    private PriceList priceList = new PriceList();
    private Order order = new Order();
    
    @Given("^there is following Price List:$")
    public void there_is_following_Price_List(DataTable prices) throws Throwable {

        for(Map<String, String> row: prices.asMaps(String.class, String.class)){
            priceList.definePriceFor(new ProductCode(row.get("Product")), Price.of(row.get("Price")));
        }
    }

    @When("^I puchase \"(.*?)\" and \"(.*?)\"$")
    public void i_puchase_and(String item1, String item2) throws Throwable {
        
        order.addItem(new ProductCode(item1));
        order.addItem(new ProductCode(item2));
    }

    @When("^apply promotion \"(.*?)\"$")
    public void apply_promotion(String promotion) throws Throwable {
        
        Promotion p = promotions.get(new PromotionCode(promotion));
        
        order.apply(p, priceList);
    }

    @Then("^I should get:$")
    public void i_should_get(DataTable expected) throws Throwable {

        List<List<String>> raw = new ArrayList<>();
        
        raw.add(Arrays.asList("Product", "Price"));
        for(OrderItem o: order.items()){
            List<String> row = Arrays.asList("" + o.getProduct(), "" + o.getPrice());
            raw.add(row);
        }
        raw.add(Arrays.asList("Total", "" + order.totalPrice()));
        
        DataTable actual = DataTable.create(raw, Locale.ENGLISH, "Product", "Price");
        expected.diff(actual);
    
    }
    
}
