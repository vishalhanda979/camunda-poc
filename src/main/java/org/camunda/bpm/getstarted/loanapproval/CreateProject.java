package org.camunda.bpm.getstarted.loanapproval;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.GsonBuilder;

@Component
public class CreateProject implements JavaDelegate {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateProject.class);

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Invoking createProject");

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://api.github.com/user/repos");

		Repository repository = new Repository();
		repository.setName((String) execution.getVariable(("repoName")));
		repository.setDescription("Created through camunda process");
		repository.setHomepage("https://github.com");

		StringEntity entity = new StringEntity(new GsonBuilder().create().toJson(repository));

		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("Authorization", "token dd3bd50ef126e6c784c4745462f5befe23114ec8");

		CloseableHttpResponse response = client.execute(httpPost);
		if (response != null) {
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			LOGGER.info("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				LOGGER.info("Output" + output);
			}

			if (response.getStatusLine().getStatusCode() == 201) {
				LOGGER.info("Repository created successsfully");
			} else {
				LOGGER.info("Respository with same name already exists");
			}
		}
		client.close();
	}

}
