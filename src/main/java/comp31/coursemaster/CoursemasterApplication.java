package comp31.coursemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Instructions to test:

First click "go to login"                                                   - login use case
Sign in as "Boss"
password is Coolboss

Create a new user                                                           - Add new user use case
to make it easier, none of the fields are required
You can see the added user in the table below

Click logout, this done not end the session, it simply returns to /login

Login as an instructor - username Charles, password is password  
Click view courses to view the courses in the database

Go to create new assignment and fill in the fields                           - add new content use case
and click create assignment

Now click on the select course dropdown to choose the course you added to and select
view assignments, you should see 2 initialized ones and the one you just added

Click back, click logout, login as a student now
user id - Alice, password is password

Select a course from the dropdown and the assignments dropdown will populate
select any assignment from the dropdown and click upload assignment, 
choose a file from your computer and then click submit.                       - student submit assignment use case

Now click uploaded assignments button, it should just show the one you uploaded

Now click view payments, select the payment record you want to make a payment to 
and enter the amount. Click pay, this should update in the table your amount owing 
and will change the status to paid once there is no amount owing.             - make payment use case

Additionally you can logout here and log back in as the instructor,
Charles, password
Select the course from the dropdown that you uploaded the assignment to 
and click view assignments. You should see a button in the submission column that 
says download, if you click this it will download the file back to your computer 
from the student submission. 											       - download assignment
 */

@SpringBootApplication
public class CoursemasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursemasterApplication.class, args);
	}

}
