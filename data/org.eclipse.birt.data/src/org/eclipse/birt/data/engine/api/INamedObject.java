/*******************************************************************************
 * Copyright (c) 2004, 2008 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.data.engine.api;

/**
 * 
 */

public interface INamedObject {

	/**
	 * set the name of current object.
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * get the name of current object.
	 * 
	 * @return
	 */
	public String getName();

}
