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

public class g14_87 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameInput.sendKeys("helpdesk27@cybertekschool.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser" + Keys.ENTER);

//      Step 1
//      Click Activity Stream
        driver.findElement(By.xpath("//a[@title='Activity Stream']")).click();
//      To be able to observe/view the name: "Activity Stream" title: "Portal"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";

        if ( actualTitle.endsWith(expectedTitle) )
            System.out.println("PASSED! Expected: Title ends with 'Portal'");
        else
            System.out.println("FAILED!!! Expected: Title ends with 'Portal'");

        System.out.println("---------");

//      Check if poll block exists before clicking POLL tab
//        Sleep.seconds(2);
//        List<WebElement> pollBlocksBeforeClick = driver.findElements(By.xpath("//form[@id='blogPostForm']"));
//        if ( pollBlocksBeforeClick.size() == 0 )
//            System.out.println("PASSED! Expected: Poll Block is NOT displayed BEFORE clicking POLL.");
//        else
//            System.out.println("FAILED!!! Expected: Poll Block is NOT displayed BEFORE clicking POLL.");

//      Step 2
//      Click Poll tab
//        Sleep.seconds(2);
        WebElement pollTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        pollTab.click();

//      To be able to observe/view an empty/new Poll creation block.
//        Sleep.seconds(2);
        List<WebElement> pollBlocksAfterClick = driver.findElements(By.xpath("//form[@id='blogPostForm']"));
        if ( pollBlocksAfterClick.size() == 1 )
            System.out.println("PASSED! Expected: Poll Block IS displayed AFTER clicking POLL.");
        else
            System.out.println("FAILED!!! Expected: Poll Block IS displayed AFTER clicking POLL.");


//        WebElement pollBlock = driver.findElement(By.xpath("//form[@id='blogPostForm']"));
//        if ( pollBlock.isDisplayed() ) System.out.println("Poll Block IS displayed.");
//        else System.out.println("Poll Block is NOT displayed.");

        WebElement topicInput       = driver.findElement(By.xpath("//input[@id='POST_TITLE']"));
        WebElement iFrameMessage    = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        WebElement questionInput    = driver.findElement(By.xpath("//input[@id='question_0']"));
        WebElement answer_1_1_Input = driver.findElement(By.xpath("//input[@id='answer_0__0_']"));
        WebElement sendButton       = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        WebElement cancelLink       = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));

        System.out.println();
        System.out.println("\t\ttopicInput is displayed:\t\t" +     topicInput      .isDisplayed());
        System.out.println("\t\tiFrameMessage is displayed:\t\t" +     iFrameMessage     .isDisplayed());
        System.out.println("\t\tquestionInput is displayed:\t\t" +  questionInput   .isDisplayed());
        System.out.println("\t\tanswer_1_1_Input is displayed:\t" + answer_1_1_Input.isDisplayed());
        System.out.println("\t\tsendButton is displayed:\t\t" +     sendButton      .isDisplayed());
        System.out.println("\t\tcancelLink is displayed:\t\t" +     cancelLink      .isDisplayed());

        if (topicInput          .isDisplayed()  &&
            iFrameMessage       .isDisplayed()  &&
            questionInput       .isDisplayed()  &&
            answer_1_1_Input    .isDisplayed()  &&
            sendButton          .isDisplayed()  &&
            cancelLink          .isDisplayed()    )
            System.out.println("PASSED! Expected: All poll elements are displayed.");
        else
            System.out.println("FAILED!!! Expected: All poll elements are displayed.");

        System.out.println("---------");

//      Step 3
//      Click the "Topic" text field
//      Topic text field is enabled
        if ( topicInput.isEnabled() ) System.out.println("PASSED! Expected: Topic is enabled");
        else System.out.println("FAILED!!! Expected: Topic is enabled");

        System.out.println("---------");

//      Step 5
//      Click the "Question" text filed
//      Question text field is enabled
        if ( questionInput.isEnabled() ) System.out.println("PASSED! Expected: Question is enabled");
        else System.out.println("FAILED!!! Expected: Question is enabled");

        System.out.println("---------");

//      Step 7
//      Click the "Answer" text filed
//      Answer text field is enabled
        if ( answer_1_1_Input.isEnabled() ) System.out.println("PASSED! Expected: Answer is enabled");
        else System.out.println("FAILED!!! Expected: Answer is enabled");

        System.out.println("---------");

//      Step 9
//      Click "Allow multiple choice" checkbox to check and uncheck it.
//      By default the checkbox should be enabled and unchecked.
//      When clicked the "checked" status of the checkbox should switch on-off.
        WebElement pollCheckBox1 = driver.findElement(By.xpath("//input[@id='multi_0']"));

        if ( pollCheckBox1.isEnabled() && !pollCheckBox1.isSelected() )
            System.out.println("PASSED! Expected: Checkbox IS enabled and is NOT selected.");
        else
            System.out.println("FAILED!!! Expected: Checkbox IS enabled and is NOT selected.");

        pollCheckBox1.click();

        if ( pollCheckBox1.isEnabled() && pollCheckBox1.isSelected() )
            System.out.println("PASSED! Expected: After first click checkbox IS enabled and IS selected.");
        else
            System.out.println("FAILED!!! Expected: After first click checkbox IS enabled and IS selected.");

        pollCheckBox1.click();

        if ( pollCheckBox1.isEnabled() && !pollCheckBox1.isSelected() )
            System.out.println("PASSED! Expected: After second click checkbox IS enabled and is NOT selected.");
        else
            System.out.println("FAILED!!! Expected: After second click checkbox IS enabled and is NOT selected.");

        System.out.println("---------");

//      Step 10
//      Click "Add Question" link
//      A new set of Questions and Answers should be appended to the poll.
        WebElement addQuestionLink = driver.findElement(By.xpath("//a[@class='vote-new-question-link addq']"));
        addQuestionLink.click();

        WebElement question2Input = driver.findElement(By.xpath("//input[@id='question_1']"));
        WebElement answer_2_1_Input = driver.findElement(By.xpath("//input[@id='answer_1__0_']"));
        WebElement pollCheckBox2 = driver.findElement(By.xpath("//input[@id='multi_1']"));

        if (    question2Input  .isDisplayed() &&
                answer_2_1_Input.isDisplayed() &&
                pollCheckBox2   .isDisplayed() )
            System.out.println("PASSED! Expected: Second set of Q/A appended");
        else
            System.out.println("FAILED!!! Expected: Second set of Q/A appended");

        System.out.println("---------");

//      Step 11
//      Click "Cancel" link
        Sleep.seconds(1);
        cancelLink = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));
        cancelLink.click();


//      The poll should be deleted.
//      The data should be deleted.
//      The Messages tab should be selected.
        Sleep.seconds(1);

        WebElement pollBlock = driver.findElement(By.xpath("//form[@id='blogPostForm']"));
        if ( pollBlock.isDisplayed() ) System.out.println("FAILED!!! Expected: Poll Block is NOT displayed.");
        else System.out.println("PASSED! Expected: Poll Block is NOT displayed.");

        pollBlocksAfterClick = driver.findElements(By.xpath("//form[@id='blogPostForm']"));
        if ( pollBlocksAfterClick.size() == 0 && !pollBlock.isDisplayed())
            System.out.println("PASSED! Expected: Poll Block is REMOVED after clicking CANCEL.");
        else if ( pollBlocksAfterClick.size() != 0 && !pollBlock.isDisplayed()) {
            System.out.println("FAILED!!!\tExpected: Poll Block is REMOVED after clicking CANCEL.");
            System.out.println("\t\t\tActual: Poll block is hidden but not removed.");
        } else if ( pollBlocksAfterClick.size() != 0 && pollBlock.isDisplayed()) {
            System.out.println("FAILED!!! Expected: Poll Block is REMOVED after clicking CANCEL.");
            System.out.println("\t\t\tActual: Poll block is displayed and is not removed.");
        }
        System.out.println("---------");

//      Open poll again in order to test the SEND button and poll confirmation
        Sleep.seconds(1);
        pollTab.click();

//      Step 4
//      Topic: Input a string (Upper case letters, lowercase letters, numbers, special chars)
//      "aA@2"
//      Input field should accept all character types
        Sleep.seconds(1);
        topicInput.sendKeys("aA@2 1");

//      Step 4
//      Message: Input a string (Upper case letters, lowercase letters, numbers, special chars)
//      "aA@2"
//      Input field should accept all character types
        Sleep.seconds(1);
        driver.switchTo().frame(iFrameMessage);
        WebElement iframeMessageBody = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        iframeMessageBody.sendKeys("aA@2 2");
        driver.switchTo().defaultContent();

//      Step 6
//      Question: Input a string (Upper case letters, lowercase letters, numbers, special chars)
//      "aA@2"
//      Input field should accept all character types
        Sleep.seconds(1);
        questionInput.sendKeys("aA@2 3");

//      Step 8
//      Answer: Input a string (Upper case letters, lowercase letters, space, numbers, special chars)
//      "aA@2"
//      Input field should accept all character types
        Sleep.seconds(1);
        answer_1_1_Input.sendKeys("aA@2 4");


//      Step 12
//      Click "SEND" button
//      The poll should be posted on the Activity Stream page, on the top.
//      I should be able to see all my data.
        Sleep.seconds(1);
        sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

//      Verify that the Poll is posted by verifying the given data is displayed
        Sleep.seconds(1);
        WebElement posted_PollTopic = driver.findElement(By.xpath("//div[@class='feed-post-item']"));
        WebElement posted_PollMessage = driver.findElement(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));
        WebElement posted_PollQuestion = driver.findElement(By.xpath("//div[@class='bx-vote-question-title']"));
        WebElement posted_PollAnswer = driver.findElement(By.xpath("//div[@class='bx-vote-bar']"));

        String expectedText = "aA@2";
        if (    posted_PollTopic.getText().contains(expectedText)     &&
                posted_PollMessage.getText().contains(expectedText)   &&
                posted_PollQuestion.getText().contains(expectedText)  &&
                posted_PollAnswer.getText().contains(expectedText)    )
            System.out.println("PASSED! Expected: Data is correctly displayed. Poll successfully posted.");
        else
            System.out.println("FAILED!!! Expected: Data is correctly displayed. Poll successfully posted.");


        Sleep.seconds(3);
        driver.close();

    }
}
