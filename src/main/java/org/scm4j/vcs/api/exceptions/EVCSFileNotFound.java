package org.scm4j.vcs.api.exceptions;

public class EVCSFileNotFound extends EVCSException {

	private static final long serialVersionUID = 1L;

	public EVCSFileNotFound(Exception e) {
		super(e);
	}

	public EVCSFileNotFound(String message) {
		super(message);
	}
}
