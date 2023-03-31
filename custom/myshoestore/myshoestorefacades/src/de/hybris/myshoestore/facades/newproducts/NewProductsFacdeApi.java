package de.hybris.myshoestore.facades.newproducts;

import de.hybris.platform.commercefacades.product.data.NewProducts;
import de.hybris.platform.commercewebservicescommons.dto.NewProducts.NewProductsDataWSDTO;

import java.util.List;

public interface NewProductsFacdeApi {
    public List<NewProductsDataWSDTO> getSpecificProductDetailsApi(final String code);

    public void removeProduct(String code);

    public  List<NewProductsDataWSDTO> getAllProductsDetails();

    public void createProducts(NewProducts newProducts);

    public void replaceProducts(NewProducts productsData, String code);

    public void updateDescription(String code, String description);
}
