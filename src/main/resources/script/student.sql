-- Create the 'students' table
CREATE TABLE students (
                          student_id serial PRIMARY KEY,
                          student_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          phone_number VARCHAR(20)
);

-- Create the 'instructors' table
CREATE TABLE instructors (
                             instructor_id serial PRIMARY KEY,
                             instructor_name VARCHAR(255) NOT NULL,
                             email VARCHAR(255) UNIQUE NOT NULL
);

-- Create the 'courses' table
CREATE TABLE courses (
                         course_id serial PRIMARY KEY,
                         course_name VARCHAR(255) NOT NULL,
                         description TEXT,
                         instructor_id INT,
                         FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id) ON DELETE SET NULL
);

-- Create the 'student_course' join table (many-to-many relationship)
CREATE TABLE student_course (
                                id serial PRIMARY KEY,
                                student_id INT,
                                course_id INT,
                                FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
                                FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
