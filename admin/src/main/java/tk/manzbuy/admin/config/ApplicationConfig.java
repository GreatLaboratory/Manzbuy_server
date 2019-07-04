package tk.manzbuy.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"tk.manzbuy.admin.dao", "tk.manzbuy.admin.service"})
// 위에 있는 두 개의 패키지에 구현되어있는 클래스의 컴포넌트들을 읽어올 목적
@Import({DBConfig.class})
// 위에서 컴포넌트들을 읽어들일 때 내부적으로 db연동작업이 기본이니까 import시키는 것이다.
public class ApplicationConfig {

}
