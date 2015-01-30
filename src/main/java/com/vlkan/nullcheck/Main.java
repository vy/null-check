package com.vlkan.nullcheck;

import com.vlkan.nullcheck.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan
@EnableAutoConfiguration
public class Main implements CommandLineRunner {

	@Autowired
	private SampleService sampleService;

	@Override
	public void run(String... args) {
		if (args.length != 1 && args[0] != null)
			throw new IllegalArgumentException(
					"expecting one non-null argument, found: " + Arrays.toString(args));
		sampleService.sayHello("null".equals(args[0]) ? null : args[0]);
		//try { sampleService.sayHello("null".equals(args[0]) ? null : args[0]); }
		//catch (NullPointerException npe) { System.out.println(">>>" + npe.getMessage()); }
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(Main.class).showBanner(false).run(args);
	}

}
