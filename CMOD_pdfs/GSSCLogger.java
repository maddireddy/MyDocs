import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GSSCLogger {
	private final String LOG_PATH = "/usr/gssc/component/logs/GSSC_";
	  FileWriter out;
	  File ioFile;
	  public static final String TIMESTAMP_FORMAT_DATE_ONLY = "yyyy-MM-dd";
	  public static String filePath;

	  public GSSCLogger()
	  {
	    try
	    {
	      this.ioFile = initialize();
	      boolean append = checkExistence();

	      this.out = new FileWriter(this.ioFile, append);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  public FileWriter getOut() {
	    return this.out;
	  }

	  public void writeToLog(String poDataArr) throws Exception
	  {
	    try
	    {
	      boolean append = checkExistence();

	      if (poDataArr != null)
	      {
	        if (append)
	          this.out.write(poDataArr);
	        else {
	          this.out.write(poDataArr);
	        }
	      }

	      this.out.flush();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  public void close() throws Exception {
	    try {
	      this.out.close();
	    }
	    catch (IOException ioe) {
	      ioe.printStackTrace();
	    }
	  }

	  public boolean checkExistence()
	  {
	    boolean append = false;
	    try
	    {
	      if ((this.ioFile != null) && 
	        (this.ioFile.exists()))
	      {
	        append = true;
	      }
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }

	    return append;
	  }

	  public static Date getUTCDate(Date poDate)
	  {
	    Date woGmtTime = null;
	    String wsUTCTimestamp = null;
	    SimpleDateFormat woFormatter = null;

	    woFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    woGmtTime = new Date(poDate.getTime() - 
	      Calendar.getInstance().getTimeZone().getRawOffset());
	    wsUTCTimestamp = woFormatter.format(woGmtTime);
	    try {
	      woGmtTime = woFormatter.parse(wsUTCTimestamp);
	    } catch (ParseException loParserExp) {
	      loParserExp.printStackTrace();
	    }

	    return woGmtTime;
	  }

	  public File initialize()
	  {
	    try
	    {
	      String lsFileName = "/usr/gssc/component/logs/GSSC_" + 
	        new SimpleDateFormat("yyyy-MM-dd").format(getUTCDate(new Date(System.currentTimeMillis()))) + ".log";

	      this.ioFile = new File(lsFileName);
	      System.out.println(this.ioFile.getAbsolutePath());
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return this.ioFile;
	  }
}
