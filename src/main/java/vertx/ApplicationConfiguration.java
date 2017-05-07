package vertx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration //설정자바파일
public class ApplicationConfiguration {
	
	@Autowired //  객체를 주입해주는enviroment=>환경설정정보를 불러올수있다
	private Environment environment;
	
	public String applicationName(){
		return environment.getProperty("spring.application.name");
	}
	
	public int httpPort(){
		return environment.getProperty("server.port",Integer.class);//문자를 숫자로 변환해주는 역할(integer.class)
	}
	
}
