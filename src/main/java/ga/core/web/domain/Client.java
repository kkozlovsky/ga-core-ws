package ga.core.web.domain;


import java.math.BigDecimal;

public class Client {
	private String login;
	private String password;
	private BigDecimal balance;

	public Client() {
	}

	public Client(String login, String password, BigDecimal balance) {
		this.login = login;
		this.password = password;
		this.balance = balance;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Client{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", balance=" + balance +
				'}';
	}
}
