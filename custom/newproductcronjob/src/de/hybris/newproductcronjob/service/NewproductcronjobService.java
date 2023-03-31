/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.newproductcronjob.service;

public interface NewproductcronjobService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
