package ga.core.web.dto;

public enum ErrorCode {

	OK(0),
	CLIENT_EXISTS(1),
	TECHNICAL_ERROR(2),
	CLIENT_NOT_FOUND(3),
	WRONG_PASSWORD(4);

	private final int code;

	ErrorCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
