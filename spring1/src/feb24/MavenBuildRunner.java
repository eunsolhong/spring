package feb24;

import java.util.List;

public class MavenBuildRunner implements BuildRunner {

	private String mavenPath; // 값을 추가시킴

	@Override
	public void build(List<String> srcDirs, String binDir) {
		String info = "메이븐 경로 : " + mavenPath + "\n";
		for (String srcDir : srcDirs)
			info += "소스 경로 : " + srcDir + "\n";
		info += "클래스파일경로 : " + binDir + "\n";

		System.out.printf("MavenBuildRunner.build() 실행\n%s", info);
	}

	public void setMavenPath(String mavaenPath) { //메인에서 얘가 먼저실행
		this.mavenPath = mavaenPath;
	}
}

interface BuildRunner { 
	public void build(List<String> srcDirs, String binDir);
}
