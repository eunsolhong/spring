package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("download") // 이 클래스를 스프링컨테이너에서 가지고있음
public class DownloadView extends AbstractView {
//스캐닝되는 패키지에 있어야함

	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file = (File) model.get("downloadFile");
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MISE") > -1;
		String fileName = null;
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "uft-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {

				}
		}
		out.flush();
	}

}

//뷰가 없음 그러면 스프링은 뷰오브젝트를 찾아서 걔를 내보냄

//뷰(jsp)가 없어도 해당되는뷰로 데이터를 보낼수있는거 : viewobject
// 컨트롤러가 없으면 뷰네임을보냄 해당되는 뷰가 있는지 읽어냄 > 스프링컨테이너에 있어야함 그 이름을 선별하기위해
// 먼가 존재함 그게 아이디임
//String viewName