package neptune.aop

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

/**
 * https://blog.csdn.net/fanrenxiang/article/details/80844077
 */
@Aspect
@Component
class LogAspect {
	Logger logger = LogManager.getLogger(this.class)

	@Pointcut("execution(public * neptune.controller.LoginController.indexPage(..))")
	public void print(){}

	@Before("print()")
	public void before(){
		logger.info("AOP Before start ....")
		Thread.sleep(1000)
		logger.info("AOP Before end ....")
	}

	@After("print()")
	public void after(){
		logger.info("AOP After start ....")
		logger.warn("--------------------")
		Thread.sleep(2000)
		logger.info("AOP After end ....")
	}


	@AfterReturning(pointcut = "print()", returning = "object")
	public void getAfterReturn(Object object) {
		logger.info("AOP AfterReturning get args: " + object)

	}
}
