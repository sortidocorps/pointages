package cloud.templates.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiVersion {
	
	
    public ApiVersion(String version) {
		
		this.version = version;
	}

	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
