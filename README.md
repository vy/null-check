This project implements a [Spring AOP](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop.html)
driven runtime null check for `javax.annotation.Nonnull` annotated method parameters.

Internally, a `@Before` pointcut is used to intercept methods that have one or more `@Nonnull` annotated parameters
and check that their values are non-null. This functionality is provided by `nullCheck` AspectJ advice in
`com.vlkan.nullcheck.monitor.NullMonitor` class.

Dependencies
============

Using Spring Boot, you can easily setup your project by adding the following dependencies to your `pom.xml`:

    <!-- Spring -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>

    <!-- JSR 305: Annotations for Software Defect Detection -->
    <dependency>
        <groupId>com.google.code.findbugs</groupId>
        <artifactId>jsr305</artifactId>
        <version>3.0.0</version>
    </dependency>

For those who do not want to use Spring Boot, they are free to add individual dependencies manually.

Usage
=====

Copy `com.vlkan.nullcheck.monitor.NullMonitor` to your project, under the directory where you keep your `@Aspect`s -- or
just simply go with `monitor` directory. Whenever you use a method parameter with `@Nonnull` annotation, it will be
intercepted by the aspect.

License
=======

The [null-check](https://github.com/vy/null-check/) by [Volkan Yazıcı](http://vlkan.com/) is licensed under the
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

[![Creative Commons Attribution 4.0 International License](http://i.creativecommons.org/l/by/4.0/80x15.png)](http://creativecommons.org/licenses/by/4.0/)
