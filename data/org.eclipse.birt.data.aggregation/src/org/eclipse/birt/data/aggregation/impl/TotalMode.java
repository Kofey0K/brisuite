/*
 *************************************************************************
 * Copyright (c) 2004, 2008 Actuate Corporation.
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
 *
 *************************************************************************
 */
package org.eclipse.birt.data.aggregation.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.eclipse.birt.core.data.DataType;
import org.eclipse.birt.data.aggregation.api.IBuildInAggregation;
import org.eclipse.birt.data.aggregation.i18n.Messages;
import org.eclipse.birt.data.engine.api.aggregation.Accumulator;
import org.eclipse.birt.data.engine.api.aggregation.IParameterDefn;
import org.eclipse.birt.data.engine.core.DataException;

/**
 *
 * Implements the built-in Total.mode aggregation
 */
public class TotalMode extends AggrFunction {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.data.engine.aggregation.Aggregation#getName()
	 */
	@Override
	public String getName() {
		return IBuildInAggregation.TOTAL_MODE_FUNC;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.data.engine.aggregation.Aggregation#getType()
	 */
	@Override
	public int getType() {
		return SUMMARY_AGGR;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.data.engine.api.aggregation.IAggregation#getDateType()
	 */
	@Override
	public int getDataType() {
		return DataType.ANY_TYPE;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.data.engine.aggregation.Aggregation#getParameterDefn()
	 */
	@Override
	public IParameterDefn[] getParameterDefn() {
		return new IParameterDefn[] { new ParameterDefn(Constants.EXPRESSION_NAME, Constants.EXPRESSION_DISPLAY_NAME,
				false, true, SupportedDataTypes.CALCULATABLE, "")//$NON-NLS-1$
		};
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.birt.data.engine.aggregation.Aggregation#newAccumulator()
	 */
	@Override
	public Accumulator newAccumulator() {
		return new MyAccumulator();
	}

	private static class MyAccumulator extends SummaryAccumulator {
		// Maps a value (Double) to its count (Integer)
		private LinkedHashMap cacheMap;// used by for muti-mode storage, return the first appeared mode
		private Object mode;
		private int maxCount;
		private boolean multiMaxValue;

		@Override
		public void start() {
			super.start();
			maxCount = 0;
			mode = null;
			cacheMap = new LinkedHashMap();
			multiMaxValue = false;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.eclipse.birt.data.engine.aggregation.Accumulator#onRow(java.lang.Object[]
		 * )
		 */
		@Override
		public void onRow(Object[] args) throws DataException {
			assert (args.length > 0);
			if (args[0] != null) {
				Object value = args[0];
				Object obj = cacheMap.get(value);
				int count = 1;
				if (obj != null) {
					count = ((Integer) obj).intValue();
					count++;
				}
				cacheMap.put(value, count);

				if (count > maxCount) {
					mode = value;
					maxCount = count;
					multiMaxValue = false;
				} else if (count == maxCount) {
					multiMaxValue = true;
				}
			}
		}

		@Override
		public void finish() throws DataException {
			super.finish();
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.eclipse.birt.data.engine.aggregation.SummaryAccumulator#getSummaryValue()
		 */
		@Override
		public Object getSummaryValue() {
			if (maxCount == 1)// all of the objects are unique values
			{
				// no modes; ROM scripting spec says we should return null
				return null;
			}
			if (multiMaxValue && cacheMap != null && !cacheMap.isEmpty()) {
				// find the mode with the minimum index in all searched modes
				for (Iterator i = cacheMap.keySet().iterator(); i.hasNext();) {
					Object key = (Object) i.next();
					int count = (Integer) cacheMap.get(key);
					if (count == maxCount) {
						mode = key;
						break;
					}
				}
			}
			cacheMap = null;
			return mode;
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.birt.data.engine.api.aggregation.IAggrFunction#getDescription()
	 */
	@Override
	public String getDescription() {
		return Messages.getString("TotalMode.description"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.birt.data.engine.api.aggregation.IAggrFunction#getDisplayName()
	 */
	@Override
	public String getDisplayName() {
		return Messages.getString("TotalMode.displayName"); //$NON-NLS-1$
	}
}
