package ga.core.web.repository;

import ga.core.web.domain.Client;
import ga.core.web.exception.ClientAlreadyRegisterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepository {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String SQL_INSERT = "INSERT INTO clients (login, password, balance) VALUES (:login, :password, :balance)";
	private static final String SQL_QUERY_FIND_BY_LOGIN = "SELECT login, password, balance FROM clients WHERE login= :login";
	private static final String LOGIN_COLUMN = "login";
	private static final String PASSWORD_COLUMN = "password";
	private static final String BALANCE_COLUMN = "balance";

	private final NamedParameterJdbcTemplate jdbcTemplate;

	public ClientRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Client findByLogin(String login) {
		try {
			Map<String, String> namedParameters = Collections.singletonMap(LOGIN_COLUMN, login);
			return this.jdbcTemplate.queryForObject(SQL_QUERY_FIND_BY_LOGIN, namedParameters, clientRowMapper);
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	public Client createClient(Client client) {
		Client existingClient = findByLogin(client.getLogin());
		if (existingClient != null) {
			logger.error(client.getLogin() + " already exist");
			throw new ClientAlreadyRegisterException(client.getLogin() + " already exist");
		}
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put(LOGIN_COLUMN, client.getLogin());
		namedParameters.put(PASSWORD_COLUMN, client.getPassword());
		namedParameters.put(BALANCE_COLUMN, BigDecimal.ZERO);
		try {
			jdbcTemplate.update(SQL_INSERT, namedParameters);
		} catch (DataIntegrityViolationException exception) {
			logger.error(client.getLogin() + " already exist");
			throw new ClientAlreadyRegisterException(client.getLogin() + " already exist");
		}

		return findByLogin(client.getLogin());
	}

	private RowMapper<Client> clientRowMapper = (ResultSet rs, int rowNum) -> {
		Client client = new Client();
		client.setLogin(rs.getString(LOGIN_COLUMN));
		client.setPassword(rs.getString(PASSWORD_COLUMN));
		client.setBalance(rs.getBigDecimal(BALANCE_COLUMN));
		return client;
	};

}
