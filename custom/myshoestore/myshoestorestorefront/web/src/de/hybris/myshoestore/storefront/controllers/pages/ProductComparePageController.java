/**
 *
 */
package de.hybris.myshoestore.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import de.hybris.myshoestore.facades.productCompare.impl.DefaultProductCompareFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/compare/product")
public class ProductComparePageController
{
	private static final Logger LOGGER = Logger.getLogger(ProductComparePageController.class);

	@Resource(name = "productCompareFacade")
	DefaultProductCompareFacade productCompareFacade;

	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	public ModelAndView displayCompProducts(@RequestParam
	final String prodCode, final HttpServletResponse response)
	{
		final List<ProductModel> productList = productCompareFacade.getListOfCompareProducts();

		final Cookie cookie = new Cookie("prodCode",prodCode);

		response.addCookie(cookie);

		final ProductModel productCmp = productCompareFacade.getComparedProduct(prodCode);

		final ModelAndView model = new ModelAndView("pages/product/productComparePage");
		model.addObject("productList", productList);
		model.addObject("compProd", productCmp);

		return model;
	}

}
