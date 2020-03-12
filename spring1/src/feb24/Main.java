package feb24;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
	MavenBuildRunner buildRunner = new MavenBuildRunner();
	buildRunner.setMavenPath("/apache-maven-3.1.1"); //값을 셋팅
	
	Project samleProject = new Project();
	List<String> srcDirs = new ArrayList<>(); //프로젝트에 리스트를 만들었음
	srcDirs.add("src");
	srcDirs.add("srcResources");
	samleProject.setSrcDirs(srcDirs);
	samleProject.setBinDir("bin");
	samleProject.setBuildRunner(buildRunner);
	
		samleProject.build();
	}
}
