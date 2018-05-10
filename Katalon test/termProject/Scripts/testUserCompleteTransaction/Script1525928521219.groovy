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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://54.190.45.48:8094/')

WebUI.setText(findTestObject('Page_Login/input_username'), 'user')

WebUI.setText(findTestObject('Page_Login/input_password'), 'user')

WebUI.click(findTestObject('Page_Login/button_Login'))

WebUI.click(findTestObject('Page_Main/button_add to cart'))

WebUI.click(findTestObject('Page_Main/button_add to cart'))

WebUI.click(findTestObject('Page_Main/a_Carts            2'))

WebUI.setText(findTestObject('Page_Main/input_amount'), '2')

WebUI.click(findTestObject('Page_Main/button_confirm'))

WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Main/div_Well done You successfully'), 'Well done! You successfully added the transaction.')

WebUI.click(findTestObject('Page_Main/a_Products'))

WebUI.closeBrowser()

