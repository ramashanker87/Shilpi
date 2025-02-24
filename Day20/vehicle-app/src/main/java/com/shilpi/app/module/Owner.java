package com.shilpi.app.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Owner{
    private String name;
    private String address;
    private String age;
    private final Logger logger = LoggerFactory.getLogger(Owner.class);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public Owner(){

        logger.trace("TRACE Level Log for Owner constructor");
        logger.debug("DEBUG Level Log for Owner constructor");
        logger.info("INFO Level Log for Owner constructor");
        logger.warn("WARN Level Log for Owner constructor");
        logger.error("ERROR Level Log for Owner constructor");

    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
