package de.hybris.myshoestore.facades.newproducts.impl;

import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.myshoestore.core.service.NewProductsService;
import de.hybris.myshoestore.facades.newproducts.NewProductsFacdeApi;
import de.hybris.myshoestore.facades.populators.NewProductsPopulatorApi;
import de.hybris.myshoestore.facades.populators.NewProductsReversePopulator;
import de.hybris.platform.commercefacades.product.data.NewProducts;
import de.hybris.platform.commercewebservicescommons.dto.NewProducts.NewProductsDataWSDTO;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class NewProductsFacadeImplApi implements NewProductsFacdeApi {
    private static final Logger LOG = Logger.getLogger(NewProductsFacadeImplApi.class);
    private  NewProductsService newProductsService;
    private NewProductsPopulatorApi newProductsPopulatorApi;
    private NewProductsReversePopulator newProductsReversePopulator;

    public NewProductsReversePopulator getNewProductsReversePopulator() {
        return newProductsReversePopulator;
    }
    public void setNewProductsReversePopulator(NewProductsReversePopulator newProductsReversePopulator) {
        this.newProductsReversePopulator = newProductsReversePopulator;
    }


    private ModelService modelService;

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public NewProductsPopulatorApi getNewProductsPopulatorApi() {
        return newProductsPopulatorApi;
    }

    public void setNewProductsPopulatorApi(NewProductsPopulatorApi newProductsPopulatorApi) {
        this.newProductsPopulatorApi = newProductsPopulatorApi;
    }

    public NewProductsService getNewProductsService() {
        return newProductsService;
    }

    public void setNewProductsService(NewProductsService newProductsService) {
        this.newProductsService = newProductsService;
    }

    @Resource(name = "newProductsDataConverterApi")
    private Converter<NewProductsModel,NewProductsDataWSDTO > newProductsDataConverterApi;

    @Override
    public List<NewProductsDataWSDTO> getSpecificProductDetailsApi(String code) {
        LOG.info("######### ProductFacadeImpl #############");
        final List<NewProductsDataWSDTO> product = new ArrayList<NewProductsDataWSDTO>();
        final List<NewProductsModel> model = getNewProductsService().getSpecificProductDetails(code);
        final List<NewProductsDataWSDTO> newProduct = newProductsDataConverterApi.convertAll(model);
        product.addAll(newProduct);
        return product;
    }
    @Override
    public void removeProduct(final String code) {

        LOG.info("-----------remove product-------");
        getNewProductsService().removeProduct(code);

    }

    @Override
    public List<NewProductsDataWSDTO> getAllProductsDetails() {
        LOG.info("####################### newProductFacadeImpl ###################");
        final List<NewProductsDataWSDTO> products = new ArrayList<NewProductsDataWSDTO>();
        final List<NewProductsModel> model = getNewProductsService().getNewProductsDetails();
        final List<NewProductsDataWSDTO> newProducts= newProductsDataConverterApi.convertAll(model);
        products.addAll(newProducts );
        return products;
    }

    @Override
    public void createProducts(NewProducts newProducts) {
        final NewProductsModel newProductsModel=getModelService().create(NewProductsModel.class);
        getNewProductsReversePopulator().populate(newProducts,newProductsModel);
        newProductsService.createProducts(newProductsModel);

    }

    @Override
    public void replaceProducts(NewProducts productsData, String code) {
        LOG.info("replace Product facade");
        final NewProductsModel newProductsModel=getModelService().create(NewProductsModel.class);
        getNewProductsReversePopulator().populate(productsData,newProductsModel);
        getNewProductsService().replaceProduct(newProductsModel,code);
    }

    @Override
    public void updateDescription(String code, String description) {
        LOG.info("Update Description");
        getNewProductsService().updateDescription(code, description);
    }


}
