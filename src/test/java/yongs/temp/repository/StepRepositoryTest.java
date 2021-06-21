package yongs.temp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StepRepositoryTest {	
	@Autowired
	private StepQueryRepository stepQueryRepo;
		
	@Test
    public void updateStepStatusAndExitCodeByExecutionId_검증() {
		long result = stepQueryRepo.updateStepStatusAndExitCodeByExecutionId(57L, "COMPLETED", "REMOVED", "Exception ??");
		assertThat(result).isEqualTo(0);
	}
	
}
