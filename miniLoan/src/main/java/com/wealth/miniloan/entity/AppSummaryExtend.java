package com.wealth.miniloan.entity;

public class AppSummaryExtend extends MlAppSummary {

    private MlNaturalApp naturalApp;
    private MlCorpApp corpApp;

    public MlNaturalApp getNaturalApp() {
		return naturalApp;
	}

	public void setNaturalApp(MlNaturalApp naturalApp) {
		this.naturalApp = naturalApp;
	}

	public MlCorpApp getCorpApp() {
		return corpApp;
	}

	public void setCorpApp(MlCorpApp corpApp) {
		this.corpApp = corpApp;
	}
}