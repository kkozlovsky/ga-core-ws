package ga.core.web.controller;

import ga.core.web.dto.ErrorCode;
import ga.core.web.dto.ResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void successRegistrationTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.successRegistrationRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.OK.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void successGetBalanceTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.successGetBalanceRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.OK.getCode());
		assertNotNull(dto.getExtra());
		assertEquals(dto.getExtra().getName(), RequestDtoTestUtils.BALANCE_PARAM);
		assertEquals(dto.getExtra().getValue(), RequestDtoTestUtils.BALANCE_SUM_EXISTING_CLIENT);
	}

	@Test
	public void existClientRegistrationTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.existClientRegistrationRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.CLIENT_EXISTS.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void clientNotFoundTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.clientNotFoundRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.CLIENT_NOT_FOUND.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void wrongPasswordTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.wrongPasswordRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.WRONG_PASSWORD.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void nullLoginGetBalanceTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.nullLoginGetBalanceRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.TECHNICAL_ERROR.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void nullPasswordGetBalanceTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.nullPasswordGetBalanceRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.TECHNICAL_ERROR.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void nullParamsGetBalanceTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.nullParamsGetBalanceRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.TECHNICAL_ERROR.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void emptyLoginGetBalanceTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.emptyLoginGetBalanceRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.TECHNICAL_ERROR.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void emptyPasswordGetBalanceTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.emptyPasswordGetBalanceRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.TECHNICAL_ERROR.getCode());
		assertNull(dto.getExtra());
	}

	@Test
	public void notExistingRequestTypeRequestTest() {
		ResponseEntity<ResponseDto> response = restTemplate.postForEntity("/", RequestDtoTestUtils.notExistingRequestTypeRequest(), ResponseDto.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		ResponseDto dto = response.getBody();
		assertNotNull(dto);
		assertEquals(dto.getResultCode(), ErrorCode.TECHNICAL_ERROR.getCode());
		assertNull(dto.getExtra());
	}

}
