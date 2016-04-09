package dsynhub.its.controller.issuedetail;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import dsynhub.its.bean.IssueBean;
import dsynhub.its.dao.IssueDao;
public class IssueDetailController extends HttpServlet
{
	private static final long serialVersionUID = 5529305582961502104L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		IssueBean bean=new IssueBean();
		boolean multipart=ServletFileUpload.isMultipartContent(request);
		if(!multipart)
		{
			
		}
		//private
		else
		{
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List items=null;			
			try
			{
				items=upload.parseRequest(request);
			}
			catch(FileUploadException e)
			{
				e.printStackTrace();
			}
			Iterator itr=items.iterator();
			String fieldname="";
			String val="";
			while(itr.hasNext())
			{
				FileItem item=(FileItem)itr.next();
				if(item.isFormField())
				{
					fieldname = item.getFieldName();
					val = item.getString();
				System.out.println("fieldname"+fieldname);
				System.out.println("val"+val);
					if(fieldname.equals("issue"))
					{
						bean.setIssueDetail(val);
					}
					if(fieldname.equals("ADD") && val.equals("ADD"))
					{
						System.out.println("btnAdd-0"+fieldname+" "+val);
						IssueDao dao=new IssueDao();
						boolean flag=dao.DataInsertIssueDetail(bean);
						if(flag)
						{
							//response.sendRedirect("rController");
							System.out.println("DONE.....");
						}
					}
				}
				else 
				{
					try
					{
						//System.out.println("5555555555555555555555555555555555");
						String itemName=item.getName();
						System.out.println("000 "+itemName);	
						String str=getServletContext().getRealPath("/")
							+"Image\\"+itemName;
						String path = "D:\\MyProject\\ISSUETRACKINGSYSTEM\\WebContent\\image1\\"+itemName;
						String filename = itemName;
						System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"+itemName);
						//System.out.println("888888888888888888888888888"+str+".........................");
						System.out.println("fileName......................"+filename);
						bean.setIssueDetail(filename);
						File savedFile=new File(path);
						item.write(savedFile);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
			}
		}
	}
}
