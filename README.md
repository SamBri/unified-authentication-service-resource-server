This is server trusts and verifies tokens generated by the unified-auth-service

<br>
can be added as so
<br>
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
	</dependencies>