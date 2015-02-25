package ddd.domain;

public class ProductCode {

    private String code;

    public ProductCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(!(obj instanceof ProductCode)){
            return false;
        }
        
        ProductCode other = (ProductCode) obj;
        
        return this.code.equals(other.code);
    }
    
    @Override
    public String toString() {
        return code;
    }
}
