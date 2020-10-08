package ga.core.web.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "extra")
public class Extra {

	@JacksonXmlProperty(isAttribute = true)
	private String name;

	@JacksonXmlText
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Extra{" +
				"name='" + name + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
