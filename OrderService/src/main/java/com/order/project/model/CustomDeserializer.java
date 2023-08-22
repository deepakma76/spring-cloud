package com.order.project.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDeserializer extends StdDeserializer<Set<OrderItem>> {

	private static final long serialVersionUID = 1L;

	public CustomDeserializer() {
		this(null);
	}

	public CustomDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Set<OrderItem> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new HashSet<>();
	}
}