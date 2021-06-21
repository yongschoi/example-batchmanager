package yongs.temp.service;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.dto.Distribution;
import yongs.temp.model.JobExecution;
import yongs.temp.model.StepExecution;

@Slf4j
@SpringBootTest
public class ServiceTest {
	@Autowired
	private JobService jobService;
	@Autowired
	private StepService stepService;
	@Autowired
	private DistributionService distributionService;
	
	@Test
    public void JOB_QUERY_DSL_CompletedOrAnyJob() {
		JobExecution jobExecution = jobService.findCompletedOrAnyJobByInstanceId(28L);
		log.debug("------>" + jobExecution.getId() + ":" + jobExecution.getInstanceId() + ":" + jobExecution.getStatus());
		assertThat(jobExecution).isNotEqualTo(null);
	}
	
	@Test
    public void Step_서비스_기본() {
		List<StepExecution> stepList = stepService.findByExecutionId(46L);
		stepList.forEach(step -> {
			log.debug(step.getId()+ ":" + step.getName());
		});
		assertThat(stepList.size()).isEqualTo(1);
	}
	
	@Test
    public void STEP_LIST_조회() {
		List<StepExecution> stepList = stepService.findByExecutionId(96L);
		assertThat(stepList.size()).isEqualTo(1);
	}

	@Test
    public void 채워진_리스트_조회() {
		List<Distribution> list = distributionService.getNumOfExecutionsByHour();
		
		list.forEach(d -> {
			log.debug(d.getKey() + ":" + d.getValue());
		});
		
		assertThat(list.size()).isEqualTo(24);
	}
	
	@Test
    public void JOB_이름_리스트_조회() {
		List<Distribution> list = distributionService.getJobNamesByTarget("42");
		
		list.forEach(d -> {
			log.debug(d.getKey() + ":" + d.getValue());
		});		
		assertThat(list.size()).isEqualTo(2);
	}

	
}
