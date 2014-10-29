package com.wealth.miniloan.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wealth.miniloan.entity.Strategy;
import com.wealth.miniloan.strategy.model.DecisionResult;

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

	public void execute(HashMap inputMap,DecisionResult decisionResult) {
		try {
			loadStrategy();

			System.out.println("==============>>>>>>>>>>"+inputMap);
			System.out.println("==============>>>>>>>>>>"+decisionResult);
			System.out.println("==============>>>>>>>>>>"+access);
			access.execute(inputMap, decisionResult);
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
//			script = this.testStrategyStr();
			System.out.println("the Execute Body is:");
			System.out.println(script);
			ClassPool pool = ClassPool.getDefault();
			pool.insertClassPath(new ClassClassPath(this.getClass()));
			pool.importPackage("java.util");
			pool.importPackage("com.wealth.miniloan.strategy");
			pool.importPackage("com.wealth.miniloan.strategy.model");
			
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
			CtMethod meth = new CtMethod(CtClass.voidType, "execute",
					new CtClass[] { pool.get("java.util.HashMap"),
							pool.get("com.wealth.miniloan.strategy.model.DecisionResult")}, clas);
			meth.setBody("{" + script + "}");
			clas.addMethod(meth);
			return clas.toBytecode();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String testStrategyStr(){
		String scripts="";
		
		try {
			FileReader fr=new FileReader("F:\\source\\test\\compile.java");
			BufferedReader br=new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine())!=null){
			    	scripts+=line+"\r";
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scripts;
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
