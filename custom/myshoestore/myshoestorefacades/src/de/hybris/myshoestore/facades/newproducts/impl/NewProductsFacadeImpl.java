package de.hybris.myshoestore.facades.newproducts.impl;

import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.myshoestore.core.service.NewProductsService;
import de.hybris.myshoestore.facades.newproducts.NewProductsFacade;
import de.hybris.myshoestore.facades.populators.NewProductsDataPopulator;
import de.hybris.myshoestore.facades.populators.NewProductsReversePopulator;
import de.hybris.platform.commercefacades.product.data.NewProducts;
import de.hybris.platform.commercewebservicescommons.dto.NewProducts.NewProductsDataWSDTO;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class NewProductsFacadeImpl implements NewProductsFacade {
    private NewProductsService newProductsService;
    private ModelService modelService;



    private NewProductsDataPopulator newProductsDataPopulator;
    private NewProductsReversePopulator newProductsReversePopulator;
    @Required
    public void setNewProductsService(final NewProductsService newProductsService)
    {
     this.newProductsService = newProductsService;
    }

    public NewProductsReversePopulator getNewProductsReversePopulator() {
        return newProductsReversePopulator;
    }

    public void setNewProductsReversePopulator(NewProductsReversePopulator newProductsReversePopulator) {
        this.newProductsReversePopulator = newProductsReversePopulator;
    }

    @Required

    public void setModelService(final ModelService modelService){
        this.modelService=modelService;
    }

    public ModelService getModelService(){
        return modelService;

    }

    public void setNewProductsDataPopulator(NewProductsDataPopulator newProductsDataPopulator) {
        this.newProductsDataPopulator = newProductsDataPopulator;
    }

    @Resource(name = "newProductsDataConverter")
    private Converter<NewProductsModel, NewProducts> newProductsDataConverter;


    private static final Logger LOG = Logger.getLogger(NewProductsFacadeImpl.class);

    @Override
    public List<NewProducts> getNewProductsDetails() {
        LOG.info("####################### newProductFacadeImpl ###################");
        final List<NewProducts> products = new ArrayList<NewProducts>();
        final List<NewProductsModel> model = newProductsService.getNewProductsDetails();
        final List<NewProducts> newProducts = newProductsDataConverter.convertAll(model);
        products.addAll(newProducts );
        return products;
    }

    @Override
    public  void createProducts(final NewProducts newProducts){
        final NewProductsModel newProductsModel=getModelService().create(NewProductsModel.class);
        getNewProductsReversePopulator().populate(newProducts,newProductsModel);
        newProductsService.createProducts(newProductsModel);
    }

    @Override
    public List<NewProducts> getSpecificProductDetails(String code) {
        LOG.info("######### ProductFacadeImpl #############");
        final List<NewProducts> product = new ArrayList<NewProducts>();
        final List<NewProductsModel> model = newProductsService.getSpecificProductDetails(code);
        final List<NewProducts> newProduct = newProductsDataConverter.convertAll(model);
        product.addAll(newProduct);
        return product;
    }

    @Override
    public void updateDescription(String code, String description) {
        LOG.info("Update Description");
        newProductsService.updateDescription(code, description);
    }

    @Override
    public void removeProduct(final String code) {

        LOG.info("-----------remove product-------");
        newProductsService.removeProduct(code);


    }

    @Override
    public void replaceProduct(NewProducts newProducts, String code) {
        LOG.info("replace Product facade");
        final NewProductsModel newProductsModel=getModelService().create(NewProductsModel.class);
        getNewProductsReversePopulator().populate(newProducts,newProductsModel);
        newProductsService.replaceProduct(newProductsModel,code);
    }




}
