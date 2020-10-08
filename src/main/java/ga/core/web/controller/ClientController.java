package ga.core.web.controller;

import ga.core.web.dto.ErrorCode;
import ga.core.web.dto.RequestDto;
import ga.core.web.dto.ResponseDto;
import ga.core.web.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ClientController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String GET_BALANCE_REQUEST = "GET-BALANCE";
	private static final String CREATE_AGT_REQUEST = "CREATE-AGT";
	private static final ResponseDto TECHNICAL_ERROR_RESPONSE = new ResponseDto(ErrorCode.TECHNICAL_ERROR.getCode());

	private final ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	public ResponseEntity<ResponseDto> handleRequest(@RequestBody RequestDto requestDto) {
		if (CREATE_AGT_REQUEST.equalsIgnoreCase(requestDto.getRequestType())) {
			return new ResponseEntity<>(clientService.registerClient(requestDto), HttpStatus.OK);
		} else if (GET_BALANCE_REQUEST.equalsIgnoreCase(requestDto.getRequestType())) {
			return new ResponseEntity<>(clientService.getBalance(requestDto), HttpStatus.OK);
		} else {
			logger.error("request-type: " + requestDto.getRequestType() + " not found");
			return new ResponseEntity<>(TECHNICAL_ERROR_RESPONSE, HttpStatus.OK);
		}
	}

}
