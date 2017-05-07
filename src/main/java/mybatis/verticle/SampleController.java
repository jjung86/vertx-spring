package mybatis.verticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.service.MyService;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class SampleController {

	@Autowired
	private MyService service;
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return service.selectNow();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}