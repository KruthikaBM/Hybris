/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.newproductcronjob.setup;

import static de.hybris.newproductcronjob.constants.NewproductcronjobConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.newproductcronjob.constants.NewproductcronjobConstants;
import de.hybris.newproductcronjob.service.NewproductcronjobService;


@SystemSetup(extension = NewproductcronjobConstants.EXTENSIONNAME)
public class NewproductcronjobSystemSetup
{
	private final NewproductcronjobService newproductcronjobService;

	public NewproductcronjobSystemSetup(final NewproductcronjobService newproductcronjobService)
	{
		this.newproductcronjobService = newproductcronjobService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		newproductcronjobService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return NewproductcronjobSystemSetup.class.getResourceAsStream("/newproductcronjob/sap-hybris-platform.png");
	}
}
