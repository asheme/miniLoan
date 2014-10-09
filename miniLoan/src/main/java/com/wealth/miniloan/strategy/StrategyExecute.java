package com.wealth.miniloan.strategy;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wealth.miniloan.entity.Strategy;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

/**
 * 执行策略
 * 
 * @author 春国
 *
 */
@Service
@Lazy(value = false)
@Singleton
public class StrategyExecute {
	private static boolean isLoaded = false;
	private Strategy strategy = null;
	private ParseStrategy parseStrategy = null;
	private static ExecuteAssistDecisionI access = null;

	public ParseStrategy getParseStrategy() {
		return parseStrategy;
	}

	@Autowired
	public void setParseStrategy(ParseStrategy parseStrategy) {
		this.parseStrategy = parseStrategy;
	}

	/**
	 * 在类初始化后，加载策略信息，并完成动态编译
	 */
	@PostConstruct
	public void loadStrategy() {
		try {
			if (isLoaded == false || access == null) {
				byte[] bytes = createExecuteClass();
				DirectLoader s_classLoader = new DirectLoader();
				Class<?> clas = s_classLoader.load(
						"com.wealth.miniloan.strategy.ExecuteAssistDecision",
						bytes);
				access = (ExecuteAssistDecisionI) clas.newInstance();

				isLoaded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			loadStrategy();

			if (false == access.execute(null, null)) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过策略执行脚本动态生成策略执行类
	 * 
	 * @return
	 * @throws Exception
	 */
	private byte[] createExecuteClass() throws Exception {
		String script = null;
		CtClass clas = null;

		try {
			script = getStrategyScript();
			System.out.println("the Execute Body is:");
			System.out.println(script);
			ClassPool pool = ClassPool.getDefault();
			pool.insertClassPath(new ClassClassPath(this.getClass()));
			pool.importPackage("java.util");
			pool.importPackage("com.wealth.miniloan.strategy");

			if (isLoaded) {
				clas = pool
						.get("com.wealth.miniloan.strategy.ExecuteAssistDecision");
				if (clas.isFrozen()) {
					clas.detach();
					clas = null;
				}
			}
			clas = pool
					.makeClass("com.wealth.miniloan.strategy.ExecuteAssistDecision");
			clas.addInterface(pool
					.get("com.wealth.miniloan.strategy.ExecuteAssistDecisionI"));

			// add public default constructor method to class
			CtConstructor cons = new CtConstructor(new CtClass[] {}, clas);
			cons.setBody(";");
			clas.addConstructor(cons);

			// add public setTarget method
			CtMethod meth = new CtMethod(CtClass.booleanType, "execute",
					new CtClass[] { pool.get("java.util.List"),
							pool.get("java.util.List") }, clas);
			meth.setBody("{" + script + "}");
			clas.addMethod(meth);
			return clas.toBytecode();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void reloadStrategy() {
		try {
			byte[] bytes = createExecuteClass();
			DirectLoader s_classLoader = new DirectLoader();
			Class<?> clas = s_classLoader
					.load("com.wealth.miniloan.strategy.ExecuteAssistDecision",
							bytes);
			access = (ExecuteAssistDecisionI) clas.newInstance();

			isLoaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取执行脚本
	 * 
	 * @return
	 */
	private String getStrategyScript() {
		String script = "";

		this.parseStrategy.loadStrategy();
		this.strategy = this.parseStrategy.getStrategy();
		if (strategy != null) {
			script = strategy.getScripts();
		}

		return script;
	}
}
