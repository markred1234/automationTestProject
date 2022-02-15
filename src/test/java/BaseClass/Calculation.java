package BaseClass;

import org.testng.Assert;

public class Calculation {


    public double CalculateTotal(String shipping, String item, String quotedPrice,String productQuantity) {

        //Removing $ from value for calculation
        String shippingPrice = shipping.replaceAll("\\$", "");
        String actualPrice = quotedPrice.replaceAll("\\$", "");
        String itemPrice = item.replaceAll("\\$", "");

        Double itemTotal = Double.valueOf(itemPrice) *   Integer.parseInt(productQuantity);

        Double total = Double.sum(Double.valueOf(shippingPrice), itemTotal);
        Assert.assertEquals(total, Double.valueOf(actualPrice));

        return total;

    }

}