package com.project.ETS.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.annotations.IdGeneratorType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@IdGeneratorType(SequenceIDGenerator.class)
public @interface SequenceId {
	

}
