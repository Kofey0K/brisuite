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

package org.eclipse.birt.core.archive.compound.v3;

public class Ext2Utils {

	public final static String getBlockId(String fileName, int nodeId, int blockId) {
		StringBuilder sb = new StringBuilder();
		sb.append(fileName);
		sb.append(nodeId);
		sb.append(blockId);
		return sb.toString();
	}

	public final static void integerToBytes(int v, byte[] b, int off) {
		assert b.length - off >= 4;
		b[off++] = (byte) ((v >>> 24) & 0xFF);
		b[off++] = (byte) ((v >>> 16) & 0xFF);
		b[off++] = (byte) ((v >>> 8) & 0xFF);
		b[off] = (byte) ((v >>> 0) & 0xFF);
	}

	public final static int bytesToInteger(byte[] b, int off) {
		assert b.length - off >= 4;
		return ((b[off++] & 0xFF) << 24) + ((b[off++] & 0xFF) << 16) + ((b[off++] & 0xFF) << 8)
				+ ((b[off] & 0xFF) << 0);
	}

}
