package pro1testforhw1;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "usecases",
	glue = "pro1testforhw1",
	plugin = {"pretty","html:target/outcucumber.html"}
		
		)

public class testconlogin  {

}
