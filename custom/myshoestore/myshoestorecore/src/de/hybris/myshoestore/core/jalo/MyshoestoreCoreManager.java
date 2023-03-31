/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myshoestore.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.myshoestore.core.constants.MyshoestoreCoreConstants;
import de.hybris.myshoestore.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class MyshoestoreCoreManager extends GeneratedMyshoestoreCoreManager
{
	public static final MyshoestoreCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MyshoestoreCoreManager) em.getExtension(MyshoestoreCoreConstants.EXTENSIONNAME);
	}
}
