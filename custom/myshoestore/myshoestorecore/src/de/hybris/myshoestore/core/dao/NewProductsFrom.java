package de.hybris.myshoestore.core.dao;

public class NewProductsFrom {
    public String code;
    public String name;
    public  String description;
    public  String size;
    public  String color;
    public int purchaseDate;

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPurchaseDate(int purchaseDate) {
        this.purchaseDate = purchaseDate;
    }



    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getPurchaseDate() {
        return purchaseDate;
    }




}
