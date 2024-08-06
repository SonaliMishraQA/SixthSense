package demo;

import org.testng.annotations.Test;

import genericUtilities.IPathConstant;
import objectRepository.CommonPage;
import objectRepository.DBM.KafkaOverviewPage;
import playWrightFactory.BaseClass;

public class demoExecution extends BaseClass {

	@Test
	public void validateXaxisTitle() throws InterruptedException {
		page.locator("#side-nav-mq").click();
		KafkaOverviewPage ps = new KafkaOverviewPage(page);
//		page.pause();
		ps.SelectMessageQueue();
		page.waitForLoadState();
		ps.selectServiceName();
		new CommonPage(page).selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		//page.reload();
		Thread.sleep(10000);
		
		for (int i = 0; i < 1; i++) {
			ps.validateXaxisTitleforBytesIn();
			Thread.sleep(2000);
		}

	}

	@Test
	public void validateExpand() throws InterruptedException {
		page.locator("#side-nav-mq").click();

		KafkaOverviewPage ps = new KafkaOverviewPage(page);
		ps.SelectMessageQueue();
		page.waitForLoadState();
		Thread.sleep(10000);
		new CommonPage(page).selectTheTimeLineFromCalender(IPathConstant.oneMonthTimeRange);
		ps.BytesInExpandView();
	}
}
