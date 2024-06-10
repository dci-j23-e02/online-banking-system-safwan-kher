### Assignment: Enhance the Online Banking System with Profile Management

#### Objective:
Extend the functionality of the existing Online Banking System by adding a `Profile` entity. Each user will have a one-to-one relationship with a profile. Update all the influenced layers, including the service layer, controller, and Thymeleaf templates, to manage user profiles. Ensure that the new functionality is integrated seamlessly with the existing transaction management features.

#### Requirements:
1. **Profile Entity:**
    - Create a `Profile` entity with fields such as `firstName`, `lastName`, `address`, `phoneNumber`, and `dateOfBirth`.
    - Establish a one-to-one relationship between `User` and `Profile`.

2. **Service Layer Updates:**
    - Develop methods to create, update, and retrieve user profiles.

3. **Controller Enhancements:**
    - Introduce new endpoints in the controller to handle requests for profile management.

4. **View Modifications:**
    - Modify Thymeleaf templates to include forms for creating and updating user profiles.
    - Ensure that the user interface is intuitive and responsive using Bootstrap 5.

#### Tasks:

1. **Profile Entity Implementation:**
    - Create the `Profile` entity with the necessary fields.
    - Establish a one-to-one relationship with the `User` entity.

2. **Service Layer Implementation:**
    - Develop methods in the service layer to handle profile creation, updating, and retrieval.

3. **Controller Enhancements:**
    - Add endpoints in the controller to manage profile-related operations.

4. **Thymeleaf Template Implementation:**
    - Design forms for creating and updating user profiles.
    - Use Bootstrap 5 to ensure the forms are responsive and user-friendly.

### Implementation Steps:
#### 1. Profile Entity Implementation
- Create the `Profile` entity with one-to-one relationship
- Update the `User` entity to include the one-to-one relationship
#### 2. Service Layer Implementation
Create a `ProfileService` class
#### 3. Controller Enhancements
Create a `ProfileController` class
#### 4. Thymeleaf Template Implementation
Create Thymeleaf templates for creating, updating, and viewing profiles.