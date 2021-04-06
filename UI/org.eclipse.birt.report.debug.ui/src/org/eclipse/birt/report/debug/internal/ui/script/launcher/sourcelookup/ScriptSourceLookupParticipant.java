/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.debug.internal.ui.script.launcher.sourcelookup;

import java.io.File;

import org.eclipse.birt.report.debug.internal.script.model.ScriptStackFrame;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

/**
 * ScriptSourceLookupParticipant
 */
public class ScriptSourceLookupParticipant extends AbstractSourceLookupParticipant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant#getSourceName(
	 * java.lang.Object)
	 */
	public String getSourceName(Object object) throws CoreException {
		if (object instanceof ScriptStackFrame) {
			return getFileName((ScriptStackFrame) object) + File.separator + ((ScriptStackFrame) object).getId();
		}
		return null;
	}

	/**
	 * @param frame
	 * @return
	 */
	private String getFileName(ScriptStackFrame frame) {
		String name = frame.getFileName();
		int index = name.lastIndexOf(File.separator);
		return name.substring(index + 1);
	}

}
