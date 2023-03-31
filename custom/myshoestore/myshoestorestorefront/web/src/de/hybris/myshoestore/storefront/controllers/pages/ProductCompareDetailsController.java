package de.hybris.myshoestore.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import de.hybris.myshoestore.facades.productCompare.impl.DefaultProductCompareFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.CookieValue;


@Controller
@RequestMapping(value = "/compare/product/details")
public class ProductCompareDetailsController
{
    private static final Logger LOGGER = Logger.getLogger(ProductCompareDetailsController.class);
    @Resource(name= "productCompareFacade")
    DefaultProductCompareFacade productCompareFacade;
    
    @RequestMapping(method = RequestMethod.GET)
    @RequireHardLogIn
    public ModelAndView productDetails(@RequestParam
    final String ID, @CookieValue(value = "prodCode", defaultValue = "0001")
    final String prodCode)
    {
        final ProductModel productCmp = productCompareFacade.getComparedProduct(ID);
        final ProductModel initialproduct = productCompareFacade.getComparedProduct(prodCode);
        
        final ModelAndView model = new ModelAndView("pages/product/productCompareDetailsPage");
        model.addObject("compProd", productCmp);
        model.addObject("initialproduct", initialproduct);
        return model;
    }
}