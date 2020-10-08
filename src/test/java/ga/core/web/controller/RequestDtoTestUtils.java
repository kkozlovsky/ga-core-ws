package ga.core.web.controller;

import ga.core.web.dto.Extra;
import ga.core.web.dto.RequestDto;

import java.util.ArrayList;
import java.util.List;

public class RequestDtoTestUtils {

	public static final String GET_BALANCE_REQUEST = "GET-BALANCE";
	public static final String CREATE_AGT_REQUEST = "CREATE-AGT";
	public static final String LOGIN_PARAM = "login";
	public static final String PASSWORD_PARAM = "password";
	public static final String BALANCE_PARAM = "balance";
	public static final String BALANCE_SUM_EXISTING_CLIENT = "1234.00";
	public static final String EXISTING_CLIENT_LOGIN = "Kirill";
	public static final String EXISTING_CLIENT_PASSWORD = "qwerty";
	public static final String EMPTY_PARAM_VALUE = "";

	public static RequestDto successRegistrationRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(CREATE_AGT_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue("user123");
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue("qwerty123");
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto successGetBalanceRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue(EXISTING_CLIENT_LOGIN);
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue(EXISTING_CLIENT_PASSWORD);
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto existClientRegistrationRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(CREATE_AGT_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue(EXISTING_CLIENT_LOGIN);
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue(EXISTING_CLIENT_PASSWORD);
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto clientNotFoundRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue("not_exist_user");
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue("qwerty123");
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto wrongPasswordRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue(EXISTING_CLIENT_LOGIN);
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue("wrong_password");
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto nullLoginGetBalanceRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue(EXISTING_CLIENT_LOGIN);
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto nullPasswordGetBalanceRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue("wrong_password");
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto nullParamsGetBalanceRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		return dto;
	}

	public static RequestDto emptyLoginGetBalanceRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue(EMPTY_PARAM_VALUE);
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue(EXISTING_CLIENT_PASSWORD);
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto emptyPasswordGetBalanceRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType(GET_BALANCE_REQUEST);
		Extra extraLogin = new Extra();
		extraLogin.setName(LOGIN_PARAM);
		extraLogin.setValue(EXISTING_CLIENT_LOGIN);
		Extra extraPassword = new Extra();
		extraPassword.setName(PASSWORD_PARAM);
		extraPassword.setValue(EMPTY_PARAM_VALUE);
		List<Extra> extraParams = new ArrayList<>();
		extraParams.add(extraLogin);
		extraParams.add(extraPassword);
		dto.setExtras(extraParams);
		return dto;
	}

	public static RequestDto notExistingRequestTypeRequest() {
		RequestDto dto = new RequestDto();
		dto.setRequestType("NOT_EXISTING_REQUEST_TYPE");
		return dto;
	}

}
