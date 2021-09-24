import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;


/**
 * Servlet implementation class FileServlet
 */
public class FileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 判断上传的文件普通表单还是带文件的表单
    if (!ServletFileUpload.isMultipartContent(request)) {
      return;//终止方法运行,说明这是一个普通的表单,直接返回
    }

    // 创建上传文件的保存路径，建议在WEB-INF路径下，安全，用户无法直接访问上传的文件
    String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
    File tempFile = new File(tmpPath);
    if (!tempFile.exists()) {
      tempFile.mkdir();//创建临时目录
    }

    //创建上传文件的保存路径,建议在WEB-INF路径下,安全,用户无法直接访间上传的文件;
    String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
    File uploadFile = new File(uploadPath);
    if (!uploadFile.exists()) {
      uploadFile.mkdir(); //创建这个月录
    }

    /*
      处理上传的文件,一般都需要通过流来获取,我们可以使用 request.getInputStream(),原生态的文件上传流获取,十分麻烦
      建议使用 Apache的文件上传组件来实现, common-fileUpload,它需要 commons-io组件
     */
    try {
      // 获取ServletFileUpload
      ServletFileUpload fileUpload = getServletFileUpload(tempFile);

      // 处理上传文件
      // 把前端请求解析，封装成FileItem对象，需要从ServletFileUpload对象中获取
      boolean flag = uploadParseRequest(fileUpload, request, uploadPath);

      // Servlet请求转发消息
      if (flag) {
        // Servlet请求转发消息
        request.setAttribute("flag", true);
      } else {
        request.setAttribute("flag", false);
      }
      request.getRequestDispatcher("info.jsp").forward(request, response);
    } catch (FileUploadException e) {
      e.printStackTrace();
    }
  }


  public static ServletFileUpload getServletFileUpload(File tempFile) {
    // 创建DiskFileItemFactory对象，处理文件路径或者大小限制
    DiskFileItemFactory factory = new DiskFileItemFactory();
    // 通过这个工厂设置一个缓冲区,当上传的文件大于这个缓冲区的时候,将他放到临时文件中;
    factory.setSizeThreshold((int) 2e20);// 缓冲区大小为1M
    factory.setRepository(tempFile);// 临时目录的保存目录,需要一个file

    ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
    // 处理乱码问题
    servletFileUpload.setHeaderEncoding("UTF-8");
    // 设置总共能够上传文件的大小 10M
    servletFileUpload.setFileSizeMax((long) 2e21);

    /*
      监听长传进度
        pBytesRead:已读取到的文件大小
        pContextLength:文件大小
     */
    servletFileUpload.setProgressListener((long pBytesRead, long pContentLength, int pItems) -> System.out.println("已上传：" + pBytesRead + "\n总大小：" + pContentLength));
    return servletFileUpload;
  }

  public static boolean uploadParseRequest(ServletFileUpload upload, HttpServletRequest request, String uploadPath)
      throws FileUploadException, IOException {
    boolean flag = false; // 是否成功

    // 把前端请求解析，封装成FileItem对象
    List<FileItem> fileItems = upload.parseRequest(request);
    for (FileItem fileItem : fileItems) {
      // 判断上传的文件是普通的表单还是带文件的表单
      if (fileItem.isFormField()) {
        // getFieldName指的是前端表单控件的name;
        String name = fileItem.getFieldName();
        String value = fileItem.getString("UTF-8"); // 处理乱码
        System.out.println(name + ": " + value);
      } else {

        // ============处理文件==============
        // 拿到文件名
        String uploadFileName = fileItem.getName();
        /*
          .trim() 删除前后空格
          下面的写法会导致"uploadFileName == null" 一直判定为false :
            uploadFileName.trim().equals("") || uploadFileName == null
            反过来就好了,原因是字符串对象引用改变了
         */
        if (uploadFileName == null || uploadFileName.trim().equals("")) {
          continue;
        }

        // 获得上传的文件名
        String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
        // 获得文件的后缀名,如果文件后缀名fileExtName不是我们所需要的 就直按return.不处理,告诉用户文件类型不对。
        String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

        System.out.println("文件名: " + fileName + "\n后缀名" + fileExtName);
        // ================处理文件完毕==============


        /*
          UUID.randomUUID(),随机生一个唯一识别的通用码,保证文件夹名唯一
          文件真实存在的路径 realPath
         */
        String realPath = uploadPath + "/" + UUID.randomUUID();

        // 给每个文件创建一个对应的文件夹
        File realPathFile = new File(realPath);
        if (!realPathFile.exists()) {
          realPathFile.mkdir();
        }
        // ==============存放地址完毕==============


        // 获得文件上传的流
        InputStream inputStream = fileItem.getInputStream();
        // 创建一个文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(realPath + "/" + fileName);

        // 创建一个缓冲区
        byte[] buffer = new byte[(int) 2e20]; // 1M
        int len;
        while ((len = inputStream.read(buffer)) > 0) {
          fileOutputStream.write(buffer, 0, len);
        }

        // 关闭流
        fileOutputStream.close();
        inputStream.close();

        flag = true;
        // 上传成功,清除临时文件
        fileItem.delete();
        //=============文件传输完成=============
      }
    }
    return flag;
  }
}
