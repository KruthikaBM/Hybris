package de.hybris.myshoestore.facades.attributehandler;

import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;


public class DynamicWarrantyHandler implements  DynamicAttributeHandler<Integer,NewProductsModel>{

    int warranty=0;
    @Override
    public Integer get(NewProductsModel model) {

        int purchaseDate=model.getPurchaseDate();
        warranty=purchaseDate+5;
        return warranty;
    }

    @Override
    public void set(NewProductsModel model, Integer integer) {
        if(integer!=null){
            throw new UnsupportedOperationException();
        }

    }
}
