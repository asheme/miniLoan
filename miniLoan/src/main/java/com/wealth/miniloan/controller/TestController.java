package com.wealth.miniloan.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@RequestMapping(value = "uploadTest")
	@ResponseBody
	public Map<String, Object> toAddDict(@RequestParam String fileName,
			@RequestParam("mFile") CommonsMultipartFile[] files,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (files!=null) {
				System.out.println("==========>>>>"+fileName);
				String path = request.getSession().getServletContext()
						.getRealPath("./attach/case");
				File file = new File(path);

				if (!file.exists() && !file.isDirectory()) {
					file.mkdirs();
				}
				for (MultipartFile tmpFile : files) {
					String newFileName = tmpFile.getOriginalFilename();
					FileCopyUtils.copy(tmpFile.getBytes(), new File(path + "/"
							+ newFileName));

					result.put("success", true);
					result.put("msg", "附件上传成功！");
				}
			} else {
				result.put("success", false);
				result.put("msg", "附件上传失败,此附件与案件已有附件同名，请检查附件信息后再上传！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "1附件上传失败,此附件与案件已有附件同名，请检查附件信息后再上传！");
		}

		return result;
	}
}
