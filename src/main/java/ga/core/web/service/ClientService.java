package ga.core.web.service;

import ga.core.web.domain.Client;
import ga.core.web.dto.ErrorCode;
import ga.core.web.dto.Extra;
import ga.core.web.dto.RequestDto;
import ga.core.web.dto.ResponseDto;
import ga.core.web.exception.ClientNotFoundException;
import ga.core.web.exception.TechnicalErrorException;
import ga.core.web.exception.WrongPasswordException;
import ga.core.web.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String LOGIN_PARAM = "login";
	private static final String PASSWORD_PARAM = "password";
	private static final String BALANCE_PARAM = "balance";
	private static final ResponseDto SUCCESS_REGISTRATION_RESPONSE = new ResponseDto(ErrorCode.OK.getCode());

	private final ClientRepository repository;

	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public ResponseDto registerClient(RequestDto requestDto) {
		String login = resolveParam(requestDto.getExtras(), LOGIN_PARAM);
		String password = resolveParam(requestDto.getExtras(), PASSWORD_PARAM);
		Client client = repository.createClient(new Client(login, password, BigDecimal.ZERO));
		if (client != null) {
			return SUCCESS_REGISTRATION_RESPONSE;
		} else {
			logger.error(login + " registration failed");
			throw new TechnicalErrorException(login + ": registration failed");
		}
	}

	@Transactional(readOnly = true)
	public ResponseDto getBalance(RequestDto requestDto) {
		String login = resolveParam(requestDto.getExtras(), LOGIN_PARAM);
		String password = resolveParam(requestDto.getExtras(), PASSWORD_PARAM);
		Client client = repository.findByLogin(login);
		if (client == null) {
			logger.error(login + ": not found");
			throw new ClientNotFoundException(login + ": not found");
		}
		if (!client.getPassword().equals(password)) {
			logger.error(client.getLogin() + ": wrong password");
			throw new WrongPasswordException(client.getLogin() + ": wrong password");
		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultCode(ErrorCode.OK.getCode());
		Extra extra = new Extra();
		extra.setName(BALANCE_PARAM);
		extra.setValue(client.getBalance().toString());
		responseDto.setExtra(extra);
		return responseDto;
	}

	private String resolveParam(List<Extra> extraParams, String paramName) {
		if (extraParams == null) {
			logger.error("extraParams not found");
			throw new TechnicalErrorException("extraParams not found");
		}
		Extra extraParam = extraParams
				.stream()
				.filter(extra -> paramName.equalsIgnoreCase(extra.getName()))
				.findAny()
				.orElseThrow((() -> new TechnicalErrorException(paramName + " param not found")));

		if (extraParam.getValue().isEmpty()) {
			logger.error(paramName + " value not found");
			throw new TechnicalErrorException(paramName + " value not found");
		}

		return extraParam.getValue();
	}

}
