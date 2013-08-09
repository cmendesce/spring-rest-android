package br.com.cmendesce.springrest;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.ListActivity;
import android.os.Bundle;
import br.com.cmendesce.springrest.models.Contato;
import br.com.cmendesce.springrest.ui.adapters.ContatoAdapter;

public class ContatosActivity extends ListActivity {

	private final String url = "http://dl.dropboxusercontent.com/u/1084171/produtos.json";
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contatos);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		
		Contato[] contatos = restTemplate.getForObject(url, Contato[].class);
		
		ContatoAdapter adapter = new ContatoAdapter(this, contatos);
		setListAdapter(adapter);
	}
}