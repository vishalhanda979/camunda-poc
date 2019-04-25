package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateGroups implements JavaDelegate {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateGroups.class);

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Invoking create groups");
	}

}
