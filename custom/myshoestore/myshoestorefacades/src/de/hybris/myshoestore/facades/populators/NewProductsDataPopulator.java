package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.platform.commercefacades.product.data.NewProducts;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class NewProductsDataPopulator implements Populator<NewProductsModel, NewProducts> {
    private static final Logger LOG = Logger.getLogger(NewProductsDataPopulator.class);

    @Override
    public void populate(NewProductsModel newProductsModel, NewProducts newProducts) throws ConversionException {
        LOG.info("############### newProductsDataPopulator ###########");
        Assert.notNull(newProductsModel, "Parameter source can not be null");//traget=newProducts,source=newProductsModel
        Assert.notNull(newProducts, "Parameter target can not be null");
        newProducts.setCode(newProductsModel.getCode());
        newProducts.setName(newProductsModel.getName());
        newProducts.setDescription(newProductsModel.getDescription());
        newProducts.setColor(newProductsModel.getColor());
        newProducts.setSize(newProductsModel.getSize());
        newProducts.setPurchaseDate(newProductsModel.getPurchaseDate());
        newProducts.setWarranty(newProductsModel.getWarranty());



    }
}
