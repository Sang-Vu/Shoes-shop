package com.sangoc.ultils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class HttpUltil {
	private String value;

	public HttpUltil(String value) {
		this.value = value;
	}

	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static HttpUltil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUltil(sb.toString());
	}
}
