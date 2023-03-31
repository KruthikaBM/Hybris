package de.hybris.myshoestore.core.dao;

import de.hybris.myshoestore.core.model.NewProductsModel;

import java.util.List;

public interface NewProductsDao {
    public List<NewProductsModel> getNewProductsDetails();
    public void createProducts(NewProductsModel newProductsModel);

    public List<NewProductsModel> getSpecificProductDetails(final String code);

    public void updateDescription(final String code, final String description);

    public void replaceProduct(NewProductsModel newProductsModel,final String code);
    public void removeProduct(List<NewProductsModel> newProductsModels);


}
