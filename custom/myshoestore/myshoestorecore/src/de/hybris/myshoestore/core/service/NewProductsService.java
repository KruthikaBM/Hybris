package de.hybris.myshoestore.core.service;

import de.hybris.myshoestore.core.model.NewProductsModel;

import java.util.List;

public interface NewProductsService {
    public List<NewProductsModel> getNewProductsDetails();
    public void createProducts(NewProductsModel newProductsModel);
    public List<NewProductsModel> getSpecificProductDetails(final String code);
    public void updateDescription(final String code,final String description);


    public void removeProduct(final String code);
    public void replaceProduct(NewProductsModel newProductsModel,final String code);
}
