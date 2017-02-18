package pk.creditfix.app.model;

/**
 * Created by Adnan Ali on 2/17/2017.
 */

public class CustomerAcquisitionModel {

    String productName;
    int productImage;

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
