/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 *
 */
package de.hybris.myshoestoreordermanagment.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.myshoestoreordermanagment.constants.MyshoestoreordermanagmentConstants;

@SuppressWarnings("PMD")
public class MyshoestoreordermanagmentManager extends GeneratedMyshoestoreordermanagmentManager
{
	public static final MyshoestoreordermanagmentManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MyshoestoreordermanagmentManager) em.getExtension(MyshoestoreordermanagmentConstants.EXTENSIONNAME);
	}
	
}
