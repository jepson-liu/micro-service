package com.lovnx;

import com.lovnx.filter.ErrorFilter;
import com.lovnx.filter.ResultFilter;
import com.marcosbarbero.zuul.filters.pre.ratelimit.RateLimitFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}


	@Bean
	public RateLimitFilter rateLimiterFilter() {
		return new RateLimitFilter(null, null, null);
	}
	
	@Bean
	public ResultFilter resultFilter() {
		return new ResultFilter();
	}
	

	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

}
