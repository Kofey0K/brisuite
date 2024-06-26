/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.model.core.namespace;

import org.eclipse.birt.report.model.core.CaseInsensitiveNameSpace;
import org.eclipse.birt.report.model.core.DesignElement;
import org.eclipse.birt.report.model.core.Module;

/**
 * Abstract element name space in one module. Subclass must override one or more
 * resolve methods in this class. Otherwise, assertion error may occur.
 */
public abstract class AbstractModuleNameContext extends AbstractNameContext {

	protected Module module = null;

	protected String nameSpaceID = null;

	/**
	 * Constructs the name space with module and name space ID.
	 *
	 * @param module      the module this name space is associated.
	 * @param nameSpaceID
	 */

	public AbstractModuleNameContext(Module module, String nameSpaceID) {
		super();
		this.module = module;
		this.nameSpaceID = nameSpaceID;

		// name of the parameter is case insensitive
		if (Module.PARAMETER_NAME_SPACE.equals(nameSpaceID)) {
			this.namespace = new CaseInsensitiveNameSpace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.report.model.core.namespace.INameContext#getElement()
	 */
	@Override
	public DesignElement getElement() {
		return module;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.report.model.core.namespace.INameContext#getNameSpaceID
	 * ()
	 */
	@Override
	public String getNameSpaceID() {
		return nameSpaceID;
	}

	/**
	 * Caches values for elements with names such as styles, etc.
	 */

	public void cacheValues() {
	}
}
