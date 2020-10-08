package ga.core.web.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "request")
public class RequestDto {

	@JacksonXmlProperty(localName = "request-type")
	private String requestType;

	@JacksonXmlProperty(localName = "extra")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Extra> extraProperties;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public List<Extra> getExtras() {
		return extraProperties;
	}

	public void setExtras(List<Extra> extraProperties) {
		this.extraProperties = extraProperties;
	}

	@Override
	public String toString() {
		return "RequestDto{" +
				"requestType='" + requestType + '\'' +
				", extras=" + extraProperties +
				'}';
	}
}
