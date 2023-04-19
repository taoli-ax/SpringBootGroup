package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyDataSource {
    private String driver;
    public String url;
    public String username;
    private String password;
}
