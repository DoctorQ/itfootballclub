package com.aodci.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.aodci.bean.Club;
import com.aodci.bean.ScoreBoard;
import com.aodci.dao.impl.ClubDAOImpl;
import com.aodci.service.impl.ClubServiceImpl;
import com.aodci.service.impl.ScoreBoardServiceImpl;

public class AddClubServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AddClubServlet");
		String cname = null;
		String ctime = null;
		String homefield = null;
		String coach = null;
		String imageName= null;
		String builder = null;
		String location = null;

		// 图片上传路径
		String uploadPath = req.getSession().getServletContext().getRealPath("\\") + "\\upload\\images\\";
		// System.out.println("uploadPath:" + uploadPath);
		// 图片临时上传路径
		String tempPath = req.getSession().getServletContext().getRealPath("\\") + "\\upload\\images\\temp\\";
		// 图片网络相对路径
		String imagePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/";
		// 文件夹不存在就自动创建：
		if (!new File(uploadPath).isDirectory())
			new File(uploadPath).mkdirs();
		if (!new File(tempPath).isDirectory())
			new File(tempPath).mkdirs();
		try {
			DiskFileUpload fu = new DiskFileUpload();
			// 设置最大文件尺寸，这里是4MB
			fu.setSizeMax(4194304);
			// 设置缓冲区大小，这里是4kb
			fu.setSizeThreshold(4096);
			// 设置临时目录：
			fu.setRepositoryPath(tempPath);
			// 得到所有的文件：
			List fileItems = fu.parseRequest(req);

			Iterator i = fileItems.iterator();
			// 依次处理每一个文件：
			while (i.hasNext()) {
				FileItem file = (FileItem) i.next();
				if (file.isFormField()) {
					String fieldName = file.getFieldName();
					String fieldValue = new String(file.getString().getBytes("iso8859-1"));
					switch (fieldName) {
					case "cname":
						cname = fieldValue;
						break;
					case "ctime":
						ctime = fieldValue;
						break;
					case "homefield":
						homefield = fieldValue;
						break;
					case "coach":
						coach = fieldValue;
						break;
					case "location":
						location = fieldValue;
						break;
					case "builder":
						builder = fieldValue;
						break;
					default:
						break;
					}
					// 当前是一个表单项
					// System.out.println("form field : " + fieldName + ", " +
					// fieldValue);
				}
				// 获得文件名，这个文件名是用户上传时用户的绝对路径：
				else {
					String sourcefileName = file.getName();
					if (sourcefileName != null && (sourcefileName.endsWith(".png")||sourcefileName.endsWith(".jpg") || sourcefileName.endsWith(".gif"))) {
						// 在这里可以记录用户和文件信息,生成上传后的文件名
						Random rd = new Random();
						Calendar time = Calendar.getInstance();
						System.out.println(time.get(Calendar.MONTH));
						if (sourcefileName.endsWith(".jpg")) {
							imageName = String.valueOf(time.get(Calendar.YEAR)) + String.valueOf(time.get(Calendar.MONTH))
									+ String.valueOf(time.get(Calendar.DAY_OF_MONTH)) + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
									+ String.valueOf(time.get(Calendar.MINUTE)) + String.valueOf(time.get(Calendar.SECOND))
									+ String.valueOf(rd.nextInt(100)) + ".jpg";
						} else if (sourcefileName.endsWith(".gif")) {
							imageName = String.valueOf(time.get(Calendar.YEAR)) + String.valueOf(time.get(Calendar.MONTH))
									+ String.valueOf(time.get(Calendar.DAY_OF_MONTH)) + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
									+ String.valueOf(time.get(Calendar.MINUTE)) + String.valueOf(time.get(Calendar.SECOND))
									+ String.valueOf(rd.nextInt(100)) + ".gif";
						}else if(sourcefileName.endsWith(".png")){
							imageName = String.valueOf(time.get(Calendar.YEAR)) + String.valueOf(time.get(Calendar.MONTH))
									+ String.valueOf(time.get(Calendar.DAY_OF_MONTH)) + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
									+ String.valueOf(time.get(Calendar.MINUTE)) + String.valueOf(time.get(Calendar.SECOND))
									+ String.valueOf(rd.nextInt(100)) + ".png";
						}
						
						File f1 = new File(uploadPath + imageName);
						file.write(f1);
						// System.out.println("文件名：" + destinationfileName);
					} else {
						// System.out.println("上传文件出错，只能上传 *.jpg , *.gif");
					}
				}
			}
			// 跳转到上传成功提示页面
		} catch (Exception e) {
			// 可以跳转出错页面
		}
		Club club = new Club();
		club.setcName(cname);
		club.setBuilder(builder);
		club.setCoach(coach);
		club.setcTime(ctime);
		club.setImgurl(imageName);
		club.setLocation(location);
		club.setHomeField(homefield);
		new ClubServiceImpl().addClub(club);
		req.getRequestDispatcher("goAddClub").forward(req, resp);
	}

}
