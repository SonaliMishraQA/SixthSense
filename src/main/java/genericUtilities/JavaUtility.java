package genericUtilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class JavaUtility {
	/**
	 * This method will return the current system time in the given format and we need to pass date format as a parameter.
	 * to represent date "dd", month in number "MM", month in text "LLL",year "YYYY" or "yyyy" , Hours "HH", minutes "mm", seconds "ss"
	 * dd/MM/yyyy or dd-MM-yyyy or dd-LLL-yyy or dd/LLL/yyyy etc
	 * @param dateFormat
	 * @return
	 */
	
	public String getTheSystemDateAndTime(String dateFormat)
	{
		DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime now=LocalDateTime.now();
		String dateTime=dateFormatter.format(now);
		return dateTime;

	}
	
/**
 * This method will return the Custom  date and time in the given format and we need to pass date format as a parameter.
 * to represent date "dd", month in number "MM", month in text "LLL",year "YYYY" or "yyyy" , Hours "HH", minutes "mm", seconds "ss"
 * dd/MM/yyyy or dd-MM-yyyy or dd-LLL-yyy or dd/LLL/yyyy etc
 * @param dateFormat
 * @param minusMin
 * @param minusHrs
 * @param minusDays
 * @param minusMonth
 * @param plusMins
 * @param plusHrs
 * @param plusDays
 * @return
 */
	
	public String getTheCustomeTimeAndDateBasedOnTheCurrentSystemTime(String dateFormat,int minusMin,int minusHrs,int minusDays,int minusMonth,int plusMins,int plusHrs,int plusDays )
	{
		DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime now=LocalDateTime.now();
		String dateTime=dateFormatter.format(now.minusMinutes(minusMin).minusHours(minusHrs).minusDays(minusDays).minusMonths(minusMonth).plusMinutes(plusMins).plusHours(plusHrs).plusDays(plusDays));
		return dateTime;
		
	}
	
	/**
	 * this method return up to 4 digit random number
	 * @return
	 */
	
	public int getRandomNumber()
	{
		Random r=new Random();
        int num=r.nextInt(999);
        return num;
	}
	
	/**
	 * This method will check for file name in the given download path ,if the file name found in the download path this method returns true
	 * @param downloadPath
	 * @param fileName
	 * @return
	 */
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
			System.out.println(dir_contents[i].getName());
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	/**
	 * this method will check for the last modified file in the given directory and return the last modified file
	 * @param dirPath
	 * @return
	 */
	public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	/**
	 * this method will delete the given file name from the given directory and return the status in boolean
	 * @param downloadPath
	 * @param fileName
	 * @return
	 */
	public boolean deleteFile(String downloadPath, String fileName)
	{
		File f=new File(downloadPath+"/"+fileName);
		boolean status=f.delete();
		return status;
	}

}
