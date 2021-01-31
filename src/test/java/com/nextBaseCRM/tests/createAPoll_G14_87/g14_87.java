package com.nextBaseCRM.tests.createAPoll_G14_87;

import com.nextBaseCRM.tests.utilities.Sleep;
import com.sun.tools.javac.comp.Check;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class g14_87 {
    public static void main(String[] args) {


        //TODO: DRIVER SETUP
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com");

        //TODO: LOGIN
        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameInput.sendKeys("helpdesk27@cybertekschool.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser" + Keys.ENTER);

        //TODO:             TEST-1
        // ACTION:          Click Activity Stream
        // EXPECTED RESULT: To be able to observe/view the name: "Activity Stream", and page title: "Portal"
        driver.findElement(By.xpath("//a[@title='Activity Stream']")).click();
        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        if ( actualTitle.endsWith(expectedTitle) )  System.out.println("TEST-1 | PASSED!"); // Expected: Title ends with 'Portal'
        else                                        System.out.println("TEST-1 | FAILED!!!"); // Expected: Title ends with 'Portal'

        //--- END OF TEST-1 ------------------------------------------------------

        //TODO:             TEST-2
        // ACTION:          Click Poll tab
        // EXPECTED RESULT: To be able to observe/view an empty/new Poll creation block.
        Sleep.seconds(2);
        WebElement pollTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        pollTab.click();
        Sleep.seconds(2);
        List<WebElement> pollBlocksAfterClick = driver.findElements(By.xpath("//form[@id='blogPostForm']"));
        if ( pollBlocksAfterClick.size() == 1 ) System.out.println("TEST-2-1 | PASSED!");// Expected: Poll Block IS displayed AFTER clicking POLL.
        else                                    System.out.println("TEST-2-1 | FAILED!!!");// Expected: Poll Block IS displayed AFTER clicking POLL.

//        WebElement pollBlock = driver.findElement(By.xpath("//form[@id='blogPostForm']"));
//        if ( pollBlock.isDisplayed() )    System.out.println("Poll Block IS displayed.");
//        else                              System.out.println("Poll Block is NOT displayed.");

        //TODO: LOCATING POLL WEB ELEMENTS
        WebElement topicInput =         driver.findElement(By.xpath("//input[@id='POST_TITLE']"));
        WebElement iFrameMessage =      driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        WebElement questionInput =      driver.findElement(By.xpath("//input[@id='question_0']"));
        WebElement answer_1_1_Input =   driver.findElement(By.xpath("//input[@id='answer_0__0_']"));
        WebElement sendButton =         driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        WebElement cancelLink =         driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));

        if (topicInput          .isDisplayed()  &&
            iFrameMessage       .isDisplayed()  &&
            questionInput       .isDisplayed()  &&
            answer_1_1_Input    .isDisplayed()  &&
            sendButton          .isDisplayed()  &&
            cancelLink          .isDisplayed()    )
            System.out.println("TEST-2-2 | PASSED!");// Expected: All poll elements are displayed.
        else
            System.out.println("TEST-2-2 | FAILED!!!");// Expected: All poll elements are displayed.

        //--- END OF TEST-2 ------------------------------------------------------

        //TODO:             TEST-3
        // ACTION:          Click the "Topic" text field
        // EXPECTED RESULT: Topic text field is enabled
        if ( topicInput.isEnabled() )   System.out.println("TEST-3 | PASSED!");// Expected: Topic is enabled
        else                            System.out.println("TEST-3 | FAILED!!!");// Expected: Topic is enabled

        //--- END OF TEST-3 ------------------------------------------------------

        //TODO:             TEST-4
        // ACTION:          Click the "Question" text filed
        // EXPECTED RESULT: Question text field is enabled
        if ( questionInput.isEnabled() )    System.out.println("TEST-4 | PASSED!");// Expected: Question is enabled
        else                                System.out.println("TEST-4 | FAILED!!!");// Expected: Question is enabled

        //--- END OF TEST-4 ------------------------------------------------------

        //TODO:             TEST-5
        // ACTION:          Click the "Answer" text filed
        // EXPECTED RESULT: Answer text field is enabled
        if ( answer_1_1_Input.isEnabled() )     System.out.println("TEST-5 | PASSED!");// Expected: Answer is enabled
        else                                    System.out.println("TEST-5 | FAILED!!!");// Expected: Answer is enabled

        //--- END OF TEST-5 ------------------------------------------------------

        //TODO:             TEST-6
        // ACTION:          Click "Allow multiple choice" checkbox to check and uncheck it.
        // EXPECTED RESULT: 1. By default the checkbox should be enabled and unchecked.
        //                  2. When clicked the "checked" status of the checkbox should switch on-off.
        WebElement pollCheckBox1 = driver.findElement(By.xpath("//input[@id='multi_0']"));

        if ( pollCheckBox1.isEnabled() && !pollCheckBox1.isSelected() )
                System.out.println("TEST-6-1 | PASSED!");// Expected: Checkbox IS enabled and is NOT selected.
        else    System.out.println("TEST-6-1 | FAILED!!!");// Expected: Checkbox IS enabled and is NOT selected.

        pollCheckBox1.click();

        if ( pollCheckBox1.isEnabled() && pollCheckBox1.isSelected() )
                System.out.println("TEST-6-2 | PASSED!");// Expected: After first click checkbox IS enabled and IS selected.
        else    System.out.println("TEST-6-2 | FAILED!!!");// Expected: After first click checkbox IS enabled and IS selected.

        pollCheckBox1.click();

        if ( pollCheckBox1.isEnabled() && !pollCheckBox1.isSelected() )
                System.out.println("TEST-6-3 | PASSED!");// Expected: After second click checkbox IS enabled and is NOT selected.
        else    System.out.println("TEST-6-3 | FAILED!!!");// Expected: After second click checkbox IS enabled and is NOT selected.

        //--- END OF TEST-6 ------------------------------------------------------

        //TODO:             TEST-7
        // ACTION:          Click "Add Question" link
        // EXPECTED RESULT: A new set of Questions and Answers should be appended to the poll.
        WebElement addQuestionLink =    driver.findElement(By.xpath("//a[@class='vote-new-question-link addq']"));
        addQuestionLink.click();

        WebElement question2Input =     driver.findElement(By.xpath("//input[@id='question_1']"));
        WebElement answer_2_1_Input =   driver.findElement(By.xpath("//input[@id='answer_1__0_']"));
        WebElement pollCheckBox2 =      driver.findElement(By.xpath("//input[@id='multi_1']"));

        if (    question2Input  .isDisplayed() &&
                answer_2_1_Input.isDisplayed() &&
                pollCheckBox2   .isDisplayed() )
                System.out.println("TEST-7 | PASSED!");// Expected: Second set of Q/A appended
        else    System.out.println("TEST-7 | FAILED!!!");// Expected: Second set of Q/A appended

        //--- END OF TEST-7 ------------------------------------------------------

        //TODO:             TEST-8
        // ACTION:          Click "Cancel" link
        // EXPECTED RESULT: 1. The poll should be deleted.
        //                  2. The data should be deleted.
        //                  3. The Messages tab should be selected.
        Sleep.seconds(1);
        cancelLink = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));
        cancelLink.click();

        Sleep.seconds(1);

        WebElement pollBlock = driver.findElement(By.xpath("//form[@id='blogPostForm']"));
        if ( pollBlock.isDisplayed() )  System.out.println("TEST-8-1 | FAILED!!!");// Expected: Poll Block is NOT displayed.
        else                            System.out.println("TEST-8-1 | PASSED!");// Expected: Poll Block is NOT displayed.

        pollBlocksAfterClick = driver.findElements(By.xpath("//form[@id='blogPostForm']"));

        if ( pollBlocksAfterClick.size() == 0 && !pollBlock.isDisplayed())
                System.out.println("TEST-8-2 | PASSED!");// Expected: Poll Block is REMOVED after clicking CANCEL.
        else if ( pollBlocksAfterClick.size() != 0 && !pollBlock.isDisplayed()) {
                System.out.println("TEST-8-2 | FAILED!!!"); // Expected: Poll Block is REMOVED after clicking CANCEL.
                                                            // Actual: Poll block is hidden but not removed.
        } else if ( pollBlocksAfterClick.size() != 0 && pollBlock.isDisplayed()) {
                System.out.println("TEST-8-2 | FAILED!!!"); // Expected: Poll Block is REMOVED after clicking CANCEL.
                                                            // Actual: Poll block is displayed and is not removed.
        }

        //--- END OF TEST-8 ------------------------------------------------------

        //TODO:             Test-9
        // ACTION:          1. Input test data into the poll file
        //                  2. Click SEND button
        // EXPECTED RESULT: The posted poll should have the test data
        Sleep.seconds(1);
        pollTab.click();

        Sleep.seconds(1);
        topicInput.sendKeys("aA@2 1");

        Sleep.seconds(1);
        driver.switchTo().frame(iFrameMessage);
        WebElement iframeMessageBody = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        iframeMessageBody.sendKeys("aA@2 2");
        driver.switchTo().defaultContent();

        Sleep.seconds(1);
        questionInput.sendKeys("aA@2 3");

        Sleep.seconds(1);
        answer_1_1_Input.sendKeys("aA@2 4");

        Sleep.seconds(1);
        sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        Sleep.seconds(1);

        WebElement posted_PollTopic =       driver.findElement(By.xpath("//div[@class='feed-post-item']"));
        WebElement posted_PollMessage =     driver.findElement(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));
        WebElement posted_PollQuestion =    driver.findElement(By.xpath("//div[@class='bx-vote-question-title']"));
        WebElement posted_PollAnswer =      driver.findElement(By.xpath("//div[@class='bx-vote-bar']"));

        String expectedText = "aA@2";

        if (    posted_PollTopic.getText().contains(expectedText)     &&
                posted_PollMessage.getText().contains(expectedText)   &&
                posted_PollQuestion.getText().contains(expectedText)  &&
                posted_PollAnswer.getText().contains(expectedText)    )
                System.out.println("TEST-9 | PASSED!");// Expected: Data is correctly displayed. Poll successfully posted.
        else    System.out.println("TEST-9 | FAILED!!!");// Expected: Data is correctly displayed. Poll successfully posted.

        //--- END OF TEST-9 ------------------------------------------------------

        //TODO: TEARDOWN
        Sleep.seconds(3);
        driver.close();
    }
}