package ru.nsu.yadryshnikova.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PizzeriaConfiguration {
    @JsonProperty("cook_configuration")
    CookConfiguration cookConfiguration;

    @JsonProperty("delivery_configuration")
    DeliveryConfiguration deliveryConfiguration;

    @JsonProperty("warehouse_configuration")
    WarehouseConfiguration warehouseConfiguration;

    @JsonProperty("queue_limit")
    Integer queueLimit = 0;

    @JsonProperty("pizza_cooking_time_ms")
    Integer pizzaCookingTime = 0;

    public CookConfiguration getCookConfiguration() {
        return cookConfiguration;
    }

    public void setCookConfiguration(CookConfiguration cookConfiguration) {
        this.cookConfiguration = cookConfiguration;
    }

    public DeliveryConfiguration getDeliveryConfiguration() {
        return deliveryConfiguration;
    }

    public void setDeliveryConfiguration(DeliveryConfiguration deliveryConfiguration) {
        this.deliveryConfiguration = deliveryConfiguration;
    }

    public WarehouseConfiguration getWarehouseConfiguration() {
        return warehouseConfiguration;
    }

    public void setWarehouseConfiguration(WarehouseConfiguration warehouseConfiguration) {
        this.warehouseConfiguration = warehouseConfiguration;
    }

    public Integer getQueueLimit() {
        return queueLimit;
    }

    public void setQueueLimit(Integer queueLimit) {
        this.queueLimit = queueLimit;
    }

    public Integer getPizzaCookingTime() {
        return pizzaCookingTime;
    }

    public void setPizzaCookingTime(Integer pizzaCookingTime) {
        this.pizzaCookingTime = pizzaCookingTime;
    }

    public PizzeriaConfiguration() {
        cookConfiguration = new CookConfiguration();
        deliveryConfiguration = new DeliveryConfiguration();
        warehouseConfiguration = new WarehouseConfiguration();
    }

    public static class CookConfiguration {
        Integer number = 0;
        Integer[] experience = new Integer[0];

        public Integer getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Integer[] getExperience() {
            return experience;

        }

        public void setExperience(Integer[] experience) {
            this.experience = experience;
        }
    }


    public static class DeliveryConfiguration {
        Integer number = 0;
        @JsonProperty("trunk_capacity")
        Integer [] trunkCapacity = new Integer[0];

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer[] getTrunkCapacity() {
            return trunkCapacity;
        }

        public void setTrunkCapacity(Integer[] trunkCapacity) {
            this.trunkCapacity = trunkCapacity;
        }
    }

    public static class WarehouseConfiguration {
        Integer capacity = 0;

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }
}
