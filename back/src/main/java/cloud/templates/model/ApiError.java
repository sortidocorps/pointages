package cloud.templates.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
	
	private String error;
	
	
    public ApiError(String error) {
		super();
		this.error = error;
	}

	

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
