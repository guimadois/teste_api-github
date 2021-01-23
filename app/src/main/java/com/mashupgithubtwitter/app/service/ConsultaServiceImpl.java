package com.mashupgithubtwitter.app.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

import com.mashupgithubtwitter.app.service.interfaces.ConsultaService;


@Service
public class ConsultaServiceImpl implements ConsultaService {

	private static String GITHUB_API_BASE_URL = "https://api.github.com/";
	
	private static String GITHUB_API_SEARCH_REPOSITORY= "search/repositories?q=";
	
	private static String GITHUB_API_SEARCH_ORDER = "&sort=stars&order=desc";	
	
	@Override
	public String consulta(String termo) throws ClientProtocolException, IOException {
		String url = GITHUB_API_BASE_URL + GITHUB_API_SEARCH_REPOSITORY + termo + GITHUB_API_SEARCH_ORDER;
		System.out.println("url: " + url);
		return executaChamadaREST(url);
		
	}


	/**
	 * Método que realiza chamada REST 
	 * 
	 * Em seguida faz o retorno usando GSON
	 */
	private String executaChamadaREST(String restUrl, String acceptHeaderValue) throws ClientProtocolException, IOException {
		
		Request request = Request.Get(restUrl);

		if (acceptHeaderValue != null && !acceptHeaderValue.isBlank()) {
			request.addHeader("Accept", acceptHeaderValue);
		}

		Content content = request.execute().returnContent();
		String jsonString = content.asString();
		
		return jsonString;
	}
	
	private String executaChamadaREST(String restUrl) throws ClientProtocolException, IOException {
		return executaChamadaREST(restUrl, null);
	}
}
