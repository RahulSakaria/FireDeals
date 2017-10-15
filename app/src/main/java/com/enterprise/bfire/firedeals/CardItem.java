package com.enterprise.bfire.firedeals;

/**
 * Created by HP on 06-10-2017.
 */

public class CardItem {
    String productName;
    String productType;
    String price;
    String pros1;
    String pros2;
    String pros3;
    String cons1;
    String cons2;
    String cons3;
    String imageLink;
    String affiliateLink;

    /*public CardItem(String productName, String productType, String price, String pros1, String pros2, String pros3, String cons1, String cons2,String cons3, String imageLink, String affiliateLink){
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.pros1 = pros1;
        this.pros2 = pros2;
        this.pros3 = pros3;
        this.cons1 = cons1;
        this.cons2 = cons2;
        this.cons3 = cons3;
        this.imageLink = imageLink;
        this.affiliateLink = affiliateLink;
    }*/

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPros1() {
        return pros1;
    }

    public void setPros1(String pros1) {
        this.pros1 = pros1;
    }

    public String getPros2() {
        return pros2;
    }

    public void setPros2(String pros2) {
        this.pros2 = pros2;
    }

    public String getCons1() {
        return cons1;
    }

    public void setCons1(String cons1) {
        this.cons1 = cons1;
    }

    public String getCons2() {
        return cons2;
    }

    public void setCons2(String cons2) {
        this.cons2 = cons2;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getAffiliateLink() {
        return affiliateLink;
    }

    public void setAffiliateLink(String affiliateLink) {
        this.affiliateLink = affiliateLink;
    }

    public String getPros3() {
        return pros3;
    }

    public void setPros3(String pros3) {
        this.pros3 = pros3;
    }

    public String getCons3() {
        return cons3;
    }

    public void setCons3(String cons3) {
        this.cons3 = cons3;
    }

}
