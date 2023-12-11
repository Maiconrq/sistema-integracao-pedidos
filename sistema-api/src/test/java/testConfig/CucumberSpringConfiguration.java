package testConfig;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestContainerConfig.class)
@CucumberOptions(features="classpath:com/sistemapedidos/pedido.feature")
public class CucumberSpringConfiguration {
}
