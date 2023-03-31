package de.hybris.myshoestore.storefront.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.PreValidateCheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.PreValidateQuoteCheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.CheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.checkout.steps.AbstractCheckoutStepController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import javax.annotation.Resource;

import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.myshoestore.facades.loyalty.impl.DefaultLoyaltyPointsFacade;
import de.hybris.myshoestore.facades.LoyaltyData;
import de.hybris.myshoestore.storefront.controllers.ControllerConstants;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
@RequestMapping(value = "/checkout/multi/loyalty-points")
public class LoyaltyPointsCheckoutStepController extends AbstractCheckoutStepController
{
	@Resource(name = "loyaltyPointsFacade")
	private DefaultLoyaltyPointsFacade loyaltyPointsFacade;



	private final static String LOYALTY_POINTS = "loyalty-points";



	@RequestMapping(method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException, CommerceCartModificationException
	{
		final LoyaltyData loyaltyData = loyaltyPointsFacade.defaultLoyaltyPointsFacade();
		model.addAttribute("intloyaltyPoints", loyaltyData.getInitialLoyalty());
		model.addAttribute("finalloyaltyPoints", loyaltyData.getUpdatedLoyalty());
		model.addAttribute("userName", loyaltyData.getUserName());



		return ControllerConstants.Views.Pages.MultiStepCheckout.LoyaltyPointsPage;
	}



	@RequireHardLogIn
	@Override
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().previousStep();
	}



	@RequireHardLogIn
	@Override
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String next(final RedirectAttributes redirectAttributes)
	{



		return getCheckoutStep().nextStep();
	}



	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(LOYALTY_POINTS);
	}
}
