/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: Actuate Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.birt.chart.ui.swt.interfaces;

import org.eclipse.swt.graphics.Image;

/**
 * @author Actuate Corporation
 *
 */
public interface INode {

	IHelpContent getHelp();

	String getLabel();

	String getPath();

	Image getIcon();
}
