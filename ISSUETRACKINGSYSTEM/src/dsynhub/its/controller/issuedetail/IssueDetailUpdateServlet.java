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

import dsynhub.its.bean.IssueDetailBean;
import dsynhub.its.dao.IssueDetailDao;
import dsynhub.its.dao.ProjectMasterDao;

public class IssueDetailUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 5529305582961502104L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
String str = "";
		
		IssueDetailBean bean=new IssueDetailBean();
		//boolean multipart1=ServletFileUpload.isMultipartContent(request);
		boolean multipart=ServletFileUpload.isMultipartContent(request);
		System.out.println("requst............"+ServletFileUpload.isMultipartContent(request));
		System.out.println(multipart);
		
		System.out.println("helloo...........................");
		if(!multipart)
		{
			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,");
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
				if(fieldname.equals("id"))
				{
					bean.setIssueId(Integer.parseInt(val));
				}
					if(fieldname.equals("issuetitle"))
					{
						bean.setIssueName(val);
					}
					if(fieldname.equals("issuedescription"))
					{
						bean.setIssueDescription(val);
					}
					if(fieldname.equals("issueCreationData"))
					{
						bean.setIssueCreationDate(val);
					}
					if(fieldname.equals("issueCreationData"))
					{
						bean.setIssueCreationDate(val);
					}
					if(fieldname.equals("taskid"))
					{
						bean.setTaskId(Integer.parseInt(val));
					}
					if(fieldname.equals("issue_type_id"))
					{
						bean.setIssueTypeId(Integer.parseInt(val));
					}
					if(fieldname.equals("issue_priority_id"))
					{
						bean.setIssuePriorityId(Integer.parseInt(val));
					}
					
					if(fieldname.equals("issue_status_id"))
					{
						bean.setIssueStatusId(Integer.parseInt(val));
					}
					if(fieldname.equals("os_id"))
					{
						bean.setOsId(Integer.parseInt(val));
					}
					if(fieldname.equals("issue_status_id"))
					{
						
						bean.setIssueStatusId(Integer.parseInt(val));
						
					}
					if(fieldname.equals("issue_status_date"))
					{
						bean.setIssueStatusDate(val);
					}
					if(fieldname.equals("userId"))
					{
						bean.setUserId(Integer.parseInt(val));
					}
					if(fieldname.equals("valUpdate") && val.equals("Update"))
					{
						System.out.println("btnAdd-0"+fieldname+" "+val);
						IssueDetailDao dao=new IssueDetailDao();
						boolean flag=dao.dataUpdateIssueDetail(bean);
						if(flag)
						{
							response.sendRedirect("IssueDetailListServlet");
							//System.out.println("llllllllllllllllllllllllllllliiiiiiiiiiii");
						}
						else
						{
							response.sendRedirect("IssueDetailInsert.jsp");
						}
					}	
				}
				else 
				{
					try
					{
						//System.out.println("5555555555555555555555555555555555");
						String itemName=item.getName();
						int n = itemName.lastIndexOf("\\");
						str = itemName.substring(n+1);
						System.out.println("Item Name......."+itemName);
						System.out.println("Sub String->"+str);
						//String str=getServletContext().getRealPath("/")
							//+"Image\\"+itemName;
						String path = "D:\\MyProject\\ISSUETRACKINGSYSTEM\\WebContent\\image1\\"+str;
						String filename = itemName;		
						bean.setIssueSnapShot(str);
						System.out.println("path set...."+bean.getIssueSnapShot());
						File savedFile=new File(path);
						item.write(savedFile);
						//System.out.println("888888888888888888888888888");
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