package de.hybris.myshoestore.facades.newproducts;

import de.hybris.platform.commercefacades.product.data.NewProducts;

import java.util.List;

public interface NewProductsFacade {
    public List<NewProducts> getNewProductsDetails();
    public void createProducts(final NewProducts newProducts);
    public List<NewProducts> getSpecificProductDetails(final String code);//without rest api


    public void updateDescription(final String code,final String description);

    public void removeProduct(final String code);
    public void replaceProduct(NewProducts newProducts,final  String code);


}
