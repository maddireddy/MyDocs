import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerUtility {

	static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat(
			PropertyServiceLoader.getValue("LOG_SIMPLE_DATE_FORMAT")); //$NON-NLS-1$
	static final SimpleDateFormat SIMPLE_FORMAT = new SimpleDateFormat(
			PropertyServiceLoader.getValue("SIMPLE_DATE_FORMAT")); //$NON-NLS-1$
	static final String LOGFILE_PATH = PropertyServiceLoader
			.getValue("LOG_FILE_FOLDER_PATH"); //$NON-NLS-1$

	/**
	 * @param Message
	 */
	public static void info(String Message) {

		String logfilename = PropertyServiceLoader.getValue("LOG_FILE_NAME"); //$NON-NLS-1$
		String strdate = SIMPLE_FORMAT.format(new Date());

		logfilename = replace(logfilename, ".", "_" + strdate + "."); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$

		File myFile = null;
		PrintWriter out = null;

		if (LOGFILE_PATH != null && logfilename != null) {

			myFile = new File(LOGFILE_PATH + logfilename);
			if (myFile != null) {
				if (!myFile.isDirectory()) {
					try {
						FileWriter myWriter = new FileWriter(LOGFILE_PATH
								+ logfilename, true);
						out = new PrintWriter(myWriter);
						out.println(LOG_DATE_FORMAT.format(new Date()) + ";" //$NON-NLS-1$
								+ Message);
						out.close();
						myWriter.close();
					} catch (Exception e) {
						System.out
								.println("Write File Error " + e.getMessage()); //$NON-NLS-1$
					}
				}
				myFile = null;
			}
		} else {
			LoggerUtility.info(LOG_DATE_FORMAT.format(new Date()) + " : "); //$NON-NLS-1$
		}
	}

	/**
	 * @param Message
	 */
	public static void error(String Message) {

		String strdate = SIMPLE_FORMAT.format(new Date());
		String logfilename = PropertyServiceLoader.getValue("LOG_FILE_NAME"); //$NON-NLS-1$
		logfilename = replace(logfilename, ".", "_" + strdate + "."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		File myFile = null;
		PrintWriter out = null;

		if (LOGFILE_PATH != null && logfilename != null) {

			myFile = new File(LOGFILE_PATH + logfilename);

			if (myFile != null) {
				if (!myFile.isDirectory()) {
					try {
						FileWriter myWriter = new FileWriter(LOGFILE_PATH
								+ logfilename, true);
						out = new PrintWriter(myWriter);
						out.println(LOG_DATE_FORMAT.format(new Date()) + ";" //$NON-NLS-1$
								+ Message);
						out.close();
						myWriter.close();
					} catch (Exception e) {
						LoggerUtility.error("Write File Error " //$NON-NLS-1$
								+ e.getMessage());
					}
				}
				myFile = null;
			}
		} else {
			LoggerUtility.info(LOG_DATE_FORMAT.format(new Date()) + " : "); //$NON-NLS-1$
		}
	}

	/**
	 * @param Message
	 */
	public static void exception(String Message) {

		String strdate = SIMPLE_FORMAT.format(new Date());
		String logfilename = PropertyServiceLoader
				.getValue("LOG_EXCP_FILE_NAME"); //$NON-NLS-1$
		logfilename = replace(logfilename, ".", "_" + strdate + "."); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$

		File myFile = null;
		PrintWriter out = null;

		if (LOGFILE_PATH != null && logfilename != null) {

			myFile = new File(LOGFILE_PATH + logfilename);

			if (myFile != null) {
				if (!myFile.isDirectory()) {
					try {
						FileWriter myWriter = new FileWriter(LOGFILE_PATH
								+ logfilename, true);
						out = new PrintWriter(myWriter);
						out.println(Message);
						out.close();
						myWriter.close();
					} catch (Exception e) {
						LoggerUtility.error("Write File Error " //$NON-NLS-1$
								+ e.getMessage());
					}
				}
				myFile = null;
			}
		} else {
			LoggerUtility.info(LOG_DATE_FORMAT.format(new Date()) + " : "); //$NON-NLS-1$
		}
	}

	/**
	 * @param oriStr
	 * @param oldStr
	 * @param newStr
	 * @return String
	 */
	public static String replace(String oriStr, String oldStr, String newStr) {

		if (oriStr == null)
			return null;

		int start = oriStr.indexOf(oldStr);

		if (start == -1)
			return oriStr;

		int oldLen = oldStr.length();
		char[] origChars = oriStr.toCharArray();

		StringBuffer buffer = new StringBuffer();
		int copyFrom = 0;

		while (start != -1) {
			buffer.append(origChars, copyFrom, start - copyFrom);
			buffer.append(newStr);
			copyFrom = start + oldLen;
			start = oriStr.indexOf(oldStr, copyFrom);
		}
		buffer.append(origChars, copyFrom, origChars.length - copyFrom);
		return buffer.toString();
	}
}
