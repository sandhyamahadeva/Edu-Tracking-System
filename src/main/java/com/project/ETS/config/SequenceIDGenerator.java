package com.project.ETS.config;

import java.time.Year;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


@SuppressWarnings("serial")
public class SequenceIDGenerator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String uuid = UUID.randomUUID().toString();
		String id="EDU"+Year.now().toString()+uuid;
		return id;
	}

}
