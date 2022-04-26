package jpa.mainrunner;

import jpa.service.CourseService;
import jpa.service.StudentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SMSRunner {
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private Scanner reader = new Scanner(System.in);
    private int choice = 0;
    private boolean inputNotNull = true;

    public static void main(String[] args) throws InterruptedException {
        // runs the application's user interface
        new SMSRunner().run();
    }

    public void run() throws InterruptedException {
        menu();
    }

    public void menu() throws InterruptedException {
        System.out.println("Welcome!");
        System.out.println("This is our school's management system");
        System.out.println();
        System.out.println("Are you a(n)");
        System.out.println("1. Student");
        System.out.println("2. quit");
        while (choice != 2) {
            while (inputNotNull) {
                try {
                    choice = reader.nextInt();
                    switch (choice) {
                        case 1:
                            reader.nextLine();
                            System.out.printf("\nEnter Your Email: ");
                            String inputEmail = reader.nextLine();
                            System.out.printf("Enter Your Password: ");
                            String inputPassword = reader.nextLine();
                            boolean verify = studentService.validateStudent(inputEmail, inputPassword);
                            if (verify) {
                                System.out.println();
                                System.out.println("Successful Authentication!");
                                Thread.sleep(1000);
                                welcomeScreen();
                            } else {
                                System.out.println("Incorrect username or password.");
                                System.out.println("Please try again");
                                Thread.sleep(2000);
                                System.out.println();
                                menu();
                                System.out.println();
                            }
                        case 2:
                            System.out.println();
                            System.out.println("Goodbye");
                            System.exit(0);
                        default:
                            System.out.println("You've entered an invalid input to the system. Please try again");
                            Thread.sleep(2000);
                            menu();
                    }
                    inputNotNull = false;
                } catch (InputMismatchException e) {
                    System.err.println("\nSorry! You've entered an invalid input. Only numbers (integers) please.");
                    System.exit(0);
                }
                reader.close();
            }
        }
    }

    public void welcomeScreen() throws InterruptedException {
        Thread.sleep(500);
        System.out.println();
        System.out.println("Welcome!");
        Thread.sleep(500);
        System.out.println("Please select from one of the following options:");
        Thread.sleep(1250);
        System.out.println();
        System.out.println("1. Register to Class");
        System.out.println("2. Logout");
        while (inputNotNull) {
            try {
                choice = reader.nextInt();
                if (choice == 1) {
                    registerMenu();
                } else if (choice == 2) {
                    System.out.println("You've successfully logged out. Have a great day!");
                    Thread.sleep(500);
                    System.exit(0);
                } else {
                    System.out.println("Invalid input. Please try again");
                    Thread.sleep(500);
                    welcomeScreen();
                }
                inputNotNull = false;
            } catch (InputMismatchException e) {
                System.err.println("\nSorry! You've entered an invalid input. Only numbers (integers) please.");
                System.exit(0);
            }
            reader.close();
        }
    }

    public void registerMenu() throws InterruptedException {
        System.out.println("Before we begin, we must verify your login credentials once more");
        Thread.sleep(500);
        System.out.println("Is this okay with you?");
        System.out.println();
        System.out.println("1. Yes");
        System.out.println("2. No");
        Thread.sleep(500);
            while (inputNotNull) {
                try {
                    choice = reader.nextInt();
                    switch (choice) {
                        case 1:
                            reader.nextLine();
                            System.out.printf("\nEnter Your Email: ");
                            String inputEmail = reader.nextLine();
                            System.out.printf("Enter Your Password: ");
                            String inputPassword = reader.nextLine();
                            boolean verify = studentService.validateStudent(inputEmail, inputPassword);
                            if (verify) {
                                System.out.println();
                                System.out.println("Successful Authentication!");
                                Thread.sleep(1000);
                                System.out.println("Please choose from one of the following courses:");
                                Thread.sleep(3000);
                                System.out.println(courseService.getAllCourses().toString().replace("[", "").replace("]", "").replace(",", ""));
                                Thread.sleep(100);
                                System.out.println("Enter the ID of the course you wish to register to below");
                                while (inputNotNull) {
                                    try {
                                        choice = reader.nextInt();
                                        if (choice == 1) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our English course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 2) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Mathematics course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 3) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Anatomy course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 4) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Organic Chemistry course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 5) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Physics course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 6) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Digital Logic course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 7) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Object Oriented Programming course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 8) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Data Structures course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 9) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Politics course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else if (choice == 10) {
                                            studentService.registerStudentToCourse(inputEmail, choice);
                                            System.out.println("You've successfully registered to our Art course!");
                                            Thread.sleep(1000);
                                            System.out.println();
                                            System.out.println(studentService.getStudentCourses(inputEmail).toString().replace("[", "").replace("]", "").replace(",", ""));
                                            finalMenu();
                                        } else {
                                            System.out.println("You've entered an invalid input to the system. Please try again");
                                            Thread.sleep(2000);
                                            registerMenu();
                                        }
                                        inputNotNull = false;
                                    } catch (InputMismatchException e) {
                                        System.err.println("\nSorry! You've entered an invalid input. Only numbers (integers) please.");
                                        System.exit(0);
                                    }
                                }
                            } else {
                                System.out.println("Incorrect username or password.");
                                System.out.println("Please try again");
                                Thread.sleep(2000);
                                registerMenu();
                                System.out.println();
                            }
                        case 2:
                            System.out.println();
                            System.out.println("Goodbye");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("You've entered an invalid input to the system. Please try again");
                            Thread.sleep(2000);
                            registerMenu();
                    }
                    inputNotNull = false;
                } catch (InputMismatchException e) {
                    System.err.println("\nSorry! You've entered an invalid input. Only numbers (integers) please.");
                    System.exit(0);
                }
            }
        reader.close();
    }

    public void finalMenu() throws InterruptedException {
        System.out.println("\nWhat would you like to do next?\n");
        System.out.println("1. Register to another course");
        System.out.println("2. Exit Application");
        while (inputNotNull) {
            try {
                choice = reader.nextInt();
                if (choice == 1) {
                    System.out.println();
                    registerMenu();
                } else if (choice == 2) {
                    System.out.println("You have successfully logged out");
                    Thread.sleep(100);
                    System.out.println("\nExiting Application...");
                    System.out.println();
                    reader.close();
                    Thread.sleep(500);
                    System.exit(0);
                } else {
                    System.out.println("Application is closing");
                    Thread.sleep(300);
                    System.out.println("You will be logged out from this session");
                    Thread.sleep(100);
                    System.exit(0);
                }
                inputNotNull = false;
            } catch (InputMismatchException e) {
                System.err.println("\nSorry! You've entered an invalid input. Only numbers (integers) please.");
                System.exit(0);
            }
            reader.close();
        }
    }
}