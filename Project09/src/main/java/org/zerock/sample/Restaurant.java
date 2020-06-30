package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	@Setter(onMethod = @_({@Autowired}))
	private Chef chef;

	//lombok의 setter 를 생성하는 기능, 생성자 , toString() 등을 자동으로 생성하다록 @Data를 이용 
}
