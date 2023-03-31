/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myshoestore.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.myshoestore.fulfilmentprocess.constants.MyshoestoreFulfilmentProcessConstants;

public class MyshoestoreFulfilmentProcessManager extends GeneratedMyshoestoreFulfilmentProcessManager
{
	public static final MyshoestoreFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MyshoestoreFulfilmentProcessManager) em.getExtension(MyshoestoreFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
