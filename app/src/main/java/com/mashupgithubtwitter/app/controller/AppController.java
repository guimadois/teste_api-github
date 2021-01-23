package com.mashupgithubtwitter.app.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mashupgithubtwitter.app.service.interfaces.ConsultaService;

@RestController
@RequestMapping("/api-consulta")
public class AppController {

	@Autowired
	private ConsultaService service;
	
	@GetMapping("/{termo}")
	public @ResponseBody String consultaTermo(@PathVariable(value="termo") String termo) throws ClientProtocolException, IOException {
		
		return service.consulta(termo);
	}
}
