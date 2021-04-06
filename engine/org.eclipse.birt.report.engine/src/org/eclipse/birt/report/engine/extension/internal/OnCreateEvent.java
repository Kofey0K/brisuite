
package org.eclipse.birt.report.engine.extension.internal;

import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.extension.IOnCreateEvent;
import org.eclipse.birt.report.engine.extension.IReportEventContext;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.birt.report.model.api.ReportElementHandle;

/*******************************************************************************
 * Copyright (c) 2008 Actuate Corporation. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Actuate Corporation - initial API and implementation
 *******************************************************************************/

public class OnCreateEvent extends ReportEvent implements IOnCreateEvent {

	DesignElementHandle handle;
	IContent content;
	IReportEventContext context;

	public OnCreateEvent(IReportEventContext context, DesignElementHandle handle, IContent content) {
		super(ON_CREATE_EVENT);

		this.context = context;
		this.handle = handle;
		this.content = content;
	}

	public DesignElementHandle getHandle() {
		return this.handle;
	}

	public void setHandle(ReportElementHandle handle) {
		this.handle = handle;
	}

	public IContent getContent() {
		return this.content;
	}

	public void setHandle(IContent content) {
		this.content = content;
	}

	public IReportEventContext getContext() {
		return this.context;
	}

	public void setContext(IReportEventContext context) {
		this.context = context;
	}
}
