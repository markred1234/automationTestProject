package BaseClass;

import org.testng.Assert;

public class Calculation {


    public double CalculateTotal(String shipping, String unitprice, String quotedPrice,String quantity) {

        String shippingPrice = shipping.replaceAll("\\$", "");
        String actualPrice = quotedPrice.replaceAll("\\$", "");
        String itemPrice = unitprice.replaceAll("\\$", "");

        System.out.println(quantity);

        Double itemTotal = Double.valueOf(itemPrice) *   Integer.parseInt(quantity);

        Double total = Double.sum(Double.valueOf(shippingPrice), itemTotal);

        Assert.assertEquals(total, Double.valueOf(actualPrice));

        return total;

    }

}