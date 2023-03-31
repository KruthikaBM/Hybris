package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.platform.commercefacades.product.data.NewProducts;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.util.Assert;

public class NewProductsReversePopulator implements Populator<NewProducts, NewProductsModel> {

    @Override
    public void populate(NewProducts newProducts, NewProductsModel newProductsModel) throws ConversionException {
        Assert.notNull(newProductsModel, "Parameter target can not be null");
        Assert.notNull(newProducts, "Parameter source can not be null");

        newProductsModel.setCode(newProducts.getCode());
        newProductsModel.setName(newProducts.getName());
        newProductsModel.setDescription(newProducts.getDescription());
        newProductsModel.setColor(newProducts.getColor());
        newProductsModel.setSize(newProducts.getSize());
        newProductsModel.setPurchaseDate(newProducts.getPurchaseDate());
    }
}
