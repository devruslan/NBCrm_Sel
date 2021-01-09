package com.nextBaseCRM.tests.createAPoll_G14_87;

import com.nextBaseCRM.tests.utilities.Sleep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class g14_87 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com");
//

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

        if ( actualTitle.endsWith(expectedTitle) ) System.out.println("PASSED! Expected: Title ends with Portal");
        else System.out.println("FAILED!!! Expected: Title ends with Portal");
        System.out.println("---------");

//      Step 2
//      Click Poll
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']")).click();
//      To be able to observe/view an empty/new Poll creation block.
        Sleep.seconds(2);

        WebElement topicInput = driver.findElement(By.xpath("//input[@id='POST_TITLE']"));
        WebElement iframeInput = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        WebElement questionInput = driver.findElement(By.xpath("//input[@id='question_0']"));
        WebElement answer_1_1_Input = driver.findElement(By.xpath("//input[@id='answer_0__0_']"));
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        WebElement cancelLink = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));

        if ( topicInput.isDisplayed() && iframeInput.isDisplayed() &&
                questionInput.isDisplayed() && answer_1_1_Input.isDisplayed() &&
                sendButton.isDisplayed() && cancelLink.isDisplayed() )
            System.out.println("PASSED! Expected: All elements are displayed.");
        else
            System.out.println("FAILED!!! Expected: All elements are displayed.");

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

        if ( question2Input.isDisplayed() &&
                answer_2_1_Input.isDisplayed() &&
                pollCheckBox2.isDisplayed() )
            System.out.println("PASSED! Expected: Second set of Q/A appended");
        else
            System.out.println("FAILED!!! Expected: Second set of Q/A appended");

        System.out.println("---------");

//      Step 11
//      Click "Cancel" link
//      The poll should be deleted.
//      The data should be deleted.
//      The Messages tab should be selected.

//      Step 12
//      Click "SEND" button
//      The poll should be posted on the Activity Stream page, on the top.
//      I should be able to see all my data.

//      Step 4
//      Topic: Input a string (Upper case letters, lowercase letters, space, numbers, special chars)
//      "Lorem ipsum dolor sit amen       LOREM IMSUM DOLOR SIT AMEN 0123456789 ~!@#$%^&*()_+=-`<>?/|\"
//      I should be able to input all the characters of the data text
//
//      Step 6
//      Question: Input a string (Upper case letters, lowercase letters, space, numbers, special chars)
//      "Lorem ipsum dolor sit amen       LOREM IMSUM DOLOR SIT AMEN 0123456789 ~!@#$%^&*()_+=-`<>?/|\"
//      I should be able to input all the characters of the data text
//
//      Step 8
//      Answer: Input a string (Upper case letters, lowercase letters, space, numbers, special chars)
//      "Lorem ipsum dolor sit amen       LOREM IMSUM DOLOR SIT AMEN 0123456789 ~!@#$%^&*()_+=-`<>?/|\"
//      I should be able to input all the characters of the data text


        Sleep.seconds(2);
        driver.close();


    }
}
