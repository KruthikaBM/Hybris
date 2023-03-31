package de.hybris.myshoestore.core.dao.impl;

import de.hybris.myshoestore.core.dao.NewProductsDao;
import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;


public class NewProductsDaoImpl implements NewProductsDao {

    private static final Logger LOG = Logger.getLogger(NewProductsDaoImpl.class);

    private FlexibleSearchService flexibleSearchService;
    private ModelService modelService;

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public void setModelService(ModelService modelService){
        this.modelService=modelService;
    }

    public ModelService getModelService(){
        return modelService;
    }



    @Override
    //annotation resources
    public List<NewProductsModel> getNewProductsDetails() {
        LOG.info("NewProducts");
        String query="SELECT {PK} FROM {NewProducts}";
        FlexibleSearchQuery searchQuery=new FlexibleSearchQuery(query.toString());
        SearchResult<NewProductsModel> searchResult= flexibleSearchService.search(searchQuery);//getFlexibleSearchService
        return searchResult.getResult();
    }

    @Override
    public void createProducts(NewProductsModel newProductsModel){
        LOG.info("Create New Products");
        getModelService().save(newProductsModel);
    }

    @Override
    public List<NewProductsModel> getSpecificProductDetails(String code) {

        LOG.info("-----Specific Product Deatails--------");
        final Map<String,Object> newProducts=new HashMap<>();
        final  String query="SELECT {PK} FROM {NewProducts} WHERE {code}=?code";
        newProducts.put("code",code);
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
        searchQuery.addQueryParameters(newProducts);
        final SearchResult searchResult=flexibleSearchService.search(searchQuery);
        return searchResult.getResult()==null? Collections.emptyList():searchResult.getResult();
    }

    @Override
    public void updateDescription(String code, String description) {
        LOG.info("##### UpdateDescription ######");
        validateParameterNotNull(description, "description cannot be null");
        for(NewProductsModel newProductsModel:getSpecificProductDetails(code)){
            if(newProductsModel.getCode().equals(code)){
//                NewProductsModel nP=newProductsModel;
//                nP.setDescription(description);
                getModelService().setAttributeValue(newProductsModel,"description",description);
                getModelService().save(newProductsModel);
                getModelService().refresh(newProductsModel);
            }
        }

    }

    @Override
    public void replaceProduct(NewProductsModel newProductsModel, String code) {
        LOG.info("====replaceProduct======");
        validateParameterNotNull(newProductsModel , "Product model cannot be null, please enter product details");
        getModelService().removeAll(getSpecificProductDetails(newProductsModel.getCode()));
        getModelService().save(newProductsModel);

    }

    @Override
    public void removeProduct(List<NewProductsModel> newProductsModels) {
        LOG.info("Delete the products");
        validateParameterNotNull(newProductsModels,"product cannot be a null");
        getModelService().removeAll(newProductsModels);
    }


}
