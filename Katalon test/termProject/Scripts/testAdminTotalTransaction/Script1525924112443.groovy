import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('')

WebUI.navigateToUrl('http://54.190.45.48:8094/')

WebUI.setText(findTestObject('Page_Login/input_username'), 'admin')

WebUI.setText(findTestObject('Page_Login/input_password'), 'admin')

WebUI.click(findTestObject('Page_Login/button_Login'))

WebUI.click(findTestObject('Page_Main/button_add to cart'))

WebUI.click(findTestObject('Page_Main/a_Total Transaction'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Main/th_1'), '1')

WebUI.verifyElementText(findTestObject('Page_Main/th_2'), '2')

WebUI.verifyElementText(findTestObject('Page_Main/p_Total price'), 'Total price: 80,690 THB')

//WebDriver driver = DriverFactory.getWebDriver()
//
//WebElement Table = driver.findElement(By.xpath(''))
//
//List<WebElement> Transactions = Table.findElements(By.tagName('th'))
//
//println('No. of elements: ' + Transactions.size())
//
//'Compare the value'
//WebUI.verifyEqual(2, Transactions.size())
//WebElement Table = driver.findElement(By.xpath('//*[@id="add-row"]/div/div[2]'))
// 
// List<WebElement> totalMoney = Table.findElements(By.tagName('p'))
// 
// println('No. of elements: ' + totalMoney.size())
// 
// 'Compare the value'
// WebUI.verifyEqual(1, totalMoney.size())
WebUI.closeBrowser()

