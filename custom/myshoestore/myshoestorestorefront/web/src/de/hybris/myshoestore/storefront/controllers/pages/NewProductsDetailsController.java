package de.hybris.myshoestore.storefront.controllers.pages;

import de.hybris.myshoestore.core.dao.NewProductsFrom;
import de.hybris.myshoestore.facades.newproducts.NewProductsFacade;
import de.hybris.myshoestore.storefront.controllers.ControllerConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.product.data.NewProducts;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value ="/new")
public class NewProductsDetailsController extends AbstractPageController {
    private static final String REDIRECT_TO_CREATE_PRODUCTS = REDIRECT_PREFIX + "/new/newProducts";
    //private static final String NEWPRODUCTS_CMS_PAGE = "newProductsDetails";

    private static final String FORM_GLOBAL_ERROR = "form.global.error";

    private static final NewProductsFrom newProductsFrom = new NewProductsFrom();


    @Autowired
    private NewProductsFacade newProductsFacade;
    private static final Logger LOG = Logger.getLogger(NewProductsDetailsController.class);

    @RequestMapping(value = "/newProducts", method = RequestMethod.GET)
    public String getNewProductsDetails(final Model model) throws CMSItemNotFoundException
    {
        LOG.info("######## newProductDetailsController  method ####");

        final List<NewProducts> newProductsData = newProductsFacade.getNewProductsDetails();

        model.addAttribute("newProducts", newProductsData );
        storeCmsPageInModel(model, getContentPageForLabelOrId("newProducts"));
        setUpMetaDataForContentPage(model, getContentPageForLabelOrId("newProducts"));

        return ControllerConstants.Views.Pages.Product.newProductsDetails;
    }

//========================Create Products=================================

    @RequestMapping(value = "/create_products", method = RequestMethod.GET)
    public String createProducts(final Model model) throws CMSItemNotFoundException
    {
        LOG.info("######## MyproductsController ########");
        final NewProductsFrom newProductsForm = getPreparedProductsForm();
        model.addAttribute("newProductsForm", new NewProductsFrom());
        final ContentPageModel createProductsPage = getContentPageForLabelOrId("create_products");
        storeCmsPageInModel(model, createProductsPage);
        setUpMetaDataForContentPage(model, createProductsPage);
        return ControllerConstants.Views.Pages.Product.create_products;
    }

    private NewProductsFrom getPreparedProductsForm() {
        newProductsFrom.setCode("0000");
        newProductsFrom.setName("");
        newProductsFrom.setDescription("");
        newProductsFrom.setSize("");
        newProductsFrom.setColor("");
        newProductsFrom.setPurchaseDate(0);
        return newProductsFrom;

    }


    @RequestMapping(value = "/create_products",method = RequestMethod.POST)
    public  String createProducts(final NewProductsFrom newProductsFrom, final BindingResult bindingResult, final Model model, final RedirectAttributes redirectAttributes)throws CMSItemNotFoundException{
        LOG.info("==============Post Method======================");
        if (bindingResult.hasErrors())
        {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel createProducts = getContentPageForLabelOrId("create_products");
            storeCmsPageInModel(model, createProducts);
            setUpMetaDataForContentPage(model, createProducts);
            return getViewForPage(model);
        }
        String returnAction=REDIRECT_TO_CREATE_PRODUCTS;
        final NewProducts products=new NewProducts();
        products.setCode(newProductsFrom.getCode());
        products.setName(newProductsFrom.getName());
        products.setDescription(newProductsFrom.getDescription());
        products.setSize(newProductsFrom.getSize());
        products.setColor(newProductsFrom.getColor());
        products.setPurchaseDate(newProductsFrom.getPurchaseDate());

        model.addAttribute("newProductsFrom",new NewProductsFrom());

        final ContentPageModel createProductsPage = getContentPageForLabelOrId("create_products");
        storeCmsPageInModel(model, createProductsPage);
        setUpMetaDataForContentPage(model, createProductsPage);

        newProductsFacade.createProducts(products);
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "Products Created!", null);

        return returnAction;
    }
    //========================update description=================================
    @RequestMapping(value = "/update_description", method = RequestMethod.GET)
    public String updateDescription(final Model model) throws CMSItemNotFoundException
    {
        LOG.info("######## Update description Controller ########");
        model.addAttribute("newProductsFrom", new NewProductsFrom());
        final ContentPageModel updateDescriptionPage = getContentPageForLabelOrId("update_description");
        storeCmsPageInModel(model, updateDescriptionPage);
        setUpMetaDataForContentPage(model, updateDescriptionPage);
        return ControllerConstants.Views.Pages.Product.update_description;
    }

    @RequestMapping(value="/update_description",method =RequestMethod.POST)
    public String updateDescription(final NewProductsFrom newProductsFrom,final  BindingResult bindingResult,
                                    final Model model,final RedirectAttributes redirectAttributes) throws  CMSItemNotFoundException
    {
        LOG.info("Post Update description");
        if(newProductsFrom.getCode()==null){
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "Please Enter Product code", null);
            return REDIRECT_PREFIX + "update_description";
        }
        if (newProductsFacade.getSpecificProductDetails(newProductsFrom.getCode()).isEmpty())
        {
            GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER, "Product Not Found", null);
            return REDIRECT_PREFIX + "update_description";
        }
        if (bindingResult.hasErrors())
        {
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            final ContentPageModel updateDescriptionPage = getContentPageForLabelOrId("update_description");
            storeCmsPageInModel(model, updateDescriptionPage);
            setUpMetaDataForContentPage(model, updateDescriptionPage);
            return getViewForPage(model);
        }
        String returnAction=REDIRECT_TO_CREATE_PRODUCTS;

        final List <NewProducts> newProducts = newProductsFacade.getSpecificProductDetails(newProductsFrom.getCode());

        model.addAttribute("newProductsFrom", new NewProductsFrom());

        final ContentPageModel updateDescriptionPage = getContentPageForLabelOrId("update_description");
        storeCmsPageInModel(model, updateDescriptionPage);
        setUpMetaDataForContentPage(model, updateDescriptionPage);

        newProductsFacade.updateDescription(newProductsFrom.getCode(), newProductsFrom.getDescription());

        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "Product Description Updated!", null);

        return  returnAction;
    }
    @RequestMapping(value = "/delete_product/{code}", method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable final String code,
                                 final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
    {
        LOG.info("######## MyEmployeeController ########");

        String returnAction = REDIRECT_TO_CREATE_PRODUCTS;

        newProductsFacade.removeProduct(code);
        GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.CONF_MESSAGES_HOLDER,
                "Product Removed with Code - " + code + "!" , null);

        return returnAction;
    }








}
