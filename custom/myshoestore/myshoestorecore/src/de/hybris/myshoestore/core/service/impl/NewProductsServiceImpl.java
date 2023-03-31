package de.hybris.myshoestore.core.service.impl;

import de.hybris.myshoestore.core.dao.NewProductsDao;
import de.hybris.myshoestore.core.model.NewProductsModel;
import de.hybris.myshoestore.core.service.NewProductsService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewProductsServiceImpl implements NewProductsService {
    private NewProductsDao newProductsDao;
    private static final Logger LOG = Logger.getLogger(NewProductsServiceImpl.class);
    @Required
    public void setNewProductsDao(final NewProductsDao newProductsDao) {
        this.newProductsDao= newProductsDao;
    }

    @Override
    public List<NewProductsModel> getNewProductsDetails() {
        LOG.info("########################### NewProductsServiceImpl ###############");
        return newProductsDao.getNewProductsDetails();
    }
    @Override
    public void createProducts(NewProductsModel newProductsModel){
        LOG.info("------Create Products in Service-------");
        newProductsDao.createProducts(newProductsModel);
    }

    @Override
    public List<NewProductsModel> getSpecificProductDetails(String code) {
        LOG.info("------Specific Products in Service-------");
        return newProductsDao.getSpecificProductDetails(code) ;
    }

    @Override
    public void updateDescription(String code, String description) {
        LOG.info("-----Update description---------");
        newProductsDao.updateDescription(code, description);
    }

    @Override
    public void removeProduct(final String code) {
        LOG.info("----------------remove product----------");
        List<NewProductsModel> pro=newProductsDao.getSpecificProductDetails(code);
        newProductsDao.removeProduct(pro);
    }

    @Override
    public void replaceProduct(NewProductsModel newProductsModel, String code) {
        LOG.info("------------replace description-----------");
        newProductsDao.replaceProduct(newProductsModel,code);
    }

}
