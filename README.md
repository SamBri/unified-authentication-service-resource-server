This is server trusts and verifies jwt tokens generated by the unified-authentication-service


_pom.xml_
```maven pom
		<dependency>
			<groupId>com.nothing</groupId>
			<artifactId>
				unified-authentication-service-resource-server
			</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<exclusions>
				<exclusion>  <!-- declare the exclusion here -->
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-devtools</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
```

<br>

_resource server usage_

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Import({UnifiedAuthenticationServiceResourceServerApplication.class})
public class TheApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheApplication.class, args);
	}

}
```
