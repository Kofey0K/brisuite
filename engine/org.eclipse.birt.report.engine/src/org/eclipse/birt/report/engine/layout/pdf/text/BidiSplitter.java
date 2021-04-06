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

package org.eclipse.birt.report.engine.layout.pdf.text;

import org.eclipse.birt.report.engine.layout.pdf.ISplitter;

import com.ibm.icu.text.Bidi;

public class BidiSplitter implements ISplitter {

	private char[] chunkText = null;

	private Bidi bidi = null;
	private int baseLevel;

	private int currentRun = 0;
	private int beginIndex = 0;
	private int endIndex = 0;

	public BidiSplitter(Chunk inputChunk) {
		this.chunkText = inputChunk.getText().toCharArray();
		this.baseLevel = inputChunk.getBaseLevel();
		this.bidi = createBidi(inputChunk.getText(), baseLevel);
	}

	private Bidi createBidi(String text, int baseLevel) {
		return new Bidi(text, baseLevel);
	}

	private Chunk buildChunk() {
		if (currentRun < bidi.getRunCount()) {
			endIndex = bidi.getRunLimit(currentRun);
			String text = new String(chunkText, beginIndex, endIndex - beginIndex);
			Chunk c = new Chunk(text, beginIndex, baseLevel, bidi.getRunLevel(currentRun));
			beginIndex = endIndex;
			currentRun++;
			return c;
		}
		return null;
	}

	public boolean hasMore() {
		return currentRun < bidi.getRunCount();
	}

	public Chunk getNext() {
		return buildChunk();
	}

}
