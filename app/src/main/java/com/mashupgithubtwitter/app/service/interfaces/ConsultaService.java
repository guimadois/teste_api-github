package com.mashupgithubtwitter.app.service.interfaces;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/**
 * Interface de definição do serviço de consulta
 * 
 * @author elton
 *
 */
public interface ConsultaService {

	public String consulta(String termo) throws ClientProtocolException, IOException;
}
