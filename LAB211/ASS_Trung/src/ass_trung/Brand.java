/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_trung;

public class Brand {
    private String brandId;
    private String brandName;
    private String soundBrand;
    private double price;

    public Brand(String brandId, String brandName, String soundBrand, double price) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return brandId + ", " + brandName + ", " + soundBrand + ": " + price;
    }
}
