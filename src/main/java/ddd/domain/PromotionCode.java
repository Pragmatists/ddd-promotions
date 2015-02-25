package ddd.domain;

public class PromotionCode {

    private String code;

    public PromotionCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(!(obj instanceof PromotionCode)){
            return false;
        }
        
        PromotionCode other = (PromotionCode) obj;
        
        return this.code.equals(other.code);
    }
    
    @Override
    public String toString() {
        return code;
    }
}
