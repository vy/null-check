package com.vlkan.nullcheck.service;

import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class SampleService {

	public void sayHello(@Nonnull String to) {
		System.out.println(String.format("Hello, %s!", to));
	}

}
