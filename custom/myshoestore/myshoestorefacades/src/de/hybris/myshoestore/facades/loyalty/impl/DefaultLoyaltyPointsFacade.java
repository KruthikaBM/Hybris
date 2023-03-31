package de.hybris.myshoestore.facades.loyalty.impl;

import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.model.ModelService;

import de.hybris.myshoestore.facades.LoyaltyData;
import de.hybris.myshoestore.facades.loyalty.LoyaltyPointsFacades;


public class DefaultLoyaltyPointsFacade implements LoyaltyPointsFacades
{

	private ModelService modelService;
	private CheckoutCustomerStrategy checkoutCustomerStrategy;
	private CartService cartService;
	private CartFacade cartFacade;

	public CartService getCartService()
	{
		return cartService;
	}

	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
	}

	public CartFacade getCartFacade()
	{
		return cartFacade;
	}

	public void setCartFacade(final CartFacade cartFacade)
	{
		this.cartFacade = cartFacade;
	}

	public ModelService getModelService()
	{
		return modelService;
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	public CheckoutCustomerStrategy getCheckoutCustomerStrategy()
	{
		return checkoutCustomerStrategy;
	}

	public void setCheckoutCustomerStrategy(final CheckoutCustomerStrategy checkoutCustomerStrategy)
	{
		this.checkoutCustomerStrategy = checkoutCustomerStrategy;
	}

	public boolean hasCheckoutCart()
	{
		return getCartFacade().hasSessionCart();
	}

	public CartModel getCart()
	{
		return hasCheckoutCart() ? getCartService().getSessionCart() : null;
	}

	@Override
	public LoyaltyData defaultLoyaltyPointsFacade()
	{
		final CustomerModel customerModel = getCheckoutCustomerStrategy().getCurrentUserForCheckout();
		final CartModel cartModel = getCart();
		return deductLoyaltyPoints(cartModel, customerModel);
	}


	public LoyaltyData deductLoyaltyPoints(final CartModel cartModel, final CustomerModel customerModel)
	{


		final LoyaltyData loyaltyData = new LoyaltyData();
		int newloyaltyPoints = 0;
		final int loyaltyPoints = customerModel.getLoyaltyPoints();
		loyaltyData.setInitialLoyalty(loyaltyPoints);
		final Double cartTotal = cartModel.getTotalPrice();

		if (cartTotal > loyaltyPoints)
		{
			final double newCartTotal = cartTotal - loyaltyPoints;
			customerModel.setLoyaltyPoints(newloyaltyPoints);
			modelService.save(customerModel);
			cartModel.setTotalPrice(newCartTotal);
			modelService.save(cartModel);
		}
		else
		{
			newloyaltyPoints = (int) (loyaltyPoints - cartTotal);
			final double newCartTotal = 0.0;
			customerModel.setLoyaltyPoints(newloyaltyPoints);
			modelService.save(customerModel);
			cartModel.setTotalPrice(newCartTotal);
			modelService.save(cartModel);
		}
		loyaltyData.setUpdatedLoyalty(newloyaltyPoints);
		loyaltyData.setUserName(customerModel.getName());
		return loyaltyData;
	}
}
