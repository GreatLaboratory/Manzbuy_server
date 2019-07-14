package tk.manzbuy.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// 이 페이지 자체가 설정이라는 걸 알려주기 위한 어노테이션
@EnableWebMvc
// 기본적인 설정들을 자동으로 만들어주는 어노테이션
@ComponentScan(basePackages = { "tk.manzbuy.admin.controller" })
// tk.manzbuy.admin.controller패키지에 있는 component나 repository 어노테이션 붙어있는 controller들에 이 config설정을 해주는 어노테이션

public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	// 이 클래스에서 하고 있는 설정들은 dispatcher서블릿이 읽어들이는 것이라는 사실이 가장 중요하다.
	// 내가 원하는 설정들을 하기 위해서 WebMvcConfigurerAdapter클래스를 상속받은 바로 이 클래스를 만들었다.
	// 아래에선 설정에 필요한 메소드들을 오버라이딩한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// url요청이 /css/**, /img/**, /js/** 이런 식으로 이루어지면 뒤에 있는 /css/, /img/, /js/폴더에서 읽어오도록 설정하는 것이다.
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// url매핑이 없이 요청되어졌을 때 default servlet handler를 사용할 수 있게 해주는 메소드
		// 매핑정보가 없는 url요청은 spring의 DefaultServletHttpRequestHandler가 처리하게 해준다.
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		// 특정 url에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해주는 메소드
		// "/"라고 요청이 들어오면 "uploadform"라는 이름의 뷰로 보여주게하는 역할.
		System.out.println("addViewControllers가 호출됩니다. ");
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	// 리졸버
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		// 적절한 view resolver가 실제 뷰 이름을 가지고 어떤 뷰인지에 대한 정보를 찾아낼 수 있게 해준다.
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	// 리졸버
	public MultipartResolver multipartResolver() {
		// dispatcherservlet이 multipart요청을 받았았을 때 이러한 설정으로 받아들여라 하는 설정클래스
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760); // 1024*1024*10 -> 최대 10메가 파일
		return multipartResolver;
	}
}