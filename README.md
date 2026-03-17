# Course Management System (CMS) - Deliverable 1
**Course:** Web Application Development - CPAN-228-RNA  
**Team:** Nebil Ferej, Harry Joseph

## Project Breakdown
This is the first deliverable for our Course Management System. For this phase, we focused on building the core application using Spring Boot, setting up the database connection, and creating the initial user interface with Thymeleaf and Bootstrap.

### Key Features
*   **Database & JPA**: We're using Hibernate and Spring Data JPA to handle data. The `Course` entity stores course codes, names, credits, and departments. Every entry gets an automatic ID and a creation timestamp.
*   **Web Interface**: Built with Thymeleaf and Bootstrap 5 so it works on mobile and desktop.
    *   **Main List**: Shows all courses with support for sorting (click the headers) and filtering by department or credit count.
    *   **Creation Form**: A simple form to add new courses. It has server-side validation, so if you miss a field or enter the wrong credit count, it shows a clear error message.
*   **Seed Data**: We included a `data.sql` file that automatically loads a few sample courses when the app starts.

---

## Deliverable 1 Requirements
This submission covers everything required for the March 15 deadline:

1.  **Navigation**: A working navbar that links to the Home page and two info pages (`Info 1` and `Info 2`). We used Thymeleaf fragments to keep the header and footer consistent across the site.
2.  **Form Validation**: The add-course form checks that course codes are between 4-8 characters and credits are between 1-5.
3.  **Persistence**: Form submissions are saved directly to the H2 database.
4.  **List Controls**: The course table supports pagination and dynamic sorting handled on the server.

---

## Technical Access
*   **URL**: [http://localhost:8081](http://localhost:8081)
*   **H2 Console**: [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
    *   **JDBC URL**: `jdbc:h2:mem:coursedb`
    *   **Login**: `sa` / `password`

---

## Milestone Progress
*   **Milestone 1**: Project setup and initial.
*   **Milestone 2**: Created the Course entity and loaded the sample data.
*   **Milestone 3**: Finished the controller setup and the validation logic for the forms.
*   **Milestone 4**: Added pagination and the search/filter feature to the list view.
*   **Final**: Testing, tidying up the code, and adding these screenshots.

---

## Application Screenshots

### Home Page
![Home Page](images/home_page.png)

### Course List & Filters
![Course List](images/course_list.png)

### Add New Course
![Create Course Form](images/create_form.png)

### Info Page
![Info Page](images/info_page.png)

---



