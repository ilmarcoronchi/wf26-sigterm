package lab.sigterm.core.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import lombok.extern.slf4j.Slf4j;

@Interceptor
@Slf4j
public class LoggingInterceptor {

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		String methodName = ctx.getMethod().getName();
		log.info(">>>>>>>>>>>>>> Entering method: {} <<<<<<<<<<<<<<<<<<", methodName);
		Object result = ctx.proceed(); // invoca il metodo target
		log.info(">>>>>>>>>>>>>> Exiting method: {} <<<<<<<<<<<<<<<<<<", methodName);
		return result;
	}
}
