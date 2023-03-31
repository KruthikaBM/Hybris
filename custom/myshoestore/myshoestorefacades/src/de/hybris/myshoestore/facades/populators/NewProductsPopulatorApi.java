package de.hybris.myshoestore.facades.populators;

import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.platform.commercewebservicescommons.dto.NewProducts.NewProductsDataWSDTO;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class NewProductsPopulatorApi implements Populator<NewProductsModel, NewProductsDataWSDTO> {
    private static final Logger LOG = Logger.getLogger(NewProductsPopulatorApi.class);

    @Override
    public void populate(NewProductsModel newProductsModel, NewProductsDataWSDTO newProductsDataWSDTO) throws ConversionException {
        LOG.info("############### newProductsDataPopulator ###########");
        Assert.notNull(newProductsModel, "Parameter source can not be null");//traget=newProducts,source=newProductsModel
        Assert.notNull(newProductsDataWSDTO, "Parameter target can not be null");
        newProductsDataWSDTO.setCode(newProductsModel.getCode());
        newProductsDataWSDTO.setName(newProductsModel.getName());
        newProductsDataWSDTO.setDescription(newProductsModel.getDescription());
        newProductsDataWSDTO.setColor(newProductsModel.getColor());
        newProductsDataWSDTO.setSize(newProductsModel.getSize());
        newProductsDataWSDTO.setPurchaseDate(newProductsModel.getPurchaseDate());
        newProductsDataWSDTO.setWarranty(newProductsModel.getWarranty());
    }
}
