/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.newproductcronjob.controller;

import static de.hybris.newproductcronjob.constants.NewproductcronjobConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hybris.newproductcronjob.service.NewproductcronjobService;


@Controller
public class NewproductcronjobHelloController
{
	@Autowired
	private NewproductcronjobService newproductcronjobService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", newproductcronjobService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
