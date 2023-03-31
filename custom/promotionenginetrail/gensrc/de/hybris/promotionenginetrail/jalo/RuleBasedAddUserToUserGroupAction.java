/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Mar-2023, 3:41:44 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.promotionenginetrail.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.promotionengineservices.jalo.AbstractRuleBasedPromotionAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type RuleBasedAddUserToUserGroupAction.
 */
@SLDSafe
@SuppressWarnings({"unused","cast"})
public class RuleBasedAddUserToUserGroupAction extends AbstractRuleBasedPromotionAction
{
	/** Qualifier of the <code>RuleBasedAddUserToUserGroupAction.userGroup</code> attribute **/
	public static final String USERGROUP = "userGroup";
	/** Qualifier of the <code>RuleBasedAddUserToUserGroupAction.user</code> attribute **/
	public static final String USER = "user";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(AbstractRuleBasedPromotionAction.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(USERGROUP, AttributeMode.INITIAL);
		tmp.put(USER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RuleBasedAddUserToUserGroupAction.user</code> attribute.
	 * @return the user
	 */
	public User getUser(final SessionContext ctx)
	{
		return (User)getProperty( ctx, "user".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RuleBasedAddUserToUserGroupAction.user</code> attribute.
	 * @return the user
	 */
	public User getUser()
	{
		return getUser( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RuleBasedAddUserToUserGroupAction.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final SessionContext ctx, final User value)
	{
		setProperty(ctx, "user".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RuleBasedAddUserToUserGroupAction.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final User value)
	{
		setUser( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RuleBasedAddUserToUserGroupAction.userGroup</code> attribute.
	 * @return the userGroup
	 */
	public UserGroup getUserGroup(final SessionContext ctx)
	{
		return (UserGroup)getProperty( ctx, "userGroup".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RuleBasedAddUserToUserGroupAction.userGroup</code> attribute.
	 * @return the userGroup
	 */
	public UserGroup getUserGroup()
	{
		return getUserGroup( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RuleBasedAddUserToUserGroupAction.userGroup</code> attribute. 
	 * @param value the userGroup
	 */
	public void setUserGroup(final SessionContext ctx, final UserGroup value)
	{
		setProperty(ctx, "userGroup".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RuleBasedAddUserToUserGroupAction.userGroup</code> attribute. 
	 * @param value the userGroup
	 */
	public void setUserGroup(final UserGroup value)
	{
		setUserGroup( getSession().getSessionContext(), value );
	}
	
}
