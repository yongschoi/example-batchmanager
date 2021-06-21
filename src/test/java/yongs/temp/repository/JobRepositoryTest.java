package yongs.temp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.dto.Job;
import yongs.temp.model.JobInstance;
@Slf4j
@SpringBootTest
public class JobRepositoryTest {	
	@Autowired
	private JobQueryRepository jobQueryRepo;
		

	@Test
    public void JOB_QUERY_DSL_기본() {
		String name = "simpleJob";
		List<JobInstance> result = jobQueryRepo.findByName(name);
		assertThat(result.get(0).getId()).isEqualTo(75);
	}
	
	@Test
    public void JOB_QUERY_DSL_파라미터() {
		Map<String, String> result = jobQueryRepo.findParamsByExcutionId(4L);
		log.debug("----------->" + result);
	}
	
	
	@Test
    public void findByNameNoOffset_첫번째_페이지() {
		List<Job> jobList = jobQueryRepo.findByNameNoOffset(null, "jdbc", 5);
		assertThat(jobList).hasSize(5);	
	}
	
}
