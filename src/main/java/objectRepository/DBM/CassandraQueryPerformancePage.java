package objectRepository.DBM;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import genericUtilities.GenericMethods;
import genericUtilities.IPathConstant;
import genericUtilities.JavaUtility;
import objectRepository.CommonPage;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CassandraQueryPerformancePage {
        Page page;
        GenericMethods util=new GenericMethods();
        CommonPage comPage = new CommonPage(page);


        private String selectedQueryThreshold="xpath =//div[@id='query-threshold-select']/div[@class='selected-item-text']"  ;
        private String queryThresholdDropdownBtn="id=btn-arrow-down-query-threshold-select"  ;
        private String downloadReportBtn="id =rex-pdf-download"  ;
        private String confirmationMsg="xpath =//div[@class='ant-notification-notice-with-icon']"  ;
        private String queryColumnTitle="xpath =(//table[@class='table-container']//td[@class='header-td'])[1]"  ;
        private String totalExecutionColumnTitle="xpath =(//table[@class='table-container']//td[@class='header-td'])[2]"  ;
        private String executionTimeColumnTitle="xpath =(//table[@class='table-container']//td[@class='header-td'])[3]"  ;
        private String timestampColumnTitle="xpath =(//table[@class='table-container']//td[@class='header-td'])[4]"  ;
        private String queryColumnData="xpath =//tr[@class='body-tr body-tr-secondary']/td[1]"  ;
        private String totalExecutionColumnData="xpath =//tr[@class='body-tr body-tr-secondary']/td[2]"  ;
        private String executionTimeColumnData="xpath =//tr[@class='body-tr body-tr-secondary']/td[3]"  ;
        private String timestampColumnData="xpath =//tr[@class='body-tr body-tr-secondary']/td[4]"  ;
        private String paginationDropdown="xpath =//div[@class='rex-service-sel pagination']"  ;
        private String selectedPagination="xpath =//span[@class='ant-select-selection-item']"  ;
        private String gotoPreviousPageBtn="xpath =//button[@aria-label='Go to previous page']"  ;
        private String gotoNextPageBtn="xpath =//button[@aria-label='Go to next page']"  ;
        private String selectDatabaseTypeDropDown= "id =btn-arrow-down-search-select-database-type";

        private String queryPerformanceTab="xpath = //div[@class='item' and .='Query Performance ']" ;

        public CassandraQueryPerformancePage(Page page) {
                this.page=page;
        }

        public void selectDataBaseType(String dataBaseName) {
                page.locator(selectDatabaseTypeDropDown).click();
                page.locator("//span[@class='selected-item-text' and text()='" + dataBaseName + "']").click();
        }

        public void querySelectionDropDownSelection(String dropDownValue) {
                util.selectTheOptionFromDropDown(page,queryThresholdDropdownBtn, dropDownValue);

}

        public void clickOnQueryPerformanceTab() {
                page.locator(queryPerformanceTab).click();
        }



        public void validateFirstColumnNameOfQueryPerformanceTable(String expectedTitle)
        {
                util.ValidateTheTitle(page, queryColumnTitle, expectedTitle);

        }

        public void validateSecondColumnNameOfQueryPerformanceTable(String expectedTitle)
        {
                util.ValidateTheTitle(page, totalExecutionColumnTitle, expectedTitle);
        }

        public void validateThirdColumnNameOfQueryPerformanceTable(String expectedTitle)
        {
                util.ValidateTheTitle(page, executionTimeColumnTitle, expectedTitle);
        }


        public void validateFourthColumnNameOfQueryPerformanceTable(String expectedTitle)
        {
                util.ValidateTheTitle(page, timestampColumnTitle, expectedTitle);
        }
        public void validateQueriesExecutionTimeAsPerQuerySelectionOrNot(String expectedTitle) {

                String selectedThreshold = page.locator(selectedQueryThreshold).innerText().trim();
                Locator executionTimeData=page.locator(executionTimeColumnData);

                if (selectedThreshold.contains("ms")) {
                        selectedThreshold = selectedThreshold.replace("ms", "");

                        if (selectedThreshold.equals("1")) {
                              //  Locator avgExeTime=page.locator(executionTimeColumnData);
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        if (executionTimeData.nth(i).innerText().trim().equals("0.00"))
                                                Assert.assertEquals(Double.parseDouble(executionTimeData.nth(i).innerText().trim()), 0.0);
                                        else
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=0.001);
                                }
                        } else if (selectedThreshold.equals("100")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        System.out.println(executionTimeData.nth(i).innerText().trim());
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=0.1);

                                    //    assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(0.1);
                                }
                        } else if (selectedThreshold.equals("200")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=0.2);

                                        //   assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(0.2);
                                }
                        } else if (selectedThreshold.equals("500")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=0.5);

                                      //  assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(0.5);
                                }
                        }
                } else {
                        selectedThreshold = selectedThreshold.replace("s", "");
                        if (selectedThreshold.equals("1")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=1.0);

                                        //assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(1.0);
                                }
                        } else if (selectedThreshold.equals("3")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=3.0);

                                        //  assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(3.0);
                                }
                        } else if (selectedThreshold.equals("5")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=5.0);

                                        // assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(5.0);
                                }
                        } else if (selectedThreshold.equals("10")) {
                                for (int i=0;i<executionTimeColumnData.length();i++) {
                                        Assert.assertTrue(Double.parseDouble(executionTimeData.nth(i).innerText().trim())>=10.0);

                                      //  assertThat(Double.parseDouble(avgExeTime.getText().trim())).isGreaterThanOrEqualTo(10.0);
                                }
                        }
                }
        }



        public void validateNumberOfQueriesAreAsPerPaginationDropDownSelection(int num)
        {
                comPage.selectPaginationAndValidate(page, num,queryColumnData);
            }
        public void validateDownloadButtonPresence()
        {
                Assert.assertTrue(page.locator(downloadReportBtn).isVisible());
                System.out.println(page.locator(downloadReportBtn).innerText());
                Assert.assertTrue(page.locator(downloadReportBtn).innerText().equalsIgnoreCase("Download report"));
               // assertThat(dbmoQP.getDownloadReportBtn().getText().trim()).isEqualToIgnoringCase("Download report");

        }

        public void validateDownloadReportButtonFunctionality() {


        }



}


