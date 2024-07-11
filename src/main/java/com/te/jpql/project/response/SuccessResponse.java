package com.te.jpql.project.response;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter    
@Builder
@EqualsAndHashCode
@ToString
@Setter
public class SuccessResponse {

	private String message;
	private Object data;
	private HttpStatus httpStatus;
	private LocalDateTime dateTime;

}
