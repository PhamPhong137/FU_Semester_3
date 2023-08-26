/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_trung;

public class Car {

    private String carId;
    private String brandId;
    private String color;
    private String frameId;
    private String engineId;

    public Car(String carId, String brandId, String color, String frameId, String engineId) {
        this.carId = carId;
        this.brandId = brandId;
        this.color = color;
        this.frameId = frameId;
        this.engineId = engineId;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getColor() {
        return color;
    }

    public String getFrameId() {
        return frameId;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    @Override
    public String toString() {
        return carId + ", " + brandId + ", " + color + ", " + frameId + ", " + engineId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
