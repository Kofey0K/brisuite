/*
 *************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *  
 *************************************************************************
 */

package org.eclipse.birt.data.engine.odi;

import org.eclipse.birt.data.engine.core.DataException;

/**
 * Runtime result objects returned by a query execution. <br>
 * A query's result data elements are mapped to result objects according to its
 * result projection, and adopting the result field properties defined in a
 * query's result hints, when applicable.
 * <p>
 * Its metadata could be obtained via the result objects' IResultIterator as
 * well. <br>
 * Its field index is 1-based for the data fields.
 */
public interface IResultObject {
	/**
	 * Gets the metadata of the this result object.
	 * 
	 * @return The IResultClass instance that represents the metadata of this result
	 *         object.
	 */
	public IResultClass getResultClass();

	/**
	 * Gets the value of a field specified by name.
	 * 
	 * @param fieldName The name or alias of a field.
	 * @return The field value object; can be null.
	 * @throws DataException if given fieldName is invalid.
	 */
	public Object getFieldValue(String fieldName) throws DataException;

	/**
	 * Gets the value of a field specified by its projected index position. <br>
	 * 
	 * @param fieldIndex The 1-based index of a field.
	 * @return The field value object; can be null.
	 * @throws DataException if given fieldIndex is invalid.
	 */
	public Object getFieldValue(int fieldIndex) throws DataException;

	/**
	 * Assigns a value to a custom result field specified by name.
	 * 
	 * @param fieldName The name or alias of a field.
	 * @param value     The field value in the field's declared type.
	 * @throws DataException if the specifed field is not a custom field, or the
	 *                       value type does not match this field's declared data
	 *                       type.
	 */
	public void setCustomFieldValue(String fieldName, Object value) throws DataException;

	/**
	 * Assigns a value to a custom result field specified by its index position.
	 * 
	 * @param fieldIndex The 1-based index of a field.
	 * @param value      The field value in the field's declared type.
	 * @throws DataException if the specifed field is not a custom field, or the
	 *                       value type does not match this field's declared data
	 *                       type.
	 */
	public void setCustomFieldValue(int fieldIndex, Object value) throws DataException;

}
