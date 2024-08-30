package com.project.ETS.enums;

import java.util.List;

public enum Stack {
	
	JAVA_FULL_STACK(List.of(Subjects.HIBERNATE,Subjects.CSS,Subjects.HTML,Subjects.JAVA,Subjects.JDBC,Subjects.REACT_JS
			,Subjects.SQL,Subjects.SPRING,Subjects.SERVELETS,Subjects.JAVA_SCRIPT)),
	MERN_STACK(List.of(Subjects.CSS,Subjects.HTML,Subjects.JAVA_SCRIPT,Subjects.MONGO_DB,Subjects.REACT_JS,
			Subjects.NODE_JS,Subjects.SQL)),
	PYTHON_FULL_STACK(List.of(Subjects.CSS,Subjects.HTML,Subjects.JAVA_SCRIPT,Subjects.REACT_JS,Subjects.PYTHON,Subjects.SQL));
	private List<Subjects> subjects;

	private Stack(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}	

}
