/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 30-Mar-2023, 3:41:44 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myshoestore.core.jalo;

import de.hybris.myshoestore.core.constants.MyshoestoreCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.myshoestore.core.jalo.NewProducts NewProducts}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedNewProducts extends GenericItem
{
	/** Qualifier of the <code>NewProducts.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>NewProducts.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>NewProducts.description</code> attribute **/
	public static final String DESCRIPTION = "description";
	/** Qualifier of the <code>NewProducts.size</code> attribute **/
	public static final String SIZE = "size";
	/** Qualifier of the <code>NewProducts.color</code> attribute **/
	public static final String COLOR = "color";
	/** Qualifier of the <code>NewProducts.purchaseDate</code> attribute **/
	public static final String PURCHASEDATE = "purchaseDate";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(DESCRIPTION, AttributeMode.INITIAL);
		tmp.put(SIZE, AttributeMode.INITIAL);
		tmp.put(COLOR, AttributeMode.INITIAL);
		tmp.put(PURCHASEDATE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.color</code> attribute.
	 * @return the color
	 */
	public String getColor(final SessionContext ctx)
	{
		return (String)getProperty( ctx, COLOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.color</code> attribute.
	 * @return the color
	 */
	public String getColor()
	{
		return getColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.color</code> attribute. 
	 * @param value the color
	 */
	public void setColor(final SessionContext ctx, final String value)
	{
		setProperty(ctx, COLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.color</code> attribute. 
	 * @param value the color
	 */
	public void setColor(final String value)
	{
		setColor( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.description</code> attribute.
	 * @return the description
	 */
	public String getDescription(final SessionContext ctx)
	{
		return (String)getProperty( ctx, DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.description</code> attribute.
	 * @return the description
	 */
	public String getDescription()
	{
		return getDescription( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final SessionContext ctx, final String value)
	{
		setProperty(ctx, DESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final String value)
	{
		setDescription( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.purchaseDate</code> attribute.
	 * @return the purchaseDate
	 */
	public Integer getPurchaseDate(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, PURCHASEDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.purchaseDate</code> attribute.
	 * @return the purchaseDate
	 */
	public Integer getPurchaseDate()
	{
		return getPurchaseDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.purchaseDate</code> attribute. 
	 * @return the purchaseDate
	 */
	public int getPurchaseDateAsPrimitive(final SessionContext ctx)
	{
		Integer value = getPurchaseDate( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.purchaseDate</code> attribute. 
	 * @return the purchaseDate
	 */
	public int getPurchaseDateAsPrimitive()
	{
		return getPurchaseDateAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.purchaseDate</code> attribute. 
	 * @param value the purchaseDate
	 */
	public void setPurchaseDate(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, PURCHASEDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.purchaseDate</code> attribute. 
	 * @param value the purchaseDate
	 */
	public void setPurchaseDate(final Integer value)
	{
		setPurchaseDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.purchaseDate</code> attribute. 
	 * @param value the purchaseDate
	 */
	public void setPurchaseDate(final SessionContext ctx, final int value)
	{
		setPurchaseDate( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.purchaseDate</code> attribute. 
	 * @param value the purchaseDate
	 */
	public void setPurchaseDate(final int value)
	{
		setPurchaseDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.size</code> attribute.
	 * @return the size
	 */
	public String getSize(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>NewProducts.size</code> attribute.
	 * @return the size
	 */
	public String getSize()
	{
		return getSize( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>NewProducts.size</code> attribute. 
	 * @param value the size
	 */
	public void setSize(final String value)
	{
		setSize( getSession().getSessionContext(), value );
	}
	
}
