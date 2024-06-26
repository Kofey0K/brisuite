/*******************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
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

package org.eclipse.birt.report.engine.api.script.element;

import org.eclipse.birt.report.engine.api.script.ScriptException;
import org.eclipse.birt.report.model.api.core.IStructure;

/**
 * Represents the design of an FilterCondition in the scripting environment
 *
 */

public interface IFilterCondition {

	/**
	 * Returns operator
	 *
	 * @return operator
	 */

	String getOperator();

	/**
	 * Sets operator
	 *
	 * @param operator
	 * @throws ScriptException
	 */

	void setOperator(String operator) throws ScriptException;

	/**
	 * Returns value1
	 *
	 * @return value1
	 */

	String getValue1();

	/**
	 * Sets value1
	 *
	 * @param value1
	 * @throws ScriptException
	 */

	void setValue1(String value1) throws ScriptException;

	/**
	 * Returns value2
	 *
	 * @return value2
	 */

	String getValue2();

	/**
	 * Sets value2
	 *
	 * @param value2
	 * @throws ScriptException
	 */

	void setValue2(String value2) throws ScriptException;

	/**
	 * Returns structure.
	 *
	 * @return structure
	 */

	IStructure getStructure();

	/**
	 * Sets expr
	 *
	 * @param expr
	 */

	void setExpr(String expr) throws ScriptException;

	/**
	 * Returns expr
	 *
	 * @return expr
	 */

	String getExpr();
}
