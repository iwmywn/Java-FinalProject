/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.*;
import utils.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tuanh
 */
public class MainController implements Initializable {

    @FXML
    private Label navTime;
    @FXML
    private Label navRole;

//    nav
    @FXML
    private Button navAccounts;
    @FXML
    private Button navCourses;
    @FXML
    private Button navStudents;
    @FXML
    private Button navScores;
    @FXML
    private Button navSignOut;

//    --------------------------------------------------------start-AccountsPage
//    btn
    @FXML
    private Button btnAddUserAccounts;
//    add
    @FXML
    private Pane pnAddUserAccounts;
    @FXML
    private TextField tfEmailAddAccounts;
    @FXML
    private TextField tfFullnameAddAccounts;
    @FXML
    private PasswordField pfPasswordAddAccounts;
    @FXML
    private TextField tfUsernameAddAccounts;
//    update
    @FXML
    private Pane pnUpdateUserAccounts;
    @FXML
    private TextField tfUsernameUpdateAccounts;
    @FXML
    private TextField tfEmailUpdateAccounts;
    @FXML
    private PasswordField pfPasswordUpdateAccounts;
    @FXML
    private TextField tfFullnameUpdateAccounts;
//    filter
    @FXML
    private TextField tfSearchUserAccounts;
    @FXML
    private MenuButton mbRoleUserAccounts;
    @FXML
    private MenuItem miAllUserAccounts;
    @FXML
    private MenuItem miManagerUserAccounts;
    @FXML
    private MenuItem miTeacherUserAccounts;
//    choose-add
    @FXML
    private MenuButton mbAddRoleUserAccounts;
    @FXML
    private MenuItem miAddManagerUserAccounts;
    @FXML
    private MenuItem miAddTeacherUserAccounts;
//    choose-update
    @FXML
    private MenuButton mbUpdateRoleUserAccounts;
    @FXML
    private MenuItem miUpdateManagerUserAccounts;
    @FXML
    private MenuItem miUpdateTeacherUserAccounts;
//    table-view
    @FXML
    private TableView<User> tvUserAccounts;
    @FXML
    private TableColumn<User, Integer> tcUserIDAccounts;
    @FXML
    private TableColumn<User, String> tcUsernameAccounts;
    @FXML
    private TableColumn<User, String> tcEmailAccounts;
    @FXML
    private TableColumn<User, String> tcFullNameAccounts;
    @FXML
    private TableColumn<User, String> tcRoleAccounts;
//    other
    @FXML
    private ImageView closeAddAccounts;
    @FXML
    private ImageView closeUpdateAccounts;
    @FXML
    private Pane pnAccounts;
//    end-AccountsPage

//    ---------------------------------------------------------start-CoursesPage
//    btn
    @FXML
    private Button btnAddCourseCourses;
//    add
    @FXML
    private Pane pnAddCourses;
    @FXML
    private TextField tfCourseCodeAddCourses;
    @FXML
    private TextField tfCourseNameAddCourses;
    @FXML
    private MenuButton mbTeacherIDAddCourses;
//    update
    @FXML
    private Pane pnUpdateCourses;
    @FXML
    private TextField tfCourseCodeUpdateCourses;
    @FXML
    private TextField tfCourseNameUpdateCourses;
    @FXML
    private MenuButton mbTeacherIDUpdateCourses;
//    filter
    @FXML
    private TextField tfSearchCourseCourses;
    @FXML
    private MenuButton mbCreditsCourses;
    @FXML
    private MenuItem miAllCreditsCourses;
    @FXML
    private MenuItem miOneCreditCourses;
    @FXML
    private MenuItem miTwoCreditsCourses;
    @FXML
    private MenuItem miThreeCreditsCourses;
    @FXML
    private MenuItem miFourCreditsCourses;
//    choose-add
    @FXML
    private MenuButton mbAddCreditsCourses;
    @FXML
    private MenuItem miAddOneCreditCourses;
    @FXML
    private MenuItem miAddTwoCreditsCourses;
    @FXML
    private MenuItem miAddThreeCreditsCourses;
    @FXML
    private MenuItem miAddFourCreditsCourses;
//    choose-update
    @FXML
    private MenuButton mbUpdateCreditsCourses;
    @FXML
    private MenuItem miUpdateOneCreditCourses;
    @FXML
    private MenuItem miUpdateTwoCreditsCourses;
    @FXML
    private MenuItem miUpdateThreeCreditsCourses;
    @FXML
    private MenuItem miUpdateFourCreditsCourses;
//    table-view
    @FXML
    private TableView<Course> tvCourses;
    @FXML
    private TableColumn<Course, Integer> tcCourseIDCourses;
    @FXML
    private TableColumn<Course, String> tcCourseCodeCourses;
    @FXML
    private TableColumn<Course, String> tcCourseNameCourses;
    @FXML
    private TableColumn<Course, Integer> tcCreditsCourses;
    @FXML
    private TableColumn<Course, Integer> tcTeacherIDCourses;
//    other
    @FXML
    private ImageView closeAddCourses;
    @FXML
    private ImageView closeUpdateCourses;
    @FXML
    private Pane pnCourses;
//    end-CoursesPage

//    --------------------------------------------------------start-StudentsPage
//    btn
    @FXML
    private Button btnAddStudentStudents;
//    add
    @FXML
    private Pane pnAddStudents;
    @FXML
    private TextField tfFullNameAddStudents;
    @FXML
    private TextField tfPhoneNumberAddStudents;
    @FXML
    private TextField tfAddressAddStudents;
    @FXML
    private MenuButton mbCourseCodeAddStudents;
//    update
    @FXML
    private Pane pnUpdateStudents;
    @FXML
    private TextField tfFullNameUpdateStudents;
    @FXML
    private TextField tfPhoneNumberUpdateStudents;
    @FXML
    private TextField tfAddressUpdateStudents;
    @FXML
    private MenuButton mbCourseCodeUpdateStudents;
//    filter
    @FXML
    private TextField tfSearchStudentStudents;
    @FXML
    private MenuButton mbGenderStudents;
    @FXML
    private MenuItem miAllGenderStudents;
    @FXML
    private MenuItem miMaleGenderStudents;
    @FXML
    private MenuItem miFemaleGenderStudents;
//    choose-add
    @FXML
    private MenuButton mbAddGenderStudents;
    @FXML
    private MenuItem miAddMaleGenderStudents;
    @FXML
    private MenuItem miAddFemaleGenderStudents;
    @FXML
    private DatePicker dpAddStudents;
//    choose-update
    @FXML
    private MenuButton mbUpdateGenderStudents;
    @FXML
    private MenuItem miUpdateMaleGenderStudents;
    @FXML
    private MenuItem miUpdateFemaleGenderStudents;
    @FXML
    private DatePicker dpUpdateStudents;
//    table-view
    @FXML
    private TableView<Student> tvStudents;
    @FXML
    private TableColumn<Student, Integer> tcStudentIDStudents;
    @FXML
    private TableColumn<Student, String> tcFullNameStudents;
    @FXML
    private TableColumn<Student, String> tcGenderStudents;
    @FXML
    private TableColumn<Student, LocalDate> tcDateOfBirthStudents;
    @FXML
    private TableColumn<Student, String> tcPhoneNumberStudents;
    @FXML
    private TableColumn<Student, String> tcAddressStudents;
    @FXML
    private TableColumn<Student, Integer> tcCourseIDStudents;
//    other
    @FXML
    private ImageView closeAddStudents;
    @FXML
    private ImageView closeUpdateStudents;
    @FXML
    private Pane pnStudents;
//    end-StudentsPage

//    ----------------------------------------------------------start-ScoresPage
//    update
    @FXML
    private Pane pnUpdateScores;
    @FXML
    private TextField tfFullNameUpdateScores;
    @FXML
    private TextField tfScoresUpdateScores;
    @FXML
    private TextArea taDescriptionUpdateScores;
//    filter
    @FXML
    private TextField tfSearchScoreScores;
    @FXML
    private MenuButton mbCourseScores;
    @FXML
    private MenuButton mbTeacherScores;
//    table-view
    @FXML
    private TableView<Score> tvScores;
    @FXML
    private TableColumn<Score, Integer> tcStudentIDScores;
    @FXML
    private TableColumn<Score, String> tcFullNameScores;
    @FXML
    private TableColumn<Score, Float> tcScoreScores;
    @FXML
    private TableColumn<Score, String> tcDesciptionScores;
//    other
    @FXML
    private ImageView closeUpdateScores;
    @FXML
    private Pane pnScores;
//    end-ScoresPage

    private ObservableList<User> userList;
    private ObservableList<Course> courseList;
    private ObservableList<Student> studentList;
    private ObservableList<Score> scoreList;
    private final AlertUtils alertUtils = new AlertUtils();
    int uID;
    String uRole;

    public void setRole(String role, int id) {
        navRole.setText(role);
        uRole = role;
        uID = id;
    }

    @FXML
    private void handleSignOut(ActionEvent event) {
        Stage mainStage = (Stage) navSignOut.getScene().getWindow();
        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to sign out?", mainStage);
        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            mainStage.close();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SignIn.fxml"));
                Image icon = IconUtils.loadIcon();
                Parent root = loader.load();
                Stage signInStage = new Stage();
                Scene scene = new Scene(root);

                signInStage.setScene(scene);
                signInStage.getIcons().add(icon);
                WindowUtils.setupDraggableWindow(signInStage, scene);
                signInStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    -----------------------------------------------------------------start-nav
    private void clearNav() {
        mbRoleUserAccounts.setText("Role");
        pnAddUserAccounts.setVisible(false);
        pnUpdateUserAccounts.setVisible(false);
        tfSearchUserAccounts.clear();
        clearAddUserForm();

        mbCreditsCourses.setText("Credits");
        pnAddCourses.setVisible(false);
        pnUpdateCourses.setVisible(false);
        tfSearchCourseCourses.clear();
        clearAddCourseForm();

        mbGenderStudents.setText("Gender");
        pnAddStudents.setVisible(false);
        pnUpdateStudents.setVisible(false);
        tfSearchStudentStudents.clear();
        clearAddStudentForm();

        mbCourseScores.setText("Course");
        mbTeacherScores.setText("Teacher");
        pnUpdateScores.setVisible(false);
        tfSearchScoreScores.clear();
    }

    private void activePane(boolean Accounts, boolean Courses, boolean Students, boolean Scores) {
        pnAccounts.setVisible(Accounts);
        pnCourses.setVisible(Courses);
        pnStudents.setVisible(Students);
        pnScores.setVisible(Scores);
        System.out.println("ID check: " + uID);
        System.out.println("ACC " + Accounts + " COU " + Courses + " STU " + Students + " SCO " + Scores);
    }

    @FXML
    void handleNavAccounts(ActionEvent event) {
        List<Button> navButtons = Arrays.asList(navCourses, navStudents, navScores);
        NavUtils.handleNavButton(navAccounts, navButtons, this::clearNav);
        activePane(true, false, false, false);
        loadUserData();
    }

    @FXML
    void handleNavCourses(ActionEvent event) {
        List<Button> navButtons = Arrays.asList(navAccounts, navStudents, navScores);
        NavUtils.handleNavButton(navCourses, navButtons, this::clearNav);
        activePane(false, true, false, false);
        loadCourseData();
        loadTeachers();
    }

    @FXML
    void handleNavStudents(ActionEvent event) {
        List<Button> navButtons = Arrays.asList(navAccounts, navCourses, navScores);
        NavUtils.handleNavButton(navStudents, navButtons, this::clearNav);
        activePane(false, false, true, false);
        loadStudentData();
        loadCourses();
    }

    @FXML
    void handleNavScores(ActionEvent event) {
        List<Button> navButtons = Arrays.asList(navAccounts, navCourses, navStudents);
        NavUtils.handleNavButton(navScores, navButtons, this::clearNav);
        activePane(false, false, false, true);
        loadCoursesByT();
        loadTeachersByS();
    }
//    end-nav

//    --------------------------------------------------------start-AccountsPage
    private void loadUserData() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) tvUserAccounts.getScene().getWindow());
                return;
            }

            userList.clear();
            mbRoleUserAccounts.setText("Role");

            String query = "SELECT * FROM Users WHERE Role != 'Admin'";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Integer id = rs.getInt("UserID");
                        String username = rs.getString("Username");
                        String email = rs.getString("Email");
                        String fullName = rs.getString("FullName");
                        String password = rs.getString("Password");
                        String role = rs.getString("Role");

                        User user = new User(username, email, fullName, password, role);
                        user.setUserID(id);
                        userList.add(user);
                        tvUserAccounts.getSelectionModel().clearSelection();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading users!", (Stage) tvUserAccounts.getScene().getWindow());
        }
    }

    private void clearAddUserForm() {
        tfUsernameAddAccounts.clear();
        tfEmailAddAccounts.clear();
        pfPasswordAddAccounts.clear();
        tfFullnameAddAccounts.clear();
        mbAddRoleUserAccounts.setText("Role");
    }

    @FXML
    void handleAddUserAccountsConfirm(ActionEvent event) {
        String username = tfUsernameAddAccounts.getText();
        String email = tfEmailAddAccounts.getText();
        String password = pfPasswordAddAccounts.getText();
        String fullName = tfFullnameAddAccounts.getText();
        String role = mbAddRoleUserAccounts.getText();
        Stage accountsStage = (Stage) tvUserAccounts.getScene().getWindow();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || fullName.isEmpty() || role.equals("Role")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please fill in all fields and select a role!", accountsStage);
            return;
        }

        if (username.length() < 5 || username.matches(".*\\d.*")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Username must be at least 5 characters and can't use numbers!", accountsStage);
            return;
        }

        if (!email.endsWith("@gmail.com") || email.equals("@gmail.com")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please provide a gmail address!", accountsStage);
            return;
        }

        if (password.length() < 8) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "The password is at least 8 characters long!", accountsStage);
            return;
        }

        if (fullName.matches(".*\\d.*")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "FullName can't use numbers!", accountsStage);
            return;
        }

        if (username.equals(password)) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Username can't match the password!", accountsStage);
            return;
        }

        if (username.contains(" ") || email.contains(" ") || password.contains(" ")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Username, email, and password should't contain spaces!", accountsStage);
            return;
        }

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", accountsStage);
                return;
            }

            if (DatabaseUtils.isUsernameExists(username, null, true)) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Username already exists!", accountsStage);
                return;
            }

            if (DatabaseUtils.isEmailExists(email, null, true)) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Email already exists!", accountsStage);
                return;
            }

            String insertUserQuery = "INSERT INTO Users (Username, Email, FullName, Password, Role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertUserStmt = conn.prepareStatement(insertUserQuery)) {
                insertUserStmt.setString(1, username);
                insertUserStmt.setString(2, email);
                insertUserStmt.setString(3, fullName);
                insertUserStmt.setString(4, password);
                insertUserStmt.setString(5, role);
                insertUserStmt.executeUpdate();
            }

            User newUser = new User(username, email, fullName, password, role);
            userList.add(newUser);

            alertUtils.showAlert(Alert.AlertType.INFORMATION, "User added successfully!", accountsStage);
            loadUserData();
            tvUserAccounts.getSelectionModel().clearSelection();
            clearAddUserForm();

            pnAddUserAccounts.setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while adding the user!", accountsStage);
        }
    }

    private boolean deleteUserFromDatabase(User user) {
        String checkUsernameQuery = "DELETE FROM Users WHERE UserID = ?";
        Stage accountsStage = (Stage) tvUserAccounts.getScene().getWindow();

        try (Connection conn = DatabaseUtils.connect(); PreparedStatement statement = conn.prepareStatement(checkUsernameQuery)) {
            statement.setInt(1, user.getUserID());

            if (user.getRole().equals("Teacher") && DatabaseUtils.isTeacherWithCourses(user.getUserID())) {
                return false;
            }

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
//            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while deleting the user account!", accountsStage);
            return false;
        }
    }

    @FXML
    void handleDeleteUserAccounts(ActionEvent event) {
        User selectedUser = tvUserAccounts.getSelectionModel().getSelectedItem();
        Stage accountsStage = (Stage) tvUserAccounts.getScene().getWindow();

        if (selectedUser == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a user account to delete!", accountsStage);
            return;
        }

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the selected user account?", accountsStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            boolean success = deleteUserFromDatabase(selectedUser);
            if (success) {
                userList.remove(selectedUser);
                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Deleted successfully!", accountsStage);
                tvUserAccounts.getSelectionModel().clearSelection();
            } else {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Can't delete this Teacher. There are courses associated with this user!", accountsStage);
            }
        }
    }

    @FXML
    private void handleUpdateUserAccounts(ActionEvent event) {
        User selectedUser = tvUserAccounts.getSelectionModel().getSelectedItem();
        Stage accountsStage = (Stage) tvUserAccounts.getScene().getWindow();

        if (selectedUser == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a user account to update!", accountsStage);
            return;
        }
        pnUpdateUserAccounts.setVisible(true);

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", accountsStage);
                return;
            }

            String query = "SELECT Username, Email, FullName, Password, Role FROM Users WHERE Username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, selectedUser.getUsername());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        tfUsernameUpdateAccounts.setText(rs.getString("Username"));
                        tfEmailUpdateAccounts.setText(rs.getString("Email"));
                        pfPasswordUpdateAccounts.setText(rs.getString("Password"));
                        tfFullnameUpdateAccounts.setText(rs.getString("FullName"));
                        mbUpdateRoleUserAccounts.setText(rs.getString("Role"));
                    } else {
                        alertUtils.showAlert(Alert.AlertType.ERROR, "User not found in the database!", accountsStage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while fetching the user data!", accountsStage);
        }
    }

    @FXML
    private void handleUpdateUserAccountsConfirm(ActionEvent event) {
        String username = tfUsernameUpdateAccounts.getText();
        String email = tfEmailUpdateAccounts.getText();
        String password = pfPasswordUpdateAccounts.getText();
        String fullName = tfFullnameUpdateAccounts.getText();
        String role = mbUpdateRoleUserAccounts.getText();
        User selectedUser = tvUserAccounts.getSelectionModel().getSelectedItem();
        Stage accountsStage = (Stage) tvUserAccounts.getScene().getWindow();

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to update the selected user account?", accountsStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || fullName.isEmpty() || role.equals("Role")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Please fill in all fields and select a role!", accountsStage);
                return;
            }

            if (username.length() < 5 || username.matches(".*\\d.*")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Username must be at least 5 characters and can't use numbers!", accountsStage);
                return;
            }

            if (!email.endsWith("@gmail.com") || email.equals("@gmail.com")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Please provide a gmail address!", accountsStage);
                return;
            }

            if (password.length() < 8) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "The password is at least 8 characters long!", accountsStage);
                return;
            }

            if (fullName.matches(".*\\d.*")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "FullName can't use numbers!", accountsStage);
                return;
            }

            if (username.equals(password)) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Username can't match the password!", accountsStage);
                return;
            }

            if (username.contains(" ") || email.contains(" ") || password.contains(" ")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Username, email, and password should't contain spaces!", accountsStage);
                return;
            }

            try (Connection conn = DatabaseUtils.connect()) {
                if (conn == null) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", accountsStage);
                    return;
                }

                if (DatabaseUtils.isUsernameExists(username, selectedUser.getUsername(), false)) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Username already exists!", accountsStage);
                    return;
                }

                if (DatabaseUtils.isEmailExists(email, selectedUser.getEmail(), false)) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Email already exists!", accountsStage);
                    return;
                }

                if (role.equals("Manager") && DatabaseUtils.isTeacherWithCourses(selectedUser.getUserID())) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Can't update this Teacher to Manager. There are courses associated with this user!", accountsStage);
                    return;
                }

                String updateUserQuery = "UPDATE Users SET Username = ?, Email = ?, FullName = ?, Password = ?, Role = ? WHERE UserID = ?";
                try (PreparedStatement updateUserStmt = conn.prepareStatement(updateUserQuery)) {
                    updateUserStmt.setString(1, username);
                    updateUserStmt.setString(2, email);
                    updateUserStmt.setString(3, fullName);
                    updateUserStmt.setString(4, password);
                    updateUserStmt.setString(5, role);
                    updateUserStmt.setInt(6, selectedUser.getUserID());
                    updateUserStmt.executeUpdate();
                }
                User updatedUser = new User(username, email, fullName, password, role);
                int selectedIndex = tvUserAccounts.getSelectionModel().getSelectedIndex();
                userList.set(selectedIndex, updatedUser);
                loadUserData();

                alertUtils.showAlert(Alert.AlertType.INFORMATION, "User updated successfully!", accountsStage);
                tvUserAccounts.getSelectionModel().clearSelection();

                pnUpdateUserAccounts.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while updating the user!", accountsStage);
            }
        }
    }
//    end-AccountsPage

//    ---------------------------------------------------------start-CoursesPage
    private void loadCourseData() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) tvCourses.getScene().getWindow());
                return;
            }

            courseList.clear();
            mbCreditsCourses.setText("Credits");

            String query = "SELECT * FROM Courses";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Integer id = rs.getInt("CourseID");
                        String courseCode = rs.getString("CourseCode");
                        String courseName = rs.getString("CourseName");
                        Integer credits = rs.getInt("Credits");
                        Integer teacherID = rs.getInt("TeacherID");

                        Course course = new Course(courseCode, courseName, credits, teacherID);
                        course.setCourseID(id);
                        courseList.add(course);
                        tvCourses.getSelectionModel().clearSelection();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading courses!", (Stage) tvCourses.getScene().getWindow());
        }
    }

    private void loadTeachers() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) mbTeacherIDAddCourses.getScene().getWindow());
                return;
            }

            mbTeacherIDAddCourses.getItems().clear();
            mbTeacherIDUpdateCourses.getItems().clear();

            String query = "SELECT UserID, FullName FROM Users WHERE Role = 'Teacher'";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Integer teacherID = rs.getInt("UserID");
                        String fullName = rs.getString("FullName");

                        MenuItem menuItemAddCourses = new MenuItem(teacherID + " - " + fullName);
                        menuItemAddCourses.setId("mi" + teacherID + "AddCourses");
                        menuItemAddCourses.setOnAction(event -> {
                            mbTeacherIDAddCourses.setText(teacherID + " - " + fullName);
                        });

                        MenuItem menuItemUpdateCourses = new MenuItem(teacherID + " - " + fullName);
                        menuItemUpdateCourses.setId("mi" + teacherID + "UpdateCourses");
                        menuItemUpdateCourses.setOnAction(event -> {
                            mbTeacherIDUpdateCourses.setText(teacherID + " - " + fullName);
                        });

                        mbTeacherIDAddCourses.getItems().add(menuItemAddCourses);
                        mbTeacherIDUpdateCourses.getItems().add(menuItemUpdateCourses);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading teachers!", (Stage) mbTeacherIDAddCourses.getScene().getWindow());
        }
    }

    private void clearAddCourseForm() {
        tfCourseCodeAddCourses.clear();
        tfCourseNameAddCourses.clear();
        mbAddCreditsCourses.setText("Credits");
        mbTeacherIDAddCourses.setText("Teacher ID");
    }

    @FXML
    private void handleAddCourseCoursesConfirm(ActionEvent event) {
        String courseCode = tfCourseCodeAddCourses.getText();
        String courseName = tfCourseNameAddCourses.getText();
        String credits = mbAddCreditsCourses.getText();
        String teacherIDText = mbTeacherIDAddCourses.getText();
        int teacherID = 0;
        Stage coursesStage = (Stage) tvCourses.getScene().getWindow();

        if (courseCode.isEmpty() || courseName.isEmpty() || credits.equals("Credits") || teacherIDText.equals("Teacher ID")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please fill in all fields, select TeacherID and select credits!", coursesStage);
            return;
        }

        if (!teacherIDText.isEmpty()) {
            int indexOfDash = teacherIDText.indexOf("-");
            if (indexOfDash != -1) {
                String teacherIDStr = teacherIDText.substring(0, indexOfDash).trim();
                try {
                    teacherID = Integer.parseInt(teacherIDStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Invalid TeacherID format!", coursesStage);
                    return;
                }
            }
        }

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", coursesStage);
                return;
            }

            if (DatabaseUtils.isCourseExists(courseCode, null, true)) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "CourseCode already exists!", coursesStage);
                return;
            }

            String insertCourseQuery = "INSERT INTO Courses (CourseCode, CourseName, Credits, TeacherID) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertCourseStmt = conn.prepareStatement(insertCourseQuery)) {
                insertCourseStmt.setString(1, courseCode);
                insertCourseStmt.setString(2, courseName);
                insertCourseStmt.setInt(3, Integer.parseInt(credits));
                insertCourseStmt.setInt(4, teacherID);
                insertCourseStmt.executeUpdate();
            }

            Course newCourse = new Course(courseCode, courseName, Integer.parseInt(credits), teacherID);
            courseList.add(newCourse);

            alertUtils.showAlert(Alert.AlertType.INFORMATION, "Course added successfully!", coursesStage);
            loadCourseData();
            tvCourses.getSelectionModel().clearSelection();
            clearAddCourseForm();

            pnAddCourses.setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while adding the course!", coursesStage);
        }
    }

    private boolean deleteCourseFromDatabase(Course course) {
        String checkCourseCodeQuery = "DELETE FROM Courses WHERE CourseID = ?";
        Stage coursesStage = (Stage) tvCourses.getScene().getWindow();

        try (Connection conn = DatabaseUtils.connect(); PreparedStatement statement = conn.prepareStatement(checkCourseCodeQuery)) {
            statement.setInt(1, course.getCourseID());

            if (DatabaseUtils.isCourseWithStudents(course.getCourseID())) {
                return false;
            }

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
//            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while deleting the course!", coursesStage);
            return false;
        }
    }

    @FXML
    private void handleDeleteCourseCourses(ActionEvent event) {
        Course selectedCourse = tvCourses.getSelectionModel().getSelectedItem();
        Stage coursesStage = (Stage) tvCourses.getScene().getWindow();

        if (selectedCourse == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a course to delete!", coursesStage);
            return;
        }

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the selected course?", coursesStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            boolean success = deleteCourseFromDatabase(selectedCourse);
            if (success) {
                courseList.remove(selectedCourse);
                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Deleted successfully!", coursesStage);
                tvCourses.getSelectionModel().clearSelection();
            } else {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Can't delete this Course. There are students associated with this course!", coursesStage);
            }
        }
    }

    @FXML
    private void handleUpdateCourseCourses(ActionEvent event) {
        Course selectedCourse = tvCourses.getSelectionModel().getSelectedItem();
        Stage coursesStage = (Stage) tvCourses.getScene().getWindow();

        if (selectedCourse == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a course to update!", coursesStage);
            return;
        }
        pnUpdateCourses.setVisible(true);

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", coursesStage);
                return;
            }

            String fullName = "";

            String checkquery = "SELECT FullName FROM Users WHERE UserID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(checkquery)) {
                stmt.setInt(1, selectedCourse.getTeacherID());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        fullName = rs.getString("FullName");
                    }
                }
            }

            String query = "SELECT CourseCode, CourseName, Credits FROM Courses WHERE CourseID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, selectedCourse.getCourseID());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        tfCourseCodeUpdateCourses.setText(rs.getString("CourseCode"));
                        tfCourseNameUpdateCourses.setText(rs.getString("CourseName"));
                        mbUpdateCreditsCourses.setText(String.valueOf(rs.getInt("Credits")));
                        mbTeacherIDUpdateCourses.setText(String.valueOf(selectedCourse.getTeacherID()) + " - " + fullName);
                    } else {
                        alertUtils.showAlert(Alert.AlertType.ERROR, "Course not found in the database!", coursesStage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while fetching the course data!", coursesStage);
        }
    }

    @FXML
    private void handleUpdateCourseCoursesConfirm(ActionEvent event) {
        String courseCode = tfCourseCodeUpdateCourses.getText();
        String courseName = tfCourseNameUpdateCourses.getText();
        String credits = mbUpdateCreditsCourses.getText();
        String teacherIDText = mbTeacherIDUpdateCourses.getText();
        int teacherID = 0;
        Course selectedCourse = tvCourses.getSelectionModel().getSelectedItem();
        Stage coursesStage = (Stage) tvCourses.getScene().getWindow();

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to update the selected course?", coursesStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            if (courseCode.isEmpty() || courseName.isEmpty() || credits.equals("Credits") || teacherIDText.equals("Teacher ID")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Please fill in all fields, select TeacherID and select credits!", coursesStage);
                return;
            }

            if (!teacherIDText.isEmpty()) {
                int indexOfDash = teacherIDText.indexOf("-");
                if (indexOfDash != -1) {
                    String teacherIDStr = teacherIDText.substring(0, indexOfDash).trim();
                    try {
                        teacherID = Integer.parseInt(teacherIDStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        alertUtils.showAlert(Alert.AlertType.ERROR, "Invalid TeacherID format!", coursesStage);
                        return;
                    }
                }
            }

            try (Connection conn = DatabaseUtils.connect()) {
                if (conn == null) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", coursesStage);
                    return;
                }

                if (DatabaseUtils.isCourseExists(courseCode, selectedCourse.getCourseCode(), false)) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "CourseCode already exists!", coursesStage);
                    return;
                }

                String updateUserQuery = "UPDATE Courses SET CourseCode = ?, CourseName = ?, Credits = ?, TeacherID = ? WHERE CourseID = ?";
                try (PreparedStatement updateUserStmt = conn.prepareStatement(updateUserQuery)) {
                    updateUserStmt.setString(1, courseCode);
                    updateUserStmt.setString(2, courseName);
                    updateUserStmt.setInt(3, Integer.parseInt(credits));
                    updateUserStmt.setInt(4, teacherID);
                    updateUserStmt.setInt(5, selectedCourse.getCourseID());
                    updateUserStmt.executeUpdate();
                }
                Course updatedCourse = new Course(courseCode, courseName, Integer.parseInt(credits), teacherID);
                int selectedIndex = tvCourses.getSelectionModel().getSelectedIndex();
                courseList.set(selectedIndex, updatedCourse);

                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Course updated successfully!", coursesStage);
                loadCourseData();
                tvCourses.getSelectionModel().clearSelection();

                pnUpdateCourses.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while updating the course!", coursesStage);
            }
        }
    }
//    end-CoursesPage

//    --------------------------------------------------------start-StudentsPage
    private void loadStudentData() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) tvStudents.getScene().getWindow());
                return;
            }

            studentList.clear();
            mbGenderStudents.setText("Gender");

            String query = "SELECT * FROM Students";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Integer id = rs.getInt("StudentID");
                        String fullName = rs.getString("FullName");
                        String gender = rs.getString("Gender");
                        LocalDate dateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
                        String phoneNumber = rs.getString("PhoneNumber");
                        String address = rs.getString("Address");
                        Integer courseId = rs.getInt("CourseID");

                        Student student = new Student(fullName, gender, dateOfBirth, phoneNumber, address, courseId);
                        student.setStudentID(id);
                        studentList.add(student);
                        tvStudents.getSelectionModel().clearSelection();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading students!", (Stage) tvStudents.getScene().getWindow());
        }
    }

    private void loadCourses() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) mbCourseCodeAddStudents.getScene().getWindow());
                return;
            }

            mbCourseCodeAddStudents.getItems().clear();
            mbCourseCodeUpdateStudents.getItems().clear();

            String query = "SELECT CourseCode, CourseName FROM Courses";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String courseCode = rs.getString("CourseCode");
                        String courseName = rs.getString("CourseName");

                        MenuItem menuItemAddStudents = new MenuItem(courseCode + " - " + courseName);
                        menuItemAddStudents.setId("mi" + courseCode + "AddCourses");
                        menuItemAddStudents.setOnAction(event -> {
                            mbCourseCodeAddStudents.setText(courseCode + " - " + courseName);
                        });

                        MenuItem menuItemUpdateStudents = new MenuItem(courseCode + " - " + courseName);
                        menuItemUpdateStudents.setId("mi" + courseCode + "UpdateCourses");
                        menuItemUpdateStudents.setOnAction(event -> {
                            mbCourseCodeUpdateStudents.setText(courseCode + " - " + courseName);
                        });

                        mbCourseCodeAddStudents.getItems().add(menuItemAddStudents);
                        mbCourseCodeUpdateStudents.getItems().add(menuItemUpdateStudents);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading courses!", (Stage) mbCourseCodeAddStudents.getScene().getWindow());
        }
    }

    private void clearAddStudentForm() {
        tfFullNameAddStudents.clear();
        mbAddGenderStudents.setText("Gender");
        dpAddStudents.setValue(null);
        tfPhoneNumberAddStudents.clear();
        tfAddressAddStudents.clear();
        mbCourseCodeAddStudents.setText("Course Code");
    }

    @FXML
    private void handleAddStudentStudentsConfirm(ActionEvent event) {
        String fullName = tfFullNameAddStudents.getText();
        String gender = mbAddGenderStudents.getText();
        LocalDate dateOfBirth = dpAddStudents.getValue();
        String phoneNumber = tfPhoneNumberAddStudents.getText();
        String address = tfAddressAddStudents.getText();
        String courseCodeAll = mbCourseCodeAddStudents.getText();
        String courseCodeOnly = null;
        int courseID;
        Stage studentsStage = (Stage) tvStudents.getScene().getWindow();

        if (fullName.isEmpty() || gender.equals("Gender") || dateOfBirth == null || phoneNumber.isEmpty() || address.isEmpty() || courseCodeAll.equals("Course Code")) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please fill in all fields, select Gender, DateOfBirth  and Course Code!", studentsStage);
            return;
        }

        if (!courseCodeAll.isEmpty()) {
            int indexOfDash = courseCodeAll.indexOf("-");
            if (indexOfDash != -1) {
                String courseCodeStr = courseCodeAll.substring(0, indexOfDash).trim();
                try {
                    courseCodeOnly = courseCodeStr;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Invalid Course Code format!", studentsStage);
                    return;
                }
            }
        }

        System.out.println(courseCodeOnly + "-");

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", studentsStage);
                return;
            }

            String getCourseID = "SELECT CourseID FROM Courses WHERE CourseCode = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(getCourseID)) {
                pstmt.setString(1, courseCodeOnly);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    courseID = rs.getInt("CourseID");
                } else {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Course code doesn't exist!", studentsStage);
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                alertUtils.showAlert(Alert.AlertType.ERROR, "Error retrieving course information!", studentsStage);
                return;
            }

            String insertStudentQuery = "INSERT INTO Students (FullName, Gender, DateOfBirth, PhoneNumber, Address, CourseID) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStudentStmt = conn.prepareStatement(insertStudentQuery, Statement.RETURN_GENERATED_KEYS)) {
                insertStudentStmt.setString(1, fullName);
                insertStudentStmt.setString(2, gender);
                insertStudentStmt.setDate(3, Date.valueOf(dateOfBirth));
                insertStudentStmt.setString(4, phoneNumber);
                insertStudentStmt.setString(5, address);
                insertStudentStmt.setInt(6, courseID);
                insertStudentStmt.executeUpdate();

                try (ResultSet generatedKeys = insertStudentStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int studentID = generatedKeys.getInt(1);
                        String insertScoreQuery = "INSERT INTO Scores (StudentID) VALUES (?)";

                        try (PreparedStatement insertScoreStmt = conn.prepareStatement(insertScoreQuery)) {
                            insertScoreStmt.setInt(1, studentID);
                            insertScoreStmt.executeUpdate();
                        }

                        Student newStudent = new Student(fullName, gender, dateOfBirth, phoneNumber, address, courseID);
                        studentList.add(newStudent);

                        alertUtils.showAlert(Alert.AlertType.INFORMATION, "Student added successfully!", studentsStage);
                        loadStudentData();
                        tvStudents.getSelectionModel().clearSelection();
                        clearAddStudentForm();

                        pnAddStudents.setVisible(false);
                    } else {
                        throw new SQLException("Creating student failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while adding the student!", studentsStage);
        }
    }

    private boolean deleteStudentFromDatabase(Student student) {
        String deleteScoresQuery = "DELETE FROM Scores WHERE StudentID = ?";
        String deleteStudentQuery = "DELETE FROM Students WHERE StudentID = ?";
        Stage studentsStage = (Stage) tvStudents.getScene().getWindow();

        try (Connection connection = DatabaseUtils.connect()) {
            if (connection == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", studentsStage);
                return false;
            }

            connection.setAutoCommit(false);

            try (PreparedStatement deleteScoresStmt = connection.prepareStatement(deleteScoresQuery)) {
                deleteScoresStmt.setInt(1, student.getStudentID());
                deleteScoresStmt.executeUpdate();
            }

            try (PreparedStatement deleteStudentStmt = connection.prepareStatement(deleteStudentQuery)) {
                deleteStudentStmt.setInt(1, student.getStudentID());
                int rowsAffected = deleteStudentStmt.executeUpdate();

                if (rowsAffected > 0) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while deleting the student!", studentsStage);
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while deleting the student!", studentsStage);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while deleting the student!", studentsStage);
            return false;
        }
    }

    @FXML
    private void handleDeleteStudentStudents(ActionEvent event) {
        Student selectedStudent = tvStudents.getSelectionModel().getSelectedItem();
        Stage studentsStage = (Stage) tvStudents.getScene().getWindow();

        if (selectedStudent == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a student to delete!", studentsStage);
            return;
        }

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the selected student?", studentsStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            boolean success = deleteStudentFromDatabase(selectedStudent);
            if (success) {
                studentList.remove(selectedStudent);
                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Deleted successfully!", studentsStage);
                tvStudents.getSelectionModel().clearSelection();
            }
        }
    }

    @FXML
    private void handleUpdateStudentStudents(ActionEvent event) {
        Student selectedStudent = tvStudents.getSelectionModel().getSelectedItem();
        Stage studentsStage = (Stage) tvStudents.getScene().getWindow();

        if (selectedStudent == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a student to update!", studentsStage);
            return;
        }
        pnUpdateStudents.setVisible(true);

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", studentsStage);
                return;
            }

            String courseCode = "";
            String courseName = "";

            String checkquery = "SELECT CourseCode, CourseName FROM Courses WHERE CourseID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(checkquery)) {
                stmt.setInt(1, selectedStudent.getCourseID());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        courseCode = rs.getString("CourseCode");
                        courseName = rs.getString("CourseName");
                    }
                }
            }

            String query = "SELECT FullName, Gender, DateOfBirth, PhoneNumber, Address FROM Students WHERE StudentID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, selectedStudent.getStudentID());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        tfFullNameUpdateStudents.setText(rs.getString("FullName"));
                        mbUpdateGenderStudents.setText(rs.getString("Gender"));
                        dpUpdateStudents.setValue(rs.getDate("DateOfBirth").toLocalDate());
                        tfPhoneNumberUpdateStudents.setText(rs.getString("PhoneNumber"));
                        tfAddressUpdateStudents.setText(rs.getString("Address"));
                        mbCourseCodeUpdateStudents.setText(courseCode + " - " + courseName);
                    } else {
                        alertUtils.showAlert(Alert.AlertType.ERROR, "Student not found in the database!", studentsStage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while fetching the student data!", studentsStage);
        }
    }

    @FXML
    private void handleUpdateStudentStudentsConfirm(ActionEvent event) {
        int studentID = tvStudents.getSelectionModel().getSelectedItem().getStudentID();
        String fullName = tfFullNameUpdateStudents.getText();
        String gender = mbUpdateGenderStudents.getText();
        LocalDate dateOfBirth = dpUpdateStudents.getValue();
        String phoneNumber = tfPhoneNumberUpdateStudents.getText();
        String address = tfAddressUpdateStudents.getText();
        String courseCodeAll = mbCourseCodeUpdateStudents.getText();
        String courseCodeOnly = null;
        int courseID;
        Stage studentsStage = (Stage) tvStudents.getScene().getWindow();

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to update the selected student?", studentsStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            if (fullName.isEmpty() || gender.equals("Gender") || dateOfBirth == null || phoneNumber.isEmpty() || address.isEmpty() || courseCodeAll.equals("Course Code")) {
                alertUtils.showAlert(Alert.AlertType.WARNING, "Please fill in all fields, select Gender, DateOfBirth  and Course Code!", studentsStage);
                return;
            }

            if (!courseCodeAll.isEmpty()) {
                int indexOfDash = courseCodeAll.indexOf("-");
                if (indexOfDash != -1) {
                    String courseCodeStr = courseCodeAll.substring(0, indexOfDash).trim();
                    try {
                        courseCodeOnly = courseCodeStr;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        alertUtils.showAlert(Alert.AlertType.ERROR, "Invalid Course Code format!", studentsStage);
                        return;
                    }
                }
            }

            try (Connection conn = DatabaseUtils.connect()) {
                if (conn == null) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", studentsStage);
                    return;
                }

                String getCourseID = "SELECT CourseID FROM Courses WHERE CourseCode = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(getCourseID)) {
                    pstmt.setString(1, courseCodeOnly);
                    ResultSet rsID = pstmt.executeQuery();
                    if (rsID.next()) {
                        courseID = rsID.getInt("CourseID");
                    } else {
                        alertUtils.showAlert(Alert.AlertType.ERROR, "Course code doesn't exist!", studentsStage);
                        return;
                    }
                } catch (SQLException e) {
//                e.printStackTrace();
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Error retrieving course information!", studentsStage);
                    return;
                }

                String updateStudentQuery = "UPDATE Students SET FullName = ?, Gender = ?, DateOfBirth = ?, PhoneNumber = ?, Address = ?, CourseID = ? WHERE StudentID = ?";
                try (PreparedStatement updateStudentStmt = conn.prepareStatement(updateStudentQuery)) {
                    updateStudentStmt.setString(1, fullName);
                    updateStudentStmt.setString(2, gender);
                    updateStudentStmt.setDate(3, Date.valueOf(dateOfBirth));
                    updateStudentStmt.setString(4, phoneNumber);
                    updateStudentStmt.setString(5, address);
                    updateStudentStmt.setInt(6, courseID);
                    updateStudentStmt.setInt(7, studentID);
                    updateStudentStmt.executeUpdate();
                }
                Student updatedStudent = new Student(fullName, gender, dateOfBirth, phoneNumber, address, courseID);
                int selectedIndex = tvStudents.getSelectionModel().getSelectedIndex();
                studentList.set(selectedIndex, updatedStudent);
                studentList.clear();
                loadCourseData();

                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Student updated successfully!", studentsStage);
                loadStudentData();
                tvStudents.getSelectionModel().clearSelection();

                pnUpdateStudents.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while updating the student!", studentsStage);
            }
        }
    }
//    end-StudentsPage

//    ----------------------------------------------------------start-ScoresPage
    private void loadCoursesByT() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) mbCourseScores.getScene().getWindow());
                return;
            }

            mbCourseScores.getItems().clear();

            String query;
            if ("teacher".equalsIgnoreCase(uRole)) {
                query = "SELECT CourseID, CourseCode, CourseName FROM Courses WHERE TeacherID = ?";
            } else {
                query = "SELECT CourseID, CourseCode, CourseName FROM Courses";
            }
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                if ("teacher".equalsIgnoreCase(uRole)) {
                    stmt.setInt(1, uID);
                }
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Integer courseID = rs.getInt("CourseID");
                        String courseCode = rs.getString("CourseCode");
                        String courseName = rs.getString("CourseName");

                        MenuItem menuItemFilterScores = new MenuItem(courseCode + " - " + courseName);
                        menuItemFilterScores.setId("mi" + courseCode + "FilterScores");
                        menuItemFilterScores.setOnAction(event -> {
                            mbCourseScores.setText(courseCode + " - " + courseName);
                            scoreList.setAll(DatabaseUtils.getStudentsByCourse(courseID));
                            tvScores.getSelectionModel().clearSelection();
                            mbTeacherScores.setText("Teacher");
                        });

                        mbCourseScores.getItems().add(menuItemFilterScores);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading courses!", (Stage) mbCourseCodeAddStudents.getScene().getWindow());
        }
    }

    private void loadTeachersByS() {
        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", (Stage) mbTeacherScores.getScene().getWindow());
                return;
            }

            mbTeacherScores.getItems().clear();

            String query = "SELECT UserID, FullName FROM Users WHERE Role = 'Teacher'";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int teacherID = rs.getInt("UserID");
                        String fullName = rs.getString("FullName");

                        MenuItem menuItemFilterScores = new MenuItem(teacherID + " - " + fullName);
                        menuItemFilterScores.setId("mi" + teacherID + "FilterScores");
                        menuItemFilterScores.setOnAction(event -> {
                            mbTeacherScores.setText(teacherID + " - " + fullName);
                            scoreList.setAll(DatabaseUtils.getStudentsByTeacher(teacherID));
                            tvScores.getSelectionModel().clearSelection();
                            mbCourseScores.setText("Course");
                        });

                        mbTeacherScores.getItems().add(menuItemFilterScores);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while loading teachers!", (Stage) mbTeacherIDAddCourses.getScene().getWindow());
        }
    }

    @FXML
    private void handleUpdateScoreStudents(ActionEvent event) {
        Score selectedScore = tvScores.getSelectionModel().getSelectedItem();
        Stage scoresStage = (Stage) tvScores.getScene().getWindow();

        if (selectedScore == null) {
            alertUtils.showAlert(Alert.AlertType.WARNING, "Please select a student to update!", scoresStage);
            return;
        }
        pnUpdateScores.setVisible(true);

        try (Connection conn = DatabaseUtils.connect()) {
            if (conn == null) {
                alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", scoresStage);
                return;
            }

            String fullName = DatabaseUtils.getFullNameByID(selectedScore.getStudentID());
            String query = "SELECT Score, Description FROM Scores WHERE StudentID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, selectedScore.getStudentID());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        tfFullNameUpdateScores.setText(fullName);
                        tfScoresUpdateScores.setText(String.valueOf(rs.getFloat("Score")));
                        taDescriptionUpdateScores.setText(rs.getString("Description"));
                    } else {
                        alertUtils.showAlert(Alert.AlertType.ERROR, "Scores not found in the database!", scoresStage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while fetching the score data!", scoresStage);
        }
    }

    @FXML
    private void handleUpdateScoreScoresConfirm(ActionEvent event) {
        int studentID = tvScores.getSelectionModel().getSelectedItem().getStudentID();
        String score = tfScoresUpdateScores.getText();
        String description = taDescriptionUpdateScores.getText();
        Stage scoresStage = (Stage) tvScores.getScene().getWindow();

        Optional<ButtonType> rs = alertUtils.showAlert(Alert.AlertType.CONFIRMATION, "Are you sure you want to update the selected scores?", scoresStage);

        if (rs.isPresent() && rs.get() == ButtonType.OK) {
            if (score.isEmpty()) {
                score = "0.0";
            }

            try (Connection conn = DatabaseUtils.connect()) {
                if (conn == null) {
                    alertUtils.showAlert(Alert.AlertType.ERROR, "Database connection failed!", scoresStage);
                    return;
                }
                
                String fullName = DatabaseUtils.getFullNameByID(studentID);
                String updateScoreQuery = "UPDATE Scores SET Score = ?, Description = ? WHERE StudentID = ?";
                try (PreparedStatement updateScoreStmt = conn.prepareStatement(updateScoreQuery)) {
                    updateScoreStmt.setFloat(1, Float.parseFloat(score));
                    updateScoreStmt.setString(2, description);
                    updateScoreStmt.setInt(3, studentID);
                    updateScoreStmt.executeUpdate();
                }
                Score updatedScore = new Score(Float.parseFloat(score), description);
                updatedScore.setStudentID(studentID);
                updatedScore.setFullName(fullName);
                int selectedIndex = tvScores.getSelectionModel().getSelectedIndex();
                scoreList.set(selectedIndex, updatedScore);

                alertUtils.showAlert(Alert.AlertType.INFORMATION, "Score updated successfully!", scoresStage);
                tvScores.getSelectionModel().clearSelection();

                pnUpdateScores.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                alertUtils.showAlert(Alert.AlertType.ERROR, "An error occurred while updating the score!", scoresStage);
            }
        }
    }
//    end-ScoresPage

//    ----------------------------------------------------------------------init
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DateTimeUtils.startDateTimeUpdater(navTime);
        Platform.runLater(() -> {
            tvUserAccounts.getSelectionModel().clearSelection();
            tvCourses.getSelectionModel().clearSelection();
            loadCoursesByT();
        });

//        ----------------------------------------------------------accountsPage
//        loadAcc\fLoad
        userList = FXCollections.observableArrayList();
        loadUserData();
//        add\AutoUpdate
        tcUserIDAccounts.setCellValueFactory(cellData -> cellData.getValue().userIDProperty().asObject());
        tcUsernameAccounts.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        tcEmailAccounts.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        tcFullNameAccounts.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        tcRoleAccounts.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        tvUserAccounts.setItems(userList);
//        page\Role\Filter(add)
        miAllUserAccounts.setOnAction(event -> {
            userList.setAll(DatabaseUtils.getUsersByRole("All"));
            mbRoleUserAccounts.setText(miAllUserAccounts.getText());
            tvUserAccounts.getSelectionModel().clearSelection();
        });
        miManagerUserAccounts.setOnAction(event -> {
            userList.setAll(DatabaseUtils.getUsersByRole("Manager"));
            mbRoleUserAccounts.setText(miManagerUserAccounts.getText());
            tvUserAccounts.getSelectionModel().clearSelection();
        });
        miTeacherUserAccounts.setOnAction(event -> {
            userList.setAll(DatabaseUtils.getUsersByRole("Teacher"));
            mbRoleUserAccounts.setText(miTeacherUserAccounts.getText());
            tvUserAccounts.getSelectionModel().clearSelection();
        });
//        add\Role
        miAddManagerUserAccounts.setOnAction(event -> mbAddRoleUserAccounts.setText(miAddManagerUserAccounts.getText()));
        miAddTeacherUserAccounts.setOnAction(event -> mbAddRoleUserAccounts.setText(miAddTeacherUserAccounts.getText()));
//        update\Role
        miUpdateManagerUserAccounts.setOnAction(event -> mbUpdateRoleUserAccounts.setText(miUpdateManagerUserAccounts.getText()));
        miUpdateTeacherUserAccounts.setOnAction(event -> mbUpdateRoleUserAccounts.setText(miUpdateTeacherUserAccounts.getText()));
//        filter
        tfSearchUserAccounts.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<User> filteredList = new FilteredList<>(userList, user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(user.getUserID()).contains(newValue)) {
                    return true;
                } else if (user.getUsername() != null && user.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (user.getEmail() != null && user.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (user.getFullName() != null && user.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });

            tvUserAccounts.setItems(filteredList);
            tvUserAccounts.getSelectionModel().clearSelection();
        });
//        visible/invisible-Add
        btnAddUserAccounts.setOnAction(event -> pnAddUserAccounts.setVisible(true));
        closeAddAccounts.setOnMouseClicked(event -> {
            pnAddUserAccounts.setVisible(false);
            clearAddUserForm();
        });
//        visible/invisible-Update
        closeUpdateAccounts.setOnMouseClicked(event -> pnUpdateUserAccounts.setVisible(false));
//        keyMode
        KeyEventUtils.addEscapeEventHandler(tvUserAccounts, () -> {
            tvUserAccounts.getSelectionModel().clearSelection();
        });

//        -----------------------------------------------------------coursesPage
//        loadAcc\fLoad
        courseList = FXCollections.observableArrayList();
        loadCourseData();
        loadTeachers();
//        add\AutoUpdate
        tcCourseIDCourses.setCellValueFactory(cellData -> cellData.getValue().courseIDProperty().asObject());
        tcCourseCodeCourses.setCellValueFactory(cellData -> cellData.getValue().courseCodeProperty());
        tcCourseNameCourses.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        tcCreditsCourses.setCellValueFactory(cellData -> cellData.getValue().creditsProperty().asObject());
        tcTeacherIDCourses.setCellValueFactory(cellData -> cellData.getValue().teacherIDProperty().asObject());
        tvCourses.setItems(courseList);
//        page\Role\Filter(add)
        miAllCreditsCourses.setOnAction(event -> {
            courseList.setAll(DatabaseUtils.getCoursesByCredits("All"));
            mbCreditsCourses.setText(miAllCreditsCourses.getText());
            tvCourses.getSelectionModel().clearSelection();
        });
        miOneCreditCourses.setOnAction(event -> {
            courseList.setAll(DatabaseUtils.getCoursesByCredits("1"));
            mbCreditsCourses.setText(miOneCreditCourses.getText());
            tvCourses.getSelectionModel().clearSelection();
        });
        miTwoCreditsCourses.setOnAction(event -> {
            courseList.setAll(DatabaseUtils.getCoursesByCredits("2"));
            mbCreditsCourses.setText(miTwoCreditsCourses.getText());
            tvCourses.getSelectionModel().clearSelection();
        });
        miThreeCreditsCourses.setOnAction(event -> {
            courseList.setAll(DatabaseUtils.getCoursesByCredits("3"));
            mbCreditsCourses.setText(miThreeCreditsCourses.getText());
            tvCourses.getSelectionModel().clearSelection();
        });
        miFourCreditsCourses.setOnAction(event -> {
            courseList.setAll(DatabaseUtils.getCoursesByCredits("4"));
            mbCreditsCourses.setText(miFourCreditsCourses.getText());
            tvCourses.getSelectionModel().clearSelection();
        });
//        add\Credits
        miAddOneCreditCourses.setOnAction(event -> mbAddCreditsCourses.setText(miAddOneCreditCourses.getText()));
        miAddTwoCreditsCourses.setOnAction(event -> mbAddCreditsCourses.setText(miAddTwoCreditsCourses.getText()));
        miAddThreeCreditsCourses.setOnAction(event -> mbAddCreditsCourses.setText(miAddThreeCreditsCourses.getText()));
        miAddFourCreditsCourses.setOnAction(event -> mbAddCreditsCourses.setText(miAddFourCreditsCourses.getText()));
//        update\Credits
        miUpdateOneCreditCourses.setOnAction(event -> mbUpdateCreditsCourses.setText(miUpdateOneCreditCourses.getText()));
        miUpdateTwoCreditsCourses.setOnAction(event -> mbUpdateCreditsCourses.setText(miUpdateTwoCreditsCourses.getText()));
        miUpdateThreeCreditsCourses.setOnAction(event -> mbUpdateCreditsCourses.setText(miUpdateThreeCreditsCourses.getText()));
        miUpdateFourCreditsCourses.setOnAction(event -> mbUpdateCreditsCourses.setText(miUpdateFourCreditsCourses.getText()));
//        filter
        tfSearchCourseCourses.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Course> filteredList = new FilteredList<>(courseList, course -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(course.getCourseID()).contains(newValue)) {
                    return true;
                } else if (course.getCourseCode() != null && course.getCourseCode().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (course.getCourseName() != null && course.getCourseName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(course.getTeacherID()).contains(newValue)) {
                    return true;
                }
                return false;
            });

            tvCourses.setItems(filteredList);
            tvCourses.getSelectionModel().clearSelection();
        });
//        visible/invisible-Add
        btnAddCourseCourses.setOnAction(event -> pnAddCourses.setVisible(true));
        closeAddCourses.setOnMouseClicked(event -> {
            pnAddCourses.setVisible(false);
            clearAddCourseForm();
        });
//        visible/invisible-Update
        closeUpdateCourses.setOnMouseClicked(event -> pnUpdateCourses.setVisible(false));
//        keyMode
        KeyEventUtils.addEscapeEventHandler(tvCourses, () -> {
            tvCourses.getSelectionModel().clearSelection();
        });

//        ----------------------------------------------------------studentsPage
//        loadAcc\fLoad
        studentList = FXCollections.observableArrayList();
        loadStudentData();
        loadCourses();
        dpAddStudents.setPromptText("Date of Birth");
        dpUpdateStudents.setPromptText("Date of Birth");
//        add\AutoUpdate
        tcStudentIDStudents.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty().asObject());
        tcFullNameStudents.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        tcGenderStudents.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        tcDateOfBirthStudents.setCellValueFactory(cellData -> cellData.getValue().dateOfBirthProperty());
        tcPhoneNumberStudents.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        tcAddressStudents.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        tcCourseIDStudents.setCellValueFactory(cellData -> cellData.getValue().courseIDProperty().asObject());
        tvStudents.setItems(studentList);
//        page\Role\Filter(add)
        miAllGenderStudents.setOnAction(event -> {
            studentList.setAll(DatabaseUtils.getStudentsByGender("All"));
            mbGenderStudents.setText(miAllGenderStudents.getText());
            tvStudents.getSelectionModel().clearSelection();
        });
        miMaleGenderStudents.setOnAction(event -> {
            studentList.setAll(DatabaseUtils.getStudentsByGender("Male"));
            mbGenderStudents.setText(miMaleGenderStudents.getText());
            tvStudents.getSelectionModel().clearSelection();
        });
        miFemaleGenderStudents.setOnAction(event -> {
            studentList.setAll(DatabaseUtils.getStudentsByGender("Female"));
            mbGenderStudents.setText(miFemaleGenderStudents.getText());
            tvStudents.getSelectionModel().clearSelection();
        });
//        add\Gender
        miAddMaleGenderStudents.setOnAction(event -> mbAddGenderStudents.setText(miAddMaleGenderStudents.getText()));
        miAddFemaleGenderStudents.setOnAction(event -> mbAddGenderStudents.setText(miAddFemaleGenderStudents.getText()));
//        update\Gender
        miUpdateMaleGenderStudents.setOnAction(event -> mbUpdateGenderStudents.setText(miUpdateMaleGenderStudents.getText()));
        miUpdateFemaleGenderStudents.setOnAction(event -> mbUpdateGenderStudents.setText(miUpdateFemaleGenderStudents.getText()));
//        filter
        tfSearchStudentStudents.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Student> filteredList = new FilteredList<>(studentList, student -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(student.getStudentID()).contains(newValue)) {
                    return true;
                } else if (student.getFullName() != null && student.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getPhoneNumber().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(student.getCourseID()).contains(newValue)) {
                    return true;
                }
                return false;
            });

            tvStudents.setItems(filteredList);
            tvStudents.getSelectionModel().clearSelection();
        });
//        visible/invisible-Add
        btnAddStudentStudents.setOnAction(event -> pnAddStudents.setVisible(true));
        closeAddStudents.setOnMouseClicked(event -> {
            pnAddStudents.setVisible(false);
            clearAddCourseForm();
        });
//        visible/invisible-Update
        closeUpdateStudents.setOnMouseClicked(event -> pnUpdateStudents.setVisible(false));
//        keyMode
        KeyEventUtils.addEscapeEventHandler(tvStudents, () -> {
            tvStudents.getSelectionModel().clearSelection();
        });

//        ------------------------------------------------------------ScoresPage
//        loadAcc\fLoad        
        scoreList = FXCollections.observableArrayList();
        loadTeachersByS();
//        add\AutoUpdate
        tcStudentIDScores.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty().asObject());
        tcFullNameScores.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        tcScoreScores.setCellValueFactory(cellData -> cellData.getValue().scoreProperty().asObject());
        tcDesciptionScores.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        tvScores.setItems(scoreList);
//        filter
        tfSearchScoreScores.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Score> filteredList = new FilteredList<>(scoreList, score -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(score.getStudentID()).contains(newValue)) {
                    return true;
                } else if (score.getFullName() != null && score.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });

            tvScores.setItems(filteredList);
            tvScores.getSelectionModel().clearSelection();
        });
//        visible/invisible-Update
        closeUpdateScores.setOnMouseClicked(event -> pnUpdateScores.setVisible(false));
//        keyMode
        KeyEventUtils.addEscapeEventHandler(tvScores, () -> {
            tvScores.getSelectionModel().clearSelection();
        });
    }
}
