/*******************************************************************************
 * Copyright (c) 2009 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.designer.internal.lib.providers;

import org.eclipse.birt.report.designer.internal.ui.editors.breadcrumb.providers.DefaultBreadcrumbNodeProvider;
import org.eclipse.birt.report.model.api.LibraryHandle;

/**
 * 
 */

public class LibraryElementBreadcrumbNodeProvider extends DefaultBreadcrumbNodeProvider {

	public Object[] getChildren(Object element) {
		if (getRealModel(element) instanceof LibraryHandle) {
			return ((LibraryHandle) getRealModel(element)).getComponents().getContents().toArray();
		}
		return super.getChildren(element);
	}
}
