package com.webservice.repository;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public abstract class JunitSpringConfig extends AbstractTransactionalJUnit4SpringContextTests {
}
