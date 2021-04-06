/*************************************************************************************
 * Copyright (c) 2004 Actuate Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Actuate Corporation - Initial implementation.
 ************************************************************************************/

package org.eclipse.birt.report.designer.ui.views;

import org.eclipse.birt.report.designer.internal.ui.extension.ExtensionPointManager;
import org.eclipse.birt.report.designer.internal.ui.views.DefaultNodeProvider;
import org.eclipse.birt.report.designer.ui.extensions.IProviderFactory;
import org.eclipse.birt.report.model.api.DesignElementHandle;

/**
 * This class represents a factory that implements the process of creating the
 * tree node.
 * 
 * 
 */
public class ProviderFactory {

	static private DefaultNodeProvider defaultProvider = new DefaultNodeProvider();

	/**
	 * Gets the default provider
	 * 
	 * @return Returns the default provider
	 */
	public static INodeProvider getDefaultProvider() {
		return defaultProvider;
	}

	/**
	 * Creates the outline provider and returns it.
	 * 
	 * @param object the object
	 * @return the outline provider
	 */

	public static INodeProvider createProvider(Object object) {
		Object adapter = ElementAdapterManager.getAdapter(object, INodeProvider.class);
		if (adapter instanceof INodeProvider) {
			return (INodeProvider) adapter;
		}

		if (object instanceof DesignElementHandle) {
			String elementName = ((DesignElementHandle) object).getDefn().getName();
			IProviderFactory factory = ExtensionPointManager.getInstance().getProviderFactory(elementName);
			if (factory != null) {
				return factory.createProvider(object);
			}
		}

		return getDefaultProvider();
	}
}