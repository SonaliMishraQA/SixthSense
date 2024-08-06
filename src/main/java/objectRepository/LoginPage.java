package objectRepository;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;
    private String username = "#username-input";
    private String password ="#password-input";
    private String loginButton = "#login-btn";
    private String loginText= "xpath = //*[@class='d-flex login-text']" ;
    private String forgotPassword = "xpath = //div[@class='forget-text']";
    private String rememberMe ="xpath = //div[@class='remember-text']";
    private String checkBocIcon ="xpath = //span[@class='checkbox-icon']";
    private String recoverPasswordTitle= "xpath = //div[@class='d-flex heading']";
    private String sendPwdRecoveryLink = "#btn-send-recoveryLink";
    private String inputRecoveryEmail = "#input-recover-email";
    private String backToHome = "#side-nav-home";
    private String textOnRecoverPasswordPage1 ="xpath = //div[@class='recover-text']";
    private String textOnRecoverPasswordPage2 = "xpath = //*[@class='help-text']";
    private String emailIsNotValid = "xpath = //div[@class='validation']";
    private String errorMessage = "xpath = //*[@class='vn-message']";
    private String rakutenSixthSenseTitle= "xpath = //*[@class='attachment-large size-large wp-image-11740']";
    
    public LoginPage(Page page)
    {
    	this.page=page;
    }
    
    
    public void loginToApplication(String UserName,String PassWord)
    {
    	page.click(username);
    	page.fill(username, UserName);
    	page.click(password);
    	page.fill(password,PassWord);
    	page.click(loginButton);
    }
    
   
   
}
