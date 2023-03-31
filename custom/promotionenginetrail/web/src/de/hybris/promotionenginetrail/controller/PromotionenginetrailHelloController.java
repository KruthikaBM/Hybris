/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.promotionenginetrail.controller;

import static de.hybris.promotionenginetrail.constants.PromotionenginetrailConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hybris.promotionenginetrail.service.PromotionenginetrailService;


@Controller
public class PromotionenginetrailHelloController
{
	@Autowired
	private PromotionenginetrailService promotionenginetrailService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", promotionenginetrailService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
